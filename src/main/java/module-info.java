module com.example.the_elite_driving_school_management_system {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.the_elite_driving_school_management_system;
    opens com.example.the_elite_driving_school_management_system.Controller to javafx.fxml;
    exports com.example.the_elite_driving_school_management_system.Controller;
}
