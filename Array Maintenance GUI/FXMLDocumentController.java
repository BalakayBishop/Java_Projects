
package csc600_arraymaint;


import java.util.Random;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author balak
 */
public class FXMLDocumentController implements Initializable 
{
    ArrayMaintMain m_obj = new ArrayMaintMain(); 
    Random rand = new Random();
    // creating the array
    public static ArrayList<Integer> intArr = new ArrayList<Integer>(); 
    @FXML private ListView<Integer> displayBox;
    @FXML private Label titleLabel;
    @FXML private Label numLabel;
    @FXML private Label sizeLabel;
    @FXML private Label searchLabel;
    @FXML private Label freqLabel;
    @FXML private Label frequencyLabel; 
    @FXML private Button addToButton;
    @FXML private Button displayButton;
    @FXML private Button deleteButton;
    @FXML private Button sortButton;
    @FXML private Button exitButton;
    @FXML private Button clearButton;
    @FXML private Button searchButton;
    @FXML private TextField inputBox;
    @FXML private TextField searchBox;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // initializing the array with random numbers
        int a;
        for (int i = 0; i < 20; i++)
        {
            intArr.add(i, rand.nextInt(100));
        }
         
        
    }  
    
    @FXML
    private void displayButtonPressed(ActionEvent event) 
    {
        m_obj.display(intArr);
        displayBox.getItems().addAll(intArr);
        sizeLabel.setText(String.valueOf(intArr.size()));
    }

    @FXML
    private void addToButton(ActionEvent event) 
    {
        try
        {
            if (inputBox.getText().equals(""))
            {
                inputBox.setPromptText("Error");
                inputBox.setStyle("-fx-border-color: red;");
                throw new NullPointerException();
            }
        }
        catch (NullPointerException ex) { System.out.println("Null string"); } 
        // tokenizing the string into an array of strings
        String[] tokens = inputBox.getText().split(", ");
        for (String t : tokens)
        {
            //walking thru to add each item from the array
            m_obj.addTo(intArr, Integer.parseInt(t) );
            displayBox.getItems().add(Integer.parseInt(t));
        }
         
        sizeLabel.setText(String.valueOf(intArr.size()));
     }

    @FXML
    private void deleteButtonPressed(ActionEvent event) 
    {
        int numSelect = displayBox.getSelectionModel().getSelectedIndex();
        m_obj.removeFrom(intArr, numSelect);
        displayBox.getItems().remove(numSelect); 
        sizeLabel.setText(String.valueOf(intArr.size()));
    }

    @FXML
    private void sortButtonPressed(ActionEvent event) 
    {
        m_obj.sortArray(intArr); // passing to the method
        displayBox.getItems().addAll(intArr);
        sizeLabel.setText(String.valueOf(intArr.size()));
    }
    
    @FXML
    private void handleSearch(ActionEvent event) 
    {
        Integer searchNum;
        int numFound; 
        //try-catch for null strings
        try
        {
            if (searchBox.getText().equals(""))
            {
                searchBox.setPromptText("Error");
                searchBox.setStyle("-fx-border-color: red;");
                throw new NullPointerException();
            }
        }
        catch (NullPointerException ex) { System.out.println("Null string"); }
        
        searchNum = Integer.parseInt( searchBox.getText() ); 
        // calling to find the int number of occurences
        numFound = m_obj.searchArray(intArr, searchNum); 
        if (numFound == 0 )
        {
            frequencyLabel.setText("Not found");
        }
        else if (numFound >= 1)
        {
            frequencyLabel.setText(String.valueOf(numFound));
            
            displayBox.setCellFactory((ListView<Integer> p) -> 
            {
                ListCell<Integer> cell = new ListCell<Integer>()
                {
                    @Override
                    protected void updateItem(Integer t, boolean b)
                    {
                        super.updateItem(t, b);
                        if (t != null)
                        {
                            setText(String.valueOf(t)); 
                            if ( !Objects.equals( t, searchNum) )
                            {
                                setStyle(""); 
                            } 
                            else 
                            {
                                setStyle("-fx-background-color: yellow;");
                            }
                        }
                    }
                    
                };
                return cell; 
            } );
                    
            
        }
        
           
    } // end of handle search 
    
    @FXML
    private void handleClear(ActionEvent event) 
    {
        inputBox.clear();
        inputBox.setStyle("");
        frequencyLabel.setText("");
        searchBox.setText("");
        displayBox.setCellFactory((ListView<Integer> p) -> 
            {
                ListCell<Integer> cell = new ListCell<Integer>()
                {
                    @Override
                    protected void updateItem( Integer t, boolean b)
                    {
                        super.updateItem(t, b);
                        if (t != null)
                        {
                            setText(String.valueOf(t)); 
                            setStyle("");
                        }
                    }
                    
                };
                return cell; 
            } );
    }

    @FXML
    private void exitButtonPressed(ActionEvent event) 
    {
        Stage stage = (Stage) exitButton.getScene().getWindow(); 
        stage.close();
    }

    

}
/*
    get the string value to then parse and split at the commma to then index those into the arrayList
    use a .split should give an array of strings 
    convert to a int value insert 
*/

