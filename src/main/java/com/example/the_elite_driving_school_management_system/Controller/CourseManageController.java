package com.example.the_elite_driving_school_management_system.Controller;

import com.example.the_elite_driving_school_management_system.Bo.BOFactory;
import com.example.the_elite_driving_school_management_system.Bo.Custom.CourseBo;
import com.example.the_elite_driving_school_management_system.Bo.Custom.StudentBo;
import com.example.the_elite_driving_school_management_system.DTO.CourseDTO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CourseManageController implements Initializable {
    public Button btnsaveACourse;
    public AnchorPane addCourseANC;
    public Label txtCourseID;
    public TableView table;
    public TableColumn colCourseID;
    public TableColumn colCourseName;
    public TableColumn colCourseDuration;
    public TableColumn colFee;
    public TableColumn colDescription;
    public TextField txtName;
    public TextField txtDuration;
    public TextField txtFee;
    public TextField txtDescription;
    private final String namePattern = "^[A-Za-z ]{2,50}$";
    private String durationPattern = "^[0-9]+\\s+(Week|Weeks|Month|Months|Day|Days)$";

    private String feePattern = "^[0-9]+(\\.[0-9]{1,2})?$";
    private String descriptionPattern = "^[A-Za-z0-9 .,()-]{10,200}$";



    private final CourseBo courseBo = (CourseBo) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCourseID.setText(generateNewId());
    }

    private String generateNewId() {
        try {
            String id = courseBo.generateNewCourseId();
            if (id != null) return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "C1001";
    }


    public void btnsaveACourse(ActionEvent actionEvent) {
        addCourseANC.setVisible(true);

    }

    public void btnsave(ActionEvent actionEvent) {
        CourseDTO courseDTO = checkMatch();
        if (courseDTO != null) {
            boolean isSaved = courseBo.save(courseDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Saved", ButtonType.OK).show();
                addCourseANC.setVisible(false);
                txtCourseID.setText(generateNewId());

            } else {
                new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK).show();
            }


        } else {
            new Alert(Alert.AlertType.ERROR,"Invalid", ButtonType.OK).show();
        }
    }

    private CourseDTO checkMatch() {
        String id = txtCourseID.getText();
        String name = txtName.getText();
        String duration = txtDuration.getText();

        // clean commas before parsing to Double
        String feeText = txtFee.getText().replaceAll(",", "");
        Double fee = null;
        try {
            fee = Double.valueOf(feeText);
        } catch (NumberFormatException e) {
            return null;
        }

        String description = txtDescription.getText();

        boolean isValidName = name.matches(namePattern);
        boolean isValidDuration = duration.matches(durationPattern);
        boolean isValidFee = feeText.matches(feePattern);   // FIXED
        boolean isValidDescription = description.matches(descriptionPattern);

        System.out.println("Name: " + name + " | " + isValidName);
        System.out.println("Duration: " + duration + " | " + isValidDuration);
        System.out.println("Fee: " + feeText + " | " + isValidFee);
        System.out.println("Description: " + description + " | " + isValidDescription);

        if (isValidName && isValidDuration && isValidFee && isValidDescription) {
            return new CourseDTO(id, name, duration, fee, description);
        }
        return null;
    }
}

