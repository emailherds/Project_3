package fitness;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Represents a list of members in a fitness center.
 * @author Colin Lee and Omkar Kadam
 */
public class MemberList {
    private Member[] members; //holds Basic, Family, or Premium objects
    private int size; //number of objects in the array
    private static final int NOT_FOUND = -1;

    /**
     * Finds the index of a member in the array.
     *
     * @param member the member to find
     * @return the index of the member if found, otherwise -1
     */
    private int find(Member member) {
        for (int i = 0; i < size; i++) {
            if (member.getProfile().equals(members[i].getProfile()))
                return i;
        }
        return NOT_FOUND;
    }

    /**
     * Finds a member by first name, last name, and date of birth.
     *
     * @param fname the first name
     * @param lname the last name
     * @param dob   the date of birth
     * @return the member if found, otherwise null
     */
    public Member findM(String fname, String lname, Date dob) {
        Profile p = new Profile(fname, lname, dob);
        for (int i = 0; i < size; i++) {
            if (p.equals(members[i].getProfile()))
                return members[i];
        }
        return null;
    }

    /**
     * Increases the capacity of the array when necessary.
     */
    private void grow() {
        Member[] newAlbum = new Member[members.length + 4];
        for (int i = 0; i < members.length; i++)
            newAlbum[i] = members[i];
        members = newAlbum;
    }

    /**
     * Checks if the list contains a member.
     *
     * @param member the member to check
     * @return true if the member is found, otherwise false
     */
    public boolean contains(Member member) {
        if (find(member) != NOT_FOUND)
            return true;
        return false;
    }

    /**
     * Adds a member to the list.
     *
     * @param member the member to add
     * @return true if added successfully, otherwise false
     */
    public boolean add(Member member) {
        if (size == 0)
            members = new Member[4];
        if (contains(member))
            return false;
        members[size] = member;
        size++;
        if (size == members.length)
            grow();
        return true;
    } //add to end of array


    /**
     * Removes a member from the list.
     *
     * @param member the member to remove
     * @return true if removed successfully, otherwise false
     */
    public boolean remove(Member member) {
        if (!contains(member))
            return false;

        boolean hit = false;
        for (int i = 0; i < size; i++) {
            if (members[i].equals(member)) {
                hit = true;
            }
            if (hit && i < size - 1) {
                members[i] = members[i + 1];
            }
        }
        size--;
        return true;
    } //shift up to remove

    /**
     * Loads member data from a file.
     *
     * @param file the file to load data from
     * @throws IOException if an I/O error occurs
     */
    public void load(File file) throws IOException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            String plan = line[0];
            String fname = line[1];
            String lname = line[2];
            String[] dobString = line[3].split("/");
            Date dob = new Date(Integer.parseInt(dobString[0]), Integer.parseInt(dobString[1]), Integer.parseInt(dobString[2]));
            String[] expireString = line[4].split("/");
            Date expire = new Date(Integer.parseInt(expireString[0]), Integer.parseInt(expireString[1]), Integer.parseInt(expireString[2]));
            Location location = Location.valueOf(line[5].toUpperCase());
            Profile p = new Profile(fname, lname, dob);

            Member m = new Member(p, expire, location);
            boolean hasExpired = false;
            if (expire.compareTo(expire.currentTime()) <= 0)
                hasExpired = true;
            switch (plan) {
                case "B":
                    m = new Basic(p, expire, location, 0);
                    break;
                case "F":
                    m = new Family(p, expire, location, true);
                    break;
                case "P":
                    m = new Premium(p, expire, location, 3);
            }
            this.add(m);
        }
    } //from the text file

    /**
     * Prints the list of members sorted by county and zip code.
     */
    public void printByCounty() {
        if (size == 0) {
            System.out.println("!");
            return;
        }
        System.out.println("\n-list of members sorted by county then zipcode-");
        for (int i = 0; i < size; i++) {
            Member min = members[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                Member current = members[j];
                if (min.getCounty().compareTo(current.getCounty()) > 0) {
                    min = members[j];
                    minIndex = j;
                } else if (min.getCounty().compareTo(current.getCounty()) == 0 && min.getZipCode().compareTo(current.getZipCode()) > 0) {
                    min = members[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Member temp = members[i];
                members[i] = min;
                members[minIndex] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(members[i].toString());
        }
        System.out.println("-end of list-\n");
    } //sort by county then zip code

    /**
     * Prints the list of members sorted by member profile.
     */
    public void printByMember() {
        if (size == 0) {
            System.out.println("!");
            return;
        }
        System.out.println("\n-list of members sorted by member profiles-");
        for (int i = 0; i < size; i++) {
            Member min = members[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                Member current = members[j];
                if (min.getProfile().compareTo(current.getProfile()) > 0) {
                    min = members[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Member temp = members[i];
                members[i] = min;
                members[minIndex] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(members[i].toString());
        }
        System.out.println("-end of list-\n");
    } //sort by member profile

    /**
     * Prints the list of members sorted by fees.
     */
    public void printFees() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("-list of members with next dues-");
        for (int i = 0; i < size; i++) {
            if (members[i].bill() > 0) {
                String formattedNumber = decimalFormat.format(members[i].bill());
                System.out.println(members[i].toString() + " [next due: $" + formattedNumber + "]");
            }
        }
        System.out.println("-end of list-\n");
    } //print the array as is with the next due amounts

    /**
     * Gets the member array
     *
     * @return The member array
     */
    public Member[] getMembers() {
        return members;
    }

    /**
     * Sets the member array
     *
     * @param members The member array to set
     */
    public void setMembers(Member[] members) {
        this.members = members;
    }

    /**
     * Gets the member array size
     *
     * @return The member array size
     */
    public int getSize() {
        return size;
    }

}