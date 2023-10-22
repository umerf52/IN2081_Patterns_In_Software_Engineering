package de.tum.in.ase.pse.utils.crypto;

/**
 *
 */
public interface CryptoUtils {

    /**
     * This method takes an input string and encrypts it using the chosen algorithm
     *
     * @param input the input string to be encrypted
     * @return byte array containing result of encryption of the input
     */
    byte[] encrypt(String input);

    /**
     * This method takes input a byte array of the encrypted string and decrypts it into the original string
     *
     * @param input the input byte array to be decrypted
     * @return the decrypted string
     */
    String decrypt(byte[] input);
}
