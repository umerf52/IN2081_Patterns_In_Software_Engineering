package de.tum.in.ase.pse;

import de.tum.in.ase.pse.controller.Controller;
import de.tum.in.ase.pse.model.Course;
import de.tum.in.ase.pse.view.CourseDetailViewInterface;

/**
 * This class is responsible for representing {@link de.tum.in.ase.pse.view.CourseDetailView} in a way that makes it
 * easier to test by removing the UI elements.
 * Keep in mind that this is <b>not</b> suitable for actual testing since we are technically testing the mock instead
 * of the actual implementation even though it works the same way.
 *
 * @see #id represents {@link de.tum.in.ase.pse.view.CourseDetailView#idTextField}
 * @see #name represents {@link de.tum.in.ase.pse.view.CourseDetailView#nameTextField}
 */
public class CourseDetailViewMock implements CourseDetailViewInterface {
	private String id;
	private String name;

	private Controller controller;
	private Course course;

	public CourseDetailViewMock(Controller controller, Course course) {
		this.controller = controller;
		this.course = course;
		course.addObserver(this);

		this.id = course.getId();
		this.name = course.getName();
	}

	@Override
	public void update() {
		this.id = course.getId();
		this.name = course.getName();
	}

	@Override
	public void save() {
		course.setId(id);
		course.setName(name);
		controller.saveCourse(course);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
