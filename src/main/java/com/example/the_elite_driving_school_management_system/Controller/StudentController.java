package com.example.the_elite_driving_school_management_system.Controller;

import com.example.the_elite_driving_school_management_system.Bo.BOFactory;
import com.example.the_elite_driving_school_management_system.Bo.Custom.StudentBo;
import com.example.the_elite_driving_school_management_system.DTO.StudentDTO;
import com.example.the_elite_driving_school_management_system.TM.StudentTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class StudentController implements Initializable {

    @FXML
    private TableView<StudentTM> table;
    @FXML
    private TableColumn<StudentTM, String> colStudentId;
    @FXML
    private TableColumn<StudentTM, String> colName;
    @FXML
    private TableColumn<StudentTM, Integer> colAge;
    @FXML
    private TableColumn<StudentTM, String> colAddress;
    @FXML
    private TableColumn<StudentTM, String> colContact;
    @FXML
    private TableColumn<StudentTM, String> colEmail;
    @FXML
    private TableColumn<StudentTM, LocalDate> colDate;
    @FXML
    private TableColumn<StudentTM, String> colCourses;
    @FXML
    private TableColumn<StudentTM, String> colCourseId;

    @FXML
    private TextField txtName, txtAge, txtAddress, txtContact, txtEmail, txtCourseID;
    @FXML
    private TextArea courseList;
    @FXML
    private DatePicker datePiker;
    @FXML
    private Label txtStudentId;
    @FXML
    private ListView<String> courseListView;

    private final String namePattern = "^[A-Za-z ]+$";
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^(\\d+)$";

    private final StudentBo studentBo = (StudentBo) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                setDataToFields(newSelection);
            }
        });
        setupTableColumns();
        courseSelection();
        loadTableData();
        txtStudentId.setText(generateNewId());
    }

    private void setupTableColumns() {
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCourses.setCellValueFactory(new PropertyValueFactory<>("courses"));
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseID"));


    }
    private void setDataToFields(StudentTM student) {
        txtStudentId.setText(student.getId());
        txtName.setText(student.getName());
        txtAge.setText(String.valueOf(student.getAge()));
        txtAddress.setText(student.getAddress());
        txtContact.setText(student.getContact());
        txtEmail.setText(student.getEmail());
        datePiker.setValue(student.getDate());
        courseList.setText(student.getCourse());
        txtCourseID.setText(student.getCourseId());
    }

    private void loadTableData() {
        ArrayList<StudentDTO> allStudents = studentBo.getAllStudents();
        ObservableList<StudentTM> tableList = FXCollections.observableArrayList();

        if (allStudents != null) {
            for (StudentDTO student : allStudents) {
                tableList.add(new StudentTM(
                        student.getStudentID(),
                        student.getName(),
                        student.getAge(),
                        student.getAddress(),
                        student.getContact(),
                        student.getEmail(),
                        student.getRegistrationDate(),
                        student.getCourse(),
                        student.getCourseId()
                ));
            }
        }
        table.setItems(tableList);
    }

    public void btnAdd(ActionEvent actionEvent) {
        StudentDTO studentDTO = checkMatch();
        if (studentDTO != null) {
            boolean isSaved = studentBo.save(studentDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Student Added Successfully").show();
                txtStudentId.setText(generateNewId());
                loadTableData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student Already Exists").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid Input").show();
        }
    }

    public StudentDTO checkMatch() {
        try {
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
            boolean isValidPhone = contact.matches(phonePattern);

            if (isValidName && isValidEmail && isValidPhone) {
                return new StudentDTO(studentId, name, age, address, contact, email, date, courses, courseID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String generateNewId() {
        try {
            String id = studentBo.generateNewStudentId();
            if (id != null) return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "S001";
    }

    private void courseSelection() {
        courseListView.getItems().addAll(
                "Basic Learner Program",
                "Advanced Defensive Driving",
                "Motorcycle License Training",
                "Heavy Vehicle Training",
                "Refresher Driving Course"
        );

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

    public void btnUpdate(ActionEvent actionEvent) {
    StudentDTO studentDTO = checkMatch();
    if (studentDTO != null) {
        boolean isUpdated=studentBo.update(studentDTO);
        if (isUpdated) {
            loadTableData();
            new Alert(Alert.AlertType.INFORMATION, "Student Updated Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student Not Update ").show();
        }
    }
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void btnView(ActionEvent actionEvent) {
    }

    public void btnReset(ActionEvent actionEvent) {
        txtName.clear();
        txtAge.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtContact.clear();
        txtCourseID.clear();
        datePiker.setValue(null);
        courseList.clear();
    }
}
