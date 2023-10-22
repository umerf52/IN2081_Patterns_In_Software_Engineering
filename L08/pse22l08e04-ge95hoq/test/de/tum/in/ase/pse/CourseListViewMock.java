package de.tum.in.ase.pse;

import com.sun.javafx.UnmodifiableArrayList;
import de.tum.in.ase.pse.controller.Controller;
import de.tum.in.ase.pse.model.Course;
import de.tum.in.ase.pse.view.CourseListViewInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * This class is responsible for representing {@link de.tum.in.ase.pse.view.CourseListView} in a way that makes it
 * easier to test by removing the UI elements.
 * Keep in mind that this is <b>not</b> suitable for actual testing since we are technically testing the mock instead
 * of the actual implementation even though it works the same way.
 */
public class CourseListViewMock implements CourseListViewInterface {
	private Controller controller;

	private ObservableList<Course> courses;

	public CourseListViewMock(Controller controller, List<Course> courseList) {
		this.controller = controller;
		this.courses = FXCollections.observableArrayList(courseList);
		for (Course course : courses) {
			course.addObserver(this);
		}
		controller.setCourseListView(this);
	}

	@Override
	public List<Course> getCourses() {
		return new UnmodifiableArrayList<>(courses.toArray(new Course[]{}), courses.size());
	}

	@Override
	public void update() {
		//empty implementation

		//refresh of the UI
	}

	@Override
	public void createCourse() {
		controller.selectCourse(new Course());
	}

	@Override
	public void selectCourse(Course course) {
		controller.selectCourse(course);
	}

	@Override
	public void addCourse(Course course) {
		if (!courses.contains(course)) {
			this.courses.add(course);
			course.addObserver(this);
		}
	}

	public Controller getController() {
		return controller;
	}
}
