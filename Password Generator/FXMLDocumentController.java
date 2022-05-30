
package password.generator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Blake Bishop, 29 May 2022
 */
public class FXMLDocumentController implements Initializable {

    @FXML private AnchorPane anchorPane;
    @FXML private Button generateButton;
    @FXML private Button clearButton;
    @FXML private Button ExitButton;
    @FXML private TextField passwordText;
    @FXML private Label lengthLabel;
    @FXML private Label titleLabel;
    @FXML private Label uppercaseLabel;
    @FXML private Label lowercaseLabel;
    @FXML private Label numbersLabel;
    @FXML private Label specialsLabel;
    @FXML private CheckBox uppercaseBox;
    @FXML private CheckBox lowercaseBox;
    @FXML private CheckBox numbersBox;
    @FXML private CheckBox specialsBox;
    @FXML private RadioButton length8Button;
    @FXML private RadioButton length10Button;
    @FXML private RadioButton length12Button;
    @FXML private RadioButton length16Button;
    
    Password m_obj; 
    String password8;
    private boolean m_upperCase = false;
    private boolean m_lowerCase = false; 
    private boolean m_numbers = false; 
    private boolean m_specials = false; 
    
    private ArrayList<Character> arrList = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ToggleGroup radioGroup = new ToggleGroup();
        length8Button.setToggleGroup(radioGroup);
        length10Button.setToggleGroup(radioGroup);
        length12Button.setToggleGroup(radioGroup);
        length16Button.setToggleGroup(radioGroup);
        
    }    

    @FXML
    private void handleGenerate(ActionEvent event) {
        if (uppercaseBox.isSelected())
        {
            m_upperCase = true;
        }
        if (lowercaseBox.isSelected())
        {
            m_lowerCase = true; 
        }
        if (numbersBox.isSelected())
        {
            m_numbers = true;
        }
        if (specialsBox.isSelected())
        {
            m_specials = true;
        }
        
        if (length8Button.isSelected())
        {
            m_obj = new Password(m_upperCase, m_lowerCase, m_numbers, m_specials);
            m_obj.password8(arrList);
            password8 = arrList.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(", ", "");
            passwordText.setText(password8);
        }
        else if (length10Button.isSelected())
        {
            m_obj = new Password(m_upperCase, m_lowerCase, m_numbers, m_specials);
            m_obj.password10(arrList);
            String password10 = arrList.toString().replaceAll("[", "").replaceAll("]", "").replaceAll(",", "");
            passwordText.setText(password10);
        }
        else if (length12Button.isSelected())
        {
            m_obj = new Password(m_upperCase, m_lowerCase, m_numbers, m_specials);
            m_obj.password12(arrList);
            String password12 = arrList.toString().replaceAll("[", "").replaceAll("]", "").replaceAll(",", "");
            passwordText.setText(password12);
        }
        else if (length16Button.isSelected())
        {
            m_obj = new Password(m_upperCase, m_lowerCase, m_numbers, m_specials);
            m_obj.password16(arrList);
            String password16 = arrList.toString().replaceAll("[", "").replaceAll("]", "").replaceAll(",", "");
            passwordText.setText(password16);
        }
    }

    @FXML
    private void handleClear(ActionEvent event) {
        passwordText.clear();
        uppercaseBox.setSelected(false);
        m_upperCase = false; 
        
        lowercaseBox.setSelected(false);
        m_lowerCase = false; 
        
        numbersBox.setSelected(false);
        m_numbers = false;
        
        specialsBox.setSelected(false);
        m_specials = false; 
        
        length8Button.setSelected(false);
        length10Button.setSelected(false);
        length12Button.setSelected(false);
        length16Button.setSelected(false);
        
        arrList.clear();
        
        
        
    }

    @FXML
    private void handleExit(ActionEvent event) {
        Stage exit = (Stage) ExitButton.getScene().getWindow();
        exit.close();
    }
    
}
