package com.example.project_3;

/**
 * The FitnessClass class represents a com.example.project_3.fitness class at the studio.
 * @author Omkar Kadam, Colin Lee
 */
public class FitnessClass {
    private Offer classInfo; // Information about the class
    private Instructor instructor; // The instructor of the class
    private Location studio; // The studio where the class is held
    private Time time; // The time of the class
    private MemberList members; // List of members attending the class
    private MemberList guests; // List of guests attending the class

    /**
     * Constructor for creating a FitnessClass with all parameters.
     *
     * @param classInfo Information about the class
     * @param instructor The instructor of the class.
     * @param studio The studio where the class is held
     * @param time The time of the class
     * @param members List of members attending the class
     * @param guests List of guests attending the class
     */
    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time, MemberList members, MemberList guests) {
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;
        this.time = time;
        this.members = members;
        this.guests = guests;
    }

    /**
     * Constructor for creating a FitnessClass with basic parameters.
     *
     * @param classInfo Information about the class
     * @param instructor The instructor of the class
     * @param studio The studio where the class is held
     * @param time The time of the class
     */
    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time) {
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;
        this.time = time;
    }

    /**
     * Gets the county based on the home studio location of the member.
     *
     * @return The county of the home studio location
     */
    public String getCounty() {
        if (this.studio.toString().toLowerCase().equals("bridgewater") ||
                this.studio.toString().toLowerCase().equals("franklin") ||
                this.studio.toString().toLowerCase().equals("somerville")) {
            return "SOMERSET";
        }
        return "MIDDLESEX";
    }

    /**
     * Gets the zip code based on the home studio location of the member.
     *
     * @return The zip code of the home studio location
     */
    public String getZipCode() {
        switch (this.studio.toString().toLowerCase()) {
            case "bridgewater":
                return "08807";
            case "edison":
                return "08837";
            case "franklin":
                return "08873";
            case "piscataway":
                return "08854";
            case "somerville":
                return "08876";
        }
        return "";
    }

    @Override
    public String toString() {
        return classInfo +
                " - " + instructor +
                ", " + time +
                ", " + studio;
    }

    // Getters and setters for class attributes

    /**
     * Sets the class
     *
     * @param classInfo The class to set
     */
    public void setClass(Offer classInfo) {
        this.classInfo = classInfo;
    }

    /**
     * Sets the instructor
     *
     * @param instructor The instructor to set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * Sets the studio location
     *
     * @param studio The studio location
     */
    public void setStudio(Location studio) {
        this.studio = studio;
    }

    /**
     * Sets the time
     *
     * @param time The time
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Sets the members MemberList
     *
     * @param members The members MemberList to set
     */
    public void setMembers(MemberList members) {
        this.members = members;
    }

    /**
     * Sets the guests MemberList
     *
     * @param guests The guests MemberList to set
     */
    public void setGuests(MemberList guests) {
        this.guests = guests;
    }

    /**
     * Gets the classInfo
     *
     * @return The classInfo
     */
    public Offer getClassInfo() {
        return classInfo;
    }

    /**
     * Gets the instructor
     *
     * @return The instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Gets the studio
     *
     * @return The studio
     */
    public Location getStudio() {
        return studio;
    }

    /**
     * Gets the time
     *
     * @return The time
     */
    public Time getTime() {
        return time;
    }

    /**
     * Gets the members MemberList
     *
     * @return The members MemberList
     */
    public MemberList getMembers() {
        return members;
    }

    /**
     * Gets the guests MemberList
     *
     * @return The guests MemberList
     */
    public MemberList getGuests() {
        return guests;
    }
}