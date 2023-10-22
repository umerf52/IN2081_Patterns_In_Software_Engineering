package de.tum.in.ase.pse;

import de.tum.in.ase.pse.controller.Controller;
import de.tum.in.ase.pse.model.Course;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class should contain only two testcases {@link #testCourseDetailViewUpdate()} and
 * {@link #testCourseUpdateOnSave()}.
 * <p>
 * In this exercise you'll be only using the mocks of the view classes instead of the classes themselves. This will
 * make life way easier for everyone because we want to test the communication between model, view and controller
 * and not if the GUI works correctly.
 */
class UniversityTest {

	//TODO 1: Implement this method according to the problem statement
	@Test
	void testCourseDetailViewUpdate() {
		Controller controller = new Controller();
		Course course = new Course("PSE", "Programming Studio");
		CourseDetailViewMock courseDetailViewMock = new CourseDetailViewMock(controller, course);
		course.setId("123");
		course.setName("new name");
		courseDetailViewMock.update();
		assertEquals("123", courseDetailViewMock.getId());
		assertEquals("new name", courseDetailViewMock.getName());
	}

	//TODO 2: Implement this method according to the problem statement
	@Test
	void testCourseUpdateOnSave() {
		Controller controller = new Controller();
		Course course1 = new Course("PSE", "Programming Studio");
		Course course2 = new Course("PSE1", "Programming Studio1");
		List<Course> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		CourseDetailViewMock courseDetailViewMock = new CourseDetailViewMock(controller, courses.get(0));
		new CourseListViewMock(controller, courses);
		courseDetailViewMock.setId("123");
		courseDetailViewMock.setName("new name");
		courseDetailViewMock.save();
		assertEquals("123", courses.get(0).getId());
		assertEquals("new name", courses.get(0).getName());
	}
}
