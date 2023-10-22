package de.tum.in.ase.pse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ExamSystem {

	private ExamSystem() {
	}

	// TODO 5: Change signature, make use of the bridge pattern
	public static String hashFile(String document, Hashing hashing) {
		return hashing.hashDocument(document);
	}

	public static void main(String[] args) throws IOException {
		String file1 = readFile("exams/short_exam.txt");
		String file2 = readFile("exams/long_exam.txt");  //This file is too big for Preview Hashing

		// TODO 6: Change SimpleHash to PreviewHashing
		PreviewHashing simpleHash = new PreviewHashing();

		System.out.println(hashFile(file1, simpleHash));
		try {
			System.out.println(hashFile(file2, simpleHash));
			throw new IllegalStateException("Hashing this file with preview hashing should not work!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		// TODO 6: Change CryptoSecureHashAlgorithm to EnterpriseHashing
		EnterpriseHashing cryptoSecureHash = new EnterpriseHashing();

		System.out.println(hashFile(file1, cryptoSecureHash));
		System.out.println(hashFile(file2, cryptoSecureHash));
	}

	public static String readFile(String filepath) throws IOException {
		Path path = Path.of(filepath);
		// TODO 4: Return the content of the passed file as a String.
		try {
			return Files.readString(path);
		} catch (IOException e) {
			throw new RuntimeException("File not found");
		}
	}

}
