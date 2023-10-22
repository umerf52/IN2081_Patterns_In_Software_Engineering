package de.tum.in.ase.pse.common;

public interface DictionaryService extends Service {

	String SERVICE_NAME_DICTIONARY = "Dictionary service";

	String lookupWord(String word);

}
