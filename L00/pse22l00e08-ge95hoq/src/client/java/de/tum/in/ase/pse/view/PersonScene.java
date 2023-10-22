package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.L00E08ClientApplication;
import de.tum.in.ase.pse.controller.PersonController;
import de.tum.in.ase.pse.model.Person;
import de.tum.in.ase.pse.util.PersonSortingOptions;
import de.tum.in.ase.pse.util.PersonSortingOptions.SortField;
import de.tum.in.ase.pse.util.PersonSortingOptions.SortingOrder;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

import java.time.LocalDate;
import java.util.List;

public class PersonScene extends Scene {
	private final PersonController personController;
	private final L00E08ClientApplication application;
	private final PersonSortingOptions sortingOptions;
	private final ObservableList<Person> personList;
	private final TableView<Person> table;

	public PersonScene(PersonController personController, L00E08ClientApplication application) {
		super(new VBox(), 640, 500);
		this.personController = personController;
		this.application = application;
		this.sortingOptions = new PersonSortingOptions();
		this.personList = FXCollections.observableArrayList();

		table = new TableView<>(personList);
		table.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown()) {
				showPopup(table.getSelectionModel().getSelectedItem());
			}
		});

		var idColumn = new TableColumn<Person, String>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		idColumn.setSortable(false);
		idColumn.setPrefWidth(620 / 4D);
		var firstNameColumn = new TableColumn<Person, String>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		firstNameColumn.setSortable(false);
		firstNameColumn.setPrefWidth(620 / 4D);
		var lastNameColumn = new TableColumn<Person, String>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		lastNameColumn.setSortable(false);
		lastNameColumn.setPrefWidth(620 / 4D);
		var birthdayColumn = new TableColumn<Person, String>("Birthday");
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		birthdayColumn.setSortable(false);
		birthdayColumn.setPrefWidth(620 / 4D);
		//noinspection unchecked
		table.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, birthdayColumn);

		var vBox = new VBox(10, createSortOptionBox(), table, createButtonBox());
		vBox.setAlignment(Pos.CENTER);
		setRoot(vBox);

		personController.getAllPersons(sortingOptions, this::setPeople);
	}

	private HBox createSortOptionBox() {
		var sortFieldChoiceBox = new ChoiceBox<SortField>();
		sortFieldChoiceBox.getItems().addAll(SortField.values());
		sortFieldChoiceBox.setValue(sortingOptions.getSortField());
		sortFieldChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			sortingOptions.setSortField(newValue);
			personController.getAllPersons(sortingOptions, this::setPeople);
		});

		var sortingOrderChoiceBox = new ChoiceBox<SortingOrder>();
		sortingOrderChoiceBox.getItems().addAll(SortingOrder.values());
		sortingOrderChoiceBox.setValue(sortingOptions.getSortingOrder());
		sortingOrderChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			sortingOptions.setSortingOrder(newValue);
			personController.getAllPersons(sortingOptions, this::setPeople);
		});

		var hBox = new HBox(10, sortFieldChoiceBox, sortingOrderChoiceBox);
		hBox.setAlignment(Pos.CENTER);
		return hBox;
	}

	private HBox createButtonBox() {
		var backButton = new Button("Back");
		backButton.setOnAction(event -> application.showHomeScene());

		var addButton = new Button("Add Person");
		addButton.setOnAction(event -> showPopup(null));

		var refreshButton = new Button("Refresh");
		refreshButton.setOnAction(event -> personController.getAllPersons(sortingOptions, this::setPeople));

		var buttonBox = new HBox(10, backButton, addButton, refreshButton);
		buttonBox.setAlignment(Pos.CENTER);
		return buttonBox;
	}

	private void showPopup(Person person) {
		var popup = new Popup();
		var firstNameTextField = new TextField();
		firstNameTextField.setPromptText("First Name");
		firstNameTextField.setText(person == null ? "" : person.getFirstName());

		var lastNameTextField = new TextField();
		lastNameTextField.setPromptText("Last Name");
		lastNameTextField.setText(person == null ? "" : person.getLastName());

		var birthdayPicker = new DatePicker();
		birthdayPicker.setValue(person == null ? LocalDate.now() : person.getBirthday());

		var addButton = new Button("Save");
		addButton.setOnAction(event -> {
			var newPerson = person != null ? person : new Person();
			newPerson.setFirstName(firstNameTextField.getText());
			newPerson.setLastName(lastNameTextField.getText());
			newPerson.setBirthday(birthdayPicker.getValue());
			if (person == null) {
				personController.addPerson(newPerson, this::setPeople);
			} else {
				personController.updatePerson(newPerson, this::setPeople);
			}
			popup.hide();
		});

		var cancelButton = new Button("Cancel");
		cancelButton.setOnAction(event -> popup.hide());

		var deleteButton = new Button("Delete");
		deleteButton.setTextFill(Color.RED);
		deleteButton.setOnAction(event -> {
			personController.deletePerson(person, this::setPeople);
			popup.hide();
		});

		var hBox = new HBox(10, addButton, cancelButton);
		hBox.setAlignment(Pos.CENTER);
		if (person != null) {
			hBox.getChildren().add(deleteButton);
		}

		var vBox = new VBox(10, firstNameTextField, lastNameTextField, birthdayPicker, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		vBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		vBox.setPrefWidth(200);
		vBox.setPrefHeight(150);
		vBox.setPadding(new Insets(5));
		popup.getContent().add(vBox);
		popup.show(application.getStage());
		popup.centerOnScreen();
	}

	private void setPeople(List<Person> people) {
		Platform.runLater(() -> personList.setAll(people));
	}
}
