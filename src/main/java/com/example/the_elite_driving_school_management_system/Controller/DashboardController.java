package com.example.the_elite_driving_school_management_system.Controller;

import com.example.the_elite_driving_school_management_system.Util.AnimationUtil;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public AnchorPane ANCMain;


    public ImageView btnStudentManage;
    public ImageView btnCourcesManage;
    public ImageView btnDashboard;
    public ImageView btnSettings;
    public ImageView btnInstructorManage;
    public ImageView btnPayment;
    public ImageView btnScheduleManagement;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnimationUtil.addHoverAnimation(btnDashboard);
        AnimationUtil.addHoverAnimation(btnInstructorManage);
        AnimationUtil.addHoverAnimation(btnStudentManage);
        AnimationUtil.addHoverAnimation(btnScheduleManagement);
        AnimationUtil.addHoverAnimation(btnCourcesManage);
        AnimationUtil.addHoverAnimation(btnPayment);
        AnimationUtil.addHoverAnimation(btnSettings);


    }
}
