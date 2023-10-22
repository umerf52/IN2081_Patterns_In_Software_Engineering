package de.tum.in.ase.pse.knowledgesource;

import java.util.HashMap;
import java.util.Map;

import de.tum.in.ase.pse.blackboard.BlackBoard;
import de.tum.in.ase.pse.blackboard.BlackBoardState;

import static de.tum.in.ase.pse.blackboard.BlackBoardState.SYNONYM_SENTENCE_SET;

public class SynonymIdentifier extends KnowledgeSource {

	private final Map<String, String> replacementMap = new HashMap<>();

	public SynonymIdentifier(BlackBoard blackBoard) {
		super(blackBoard);
		initializeReplacementMap();
	}

	@Override
	public boolean executeCondition() {
		return this.blackBoard.getState() == BlackBoardState.INPUT_SENTENCE_SET;
	}

	@Override
	public void executeAction() {
		updateBlackBoard();
	}

	@Override
	protected void updateBlackBoard() {
		String[] inputWords = blackBoard.getInputSentence().split("[ ,]");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < inputWords.length; i++) {
			builder.append(replacementMap.getOrDefault(inputWords[i], inputWords[i]));
			if (i != inputWords.length - 1) {
				builder.append(" ");
			}
		}
		this.blackBoard.setSynonymSentence(builder.toString());
		this.blackBoard.setState(SYNONYM_SENTENCE_SET);
	}

	private void initializeReplacementMap() {
		// Universities:
		replacementMap.put("Technische-Universität-München", "TUM");
		replacementMap.put("Technical-University-Munich", "TUM");
		replacementMap.put("Ludwig-Maximilian-Universität", "LMU");
		replacementMap.put("Ludwig-Maximilian-University", "LMU");
		replacementMap.put("Rheinisch-Westfälische-Technische-Hochschule-Aachen", "RWTH");
		replacementMap.put("Karlsruhe-Institute-of-Technology", "KIT");

		// Animals from the movie "Madagascar"
		replacementMap.put("Private", "Penguin");
		replacementMap.put("Skipper", "Penguin");
		replacementMap.put("Kowalski", "Penguin");
		replacementMap.put("Rico", "Penguin");
		replacementMap.put("Alex", "Lion");
		replacementMap.put("Malman", "Giraffe");
		replacementMap.put("Marty", "Zebra");
		replacementMap.put("Gloria", "Hippopotamus");
		replacementMap.put("Julien", "Lemur");
		// From Madagascar 3
		replacementMap.put("Stefano", "Seal");
	}
}
