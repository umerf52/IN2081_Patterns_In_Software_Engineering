package de.tum.in.ase.pse.knowledgesource;

import de.tum.in.ase.pse.blackboard.BlackBoard;


public abstract class KnowledgeSource {

	protected BlackBoard blackBoard;

	protected KnowledgeSource(BlackBoard blackBoard) {
		this.blackBoard = blackBoard;
	}

	protected abstract void updateBlackBoard();

	public abstract boolean executeCondition();

	public abstract void executeAction();
}
