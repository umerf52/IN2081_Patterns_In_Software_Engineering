package de.tum.in.ase.pse.factory;

import java.time.Instant;

public class IdGenerationService {

	private static final int FACTORY_ID_BITS = 4;
	private static final int SEQUENCE_BITS = 6;

	private static final long MAX_SEQUENCE = (1L << SEQUENCE_BITS) - 1;


	private long lastTimestamp = -1L;
	private long sequence = 0L;

	public synchronized long generateId(int factoryId) {
		long currentTimestamp = timestamp();

		// TODO implement the ID generation algorithm as described on Artemis.
		long id = 0;
		if (currentTimestamp == lastTimestamp) {
			sequence = (sequence + 1) & MAX_SEQUENCE;
		}
		id = (currentTimestamp << FACTORY_ID_BITS) | factoryId;
		id = (id << SEQUENCE_BITS) | sequence;
		lastTimestamp = currentTimestamp;
		return id;
	}


	// Get current timestamp in milliseconds and the difference to the UNIX epoch Jan, 1st 1970.
	private long timestamp() {
		return Instant.now().toEpochMilli();
	}

}
