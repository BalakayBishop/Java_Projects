/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc600_encryption;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author balak
 */
public class FXMLDocumentController implements Initializable 
{
    @FXML private Label titleLable;
    @FXML private TextField stringBox;
    @FXML private Button encodeButton;
    @FXML private Button decodeButton;
    @FXML private Button exitButton;
    @FXML private Button clearButton;
    
    private static final String secretKey = "9kg_3`y7Pmc,gCv";
 
    String m_originalString;
    String m_encryptedString;
    String m_decryptedString;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void handleEncrypt(ActionEvent event) 
    {
        m_originalString = stringBox.getText();
        try 
        {
            if (m_originalString.equals(""))
            {
                stringBox.setStyle("-fx-border-color: red;");
                throw new NullPointerException();
            }
            else 
            {
                m_encryptedString = AES.encrypt(m_originalString, secretKey);
                stringBox.setText(m_encryptedString);
            }
        }
        catch(NullPointerException e) {System.out.println("Null String");}
        
        
    }

    @FXML
    private void handleDecrypt(ActionEvent event) 
    {
        m_decryptedString = AES.decrypt(m_encryptedString, secretKey);
        stringBox.setText(m_decryptedString);
    }
    
    @FXML
    private void handleClear(ActionEvent event) 
    {
        stringBox.clear();
        stringBox.setStyle("");
    }

    @FXML
    private void handleExit(ActionEvent event) 
    {
        Stage exit = (Stage) exitButton.getScene().getWindow(); 
        exit.close(); 
    }
    
}
