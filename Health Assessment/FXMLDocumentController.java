/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc600_healthassessment;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author balak
 */
public class FXMLDocumentController implements Initializable 
{

    @FXML private AnchorPane anchorPane;
    @FXML private Label titleLabel;
    @FXML private Label nameLabel;
    @FXML private Label bloodPressureLabel;
    @FXML private Label bmiLabel;
    @FXML private Label cholLabel;
    @FXML private Label glucoseLabel;
    @FXML private Label trigLabel;
    @FXML private Label LDLLabel;
    @FXML private Label HDLLabel;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label label3;
    @FXML private Label label4;
    @FXML private Label label5;
    @FXML private Label label6;
    @FXML private Label label7;
    @FXML private TextField patientNameText;
    @FXML private TextField bloodPressureText;
    @FXML private TextField bmiText;
    @FXML private TextField cholText;
    @FXML private TextField glucoseText;
    @FXML private TextField trigText;
    @FXML private TextField LDLText;
    @FXML private TextField HDLText;
    @FXML private Button exitButton;
    @FXML private Button clearButton;
    @FXML private Button saveButton;
    @FXML private Button getReportButton;
    @FXML private Button assessButton;
    
    HealthApp m_obj;
    
    private static String m_fileName;
    private static Integer m_BP;
    private static String s_BP;
    
    private static double m_BMI;
    private static String s_BMI;
    
    private static Integer m_Chol;
    private static String s_Chol;
    private static Integer m_LDL;
    private static String s_LDL;
    private static Integer m_HDL;
    private static String s_HDL;
    
    private static Integer m_BS;
    private static String s_BS;
    
    private static Integer m_trig;
    private static String s_Trig;
    
    private final ArrayList<String> assessment = new ArrayList<>();
    private final ArrayList<String> fillMe = new ArrayList<>();
    private final Dialog<String> m_dialogBox = new Dialog<>();
    
    //path is not to the C drive only 
    //private final String path = "C:\\";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        m_dialogBox.setTitle("Health Assessment");
        ButtonType btnOnDialog = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Adding buttons to the dialog pane
        m_dialogBox.getDialogPane().getButtonTypes().add(btnOnDialog);
         
    }   
    
    @FXML
    private void handleAssess (ActionEvent event) 
    {
        
        try //name 
        {
            if ( !( patientNameText.getText().matches("^[a-zA-Z\\s]*$") ) )
            {
                patientNameText.setPromptText("Error");
                patientNameText.setStyle("-fx-border-color: red;");
                throw new Exception();
            }
            else if (patientNameText.getText().matches("^[a-zA-Z\\s]*$") )
            {
                m_fileName = patientNameText.getText();
            }
            
        }
        catch (Exception e) { System.out.println("Invalid name input"); }
        
        try //blood pressure
        { 
            if (!( bloodPressureText.getText().matches("^\\d{1}(\\d{1,2})?$" ) ) ) // matching any non digit 
            {
                bloodPressureText.setPromptText("Error");
                bloodPressureText.setStyle("-fx-border-color: red;");
                //throw new Exception();
            }
            else 
            {
                // assess Blood Pressure
                m_BP = Integer.parseInt(bloodPressureText.getText());
                s_BP = m_obj.assessBP(m_BP);
                label1.setText(s_BP);
                assessment.add("Blood Pressure: " + String.valueOf(m_BP));
            }
            
        }
        catch (Exception e){ System.out.println("Invalid Blood Pressure input"); }
        
        
        
        try // bmi
        {
            if (!( bmiText.getText().matches("^\\d{1,2}(\\.\\d{1,2})?$" ) ) )
            {
                bmiText.setPromptText("Error");
                bmiText.setStyle("-fx-border-color: red;");
                throw new Exception();
            }
            else
            {
                // assess BMI
                m_BMI = Double.parseDouble(bmiText.getText()); 
                s_BMI = m_obj.assessBMI(m_BMI);
                label2.setText(s_BMI);
                assessment.add("BMI: " + String.valueOf(m_BMI));
            }
            
        }
        catch (Exception e){ System.out.println("Invalid BMI input"); }
        
        try // Cholesterol
        {
            if (!( cholText.getText().matches("^\\d{1}(\\d{1,2})?$" ) ) )
            {
                cholText.setPromptText("Error");
                cholText.setStyle("-fx-border-color: red;");
                throw new Exception();
            }
            else
            {
                // assess Cholesterol
                m_Chol = Integer.parseInt(cholText.getText());
                s_Chol = m_obj.assessChol(m_Chol);
                label3.setText(s_Chol);
                assessment.add("Cholesterol: " + String.valueOf(m_Chol));
            }
            
        }
        catch (Exception e){ System.out.println("Invalid Cholesterol input"); }
        
        try // Blood Sugar
        {
            if (!( glucoseText.getText().matches("^\\d{1}(\\d{1,3})?$" ) ) )
            {
                glucoseText.setPromptText("Error");
                glucoseText.setStyle("-fx-border-color: red;");
                throw new Exception();
            }
            else
            {
                // assess Blood Sugar
                m_BS = Integer.parseInt(glucoseText.getText());
                s_BS = m_obj.assessBS(m_BS);
                label4.setText(s_BS);
                assessment.add("Blood Sugar: " + String.valueOf(m_BS));
            }
            
        }
        catch (Exception e){ System.out.println("Invalid Blood Sugar input"); }
        
        try // Tryglycerides
        {
            if (!( trigText.getText().matches("^\\d{1,2}(\\d{1})?$" ) ) )
            {
                trigText.setPromptText("Error");
                trigText.setStyle("-fx-border-color: red;");
                throw new Exception();
            }
            else
            {
                // assess Triglycerides
                m_trig = Integer.parseInt(trigText.getText());
                s_Trig = m_obj.assessTrig(m_trig);
                label5.setText(s_Trig);
                assessment.add("Triglycerides: " + String.valueOf(m_trig));
            }
            
        }
        catch (Exception e){ System.out.println("Invalid Triglyceride input"); }
        
        try // LDL
        {
            if (!( LDLText.getText().matches("^\\d{1}(\\d{1,2})?$" ) ) )
            {
                LDLText.setPromptText("Error");
                LDLText.setStyle("-fx-border-color: red;");
                throw new Exception();
            }
            else
            {
                // assess LDL
                m_LDL =  Integer.parseInt(LDLText.getText());
                s_LDL = m_obj.assessLDL(m_LDL);;
                label6.setText(s_LDL);
                assessment.add("LDL: " + String.valueOf(m_LDL));
            }
            
        }
        catch (Exception e){ System.out.println("Invalid LDL input"); }
        
        try // HDL
        {
            if (!( HDLText.getText().matches("^\\d{1,2}(\\d{1})?$" ) ) )
            {
                HDLText.setPromptText("Error");
                HDLText.setStyle("-fx-border-color: red;");
                throw new Exception();
            }
            else
            {
                // assess HDL
                m_HDL =  Integer.parseInt(HDLText.getText());
                s_HDL = m_obj.assessHDL(m_HDL);
                label7.setText(s_HDL);
                assessment.add("HDL: " + String.valueOf(m_HDL));
            }
            
        }
        catch (Exception e){ System.out.println(e); }
        
        // setting the dialogs
        assessment.forEach( (String s) -> {
            
            for ( int i = 0; i < assessment.size(); i++)
            {
                 s = assessment.get(i);
                 if (!( s.equalsIgnoreCase("Ideal") ||
                        s.equalsIgnoreCase("Excellent") || 
                        s.equalsIgnoreCase("Good") ||
                        s.equalsIgnoreCase("Optimal") ||
                        s.equalsIgnoreCase("Normal") ||
                        s.equalsIgnoreCase("Normal weight") ) )
                {
                    m_dialogBox.setContentText(m_fileName + "\n" + 
                            "One or more of your assessment values is concerning, please consult your primary healthcare provider!");
                }
            }
            
        });
        
        m_dialogBox.showAndWait();
    }

    @FXML
    private void handleSave(ActionEvent event) 
    {
        Path paths = Paths.get("C:\\" + m_fileName + ".txt");
        try 
        {
            if ( !(Files.exists(Paths.get("C:\\" + m_fileName + ".txt")) ) ) // if the file doesn't exist the system will create one
            {
                System.out.println("File does not exists, creating a file in Local Disk (C:)");
                Path p = Files.createFile(paths);
            }
            else
            {
                if ( !(patientNameText.getText().matches("^[a-zA-Z\\s]*$") ) )
                {
                    patientNameText.setPromptText("Error");
                    patientNameText.setStyle("-fx-border-color: red;");
                    throw new Exception();
                }
                else if ( patientNameText.getText().matches("[a-zA-Z\\s]*$") )
                {
                    if (assessment.isEmpty() == false) // asking if the array is full to write to file
                    {
                        m_fileName = patientNameText.getText();
                        m_obj = new HealthApp("C:\\" + m_fileName + ".txt");
                        if (m_obj.openFileToWrite() == true )
                        {
                            m_obj.writeAssessmentToFile(assessment);
                        }
                    } 
                    else 
                    {
                        System.out.println("Error, in the saving process");
                    }
                
                }
               
            }
                
        }
            
         catch (Exception e) { System.out.println("Invalid name input"); }
        
         
    }

    @FXML
    private void handleGetReport(ActionEvent event) 
    {
        
        try 
        {
            if ( (Files.exists(Paths.get("C:\\" + m_fileName + ".txt")) ) ) // checks if the file exists to read data
            {
                if ( !(patientNameText.getText().matches("^[a-zA-Z\\s]*$") ) )
                {
                    patientNameText.setPromptText("Error");
                    patientNameText.setStyle("-fx-border-color: red;");
                    throw new Exception();
                }
                else if ( patientNameText.getText().matches("^[a-zA-Z\\s]*$") )
                {
                    m_fileName = patientNameText.getText();
                    m_obj = new HealthApp("C:\\" + m_fileName + ".txt");
                    if (m_obj.openFileToRead() == true)
                    {
                        if (fillMe.isEmpty() == true) // asking if the array is empty to fill
                        {
                            m_obj.readAssessmentFromFile(fillMe);
                        
                            // lambda for each to process the array 
                            fillMe.forEach((String s) -> {
                            if (s.matches("[^\\d]* \\d*$") == true )
                            {
                                for ( int i = 0; i < fillMe.size(); i++)
                                {
                                    s = fillMe.get(i);
                                    String str = s.replaceAll("[^\\d.]*", "");
                                    switch (i)
                                    {
                                        case 0:
                                            bloodPressureText.setText(str);
                                            break;
                                        case 1:
                                            bmiText.setText(str);
                                            break;
                                        case 2:
                                            cholText.setText(str);
                                            break;
                                        case 3:
                                            glucoseText.setText(str);
                                            break;
                                        case 4:
                                            trigText.setText(str);
                                            break;
                                        case 5:
                                            LDLText.setText(str);
                                            break;
                                        case 6:
                                            HDLText.setText(str);
                                            break;
                                        default:
                                            System.out.println("Error");
                                            break;
                                    }
                                }
                                 
                            }
                        });
                        
                        }
                        else 
                        {
                            System.out.println("Values have been assessed, clear and try again.");
                        }
                    }
            
                    
                }
            }
            else 
            {
                System.out.println("File does not exist, please create a file with patient data.");
            }
            
        }
        catch (Exception e) { System.out.println("Invalid name input"); }
        
    }
    
    @FXML
    private void handleClear(ActionEvent event) 
    {
        
        patientNameText.setStyle("");
        
        bloodPressureText.clear();
            bloodPressureText.setPromptText("120");
            bloodPressureText.setStyle(""); 
            
        bmiText.clear();
            bmiText.setPromptText("22.5");
            bmiText.setStyle(""); 
            
        cholText.clear();
            cholText.setPromptText("150");
            cholText.setStyle("");
            
        glucoseText.clear();
            glucoseText.setPromptText("100");
            glucoseText.setStyle("");
            
        trigText.clear();
            trigText.setPromptText("150");
            trigText.setStyle("");
            
        LDLText.clear();
            LDLText.setPromptText("100");
            LDLText.setStyle("");
            
        HDLText.clear();
            HDLText.setPromptText("45");
            HDLText.setStyle("");
            
        label1.setText("Status");
            label2.setText("Status");
            label3.setText("Status");
            label4.setText("Status");
            label5.setText("Status");
            label6.setText("Status");
            label7.setText("Status");
            
        assessment.clear(); // empty the arrayList
        fillMe.clear();
    }
    
    @FXML
    private void handleExit(ActionEvent event) 
    {
        Stage exit = (Stage) exitButton.getScene().getWindow();
        exit.close();
    }
    
}
