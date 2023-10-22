package de.tum.in.ase.pse;

public class EnterpriseHashing extends Hashing {
    public EnterpriseHashing() {
        setImplementation(new CryptoSecureHashAlgorithm());
    }

    @Override
    public String hashDocument(String document) {
        CryptoSecureHashAlgorithm algorithm = new CryptoSecureHashAlgorithm();
        return algorithm.calculateHashCode(document);
    }
}
