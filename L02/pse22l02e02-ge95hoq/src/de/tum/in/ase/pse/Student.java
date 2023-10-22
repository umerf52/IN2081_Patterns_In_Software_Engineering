package de.tum.in.ase.pse;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private final String tumId;
	private final String name;
	private final String matriculationNumber;
	private final Set<String> knowledge;
	private final Set<Skill> skills;
	private final int age;
	private final int semester;

	public Student(String name, int age, String tumId, String matriculationNumber, int semester) {
		this.name = name;
		this.age = age;
		this.tumId = tumId;
		this.matriculationNumber = matriculationNumber;
		this.semester = semester;
		this.knowledge = new HashSet<>();
		this.skills = new HashSet<>();
	}

	public String getTumId() {
		return tumId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public final String getMatriculationNumber() {
		return matriculationNumber;
	}

	public final int getSemester() {
		return semester;
	}

	public final Set<String> getKnowledge() {
		return knowledge;
	}

	public final Set<Skill> getSkills() {
		return skills;
	}

	public void learnSkill(Skill newSkill) {
		skills.add(newSkill);
	}

	public void presentHomework() {
		say("I presented the homework");
	}

	public void acquireKnowledge(String newKnowledge) {
		knowledge.add(newKnowledge);
	}

	public final void say(String text) {
		System.out.println(name + " said: " + text);
	}
}
