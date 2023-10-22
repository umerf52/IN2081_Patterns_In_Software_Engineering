package de.tum.in.ase.pse;

import java.util.HashSet;
import java.util.Set;

public class TutorGroup {

	private final String id;
	private final TimeSlot timeSlot;
	private final Student tutor;
	private final Set<Student> students;

	public TutorGroup(String id, TimeSlot timeSlot, Student tutor) {
		this.id = id;
		this.timeSlot = timeSlot;
		this.tutor = tutor;
		this.students = new HashSet<>();
	}

	public String getId() {
		return id;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public Student getTutor() {
		return tutor;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void register(Student student) {
		students.add(student);
	}
}
