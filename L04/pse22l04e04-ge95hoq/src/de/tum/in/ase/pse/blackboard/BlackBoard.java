package de.tum.in.ase.pse.blackboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.tum.in.ase.pse.knowledgesource.KnowledgeSource;
import de.tum.in.ase.pse.knowledgesource.TaggedWord;

public class BlackBoard {

	private BlackBoardState state = BlackBoardState.CLEAN;
	private List<KnowledgeSource> knowledgeSources = new ArrayList<>();

	private String inputSentence;
	private List<TaggedWord> taggedValues = new ArrayList<>();
	private String synonymSentence;
	private String encryptedSentence;

	public List<KnowledgeSource> getKnowledgeSources() {
		if (knowledgeSources == null) {
			knowledgeSources = new ArrayList<>();
		}
		return Collections.unmodifiableList(knowledgeSources);
	}

	public void addKnowledgeSource(KnowledgeSource ks) {
		if (knowledgeSources == null) {
			knowledgeSources = new ArrayList<>();
		}
		knowledgeSources.add(ks);
	}

	public void clean() {
		this.inputSentence = null;
		this.taggedValues.clear();
		this.synonymSentence = null;
		this.encryptedSentence = null;
		this.state = BlackBoardState.CLEAN;
	}

	public BlackBoardState getState() {
		return state;
	}

	public void setState(BlackBoardState state) {
		this.state = state;
	}

	public String getInputSentence() {
		return inputSentence;
	}

	public void setInputSentence(String inputSentence) {
		this.inputSentence = inputSentence;
	}

	public void setSynonymSentence(String synonymSentence) {
		this.synonymSentence = synonymSentence;
	}

	public String getSynonymSentence() {
		return this.synonymSentence;
	}

	public void setTaggedValues(List<TaggedWord> taggedValues) {
		this.taggedValues = taggedValues;
	}

	public List<TaggedWord> getTaggedValues() {
		return Collections.unmodifiableList(taggedValues);
	}

	public void setEncryptedSentence(String encryptedSentence) {
		this.encryptedSentence = encryptedSentence;
	}

	public String getEncryptedSentence() {
		return this.encryptedSentence;
	}
}
