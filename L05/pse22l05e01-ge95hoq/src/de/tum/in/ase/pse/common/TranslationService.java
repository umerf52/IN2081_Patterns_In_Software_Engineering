package de.tum.in.ase.pse.common;

/*
 * TODO Task 1: Add variables for the French language and for the French service
 */
public interface TranslationService extends Service {

	String LANGUAGE_GERMAN = "German";
	String SERVICE_NAME_TRANSLATION_GERMAN = "German service";

	String LANGUAGE_FRENCH = "French";
	String SERVICE_NAME_TRANSLATION_FRENCH = "French service";

	String translate(String word, String language);

}
