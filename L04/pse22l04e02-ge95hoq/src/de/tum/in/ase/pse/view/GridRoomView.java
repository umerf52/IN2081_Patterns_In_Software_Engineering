package de.tum.in.ase.pse.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GridRoomView extends Stage {

	private static final int OFFSET = 10;
	private static final int V_GAP = 8;
	private static final int H_GAP = 10;

	private void configTextFieldForInts(TextField textField) {
		textField.setTextFormatter(new TextFormatter<>((TextFormatter.Change change) -> {
			if (change.getControlNewText().matches("-?\\d*")) {
				return change;
			}
			return null;
		}));
	}

	protected GridPane createGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(OFFSET, OFFSET, OFFSET, OFFSET));
		gridPane.setVgap(V_GAP);
		gridPane.setHgap(H_GAP);
		return gridPane;
	}

	protected Label createLabel(String text, int columnIndex, int rowIndex) {
		Label label = new Label(text);
		GridPane.setConstraints(label, columnIndex, rowIndex);
		return label;
	}

	protected TextField createIntegerTextField(int columnIndex, int rowIndex) {
		TextField textField = new TextField();
		configTextFieldForInts(textField);
		GridPane.setConstraints(textField, columnIndex, rowIndex);
		return textField;
	}

	protected Button createButton(String text, int columnIndex, int rowIndex) {
		Button button = new Button(text);
		GridPane.setConstraints(button, columnIndex, rowIndex);
		return button;
	}

	protected Label createLabelWithHighlight(String text, int columnIndex, int rowIndex) {
		Label label = new Label(text);
		GridPane.setConstraints(label, columnIndex, rowIndex);
		label.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		return label;
	}

	protected Label createLabelWithConstraintsAndBorder(String text, int columnIndex, int rowIndex) {
		Label label = new Label(text);
		GridPane.setConstraints(label, columnIndex, rowIndex);
		label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		return label;
	}

	protected Label createLabelWithBorder(String text, int columnIndex, int rowIndex) {
		Label label = new Label(text);
		GridPane.setConstraints(label, columnIndex, rowIndex);
		label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		return label;
	}

	protected <T> ComboBox<T> createComboBox(List<T> values, int columnIndex, int rowIndex) {
		ComboBox<T> comboBox = new ComboBox<>();
		comboBox.setItems(FXCollections.observableArrayList(values));
		GridPane.setConstraints(comboBox, columnIndex, rowIndex);
		return comboBox;
	}
}
