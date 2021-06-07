package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.text.DateFormat;
import java.util.Date;

public class Controller {

    @FXML
    public ListView<String> usersList;

    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextArea messageTextArea;

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(Main.USERS_DATA));
    }

    @FXML
    private void sendMessage() {
        chatHistory.appendText(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistory.appendText(System.lineSeparator());
        if (!usersList.getSelectionModel().isEmpty()) {
            String selectedUser = usersList.getSelectionModel().getSelectedItem();
            chatHistory.appendText(selectedUser + ":");
            chatHistory.appendText(System.lineSeparator());
        }
        chatHistory.appendText(messageTextArea.getText());
        chatHistory.appendText(System.lineSeparator());
        messageTextArea.clear();
    }

    @FXML
    public void sendTextAreaMessage(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            event.consume();
            if (event.isShiftDown()) {
                messageTextArea.appendText(System.lineSeparator());
            } else {
                sendMessage();
            }
        }
    }

}
