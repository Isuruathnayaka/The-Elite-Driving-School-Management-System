package com.example.the_elite_driving_school_management_system.Controller;

import com.example.the_elite_driving_school_management_system.Bo.BOFactory;
import com.example.the_elite_driving_school_management_system.Bo.Custom.StudentBo;
import com.example.the_elite_driving_school_management_system.DTO.StudentDTO;
import com.example.the_elite_driving_school_management_system.TM.StudentTM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class StudentController implements Initializable {

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
    public TextField txtCourseID;


    @FXML
    private ListView<String> courseListView; // REPLACE ComboBox with ListView

    StudentBo studentBo = (StudentBo) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void btnAdd(ActionEvent actionEvent) {
        StudentDTO studentDTO = checkMatch();
        boolean isSaved = studentBo.save(studentDTO);

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Student Added Successfully").show();
            txtStudentId.setText(generateNewId());

        }
        else {
            new Alert(Alert.AlertType.ERROR, "Student Already Exists").show();
        }
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void btnView(ActionEvent actionEvent) {
    }

    public StudentDTO checkMatch() {
        String studentId = txtStudentId.getText();
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        LocalDate date = datePiker.getValue();
        String courses = courseList.getText();
        String courseID = txtCourseID.getText();

        boolean isValidName = name.matches(namePattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValiedPhone = contact.matches(phonePattern);

        txtStudentId.setStyle("-fx-border-color: #7367F0;");
        txtName.setStyle("-fx-border-color: #7367F0;");
        txtAge.setStyle("-fx-border-color: #7367F0;");
        txtAddress.setStyle("-fx-border-color: #7367F0;");
        txtEmail.setStyle("-fx-border-color: #7367F0;");
        txtContact.setStyle("-fx-border-color: #7367F0;");
        datePiker.setStyle("-fx-border-color: #7367F0;");
        courseList.setStyle("-fx-border-color: #7367F0;");
        txtCourseID.setStyle(courseID + " -fx-border-color: #7367F0;");

        if (!isValidName) txtName.setStyle("-fx-border-color:red;");
        if (!isValidEmail) txtEmail.setStyle("-fx-border-color:red;");
        if (!isValiedPhone) txtContact.setStyle("-fx-border-color:red;");

        if (isValidName && isValidEmail && isValiedPhone) {
            return new StudentDTO(studentId, name, age, address, contact, email, date, courses,courseID);
        }
        return null;
    }

    private String generateNewId() {
        try {
            return studentBo.generateNewStudentId();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        }

        if (table.getItems().isEmpty()) {
            return "S001";
        } else {
            String id = getLastCustomerId();
            int newCustomerId = Integer.parseInt(id.replace("S", "")) + 1;
            return String.format("S%03d", newCustomerId);
        }
    }

    private String getLastCustomerId() {
        List<StudentTM> tempStudentList = new ArrayList<>(table.getItems());
        Collections.sort(tempStudentList);
        return tempStudentList.get(tempStudentList.size() - 1).getId();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        courseListView.getItems().addAll(
                "Basic Learner Program",
                "Advanced Defensive Driving",
                "Motorcycle License Training",
                "Heavy Vehicle Training",
                "Refresher Driving Course"
        );
        txtStudentId.setText(generateNewId());


        Map<String, String> courseMapping = new HashMap<>();
        courseMapping.put("Basic Learner Program", "Basic Learner Program: RS 50,000.00");
        courseMapping.put("Advanced Defensive Driving", "Advanced Defensive Driving: RS 65,000.00");
        courseMapping.put("Motorcycle License Training", "Motorcycle License Training: RS 75,000.00");
        courseMapping.put("Heavy Vehicle Training", "Heavy Vehicle Training: RS 150,000.00");
        courseMapping.put("Refresher Driving Course", "Refresher Driving Course: RS 150,000.00");


        Map<String, String> courseIdMapping = new HashMap<>();
        courseIdMapping.put("Basic Learner Program", "C1001");
        courseIdMapping.put("Advanced Defensive Driving", "C1002");
        courseIdMapping.put("Motorcycle License Training", "C1003");
        courseIdMapping.put("Heavy Vehicle Training", "C1004");
        courseIdMapping.put("Refresher Driving Course", "C1005");


        courseListView.setOnMouseClicked(event -> {
            String selectedCourse = courseListView.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {

                courseList.appendText(courseMapping.get(selectedCourse) + "\n");


                txtCourseID.appendText(courseIdMapping.get(selectedCourse) + "\n");


                courseListView.getItems().remove(selectedCourse);
            }
        });
    }



}
