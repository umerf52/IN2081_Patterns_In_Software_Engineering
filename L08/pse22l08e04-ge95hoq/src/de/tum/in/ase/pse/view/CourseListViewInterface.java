package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.model.Course;

import java.util.List;

public interface CourseListViewInterface extends Observer {
	void selectCourse(Course course);

	void createCourse();

	void addCourse(Course course);

	List<Course> getCourses();
}

