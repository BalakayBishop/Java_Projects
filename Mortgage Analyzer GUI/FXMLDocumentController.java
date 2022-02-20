package csc600_loanapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author balak
 */
public class FXMLDocumentController implements Initializable {
    
    //setting to -1 make the values invalid until Button Event
    private double m_amount = -1.0;
    private double m_intRate = -1.0;
    private int m_duration = -1;
    private double m_monthlyPayment; 
    private double m_totalInterest;
    
    boolean m_amountVerified = false;
    boolean m_interestVerified = false;
    boolean m_durationVerified = false;

    @FXML private AnchorPane parentAnchor;
    @FXML private Label titleLabel;
    @FXML private Label amountLabel;
    @FXML private Label interestLabel;
    @FXML private Label durationLabel;
    @FXML private Label monPayLabel;
    @FXML private Label totalIntLabel;
    @FXML private TextField amountText;
    @FXML private TextField interestText;
    @FXML private TextField durationText;
    @FXML private TextField monthlyPayText;
    @FXML private TextField totalPaidText;
    @FXML private Button verifyButton;
    @FXML private Button exitButton;
    @FXML private Button clearButton;
    
    LoanAppMain m_obj = new LoanAppMain(m_amount, m_intRate, m_duration);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
    }    

    @FXML
    private void handleVerify(ActionEvent event) 
    {
        try // try-catch to check null strings
        {
            if (amountText.getText().equals("")) 
            {
                amountText.setStyle("-fx-border-color: red;");
                amountText.setPromptText("Please enter a number");
                throw new NullPointerException();  
            }
            else if (interestText.getText().equals("")) 
            {
                interestText.setStyle("-fx-border-color: red;");
                interestText.setPromptText("Please enter a number");
                throw new NullPointerException(); 
            }
            else if (durationText.getText().equals("")) 
            {
                durationText.setStyle("-fx-border-color: red;");
                durationText.setPromptText("Please enter a number");
                throw new NullPointerException(); 
            }
        }
        catch (NullPointerException ex)
        {
            System.out.println("There has been an invalid input into one of the text fields");
        }
        
        // Allows the user to enter dollar value with comma w/out error
        String amount = amountText.getText(); 
        String newAmount = amount.replaceAll(",", "");
        
        // getting the new values out of the textFields
        m_amount = Double.parseDouble(newAmount); 
        m_intRate = Double.parseDouble(interestText.getText()) / 100.0; // divided by 100 to get true percent value
        m_duration = Integer.parseInt(durationText.getText()); 
        
        // passes each to the method, validates each to know which fails
        m_amountVerified = m_obj.isValid(m_amount); 
        m_interestVerified = m_obj.isValid(m_intRate);
        m_durationVerified = m_obj.isValid(m_duration);
        
        if (m_amountVerified == true && m_interestVerified == true && m_durationVerified == true)
        {
            m_monthlyPayment = m_obj.monthlyPayment(m_amount, m_intRate, m_duration);
            m_totalInterest = m_obj.totalInterest(m_amount, m_monthlyPayment, m_duration);
            
            monthlyPayText.setText( String.valueOf(m_monthlyPayment) );
            totalPaidText.setText( String.valueOf(m_totalInterest) ); 
        }
        if ( m_amountVerified == false)
        {
            amountText.clear();
            amountText.setStyle("-fx-border-color: red;");
            amountText.setPromptText("Error, invalid value");
        }
        if ( m_interestVerified == false)
        {
            interestText.clear();
            interestText.setStyle("-fx-border-color: red;");
            interestText.setPromptText("Error, invalid value");
        }
        if ( m_durationVerified == false)
        {
            durationText.clear();
            durationText.setStyle("-fx-border-color: red;");
            durationText.setPromptText("Error, invalid value");
        }
         
    } // end of handleVerify
    
    @FXML
    private void handleClear(ActionEvent event) 
    {
       amountText.clear(); 
       interestText.clear();
       durationText.clear();
       monthlyPayText.clear();
       totalPaidText.clear();
       
       amountText.setPromptText("150,00");
       interestText.setPromptText("8.0");
       durationText.setPromptText("Months");
       
       amountText.setStyle("");
       interestText.setStyle("");
       durationText.setStyle("");
    } // end of handleClear

    @FXML
    private void handleExit(ActionEvent event) 
    {
        Stage exit = (Stage) exitButton.getScene().getWindow(); 
        exit.close();
    } // end of handleExit

}
