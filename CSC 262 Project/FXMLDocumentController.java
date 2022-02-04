package robot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class FXMLDocumentController implements Initializable 
{

    @FXML private Button moveDownButton;
    @FXML private Button moveRightButton;
    @FXML private Button moveLeftButton;
    @FXML private Button moveUpButton;
    @FXML private Button pickUpButton;
    @FXML private Button dropOffButton;
    
    @FXML private Text robot;
    @FXML private Text text1;
    @FXML private Text text2;
    @FXML private Text text3;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        text3.setText(String.valueOf("*")); 
    }
    
    @FXML
    private void moveUpButtonPressed(ActionEvent event) 
    {
        if (robot.getY() != 0)
                robot.setY(robot.getY() - 20);
         
    }

    @FXML
    private void moveDownButtonPressed(ActionEvent event) 
    {
       
            if (robot.getY() != 500)
                robot.setY(robot.getY() + 20);
        
    }

    @FXML
    private void moveRightButtonPressed(ActionEvent event) 
    {
       
            if (robot.getX() != 500)
                robot.setX(robot.getX() + 20);
              
    }

    @FXML
    private void moveLeftButtonPressed(ActionEvent event) 
    {
        
            if (robot.getX() != 0)
                robot.setX(robot.getX() - 20);
                   
    } 

    @FXML
    private void pickUpButtonPressed(ActionEvent event) 
    {
        String Switch = null; 
        if ( robot.getX() == text1.getX() && robot.getY() == text1.getY() )
        {
            if ( (robot.getText().equals("*") == true) && (text1.getText().equals("*") == false) )
            {
                Switch = robot.getText(); 
                robot.setText(text1.getText());
                text1.setText(Switch);
            }
        }
        else if ( robot.getX() == text2.getX() && robot.getY() == text2.getY() )
        {
            if ( (robot.getText().equals("*") == true) && (text2.getText().equals("*") == false) )
            {
                Switch = robot.getText(); 
                robot.setText(text2.getText());
                text2.setText(Switch);
            }
        }
        else if ( robot.getX() == text3.getX() && robot.getY() == text3.getY() )
        {
            if ( (robot.getText().equals("*") == true) && (text3.getText().equals("*") == false) )
            {
                Switch = robot.getText(); 
                robot.setText(text3.getText());
                text3.setText(Switch);
            }
        }
    }

    @FXML
    private void dropOffButtonPressed(ActionEvent event) 
    {
        String Switcher = null; 
        if ( robot.getX() == text1.getX() && robot.getY() == text1.getY() )
        {
            if ( (robot.getText().equals("*") == false ) && (text1.getText().equals("*") == true) )
            {
                Switcher = text1.getText(); 
                text1.setText(robot.getText());
                robot.setText(Switcher);
            }
        }
        else if ( (robot.getText().equals("*") == false ) && (text2.getText().equals("*") == true) )
        {
            if ( !(robot.getText().equals("*") ) )
            {
                Switcher = text2.getText(); 
                text2.setText(robot.getText());
                robot.setText(Switcher);
            }
        }
        else if ( (robot.getText().equals("*") == false ) && (text3.getText().equals("*") == true) )
        {
            if ( !(robot.getText().equals("*") ) )
            {
                Switcher = text3.getText(); 
                text3.setText(robot.getText());
                robot.setText(Switcher);
                
            }
        }
    }
     
}
