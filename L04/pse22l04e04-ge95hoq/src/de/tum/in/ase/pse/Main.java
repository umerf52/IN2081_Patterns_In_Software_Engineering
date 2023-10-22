package de.tum.in.ase.pse;

import de.tum.in.ase.pse.blackboard.BlackBoard;
import de.tum.in.ase.pse.control.Control;
import de.tum.in.ase.pse.knowledgesource.PrivacyProtector;
import de.tum.in.ase.pse.knowledgesource.SynonymIdentifier;
import de.tum.in.ase.pse.knowledgesource.WordTagger;

public class Main {
	public static void main(String[] args) {
		BlackBoard blackBoard = new BlackBoard();

		blackBoard.addKnowledgeSource(new SynonymIdentifier(blackBoard));
		blackBoard.addKnowledgeSource(new WordTagger(blackBoard));

		// TODO 5: Add the PrivacyProtector to the blackboard
		 blackBoard.addKnowledgeSource(new PrivacyProtector(blackBoard));

		Control control = new Control(blackBoard);
		control.start();
	}
}
