package de.tum.in.ase.pse.control;

import java.util.ArrayList;
import java.util.List;

import de.tum.in.ase.pse.blackboard.BlackBoard;
import de.tum.in.ase.pse.knowledgesource.KnowledgeSource;

import static de.tum.in.ase.pse.blackboard.BlackBoardState.DONE;
import static de.tum.in.ase.pse.blackboard.BlackBoardState.INPUT_SENTENCE_SET;

public class Control {

	private final BlackBoard blackBoard;
	private final InputSource inputSource;

	public Control(final BlackBoard blackBoard) {
		this.blackBoard = blackBoard;
		this.inputSource = new InputSource();
	}

	public void start() {
		for (String sentence : inputSource.getSentences()) {
			this.blackBoard.clean();
			this.blackBoard.setInputSentence(sentence);
			this.blackBoard.setState(INPUT_SENTENCE_SET);
			applyKnowledgeSources();
			System.out.println("\nOriginal sentence: " + sentence);
			System.out.println("Synonym sentence: " + this.blackBoard.getSynonymSentence());
			System.out.println("Encrypted sentence: " + this.blackBoard.getEncryptedSentence() + "\n");
		}
	}

	public void applyKnowledgeSources() {
		while (blackBoard.getState() != DONE) {
			List<KnowledgeSource> candidateKnowledgeSources = new ArrayList<>();
			for (KnowledgeSource knowledgeSource : this.blackBoard.getKnowledgeSources()) {
				// TODO 6: Check if the knowledge source can perform an action
				if (knowledgeSource.executeCondition()) {
					candidateKnowledgeSources.add(knowledgeSource);
				}
			}

			// TODO 7: Perform the actions of the candidateKnowledgeSources or set the state
			// of the blackboard to DONE
			if (candidateKnowledgeSources.isEmpty()) {
				blackBoard.setState(DONE);
			} else {
				for (KnowledgeSource knowledgeSource : candidateKnowledgeSources) {
					knowledgeSource.executeAction();
				}
			}

			// TODO: Remove this. It just prevents an endless loop
//			return;
		}
	}
}
