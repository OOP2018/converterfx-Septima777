package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * This class shows components of user interface and method.
 * 
 * @author Noppawan Kulchol
 *
 */
public class ConverterController {

	@FXML
	private TextField firstLength;

	@FXML
	private ComboBox<Length> length1;

	@FXML
	private TextField secondLength;

	@FXML
	private ComboBox<Length> length2;

	/**
	 * Get the units from combo box.
	 */
	@FXML
	public void initialize() {
		// This is for testing
		System.out.println("Running initialize");

		if (length1 != null) {
			length1.getItems().addAll(Length.values());
			length1.getSelectionModel().select(0); // select an item to show
		}
		if (length2 != null) {
			length2.getItems().addAll(Length.values());
			length2.getSelectionModel().select(1); // select an item to show
		}
	}

	/**
	 * Convert from some unit to the other unit. When we put String or something
	 * that is not number it will show the message to warning.
	 * 
	 * @param event when we click convert button or pressed enter button it will
	 * work.
	 */
	@FXML
	public void handleConvert(ActionEvent event) {
		String text1 = firstLength.getText().trim();
		String text2 = secondLength.getText().trim();
		Length unit1 = length1.getValue();
		Length unit2 = length2.getValue();
		double valueLength1 = unit1.getValue();
		double valueLength2 = unit2.getValue();
		double doubleInput = 0.0;
		try {
			if (firstLength.getText().isEmpty()) {
				doubleInput = Double.parseDouble(text2);
				double answer1 = (valueLength2 / valueLength1) * doubleInput;
				firstLength.setText(String.format("%.4g", answer1));
			}
			if (secondLength.getText().isEmpty()) {
				doubleInput = Double.parseDouble(text1);
				double answer2 = (valueLength1 / valueLength2) * doubleInput;
				secondLength.setText(String.format("%.4g", answer2));
			}
		} catch (Exception e) {
			firstLength.setText("Input is invalid");
			secondLength.setText("Input is invalid");
		}

	}

	/**
	 * Clear the number from both text fields.
	 */
	@FXML
	public void handleClear() {
		firstLength.clear();
		secondLength.clear();
	}

}
