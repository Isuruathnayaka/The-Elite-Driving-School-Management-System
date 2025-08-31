package com.example.the_elite_driving_school_management_system.Controller;

import com.example.the_elite_driving_school_management_system.Bo.BOFactory;
import com.example.the_elite_driving_school_management_system.Bo.Custom.StudentBo;
import com.example.the_elite_driving_school_management_system.DTO.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Date;

public class StudentController {
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAge;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colDate;
    public TableColumn colCourses;
    public Label txtStudentId;
    public TableView table;
    public TextArea courseList;
    public DatePicker datePiker;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtAge;
    public TextField txtName;

    private final String namePattern = "^[A-Za-z ]+$";
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^(\\d+)$";

     StudentBo studentBo=(StudentBo) BOFactory.getInstance().getBO(BOFactory.BOType.)
    public void btnAdd(ActionEvent actionEvent) {
        StudentDTO studentDTO =checkMatch();
        boolean isSaved=studentBo.saveStudent(studentDTO);
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void btnView(ActionEvent actionEvent) {
    }
    public StudentDTO checkMatch(){
        String studentId = txtStudentId.getText();
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        LocalDate date = datePiker.getValue();
        String courses = courseList.getText();

        boolean isValidName = name.matches(namePattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValiedPhone = phonePattern.matches(phonePattern);

        txtStudentId.setStyle("-fx-border-color: #7367F0;");
        txtName.setStyle("-fx-border-color: #7367F0;");
        txtAge.setStyle("-fx-border-color: #7367F0;");
        txtAddress.setStyle("-fx-border-color: #7367F0;");
        txtEmail.setStyle("-fx-border-color: #7367F0;");
        txtContact.setStyle("-fx-border-color: #7367F0;");
        datePiker.setStyle("-fx-border-color: #7367F0;");
        courseList.setStyle("-fx-border-color: #7367F0;");

        if (!isValidName) txtName.setStyle("-fx-border-color:red;");
        if (!isValidEmail) txtEmail.setStyle("-fx-border-color:red;");
        if (!isValiedPhone) txtContact.setStyle("-fx-border-color:red;");

        if (isValidName && isValidEmail && isValiedPhone){
            return new StudentDTO(studentId,name,age,address,contact,email,date,courses);
        }
        return null;
    }
}
