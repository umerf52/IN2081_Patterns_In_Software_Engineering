package de.tum.in.ase.pse.vendors.mig;

import com.migcomponents.migbase64.Base64;

public class MigBase64Encoder {
    public String encodeToBase64(byte[] fileBytesArray) {
        // TODO 1 Implement the encoder by using the function from migbase64
        // Find more about the migbase64's Base64 encoder here: https://www.javadoc.io/doc/com.brsanthu/migbase64/latest/index.html
        // The required dependency is already set up in this project.
        Base64 base64 = new Base64();
        return base64.encodeToString(fileBytesArray, false);
    }
}
