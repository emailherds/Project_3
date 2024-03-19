package com.example.project_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea bottomText;

    @FXML
    private TextField firstNameMem;
    @FXML
    private TextField lastNameMem;
    @FXML
    private DatePicker dobMem;
    @FXML
    private TextField firstNameClass;
    @FXML
    private TextField lastNameClass;
    @FXML
    private DatePicker dobClass;

    @FXML
    private ToggleGroup member_type;
    private String memberType;

    @FXML
    private ToggleGroup home_studio;
    private String homeStudio;

    @FXML
    private ToggleGroup class_group;
    private String className;
    @FXML
    private ToggleGroup instructor_group;
    private String instructorName;
    @FXML
    private ToggleGroup location_group;
    private String locationName;

    private String firstName, lastName;
    private Date dob;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onAddNewButtonClick() {
        if(member_type.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) member_type.getSelectedToggle();
            memberType = selected.getText();
            bottomText.setText(memberType);
        }
        if(home_studio.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) home_studio.getSelectedToggle();
            homeStudio = selected.getText();
        }
        firstName = firstNameMem.getText();
        lastName = lastNameMem.getText();
        dob = new Date(dobMem.getValue().getMonthValue(), dobMem.getValue().getDayOfMonth(), dobMem.getValue().getYear());
    }

    @FXML
    protected void onCancelExistingButtonClick() {
        firstName = firstNameMem.getText();
        lastName = lastNameMem.getText();
        dob = new Date(dobMem.getValue().getMonthValue(), dobMem.getValue().getDayOfMonth(), dobMem.getValue().getYear());
    }

    @FXML
    protected void onLoadMembersButtonClick() {

    }

    @FXML
    protected void onAddMemberButtonClick() {
        if(class_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) class_group.getSelectedToggle();
            className = selected.getText();
        }
        if(instructor_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) instructor_group.getSelectedToggle();
            instructorName = selected.getText();
        }
        if(location_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) location_group.getSelectedToggle();
            locationName = selected.getText();
        }
        firstName = firstNameClass.getText();
        lastName = lastNameClass.getText();
        dob = new Date(dobClass.getValue().getMonthValue(), dobClass.getValue().getDayOfMonth(), dobClass.getValue().getYear());
    }

    @FXML
    protected void onRemoveMemberButtonClick() {
        if(class_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) class_group.getSelectedToggle();
            className = selected.getText();
        }
        if(instructor_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) instructor_group.getSelectedToggle();
            instructorName = selected.getText();
        }
        if(location_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) location_group.getSelectedToggle();
            locationName = selected.getText();
        }
        firstName = firstNameClass.getText();
        lastName = lastNameClass.getText();
        dob = new Date(dobClass.getValue().getMonthValue(), dobClass.getValue().getDayOfMonth(), dobClass.getValue().getYear());
    }
}