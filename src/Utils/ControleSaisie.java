package Utils;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleSaisie {


    public ControleSaisie() {
    }

    public static boolean controleTextFieldVide(TextField textField, String msg, Label errorLabel) {
        String chaine = textField.getText().trim();
        if (chaine.length() == 0) {
            errorLabel.setText(msg);
            textField.clear();
            return true;
        }
        return false;
    }

    public static boolean controleTextFieldNonNumerique(TextField textField, String msg, Label errorLabel) {
        if (!textField.getText().matches(".*[a-zA-Z].*")) {
            errorLabel.setText(msg);

            return true;
        }
        return false;
    }

}
