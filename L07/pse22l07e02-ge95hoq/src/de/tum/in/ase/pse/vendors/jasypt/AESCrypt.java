package de.tum.in.ase.pse.vendors.jasypt;

import org.jasypt.util.text.AES256TextEncryptor;

public class AESCrypt {
    // TODO 4 Use an `algorithm` attribute to instantiate jasypt's `AES256TextEncryptor`
    // Find more about the jasypt's encryption functions here: http://www.jasypt.org/api/jasypt/1.9.3/org/jasypt/util/text/AES256TextEncryptor.html
    // The required Gradle dependency is already set up in this project.
    private AES256TextEncryptor algorithm;

    public AESCrypt() {
        // TODO 5 Initialize the `algorithm` and set the password to "PSEL07E02"
        algorithm = new AES256TextEncryptor();
        algorithm.setPassword("PSEL07E02");
    }

    // TODO 6 Implement the encrypt algorithm accordingly to return a byte array using UTF_8 as a StandardCharset
    public byte[] encrypt(String input) {
        return algorithm.encrypt(input).getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }

    // TODO 7 Implement the decrypt algorithm accordingly to return a String which adheres to the UTF_8 StandardCharset
    public String decrypt(byte[] input) {
        return algorithm.decrypt(new String(input, java.nio.charset.StandardCharsets.UTF_8));
    }
}
