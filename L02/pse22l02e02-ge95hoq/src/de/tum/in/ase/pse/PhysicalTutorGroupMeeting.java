package de.tum.in.ase.pse;

public class PhysicalTutorGroupMeeting extends TutorGroupMeeting {
	public PhysicalTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, String room) {
		setTimeSlot(timeSlot);
		setTutorGroup(tutorGroup);
		setSkillToPractice(skillToPractice);
		setRoom(room);
	}

	public void practice() {
		Student tutor = getTutorGroup().getTutor();
		tutor.say("Welcome to the physical tutor meeting :)");
		tutor.say("Thank you for coming to " + getRoom() + " today.");
		super.presentations(tutor);
		tutor.say("By the way I wanted to remind you this meeting happens regularly in person on "
				+ getTimeSlot().getDayOfWeek() + " starting at " + getTimeSlot().getStartTime()
				+ " and finishing at " + getTimeSlot().getEndTime() + " in the room " + getRoom() + ".");
		super.groupWork(tutor);
		tutor.say("Thank you that you have participated in " + getRoom() + " today.");
		tutor.say("See you next time!");
	}
}
