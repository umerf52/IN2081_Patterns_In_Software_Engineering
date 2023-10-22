package de.tum.in.ase.pse.utils.crypto;

import de.tum.in.ase.pse.vendors.jasypt.AESCrypt;

// TODO 8 Implement CryptoUtils.java
public class Cryptography implements CryptoUtils {
    private final AESCrypt algorithm;

    public Cryptography() {
        // TODO 9 Initialize AESCrypt algorithm
        algorithm = new AESCrypt();
    }

    // TODO 10 Implement interface's methods
    @Override
    public byte[] encrypt(String input) {
        return algorithm.encrypt(input);
    }

    @Override
    public String decrypt(byte[] input) {
        return algorithm.decrypt(input);
    }
}
