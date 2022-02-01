package pkgfinal.p4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Button calcButton;
    @FXML
    private TextField scoreBox;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label letterGradeLabel;
    @FXML
    private TextField letterGradeBox;
    
    private int score = 100;
    @FXML
    private Button clearButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void CalcButtonPressed(ActionEvent event) 
    {
        try
        {
            if ( String.valueOf(scoreBox) == null)
            {
                throw new Exception();
            }
        }
        catch (Exception ex) {}
        
        score = Integer.parseInt(scoreBox.getText()); 
        if ( score >= 96 && score <= 100 )
        {
            letterGradeBox.setText("A"); 
        }
        else if( score >= 90 && score <= 95 )
        {
            letterGradeBox.setText("A-"); 
        }
        else if( score >= 87 && score <= 89 )
        {
            letterGradeBox.setText("B+"); 
        }
        else if( score >= 84 && score <= 86 )
        {
            letterGradeBox.setText("B"); 
        }
        else if( score >= 80 && score <= 83 )
        {
            letterGradeBox.setText("B-"); 
        }
        else if( score >= 77 && score <= 79 )
        {
            letterGradeBox.setText("C+"); 
        }
        else if( score >= 74 && score <= 76 )
        {
            letterGradeBox.setText("C"); 
        }
        else if( score >= 70 && score <= 73 )
        {
            letterGradeBox.setText("C-"); 
        }
        else if( score >= 67 && score <= 69 )
        {
            letterGradeBox.setText("D+"); 
        }
        else if( score >= 64 && score <= 66 )
        {
            letterGradeBox.setText("D"); 
        }
        else if( score >= 60 && score <= 63 )
        {
            letterGradeBox.setText("D-"); 
        }
        else
        {
            letterGradeBox.setText("F"); 
        }
        
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) 
    {
         letterGradeBox.setText("");
         scoreBox.setText(""); 
         
    }

    
}
