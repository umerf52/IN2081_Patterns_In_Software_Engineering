package de.tum.in.ase.pse;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class TutorGroupMeeting {
    public static final int NUMBER_OF_HOMEWORK_PRESENTATIONS = 3;
    public static final int HOUR = 10;
    public static final int MINUTE = 0;
    public static final int HOUR1 = 12;
    public static final int MINUTE1 = 0;
    public static final int AGE = 21;
    public static final int SEMESTER = 4;
    public static final int AGE1 = 19;
    public static final int SEMESTER1 = 2;
    public static final int AGE2 = 21;
    public static final int SEMESTER2 = 2;
    public static final int AGE3 = 19;
    public static final int SEMESTER3 = 2;
    public static final int HOUR2 = 16;
    public static final int MINUTE2 = 0;
    public static final int HOUR3 = 18;
    public static final int MINUTE3 = 0;
    public static final int AGE4 = 20;
    public static final int SEMESTER4 = 4;
    public static final int AGE5 = 20;
    public static final int SEMESTER5 = 2;
    public static final int HOUR4 = 11;
    public static final int MINUTE4 = 0;
    public static final int HOUR5 = 13;
    public static final int MINUTE5 = 0;
    public static final int AGE6 = 21;
    public static final int SEMESTER6 = 4;
    public static final int AGE7 = 19;
    public static final int SEMESTER7 = 2;

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setTutorGroup(TutorGroup tutorGroup) {
        this.tutorGroup = tutorGroup;
    }

    public void setSkillToPractice(Skill skillToPractice) {
        this.skillToPractice = skillToPractice;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private TimeSlot timeSlot;
    private TutorGroup tutorGroup;
    private Skill skillToPractice;
    private URL url;
    private String room;

    private String address;

    public TutorGroup getTutorGroup() {
        return this.tutorGroup;
    }

    public Skill getSkillToPractice() {
        return this.skillToPractice;
    }

    public TimeSlot getTimeSlot() {
        return this.timeSlot;
    }

    public URL getUrl() {
        return this.url;
    }

    public String getRoom() {
        return this.room;
    }

    public String getAddress() {
        return this.address;
    }


    public abstract void practice();

    public void main(String[] args) throws MalformedURLException {
        this.timeSlot = new TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(HOUR, MINUTE), LocalTime.of(HOUR1, MINUTE1));
        Student tutor = new Student("Johannes", AGE, "ge25cus", "0123456789", SEMESTER);
        this.tutorGroup = new TutorGroup("Fr01", timeSlot, tutor);
        this.skillToPractice = new Skill("Software Quality Management");

        Student student1 = new Student("Simon", AGE1, "ge97zag", "03894452", SEMESTER1);
        Student student2 = new Student("Jan-Luca", AGE2, "ge38waz", "03894453", SEMESTER2);
        Student student3 = new Student("Manuela", AGE3, "ge35giz", "03894454", SEMESTER3);

        tutorGroup.register(student1);
        tutorGroup.register(student2);
        tutorGroup.register(student3);

        PhysicalTutorGroupMeeting localTutorGroup = new PhysicalTutorGroupMeeting(timeSlot, tutorGroup,
                this.skillToPractice, "MI 01.07.014");
        localTutorGroup.practice();

        TimeSlot timeSlot2 = new TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(HOUR2, MINUTE2), LocalTime.of(HOUR3, MINUTE3));
        Student tutor2 = new Student("Christian", AGE4, "ge25rem", "1234567890", SEMESTER4);
        TutorGroup tutorGroup2 = new TutorGroup("Mi17", timeSlot2, tutor2);

        Student studentOnline = new Student("Tobias", AGE5, "ga55zzz", "03141592", SEMESTER5);
        tutorGroup2.register(studentOnline);

        VirtualTutorGroupMeeting virtualTutorGroup = new VirtualTutorGroupMeeting(timeSlot2, tutorGroup2,
                this.skillToPractice, new URL("https://tum-conf.zoom.us/j/99711605391?pwd=R3NjVGs2Y2lReVVXdk1ZaFBSMk9sUT09"));
        virtualTutorGroup.practice();

        TimeSlot timeSlot3 = new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(HOUR4, MINUTE4), LocalTime.of(HOUR5, MINUTE5));
        Student tutor3 = new Student("Julia", AGE6, "ge25quo", "1234567891", SEMESTER6);
        TutorGroup tutorGroup3 = new TutorGroup("Mo11", timeSlot3, tutor3);

        Student studentPrivate = new Student("Marie", AGE7, "ga55ram", "03894457", SEMESTER7);
        tutorGroup3.register(studentPrivate);
        PrivateTutorGroupMeeting privateTutorGroup = new PrivateTutorGroupMeeting(timeSlot3, tutorGroup3,
                this.skillToPractice, "Leopoldstraße 250");
        privateTutorGroup.practice();
    }

    public void presentations(Student tutor) {
        tutor.say("We start with the homework presentation.");
        List<Student> homeworkPresentationCandidates = new ArrayList<>(getTutorGroup().getStudents());

        for (int i = 0; i < NUMBER_OF_HOMEWORK_PRESENTATIONS; i++) {
            if (homeworkPresentationCandidates.isEmpty()) {
                break;
            }
            int randomIndex = ThreadLocalRandom.current().nextInt(homeworkPresentationCandidates.size());
            Student randomStudent = homeworkPresentationCandidates.get(randomIndex);
            randomStudent.presentHomework();
            homeworkPresentationCandidates.remove(randomIndex);
        }
    }

    public void groupWork(Student tutor) {
        tutor.say("Next is the group work!");

        Skill skill = getSkillToPractice();
        skill.apply();
        for (Student student : getTutorGroup().getStudents()) {
            student.learnSkill(skill);
        }
        tutor.say("Let's have a look at the new homework :)");
    }
}
