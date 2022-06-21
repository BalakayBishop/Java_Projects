package vigenere_tableau;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static vigenere_tableau.Main.encryptedArray;


public class VigenereTableau_FXMLController implements Initializable 
{

    @FXML private AnchorPane anchorPane;
    @FXML private Label titleLabel;
    @FXML private Label ptLabel;
    @FXML private Label enLabel;
    @FXML private Label keyLabel;
    @FXML private Button exitButton;
    @FXML private Button clearButton;
    @FXML private Button encryptButton;
    @FXML private TextArea ptTextBox;
    @FXML private TextArea enTextBox;
    @FXML private TextArea keyTextBox;
    
    Main obj = new Main();
    
    static String m_plain;
    static String m_encrypt;
    static String m_key;
    static String m_encryptedMessage;
    static String m_newStr;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        obj.init(); // creates and prints the table
        
        ptTextBox.setWrapText(true);
        enTextBox.setWrapText(true);
        keyTextBox.setWrapText(true);
        
    } // end of init 
    
    @FXML
    private void handleEncrypt(ActionEvent event) 
    {
        try
        {
            if (ptTextBox.getText().equalsIgnoreCase(""))
            {
                ptTextBox.setPromptText("Error");
                ptTextBox.setStyle("-fx-border-color: red;");
            }
            else 
            {
                m_plain = ptTextBox.getText();
            }
            
            if (keyTextBox.getText().equalsIgnoreCase(""))
            {
                keyTextBox.setPromptText("Error");
                keyTextBox.setStyle("-fx-border-color: red;");
            }
            else 
            {
                m_key = keyTextBox.getText();
            }
            
            // making them all caps to match the table and removing spaces
            String newMessage = m_plain.toUpperCase().replaceAll(" ", "");
            String newKey = m_key.toUpperCase().replaceAll(" ", "");
            
            // sending the message and key to method to encrypt
            obj.encrypt(newMessage, newKey);
            
            // removing commas from toString method
            m_encryptedMessage = obj.encryptedArray.toString().replaceAll("[^a-zA-Z0-9\\s]", "").replaceAll(" ", "");
            
        }
        catch(NullPointerException e)
        {
            System.out.println("Null String value for plaintext message.");
        }
        
            
        enTextBox.setText(m_encryptedMessage);
        
    } // end of handle Encrypt
    
    @FXML
    private void handleClear(ActionEvent event) 
    {
        obj.clearArr();
        ptTextBox.clear();
            ptTextBox.setPromptText("Please enter your plaintext message");
            ptTextBox.setStyle("");
            
        keyTextBox.clear();
            keyTextBox.setPromptText("Key");
            keyTextBox.setStyle("");
            
        enTextBox.clear();
            enTextBox.setPromptText("Encrypted message");
    } // end of handle Clear
    
    @FXML
    private void handleExit(ActionEvent event) 
    {
        Stage exit = (Stage) exitButton.getScene().getWindow();
        exit.close();
    } // end of handle Exit
    
}
/*
        
*/