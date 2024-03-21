package com.example.project_3;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

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
    private Location location;

    @FXML
    private ToggleGroup class_group;
    private Offer offer;
    @FXML
    private ToggleGroup instructor_group;
    private Instructor instructor;
    @FXML
    private ToggleGroup location_group;
    private Location locationName;

    @FXML
    private TableView<FitnessClass> tableViewClass;
    @FXML
    private TableColumn<FitnessClass, String> timeCol;
    @FXML
    private TableColumn<FitnessClass, String> classNameCol;
    @FXML
    private TableColumn<FitnessClass, String> instructorCol;
    @FXML
    private TableColumn<FitnessClass, String> studioLocationCol;


    @FXML
    private TableView<Location> locView;
    @FXML
    private TableColumn<Location, String> cityCol;
    @FXML
    private TableColumn<Location, String> countyCol;
    @FXML
    private TableColumn<Location, String> zipCol;

    private String fname, lname;
    private Date dob;
    private MemberList mL;
    private Schedule s;

    public void initialize() {
        mL = new MemberList();
        s = new Schedule();

        cityCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));
        countyCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCounty()));
        zipCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getZipCode()));
        locView.getItems().addAll(Location.values());
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onAddNewButtonClick() {
        Date today = new Date(2, 15, 2004);
        today = today.currentTime();
        if(firstNameMem != null)
            fname = firstNameMem.getText();
        else
            return;
        if(lastNameMem != null)
            lname = lastNameMem.getText();
        else
            return;
        if(dobMem.getValue() != null)
            dob = new Date(dobMem.getValue().getMonthValue(), dobMem.getValue().getDayOfMonth(), dobMem.getValue().getYear());
        else
            return;

        if(home_studio.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) home_studio.getSelectedToggle();
            location = Location.valueOf(selected.getText().toUpperCase());
        }
        else
            return;

        if(member_type.getSelectedToggle() != null && fname != null && lname != null && dob != null && location != null && dob.isValid() && dob.isPast() && dob.dobIsEighteen()) {
            RadioButton selected = (RadioButton) member_type.getSelectedToggle();
            memberType = selected.getText();
            bottomText.setText(memberType);
            switch(memberType){
                case "BASIC":
                    Basic newBasic = new Basic((new Profile(fname, lname, dob)), today.getNextDate(1), location, 0);
                    mL.add(newBasic);
                    break;
                case "FAMILY":
                    Family newFamily = new Family((new Profile(fname, lname, dob)), today.getNextDate(3), location, true);
                    mL.add(newFamily);
                    break;
                case "PREMIUM":
                    Premium newPremium = new Premium((new Profile(fname, lname, dob)), today.getNextDate(12), location, 3);
                    mL.add(newPremium);
                    break;
            }
        }

    }

    @FXML
    protected void onCancelExistingButtonClick() {
        if(firstNameMem != null)
            fname = firstNameMem.getText();
        if(lastNameMem != null)
            lname = lastNameMem.getText();
        if(dobMem != null)
            dob = new Date(dobMem.getValue().getMonthValue(), dobMem.getValue().getDayOfMonth(), dobMem.getValue().getYear());
        if(fname != null && lname != null && dob != null)
            if (mL.findM(fname, lname, dob) != null)
                mL.remove(mL.findM(fname, lname, dob));
    }

    @FXML
    protected void onLoadMembersButtonClick() throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if(selectedFile != null){
            mL.load(selectedFile.getAbsoluteFile());
        }
        else{
            System.out.println("file invalid");
            return;
        }

        /*
        Collection<FitnessClass> list = Files.readAllLines(selectedFile.toPath())
                .stream()
                .map(line -> {
                    String[] details = line.split(" ");
                    FitnessClass cd = new FitnessClass(Offer.valueOf(details[0].toUpperCase()), Instructor.valueOf(details[1].toUpperCase()), Location.valueOf(details[3].toUpperCase()), Time.valueOf(details[2].toUpperCase()), members, guests);
                    return cd;
                })
                .collect(Collectors.toList());

        ObservableList<FitnessClass> details = FXCollections.observableArrayList(list);

        //tableView.getColumns().addAll(col1, col2, col3, col4);

        col1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime().toString()));
        col2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClassInfo().toString()));
        col3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getInstructor().toString()));
        col4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudio().toString()));

        tableView.setItems(details);
        */

    }

    @FXML
    protected void onAddMemberButtonClick() {
        Date today = new Date(2, 15, 2004);
        today = today.currentTime();

        if(class_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) class_group.getSelectedToggle();
            offer = Offer.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(instructor_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) instructor_group.getSelectedToggle();
            instructor = Instructor.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(location_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) location_group.getSelectedToggle();
            location = Location.valueOf(selected.getText().toUpperCase());
        }
        else
            return;

        if(firstNameClass != null)
            fname = firstNameClass.getText();
        else
            return;
        if(lastNameClass != null)
            lname = lastNameClass.getText();
        else
            return;
        if(dobClass.getValue() != null)
            dob = new Date (dobClass.getValue().getMonthValue(), dobClass.getValue().getDayOfMonth(), dobClass.getValue().getYear());
        else
            return;

        Time t = s.findFitnessClass(offer, instructor, location);
        FitnessClass fitnessClass = s.findFitnessClassA(offer, instructor, location, t);
        if (fitnessClass == null) {
            System.out.println(fitnessClass + " does not exist at ");
            return;
        }
        MemberList classMembers = new MemberList();
        MemberList classGuests = new MemberList();
        Member m = mL.findM(fname, lname, dob);
        if (m == null) {
            System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
            return;
        }
        boolean conflict = false;
        FitnessClass conflictedClass;

        for (int i = 0; i < s.getNumClasses(); i++) {
            if (s.getClasses()[i].getMembers().contains(m)) {
                if (s.getClasses()[i].getTime().equals(t) && !s.getClasses()[i].equals(fitnessClass)) {
                    conflictedClass = s.getClasses()[i];
                    conflict = true;
                }
            }
        }

        if(fname != null && lname != null && dob != null && offer != null && instructor != null && location != null) {
            if (m == null) {
                System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
                return;
            } else if (m.getExpire().compareTo(m.getExpire().currentTime()) < 0) {
                System.out.println(fname + " " + lname + " " + dob + " membership expired.");
                return;
            } else if (!s.contains(fitnessClass)) {
                System.out.println("Fitness class is not on the schedule.");
                return;
            } else if (m.getClass().toString().equals("class fitness.Basic") && !location.equals(m.getHomeStudio())) {
                System.out.println(fname + " " + lname + " is attending a class at " + location + " - " + "[BASIC] home studio at " + m.getHomeStudio());
                return;
            } else if (conflict) { // Time Conflict
                System.out.println("Time conflict - " + fname + " " + lname + " is in another class held at " + t.toString() + " - " + fitnessClass.getInstructor().toString().toUpperCase() + ", " + t + ", " + fitnessClass.getStudio().toString().toUpperCase());
                return;
            } else if (!s.contains(fitnessClass)) {
                System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
                return;
            } else if (fitnessClass.getMembers().contains(m)) {
                System.out.println(fname + " " + lname + " is already in the class.");
                return;
            }
            if (m.getClass().toString().equals("class fitness.Basic")) {
                ((Basic) m).setNumClasses(((Basic) m).getNumClasses() + 1);
            }
            classMembers = fitnessClass.getMembers();
            classMembers.add(m);
            fitnessClass.setMembers(classMembers);
            System.out.println(fname + " " + lname + " attendance recorded " + offer + " at " + location + ", " + fitnessClass.getZipCode() + ", " + fitnessClass.getCounty());
        }
    }

    @FXML
    protected void onRemoveMemberButtonClick() {
        if(class_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) class_group.getSelectedToggle();
            offer = Offer.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(instructor_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) instructor_group.getSelectedToggle();
            instructor = Instructor.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(location_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) location_group.getSelectedToggle();
            locationName = Location.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(firstNameClass != null)
            fname = firstNameClass.getText();
        else
            return;
        if(lastNameClass != null)
            lname = lastNameClass.getText();
        else
            return;
        if(dobClass.getValue() != null)
            dob = new Date(dobClass.getValue().getMonthValue(), dobClass.getValue().getDayOfMonth(), dobClass.getValue().getYear());
        else
            return;
        Time t = s.findFitnessClass(offer, instructor, location);
        FitnessClass fitnessClass = s.findFitnessClassA(offer, instructor, location, t);
        if (fitnessClass == null) {
            System.out.println(fitnessClass + " does not exist at ");
            return;
        }
        MemberList classMembers = new MemberList();
        MemberList classGuests = new MemberList();
        Member m = mL.findM(fname, lname, dob);
        if (m == null) {
            System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
            return;
        }
        boolean conflict = false;
        FitnessClass conflictedClass;

        Member u = mL.findM(fname, lname, dob);
        if (fitnessClass.getMembers().contains(u)) {
            String type = u.getClass().toString();
            classMembers = fitnessClass.getMembers();
            classMembers.remove(u);
            fitnessClass.setMembers(classMembers);
            System.out.println(fname + " " + lname + " is removed from " + instructor + ", " + fitnessClass.getTime() + ", " + location + ", " + fitnessClass.getZipCode() + ", " + fitnessClass.getCounty());
        } else
            System.out.println(fname + " " + lname + " is not in " + instructor + ", " + fitnessClass.getTime() + ", " + location + ", " + fitnessClass.getZipCode() + ", " + fitnessClass.getCounty());
    }
    @FXML
    protected void onAddGuestButtonClick() {
        if(class_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) class_group.getSelectedToggle();
            offer = Offer.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(instructor_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) instructor_group.getSelectedToggle();
            instructor = Instructor.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(location_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) location_group.getSelectedToggle();
            locationName = Location.valueOf(selected.getText().toUpperCase());
        }
        else
            return;
        if(firstNameClass != null)
            fname = firstNameClass.getText();
        else
            return;
        if(lastNameClass != null)
            lname = lastNameClass.getText();
        else
            return;
        if(dobClass.getValue() != null)
            dob = new Date(dobClass.getValue().getMonthValue(), dobClass.getValue().getDayOfMonth(), dobClass.getValue().getYear());
        else
            return;
        Time t = s.findFitnessClass(offer, instructor, location);
        FitnessClass fitnessClass = s.findFitnessClassA(offer, instructor, location, t);
        if (fitnessClass == null) {
            System.out.println(fitnessClass + " does not exist at ");
            return;
        }
        MemberList classMembers = new MemberList();
        MemberList classGuests = new MemberList();
        Member m = mL.findM(fname, lname, dob);
        if (m == null) {
            System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
            return;
        }
        boolean conflict = false;
        FitnessClass conflictedClass;


        String type = m.getClass().toString();
        if (m == null) {
            System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
            return;
        } else if (m.getExpire().compareTo(m.getExpire().currentTime()) < 0) {
            System.out.println(fname + " " + lname + " " + dob + " membership expired.");
            return;
        } else if (!s.contains(fitnessClass)) {
            System.out.println("Fitness class is not on the schedule.");
            return;
        } else if (type.equals("class fitness.Basic")) {
            System.out.println(fname + " " + lname + " [BASIC] - no guest pass.");
            return;
        } else if (!location.equals(m.getHomeStudio())) {
            System.out.println(fname + " " + lname + " (guest) is attending a class at " + location + " - " + "home studio at " + m.getHomeStudio());
            return;
        }
        if (type.equals("class fitness.Family")) {
            if (!((Family) m).isGuest()) {
                System.out.println(fname + " " + lname + " guest pass not available.");
                return;
            } else {
                ((Family) m).setGuest(false);
            }
        }
        if (type.equals("class fitness.Premium")) {
            if (((Premium) m).getGuestPass() <= 0) {
                System.out.println(fname + " " + lname + " guest pass not available.");
                return;
            } else {
                ((Premium) m).setGuestPass(((Premium) m).getGuestPass() - 1);
            }
        }

        classGuests = fitnessClass.getGuests();
        classGuests.add(m);
        fitnessClass.setGuests(classGuests);

        System.out.println(fname + " " + lname + " (guest) attendance recorded " + offer + " at " + location + ", " + fitnessClass.getZipCode() + ", " + fitnessClass.getCounty());
    }

    @FXML
    protected void onRemoveGuestButtonClick() {
        if (class_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) class_group.getSelectedToggle();
            offer = Offer.valueOf(selected.getText().toUpperCase());
        } else
            return;
        if (instructor_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) instructor_group.getSelectedToggle();
            instructor = Instructor.valueOf(selected.getText().toUpperCase());
        } else
            return;
        if (location_group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) location_group.getSelectedToggle();
            locationName = Location.valueOf(selected.getText().toUpperCase());
        } else
            return;
        if (firstNameClass != null)
            fname = firstNameClass.getText();
        else
            return;
        if (lastNameClass != null)
            lname = lastNameClass.getText();
        else
            return;
        if (dobClass.getValue() != null)
            dob = new Date(dobClass.getValue().getMonthValue(), dobClass.getValue().getDayOfMonth(), dobClass.getValue().getYear());
        else
            return;

        Time t = s.findFitnessClass(offer, instructor, location);
        FitnessClass fitnessClass = s.findFitnessClassA(offer, instructor, location, t);
        if (fitnessClass == null) {
            System.out.println(fitnessClass + " does not exist at ");
            return;
        }
        MemberList classMembers = new MemberList();
        MemberList classGuests = new MemberList();
        Member m = mL.findM(fname, lname, dob);
        if (m == null) {
            System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
            return;
        }
        boolean conflict = false;
        FitnessClass conflictedClass;

        if (fitnessClass.getGuests().contains(m)) {
            classGuests = fitnessClass.getGuests();
            classGuests.remove(m);
            fitnessClass.setGuests(classGuests);
            String type1 = m.getClass().toString();
            if (type1.equals("class fitness.Family")) {
                ((Family) m).setGuest(true);
            }
            if (type1.equals("class fitness.Premium")) {
                ((Premium) m).setGuestPass(((Premium) m).getGuestPass() + 1);
            }

            System.out.println(fname + " " + lname + " (guest) is removed from " + instructor + ", " + fitnessClass.getTime() + ", " + location + ", " + fitnessClass.getZipCode() + ", " + fitnessClass.getCounty());
        } else
            System.out.println(fname + " " + lname + " (guest) is not in " + instructor + ", " + fitnessClass.getTime() + ", " + location + ", " + fitnessClass.getZipCode() + ", " + fitnessClass.getCounty());
    }

    @FXML
    protected void onLoadScheduleButtonClick() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile != null){
            s.load(selectedFile.getAbsoluteFile());
        }
        else{
            System.out.println("file invalid");
            return;
        }

        MemberList members = new MemberList();
        MemberList guests = new MemberList();
        Collection<FitnessClass> list = Files.readAllLines(selectedFile.toPath())
                .stream()
                .map(line -> {
                    String[] details = line.split(" ");
                    FitnessClass cd = new FitnessClass(Offer.valueOf(details[0].toUpperCase()), Instructor.valueOf(details[1].toUpperCase()), Location.valueOf(details[3].toUpperCase()), Time.valueOf(details[2].toUpperCase()), members, guests);
                    return cd;
                })
                .collect(Collectors.toList());

        ObservableList<FitnessClass> details = FXCollections.observableArrayList(list);

        //tableView.getColumns().addAll(col1, col2, col3, col4);

        timeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime().toString()));
        classNameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClassInfo().toString()));
        instructorCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getInstructor().toString()));
        studioLocationCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudio().toString()));

        tableViewClass.setItems(details);

    }

}