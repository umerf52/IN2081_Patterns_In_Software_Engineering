package de.tum.in.ase.pse.knowledgesource;

public class TaggedWord {
	private final String word;
	private final String tag;

	public TaggedWord(String word) {
		this.word = word;
		this.tag = createTag();
	}

	public String getWord() {
		return word;
	}

	public String getTag() {
		return tag;
	}

	private String createTag() {
		return switch (word) {
			case "TUM" -> "excellence";
			case "LMU" -> "mediocre";
			case "Penguin", "Seal" -> "antarctic animal";
			case "Lion", "Giraffe", "Zebra", "Hippopotamus", "Lemur" -> "african animal";
			default -> null;
		};
	}
}
