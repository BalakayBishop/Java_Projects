package csc600_midterm;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event; 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author balak
 */
public class FXMLDocumentController implements Initializable {
    private Midterm_Java m_obj = new Midterm_Java(); 

    @FXML private Label titleLabel;
    @FXML private Label nameLabel;
    @FXML private Button loadButton;
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private Button selectedButton;
    @FXML private Button resetButton;
    @FXML private Button exitButton;
    @FXML private TextField inputTextBox;
    @FXML private TextArea selectedNamesBox;
    @FXML private TitledPane titledPane;
    @FXML private ListView<String> listView;
    @FXML private AnchorPane anchorPane;
    @FXML private AnchorPane anchorInList;
    
    // creating the original array list
    private static final ArrayList<String> nameArray = new ArrayList<String>(10); 
    // manipulatable arrays
    ArrayList<String> addNameArr = new ArrayList<String>();
    ArrayList<String> removeNameArr = new ArrayList<String>();
    ArrayList<String> selectedNameArr = new ArrayList<String>();
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        nameArray.add(0, "Blake Bishop");
        nameArray.add(1, "Professor Sam");
        nameArray.add(2, "Ryan");
        nameArray.add(3, "Frank");
        nameArray.add(4, "Bjarne Stroustrup");
        nameArray.add(5, "Dennis Ritchie");
        nameArray.add(6, "James Gosling");
        nameArray.add(7, "Stan Lee");
        nameArray.add(8, "Guido van Rossum");
        nameArray.add(9, "Yukihiro Matsumoto");
         
    }   
    
    @FXML
    private void loadButtonPressed(ActionEvent event) 
    {
       m_obj.loadArray(nameArray);
       listView.getItems().addAll(nameArray);
       
    }

    @FXML
    private void addButtonPressed(ActionEvent event) 
    {
       for (String s: nameArray)
       {
           addNameArr.add(s);
       }
       String newName = inputTextBox.getText(); 
       m_obj.addName(addNameArr, newName);
       listView.getItems().add(newName);
    }

    @FXML
    private void removeButtonPressed(ActionEvent event) 
    {
        for (String s: nameArray)
        {
            removeNameArr.add(s);
        }
        String removeName;
        removeName = String.valueOf(listView.getSelectionModel().getSelectedItem()); 
        m_obj.removeName(removeNameArr, removeName);
        listView.getItems().remove(removeName); 
    }

    @FXML
    private void selectedButtonPressed(ActionEvent event) 
    {
        selectedNamesBox.setText("");
        
        String name;
        ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
        
        for ( int i = 0; i < selectedItems.size(); i++)
        {
            name = String.valueOf( selectedItems.get(i) );
            selectedNamesBox.appendText(name + "\n");
        }
        
          
    }

    @FXML
    private void resetButtonPressed(ActionEvent event) 
    {
        listView.getItems().clear(); // clearing the current items
        listView.getItems().addAll(nameArray); // then re-adding all the og items
        selectedNamesBox.clear();
        inputTextBox.clear();
        selectedNameArr.clear();
    }

    @FXML
    private void exitButtonPressed(ActionEvent event) 
    {
        Stage stage = (Stage) exitButton.getScene().getWindow(); 
        stage.close();
    }

    
    
}


