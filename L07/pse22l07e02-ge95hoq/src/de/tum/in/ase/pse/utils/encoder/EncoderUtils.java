package de.tum.in.ase.pse.utils.encoder;

public interface EncoderUtils {
    /**
     * Converts given input file to a Base64 string using a Base64 codec library
     *
     * @param fileBytesArray file to be encoded to Base64
     * @return a String representing the Base64 string of the file
     */
    String encodeToBase64(byte[] fileBytesArray);
}
