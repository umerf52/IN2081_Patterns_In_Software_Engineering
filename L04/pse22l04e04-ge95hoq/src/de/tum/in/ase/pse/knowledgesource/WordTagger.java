package de.tum.in.ase.pse.knowledgesource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.tum.in.ase.pse.blackboard.BlackBoard;
import de.tum.in.ase.pse.blackboard.BlackBoardState;

import static de.tum.in.ase.pse.blackboard.BlackBoardState.TOPIC_SENTENCE_SET;

public class WordTagger extends KnowledgeSource {

	public WordTagger(BlackBoard blackboard) {
		super(blackboard);
	}

	private String[] splitSentence(String sentence) {
		return sentence.split(" ");
	}

	private List<TaggedWord> taggWords(String[] splitSentence) {
		return Arrays.stream(splitSentence)
				.map(TaggedWord::new)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public boolean executeCondition() {
		// This knowledge source should take action only if there is raw
		// text is on the BlackBoard
		return this.blackBoard.getState() == BlackBoardState.SYNONYM_SENTENCE_SET;
	}

	@Override
	public void executeAction() {
		updateBlackBoard();
	}

	@Override
	protected void updateBlackBoard() {
		String rawSentence = this.blackBoard.getSynonymSentence();
		if (rawSentence != null) {
			String[] splitSentence = splitSentence(rawSentence);
			this.blackBoard.setTaggedValues(taggWords(splitSentence));
			this.blackBoard.setState(TOPIC_SENTENCE_SET);
		}
	}
}
