package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Main{
    public ComboBox comboBox1, comboBox2;
    public TextField textField;
    public TextArea textArea;
    public Button convert, reset, swap, copy;

    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("2 (binary)", "8 (octal)", "10 (decimal)", "16 (hex)");
        comboBox1.setItems(list);
        comboBox2.setItems(list);
    }
    public void pressConvert(ActionEvent event) {
        if (textField.getText().isEmpty())
            textArea.setText("Please enter a number to convert!");
        else if (comboBox1.getValue().toString().equalsIgnoreCase("2 (binary)") && comboBox2.getValue().toString().equalsIgnoreCase("8 (octal)"))
            textArea.setText(binToOct(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("2 (binary)") && comboBox2.getValue().toString().equalsIgnoreCase("10 (decimal)"))
            textArea.setText(binToDec(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("2 (binary)") && comboBox2.getValue().toString().equalsIgnoreCase("16 (hex)"))
            textArea.setText(binToHex(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("8 (octal)") && comboBox2.getValue().toString().equalsIgnoreCase("2 (binary)"))
            textArea.setText(octToBin(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("8 (octal)") && comboBox2.getValue().toString().equalsIgnoreCase("10 (decimal)"))
            textArea.setText(octToDec(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("8 (octal)") && comboBox2.getValue().toString().equalsIgnoreCase("16 (hex)"))
            textArea.setText(octToHex(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("10 (decimal)") && comboBox2.getValue().toString().equalsIgnoreCase("2 (binary)"))
            textArea.setText(decToBin(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("10 (decimal)") && comboBox2.getValue().toString().equalsIgnoreCase("8 (octal)"))
            textArea.setText(decToOct(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("10 (decimal)") && comboBox2.getValue().toString().equalsIgnoreCase("16 (hex)"))
            textArea.setText(decToHex(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("16 (hex)") && comboBox2.getValue().toString().equalsIgnoreCase("2 (binary)"))
            textArea.setText(hexToBin(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("16 (hex)") && comboBox2.getValue().toString().equalsIgnoreCase("8 (octal)"))
            textArea.setText(hexToOct(textField.getText()));
        else if (comboBox1.getValue().toString().equalsIgnoreCase("16 (hex)") && comboBox2.getValue().toString().equalsIgnoreCase("10 (decimal)"))
            textArea.setText(hexToDec(textField.getText()));
        else
            textArea.setText("There is something WRONG in your entries!");
    }
    public void pressReset(ActionEvent event) {
        textField.clear();
        textArea.clear();
        comboBox1.setValue("10 (decimal)");
        comboBox2.setValue("16 (hex)");
    }
    public void pressSwap(ActionEvent event) {
        String temp = comboBox1.getValue().toString();
        comboBox1.setValue(comboBox2.getValue());
        comboBox2.setValue(temp);
        pressConvert(event);
    }
    public void pressCopy(ActionEvent event) {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(textArea.getText());
        clipboard.setContent(content);
    }
}
