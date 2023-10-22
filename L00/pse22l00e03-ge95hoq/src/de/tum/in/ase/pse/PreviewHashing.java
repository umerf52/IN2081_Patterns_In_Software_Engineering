package de.tum.in.ase.pse;

public class PreviewHashing extends Hashing {
    private static final int LIMIT = 1000;

    public PreviewHashing() {
        setImplementation(new SimpleHashAlgorithm());
    }

    public String hashDocument(String document) {
        if (document.length() > LIMIT) {
            throw new IllegalArgumentException("Document too long");
        } else {
            SimpleHashAlgorithm algorithm = new SimpleHashAlgorithm();
            return algorithm.calculateHashCode(document);
        }
    }
}
