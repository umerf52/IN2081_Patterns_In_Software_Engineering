package de.tum.in.ase.pse.utils.encoder;

import de.tum.in.ase.pse.vendors.mig.MigBase64Encoder;

// TODO 2 Implement EncoderUtils.java
public class Base64Encoder implements EncoderUtils {
    // TODO 3 Use MigBase64Encoder you implemented from TODO 1, when implementing this method
    private MigBase64Encoder encoder = new MigBase64Encoder();

    @Override
    public String encodeToBase64(byte[] fileBytesArray) {
        return encoder.encodeToBase64(fileBytesArray);
    }
}
