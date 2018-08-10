/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.msm.view.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.msm.business.StudentBO;
import lk.ijse.msm.dto.StudentDTO;

/**
 * FXML Controller class
 *
 * @author LAHIRU SASANKA
 */
public class StudentController implements Initializable {

    @FXML
    private JFXTextField studentIdText;
    @FXML
    private JFXTextField studentNameText;
    @FXML
    private JFXTextField studentAddressText;
    @FXML
    private JFXTextField studentTellText;
    @FXML
    private JFXTextField studentEmailText;
    @FXML
    private TableView<StudentDTO> tblStudent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getAllStudent();
    }    

    @FXML
    private void addStudent(ActionEvent event) {
        try {
            int id=Integer.parseInt(studentIdText.getText());
            String name = studentNameText.getText();
            String address = studentAddressText.getText();
            String tell = studentTellText.getText();
            String email= studentEmailText.getText();
            StudentDTO studentDTO= new StudentDTO(id, name, address, tell, email);
            StudentBO.getStudent(studentDTO);
//            if (isAdded) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Deleted SuccessFully",ButtonType.OK);
                alert.show();
//            } else {
//                Alert alert=new Alert(Alert.AlertType.ERROR,"Deleted UnSuccessFully",ButtonType.OK);
//                alert.show();
//            }
        } catch (Exception ex) {
            Logger.getLogger(lk.ijse.msm.view.controller.StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getAllStudent(){   
        try {
            StudentBO sbo= new StudentBO();
            tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
            tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
            tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("email"));
            tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("tell"));
            ArrayList<StudentDTO> aa=sbo.getAllStudent();
            tblStudent.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchStudent(ActionEvent event) {
        try {
            StudentBO sbo= new StudentBO();
            StudentDTO employee=sbo.serachStudent(Integer.parseInt(studentIdText.getText()));
            if(employee !=null){
                studentIdText.setText(""+employee.getSid());
                studentNameText.setText(employee.getName());
                studentAddressText.setText(employee.getAddress());
                studentTellText.setText(""+employee.getTell());
                studentEmailText.setText(employee.getEmail());
                studentIdText.setDisable(true);
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Name Search",ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeStudent(ActionEvent event) {
        try {
            StudentBO sbo= new StudentBO();
            System.out.println("llll  "+studentIdText.getText());
            boolean isDelete=sbo.deleteStudent(studentIdText.getText());
            if(isDelete==true){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Name Search",ButtonType.OK);
                alert.show();
                getAllStudent();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Name Search",ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateStudent(ActionEvent event) {
        try {
            int id=Integer.parseInt(studentIdText.getText());
            String name = studentNameText.getText();
            String address = studentAddressText.getText();
            String tell = studentTellText.getText();
            String email= studentEmailText.getText();
            StudentDTO studentDTO= new StudentDTO(id, name, address, tell, email);
            StudentBO bO= new StudentBO();
            bO.updateStudent(studentDTO);
            System.out.println("sdafghsjdkfl");
            getAllStudent();
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
