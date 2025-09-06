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
   private String durationPattern = "^[0-9]{1,2}\\s*(days|weeks|months)$";
   private String feePattern = "^[0-9]+(\\.[0-9]{1,2})?$";
   private String descriptionPattern = "^[A-Za-z0-9 ,.!?'-]{10,200}$";

    private final CourseBo courseBo = (CourseBo) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void btnsaveACourse(ActionEvent actionEvent) {
        addCourseANC.setVisible(true);

    }

    public void btnsave(ActionEvent actionEvent) {
        CourseDTO courseDTO = checkMatch();
        if (courseDTO != null) {

        }
    }

    private CourseDTO checkMatch (){

     String id =txtCourseID.getText();
       String name= txtName.getText();
       String duration= txtDuration.getText();
       Double fee= Double.valueOf(txtFee.getText());
       String description= txtDescription.getText();

       boolean isValidName=name.matches(namePattern);
       boolean isValidDuration=duration.matches(durationPattern);
       boolean isValidFee=feePattern.matches(feePattern);
       boolean isValidDescription=description.matches(descriptionPattern);

       if (isValidName && isValidDuration && isValidFee && isValidDescription){
           return new CourseDTO(id,name,duration,fee,description);
       }
       return null;
    }


}
