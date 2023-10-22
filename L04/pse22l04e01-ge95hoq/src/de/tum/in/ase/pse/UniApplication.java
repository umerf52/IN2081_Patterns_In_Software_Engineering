package de.tum.in.ase.pse;

import de.tum.in.ase.pse.controller.Controller;
import de.tum.in.ase.pse.model.Course;
import de.tum.in.ase.pse.view.CourseListView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public final class UniApplication extends Application {

	/**
	 * main method in order to be called from University Main.
	 */
	public static void startApp(String[] args) {
		launch(args);
	}

	/**
	 * This method is setting up everything for local testing.
	 */
	@Override
	public void start(Stage primaryStage) {
		List<Course> courses = new ArrayList<>();
		Course designPatterns = new Course("IN2081", "Design Patterns");
		courses.add(designPatterns);
		Course eist = new Course("IN0006", "EIST");
		courses.add(eist);
		Course interactiveLearning = new Course("IN0012", "Interactive Learning");
		courses.add(interactiveLearning);
		Course agileProjectManagement = new Course("IN0014", "Agile Project Management");
		courses.add(agileProjectManagement);

		Controller controller = new Controller();

		CourseListView courseListView = new CourseListView(controller, courses);
		courseListView.show();

	}

}
