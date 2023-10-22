package de.tum.in.ase.pse.control;

import java.util.ArrayList;
import java.util.List;

public class InputSource {
	private static final String TUM = "The Technical-University-Munich is one of the best universities in Munich";
	private static final String LMU = "Another university in Munich is the Ludwig-Maximilian-University";
	private static final String KIT_AND_RWTH = "But there are other good universities as well like the Karlsruhe-Technical-University or the RWTH";
	private static final String MADAGASCAR = "Madagascar is a famous movie staring Alex, Marty, Malman and Gloria";
	private static final String PENGUINS = "Some side characters that even got their own series are Skipper, Kowalski, Private, and Rico";
	private final List<String> sentences;

	public InputSource() {
		sentences = new ArrayList<>();
		sentences.add(TUM);
		sentences.add(LMU);
		sentences.add(KIT_AND_RWTH);
		sentences.add(MADAGASCAR);
		sentences.add(PENGUINS);
	}

	public List<String> getSentences() {
		return sentences;
	}
}
