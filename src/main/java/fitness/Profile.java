package fitness;

/**
 * Represents a profile containing first name, last name, and date of birth.
 * Provides methods to compare profiles and retrieve profile information.
 * Authors: Omkar Kadam, Colin Lee
 */
public class Profile implements Comparable < Profile > {
    private String fname;
    private String lname;
    private Date dob;

    /**
     * Constructs a Profile with the given first name, last name, and date of birth.
     * @param fname the first name
     * @param lname the last name
     * @param dob the date of birth
     */
    public Profile(String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    /**
     * Compares this Profile with another Profile based on last name, first name, and date of birth.
     * @param o the Profile to compare to
     * @return a negative integer, zero, or a positive integer as this Profile is less than, equal to, or greater than the specified Profile
     */
    @Override
    public int compareTo(Profile o) {
        if (this.lname.compareTo(o.lname) == 0) {
            if (this.fname.compareTo(o.fname) == 0) {
                if (this.dob.compareTo(o.dob) == 0) {
                    return 0;
                } else if (this.dob.compareTo(o.dob) < 0) {
                    return -1;
                }
                return 1;
            } else if (this.fname.compareTo(o.fname) < 0) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.lname.compareTo(o.lname) < 0) {
            return -1;
        }
        return 1;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o the object to compare
     * @return true if this Profile is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        Profile profile = (Profile) o;
        return fname.equalsIgnoreCase(profile.getFname()) && lname.equalsIgnoreCase(profile.getLname()) && dob.compareTo(profile.getDob()) == 0;
    }

    /**
     * Returns a string representation of the Profile.
     * @return a string containing the first name, last name, and date of birth
     */
    @Override
    public String toString() {
        return fname + ':' +
                lname + ':' +
                dob + ", ";
    }

    /**
     * Retrieves the first name of the Profile.
     * @return the first name
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets the first name of the Profile.
     * @param fname the first name to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Retrieves the last name of the Profile.
     * @return the last name
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets the last name of the Profile.
     * @param lname the last name to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Retrieves the date of birth of the Profile.
     * @return the date of birth
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the Profile.
     * @param dob the date of birth to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }
}