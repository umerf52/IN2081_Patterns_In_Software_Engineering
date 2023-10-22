package de.tum.in.ase.pse.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;


@Component
public class CircuitBreaker<T, R> {
    private static final long WAITING_TIME = 10_000_000_000L;
    private static final int MAX_NUMBER_OF_ATTEMPTS_WITH_UNSUCCESSFUL_REPLY = 2;
    //Do NOT make these attributes final, this will cause the tests to fail.
    private Map<T, AtomicInteger> unsuccessfulAttemptsPerEndpoint = new ConcurrentHashMap<>();
    private Map<T, CircuitBreakerState> circuitBreakerStatePerEndpoint = new ConcurrentHashMap<>();
    private Map<T, Long> waitingStartTimePerEndpoint = new ConcurrentHashMap<>();

    public ResponseEntity<R> protectedCall(T object, Function<T, R> operation) {

        //TODO implement the Circuit Breaker as described on Artemis.
        circuitBreakerStatePerEndpoint.putIfAbsent(object, CircuitBreakerState.CLOSED);
        unsuccessfulAttemptsPerEndpoint.putIfAbsent(object, new AtomicInteger(0));

        CircuitBreakerState state = circuitBreakerStatePerEndpoint.get(object);
        if (state == CircuitBreakerState.CLOSED || state == CircuitBreakerState.HALF_OPEN) {
            try {
                R result = operation.apply(object);
                unsuccessfulAttemptsPerEndpoint.get(object).set(0);
                circuitBreakerStatePerEndpoint.put(object, CircuitBreakerState.CLOSED);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } catch (Exception e) {
                if (state == CircuitBreakerState.HALF_OPEN) {
                    circuitBreakerStatePerEndpoint.put(object, CircuitBreakerState.OPEN);
                    waitingStartTimePerEndpoint.put(object, System.nanoTime());
                    throw e;
                }
                if (state == CircuitBreakerState.CLOSED) {
                    unsuccessfulAttemptsPerEndpoint.get(object).incrementAndGet();
                    if (unsuccessfulAttemptsPerEndpoint.get(object).get() >= MAX_NUMBER_OF_ATTEMPTS_WITH_UNSUCCESSFUL_REPLY) {
                        circuitBreakerStatePerEndpoint.put(object, CircuitBreakerState.OPEN);
                        waitingStartTimePerEndpoint.put(object, System.nanoTime());
                    }
                    throw e;
                }
            }
        } else if (state == CircuitBreakerState.OPEN) {
            if (System.nanoTime() - waitingStartTimePerEndpoint.get(object) < WAITING_TIME) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                circuitBreakerStatePerEndpoint.put(object, CircuitBreakerState.HALF_OPEN);
            }
        }
        return null;
    }
}
