package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.controller.Controller;
import de.tum.in.ase.pse.model.Course;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseDetailView extends Stage implements CourseDetailViewInterface {

	// controller
	private Controller controller;

	// model
	private Course course;

	//GUI Objects
	private TextField idTextField;
	private TextField nameTextField;
	private Button saveButton;
	private static final int PADDING = 10;
	private static final int VGAP = 8;
	private static final int HGAP = 10;
	private static final int SCENE_WIDTH = 300;
	private static final int SCENE_HEIGHT = 130;

	public CourseDetailView(Controller controller, Course course) {
		this.controller = controller;
		this.course = course;
		course.addObserver(this);

		this.idTextField = new TextField(course.getId());
		this.nameTextField = new TextField(course.getName());

		generateUserInterface();
	}

	public void save() {
		course.setId(idTextField.getText());
		course.setName(nameTextField.getText());
		controller.saveCourse(course);
	}

	@Override
	public void update() {
		this.idTextField.setText(course.getId());
		this.nameTextField.setText(course.getName());
		this.setTitle(course.toString());
	}

	private void generateUserInterface() {

		VBox vbox = new VBox();

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		grid.setVgap(VGAP);
		grid.setHgap(HGAP);

		Label idLabel = new Label("ID: ");
		GridPane.setConstraints(idLabel, 0, 0);
		GridPane.setConstraints(idTextField, 1, 0);
		Label nameLabel = new Label("Name ");
		GridPane.setConstraints(nameLabel, 0, 1);
		GridPane.setConstraints(nameTextField, 1, 1);

		saveButton = new Button("save changes");
		GridPane.setConstraints(saveButton, 0, 2);
		saveButton.setOnAction(event -> save());

		grid.getChildren().addAll(idLabel, nameLabel);
		grid.getChildren().addAll(idTextField, nameTextField);
		grid.getChildren().add(saveButton);
		vbox.getChildren().add(grid);

		Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);
		setScene(scene);
		if (this.course.getName() != null) {
			setTitle(this.course.getId() + " " + this.course.getName());
		} else {
			setTitle("Create a new course");
		}
	}
}
