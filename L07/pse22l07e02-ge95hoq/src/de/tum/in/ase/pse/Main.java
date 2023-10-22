package de.tum.in.ase.pse;

import de.tum.in.ase.pse.utils.crypto.Cryptography;
import de.tum.in.ase.pse.utils.encoder.Base64Encoder;
import de.tum.in.ase.pse.vendors.apache.ApacheFileReader;

public final class Main {

    private Main() {
        // Main class can't be instantiated
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        // Step 1 Read local image using utilities from Apache
        ApacheFileReader fileReader = new ApacheFileReader();
        byte[] fileByteArray = fileReader.readFile(Main.class.getClassLoader().getResource("image.jpg"));

        // Step 2 Encode image file to base64 string using utility from Apache
        // TODO 11 Replace Apache encoder with the Base64Encoder
        Base64Encoder encoder = new Base64Encoder();
        String imageBase64 = encoder.encodeToBase64(fileByteArray);
        System.out.println("base64: " + imageBase64);

        // Step 3 Encrypt image's base64 string using utility from Apache
        //encrypt
        // TODO 12 Replace Apache implementation with the new vendor's
        Cryptography crypto = new Cryptography();
        byte[] encryptedString = crypto.encrypt(imageBase64);

        //decrypt
        System.out.println("decrypted= " + crypto.decrypt(encryptedString));
    }
}
