package fitness;
/**
 * Represents a premium member, extending the Member class.
 * Contains information about the number of guest passes.
 * Authors: Omkar Kadam, Colin Lee
 */
public class Premium extends Member {
    private int guestPass;
    /**
     * Constructs a Premium member with the given profile, expiration date, home studio, and number of guest passes.
     * @param profile the profile of the member
     * @param expire the expiration date of the membership
     * @param homeStudio the home studio location of the member
     * @param guestPass the number of guest passes for the member
     */
    public Premium(Profile profile, Date expire, Location homeStudio, int guestPass) {
        super(profile, expire, homeStudio);
        this.guestPass = guestPass;
    }
    /**
     * Returns a string representation of the Premium member.
     * @return a string containing the member's profile, membership type, and guest pass information
     */
    public String toString() {
        String thing = "";
        if (getGuestPass() <= 0) {
            thing = "0";
        } else if (getExpire().compareTo(getExpire().currentTime()) <= 0) {
            thing = "not eligible";
        } else {
            thing = String.valueOf(getGuestPass());
        }
        return super.toString() + " (Premium) guest-pass remaining: " + thing;
    }

    /**
     * Calculates the next due amount for the Premium member.
     * @return the next due amount
     */
    @Override
    public double bill() {
        return 59.99 * 11.00;
    }

    /**
     * Retrieves the number of guest passes for the Premium member.
     * @return the number of guest passes
     */
    public int getGuestPass() {
        return guestPass;
    }

    /**
     * Sets the number of guest passes for the Premium member.
     * @param guestPass the number of guest passes to set
     */
    public void setGuestPass(int guestPass) {
        this.guestPass = guestPass;
    }
}