package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.controller.Controller;
import de.tum.in.ase.pse.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;

public class CourseListView extends Stage implements CourseListViewInterface {

	// controller
	private Controller controller;

	// model
	private ObservableList<Course> courses;

	//GUI Objects
	private ListView<Course> courseListView;
	private Button createButton;
	private static final int SCENE_SIZE = 300;

	public CourseListView(Controller controller, List<Course> courseList) {
		this.controller = controller;
		this.courses = FXCollections.observableArrayList(courseList);
		for (Course course : courses) {
			course.addObserver(this);
		}
		this.courseListView = new ListView<>(courses);
		generateUserInterface();
		controller.setCourseListView(this);
	}

	public void selectCourse(Course course) {
		controller.selectCourse(course);
	}

	public void createCourse() {
		controller.selectCourse(new Course());
	}

	public void addCourse(Course course) {
		if (!courses.contains(course)) {
			this.courses.add(course);
			course.addObserver(this);
		}
	}

	@Override
	public List<Course> getCourses() {
		return Collections.unmodifiableList(courses);
	}

	@Override
	public void update() {
		displayCourses();
	}

	private void displayCourses() {
		courseListView.refresh();
	}

	private void generateUserInterface() {

		VBox vbox = new VBox();

		createButton = new Button("Create a course");
		createButton.setOnAction(event -> createCourse());

		Label courseListLabel = new Label("Course List");
		courseListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		courseListView.setOnMouseClicked(event -> selectCourse(courseListView.getSelectionModel().getSelectedItem()));
		vbox.getChildren().addAll(courseListLabel, courseListView, createButton);

		Scene scene = new Scene(vbox, SCENE_SIZE, SCENE_SIZE);
		setScene(scene);
		setTitle("Course List");
		displayCourses();
	}
}
