package fitness;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a schedule of fitness classes.
 * Authors: Omkar Kadam, Colin Lee
 */
public class Schedule {
    private FitnessClass[] classes;
    private int numClasses;
    private static final int NOT_FOUND = -1;

    private static final int INITIALSIZE = 4;

    /**
     * Loads fitness classes from a file into the schedule.
     * @param file the file containing fitness class information
     * @throws IOException if an I/O error occurs
     */
    public void load(File file) throws IOException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            Offer offer = Offer.valueOf(line[0].toUpperCase());
            Instructor instructor = Instructor.valueOf(line[1].toUpperCase());
            Time time = Time.valueOf(line[2].toUpperCase());
            Location location = Location.valueOf(line[3].toUpperCase());
            MemberList ml = new MemberList();
            MemberList gl = new MemberList();

            FitnessClass fitnessClass = new FitnessClass(offer, instructor, location, time, ml, gl);

            add(fitnessClass);
        }
    }

    /**
     * Increases the capacity of the schedule array.
     */
    private void grow() {
        FitnessClass[] temp = new FitnessClass[classes.length + INITIALSIZE];
        for (int i = 0; i < numClasses; i++)
            temp[i] = classes[i];
        classes = temp;
    }

    /**
     * Adds a fitness class to the schedule.
     * @param fitnessClass the fitness class to add
     * @return true if the fitness class was added successfully, false otherwise
     */
    public boolean add(FitnessClass fitnessClass) {
        if (numClasses == 0)
            classes = new FitnessClass[INITIALSIZE];
        else if (contains(fitnessClass))
            return false;
        classes[numClasses] = fitnessClass;
        numClasses++;
        if (numClasses == classes.length)
            grow();
        return true;
    }

    /**
     * Checks if a fitness class is already in the schedule.
     * @param fitnessClass the fitness class to check
     * @return true if the fitness class is already in the schedule, false otherwise
     */
    public boolean contains(FitnessClass fitnessClass) {
        return find(fitnessClass) != NOT_FOUND;
    }

    /**
     * Finds the index of a fitness class in the schedule.
     * @param fitnessClass the fitness class to find
     * @return the index of the fitness class if found, otherwise -1
     */
    private int find(FitnessClass fitnessClass) {
        for (int i = 0; i < numClasses; i++) {
            if (fitnessClass.equals(classes[i]))
                return i;
        }
        return NOT_FOUND;
    }

    /**
     * Retrieves all fitness classes in the schedule.
     * @return an array of fitness classes
     */
    public FitnessClass[] getClasses() {
        return classes;
    }

    /**
     * Retrieves the number of fitness classes in the schedule.
     * @return the number of fitness classes
     */
    public int getNumClasses() {
        return numClasses;
    }

    /**
     * Sets the fitness classes in the schedule.
     * @param classes the fitness classes to set
     */
    public void setClasses(FitnessClass[] classes) {
        this.classes = classes;
    }

    /**
     * Sets the number of fitness classes in the schedule.
     * @param numClasses the number of fitness classes to set
     */
    public void setNumClasses(int numClasses) {
        this.numClasses = numClasses;
    }

    /**
     * Prints the schedule of fitness classes.
     */
    public void print() {
        // Implementation for printing the schedule
        for (int i = 0; i < numClasses; i++) {
            FitnessClass fc = classes[i];
            System.out.println(fc);

            if (fc.getMembers().getMembers() != null) {
                for (int j = 0; j < fc.getMembers().getSize(); j++) {
                    if (j == 0)
                        System.out.println("[Attendees]");
                    System.out.println("   " + fc.getMembers().getMembers()[j]);
                }
            }
            if (fc.getGuests().getMembers() != null) {
                for (int j = 0; j < fc.getGuests().getSize(); j++) {
                    if (j == 0)
                        System.out.println("[Guests]");
                    System.out.println("   " + fc.getGuests().getMembers()[j]);
                }
            }
        }
        System.out.println("-end of class list.");
    }

    /**
     * Finds the time of a fitness class with the specified offer, instructor, and location.
     * @param offer the offer of the fitness class
     * @param instructor the instructor of the fitness class
     * @param location the location of the fitness class
     * @return the time of the fitness class if found, otherwise null
     */
    public Time findFitnessClass(Offer offer, Instructor instructor, Location location) {
        for (int i = 0; i < numClasses; i++) {
            if (classes[i].getClassInfo() == offer && classes[i].getInstructor() == instructor && classes[i].getStudio() == location) {
                return classes[i].getTime();
            }
        }
        return null;
    }

    /**
     * Finds a fitness class with the specified offer, instructor, location, and time.
     * @param offer the offer of the fitness class
     * @param instructor the instructor of the fitness class
     * @param location the location of the fitness class
     * @param t the time of the fitness class
     * @return the fitness class if found, otherwise null
     */
    public FitnessClass findFitnessClassA(Offer offer, Instructor instructor, Location location, Time t) {
        for (int i = 0; i < numClasses; i++) {
            if (classes[i].getClassInfo() == offer && classes[i].getInstructor() == instructor && classes[i].getStudio() == location && classes[i].getTime().compareTo(t) == 0) {
                return classes[i];
            }
        }
        return null;
    }
}