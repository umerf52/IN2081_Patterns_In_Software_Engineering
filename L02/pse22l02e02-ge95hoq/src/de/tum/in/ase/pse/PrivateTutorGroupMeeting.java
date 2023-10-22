package de.tum.in.ase.pse;

public class PrivateTutorGroupMeeting extends TutorGroupMeeting {
	public PrivateTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, String address) {
		setTimeSlot(timeSlot);
		setTutorGroup(tutorGroup);
		setSkillToPractice(skillToPractice);
		setAddress(address);
	}

	public void practice() {
		Student tutor = getTutorGroup().getTutor();
		tutor.say("Welcome to the private tutor meeting :)");
		tutor.say("Thank you for coming to " + getAddress() + " today.");
		tutor.say("Please don't forget to wash your hands.");
		super.presentations(tutor);
		tutor.say("By the way I wanted to remind you this meeting happens regularly at " + getAddress() + " on "
				+ getTimeSlot().getDayOfWeek() + " starting at " + getTimeSlot().getStartTime() + " and finishing at "
				+ getTimeSlot().getEndTime() + ".");
		super.groupWork(tutor);
		tutor.say("Thank you that you have participated today.");
		tutor.say("See you next time at " + getAddress() + "!");
	}
}
