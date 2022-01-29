/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incrementordecrement;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author balak
 */
public class IncrementOrDecrementController implements Initializable 
{
     
    @FXML
    private Button decrementButton;
    @FXML
    private TextField textBox;
    @FXML
    private Button incrementButton;
    
    @FXML
    private void incrementButtonPressed(ActionEvent event) 
    {
        int increment = Integer.parseInt( textBox.getText() ); // used to get the int value from the text field
        int out = increment + 1; 
        
        textBox.setText( String.valueOf(out) ); 
        
    }
    
    @FXML
    private void decrementButtonPressed(ActionEvent event) 
    {
        int decrement = Integer.parseInt( textBox.getText() ); // used to get the int value from the text field
        int out = decrement - 1; 
        
        textBox.setText( String.valueOf(out) );
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
}
