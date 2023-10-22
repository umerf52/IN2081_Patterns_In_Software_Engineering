package de.tum.in.ase.pse;

import java.net.URL;

public class VirtualTutorGroupMeeting extends TutorGroupMeeting {
	public VirtualTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, URL url) {
		setTimeSlot(timeSlot);
		setTutorGroup(tutorGroup);
		setSkillToPractice(skillToPractice);
		setUrl(url);
	}

	public void practice() {
		Student tutor = getTutorGroup().getTutor();
		tutor.say("Welcome to the virtual tutor meeting :)");
		tutor.say("Thank you for joining using " + getUrl().toString() + " today.");
		tutor.say("Please turn on your cameras.");
		super.presentations(tutor);
		tutor.say("By the way I wanted to remind you this meeting happens regularly online on "
				+ getTimeSlot().getDayOfWeek() + " starting at " + getTimeSlot().getStartTime() + " and finishing at "
				+ getTimeSlot().getEndTime() + ", you can join it with the link " + getUrl() + ".");
		super.groupWork(tutor);
		tutor.say("Thank you that you have participated using the " + getUrl() + " today.");
		tutor.say("See you next time!");
	}
}
