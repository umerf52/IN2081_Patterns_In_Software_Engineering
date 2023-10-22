package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.L00E08ClientApplication;
import de.tum.in.ase.pse.controller.NoteController;
import de.tum.in.ase.pse.model.Note;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;

import java.util.List;

public class NoteScene extends Scene {
	private final NoteController noteController;
	private final L00E08ClientApplication application;
	private final FlowPane flowPane;

	public NoteScene(NoteController noteController, L00E08ClientApplication application) {
		super(new VBox(), 640, 500);
		this.noteController = noteController;
		this.application = application;

		flowPane = new FlowPane(10, 10);
		var scrollPane = new ScrollPane(flowPane);
		scrollPane.setPrefHeight(450);
		scrollPane.setFitToWidth(true);

		var vBox = new VBox(10, scrollPane, createButtonBox());

		noteController.getAllNotes(this::setNotes);
		this.setRoot(vBox);
	}

	public void setNotes(List<Note> notes) {
		Platform.runLater(() -> {
			var children = flowPane.getChildren();
			children.setAll(notes.stream().map(this::createNoteView).toList());
		});
	}

	private Node createNoteView(Note note) {
		var name = new Text(note.getName());
		name.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.EXTRA_BOLD, 20));

		var spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);

		var deleteButton = new Button("E");
		deleteButton.setTextFill(Color.ORANGE);
		deleteButton.setOnAction(event -> showPopup(note));

		var titleBox = new HBox(name, spacer, deleteButton);

		var content = new Text(note.getContent());
		var contentScrollPane = new ScrollPane(content);
		contentScrollPane.setFitToWidth(true);
		contentScrollPane.setFitToHeight(true);
		contentScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		contentScrollPane.getStyleClass().clear();
		content.wrappingWidthProperty().bind(contentScrollPane.widthProperty());

		var vBox = new VBox(10, titleBox, contentScrollPane);
		vBox.setPrefWidth(200);
		vBox.setPrefHeight(200);
		vBox.setStyle("-fx-background-color:white;");
		vBox.setPadding(new Insets(5));
		return vBox;
	}

	private HBox createButtonBox() {
		var backButton = new Button("Back");
		backButton.setOnAction(event -> application.showHomeScene());

		var addButton = new Button("Add Note");
		addButton.setOnAction(event -> showPopup(null));

		var refreshButton = new Button("Refresh");
		refreshButton.setOnAction(event -> noteController.getAllNotes(this::setNotes));

		var buttonBox = new HBox(10, backButton, addButton, refreshButton);
		buttonBox.setAlignment(Pos.CENTER);
		return buttonBox;
	}

	private void showPopup(Note note) {
		var popup = new Popup();
		var nameTextField = new TextField();
		nameTextField.setPromptText("Name");
		nameTextField.setText(note == null ? "" : note.getName());

		var contentTextArea = new TextArea();
		contentTextArea.setPromptText("Content");
		contentTextArea.setText(note == null ? "" : note.getContent());

		var addButton = new Button("Save");
		addButton.setOnAction(event -> {
			var newNote = note != null ? note : new Note();
			newNote.setName(nameTextField.getText());
			newNote.setContent(contentTextArea.getText());
			if (note == null) {
				noteController.addNote(newNote, this::setNotes);
			} else {
				noteController.editNote(newNote, this::setNotes);
			}
			popup.hide();
		});

		var cancelButton = new Button("Cancel");
		cancelButton.setOnAction(event -> popup.hide());

		var deleteButton = new Button("Delete");
		deleteButton.setTextFill(Color.RED);
		deleteButton.setOnAction(event -> {
			noteController.deleteNote(note, this::setNotes);
			popup.hide();
		});

		var hBox = new HBox(10, addButton, cancelButton);
		hBox.setAlignment(Pos.CENTER);
		if (note != null) {
			hBox.getChildren().add(deleteButton);
		}

		var vBox = new VBox(10, nameTextField, contentTextArea, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		vBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		vBox.setPrefWidth(200);
		vBox.setPrefHeight(200);
		vBox.setPadding(new Insets(5));
		popup.getContent().add(vBox);
		popup.show(application.getStage());
		popup.centerOnScreen();
	}
}
