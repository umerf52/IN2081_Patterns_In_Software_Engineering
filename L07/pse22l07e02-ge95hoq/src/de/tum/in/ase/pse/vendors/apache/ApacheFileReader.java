package de.tum.in.ase.pse.vendors.apache;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ApacheFileReader {
    /**
     * Reads the file by filename from the resources folder and converts it to a File object
     *
     * @param fileURL the name of the file to be read from the resources
     * @return a File object from the given input filename
     */
    public byte[] readFile(URL fileURL) {
        if (fileURL == null) {
            System.err.println("Could not find URL from classloader");
            return new byte[0];
        }
        String imageURL = fileURL.getFile();
        try {
            return FileUtils.readFileToByteArray(new File(imageURL));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image could not be read: " + e.getMessage());
            return new byte[0];
        }
    }
}
