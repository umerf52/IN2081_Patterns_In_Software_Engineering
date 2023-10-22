package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.L00E08ClientApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomeScene extends Scene {
	public HomeScene(L00E08ClientApplication application) {
		super(new VBox(), 640, 500);

		var noteButton = new Button("Notes");
		noteButton.setOnAction(event -> application.showNoteScene());

		var personButton = new Button("Persons");
		personButton.setOnAction(event -> application.showPersonScene());

		var vBox = new VBox(10, noteButton, personButton);
		vBox.setAlignment(Pos.CENTER);
		setRoot(vBox);
	}
}
