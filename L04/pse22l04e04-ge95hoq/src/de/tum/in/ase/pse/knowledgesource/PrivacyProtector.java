package de.tum.in.ase.pse.knowledgesource;

import de.tum.in.ase.pse.blackboard.BlackBoard;
import de.tum.in.ase.pse.blackboard.BlackBoardState;
import org.jasypt.util.text.BasicTextEncryptor;

import java.util.List;

//TODO 1: Implement the PrivacyProtector as stated in the UML diagram
public class PrivacyProtector extends KnowledgeSource {
	private static final String ENCRYPTION_KEY = "SXGWOwgzldpLZPDkoHell0ifWrlduJYvjhtysecureFrOmN$A.ACE";

	public PrivacyProtector(BlackBoard blackBoard) {
		super(blackBoard);
	}

	public boolean executeCondition() {
		// TODO 2: Return if this knowledge source can execute an action
		return isEncryptionRequired() && !(this.blackBoard.getState() == BlackBoardState.ENCRYPTED_SENTENCE_SET);
	}

	public void executeAction() {
		updateBlackBoard();
	}

	protected void updateBlackBoard() {
		// TODO 3: Encrypt the synonym sentence that is stored on the blackboard.
		String encryptedSentence = encrypt(blackBoard.getSynonymSentence());
		blackBoard.setEncryptedSentence(encryptedSentence);
		blackBoard.setState(BlackBoardState.ENCRYPTED_SENTENCE_SET);
	}

	private boolean isEncryptionRequired() {
		// TODO 4: Uncomment this code to compute whether encryption is needed

        List<TaggedWord> taggedValues = this.blackBoard.getTaggedValues();
        if (taggedValues != null && !taggedValues.isEmpty()) {
            for (TaggedWord word : taggedValues) {
                if ("excellence".equals(word.getTag()) || "antarctic animal".equals(word.getTag())) {
                    return true;
                }
            }
        }
		return false;
	}

	private String encrypt(String plainText) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(ENCRYPTION_KEY);
		return textEncryptor.encrypt(plainText);
	}
}
