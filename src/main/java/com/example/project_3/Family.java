package com.example.project_3;

/**
 * The Family class represents a family membership at the com.example.project_3.fitness club.
 * @author Omkar Kadam, Colin Lee
 */
public class Family extends Member {
    private boolean guest;

    /**
     * Constructor for the Family class.
     *
     * @param profile     The profile of the family
     * @param expire      The expiration date of the family membership
     * @param homeStudio  The home studio location of the family
     * @param guest       Whether the family has a guest pass
     */
    public Family(Profile profile, Date expire, Location homeStudio, boolean guest) {
        super(profile, expire, homeStudio);
        this.guest = guest;
    }

    /**
     * Calculates the bill amount for the family.
     *
     * @return The bill amount for the family
     */
    @Override
    public double bill() {
        return 49.99 * 3.00; // Monthly fee for a family membership
    }

    /**
     * Overrides the toString method to provide a string representation of the family.
     *
     * @return A string representation of the family
     */
    @Override
    public String toString() {
        String guestStatus = "1";
        if (!isGuest())
            guestStatus = "0";
        else if (getExpire().compareTo(getExpire().currentTime()) <= 0)
            guestStatus = "not eligible";
        else
            guestStatus = "1";
        return super.toString() + " (Family) guest-pass remaining: " + guestStatus;
    }

    /**
     * Checks if the family has a guest pass.
     *
     * @return true if the family has a guest pass, false otherwise
     */
    public boolean isGuest() {
        return guest;
    }

    /**
     * Sets whether the family has a guest pass.
     *
     * @param guest Whether the family has a guest pass
     */
    public void setGuest(boolean guest) {
        this.guest = guest;
    }
}