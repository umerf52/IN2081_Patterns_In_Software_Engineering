package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Course;
import de.tum.in.ase.pse.view.CourseDetailView;
import de.tum.in.ase.pse.view.CourseListViewInterface;

public class Controller {

	private CourseListViewInterface courseListView;

	public void saveCourse(Course course) {
		if (courseListView == null) {
			throw new NullPointerException("courseListView is null");
		}
		courseListView.addCourse(course);
		course.notifyObservers();
	}

	public CourseDetailView selectCourse(Course course) {
		CourseDetailView courseDetailView = new CourseDetailView(this, course);
		courseDetailView.show();
		return courseDetailView;
	}

	public void setCourseListView(CourseListViewInterface courseListView) {
		this.courseListView = courseListView;
	}

}
