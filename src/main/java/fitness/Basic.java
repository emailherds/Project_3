package fitness;

/**
 * The Basic class represents a basic membership for a member.
 * Extends the Member class.
 * @author Omkar Kadam, Colin Lee
 */
public class Basic extends Member {
    private int numClasses; // Number of classes attended by the member

    /**
     * Constructor for the Basic class.
     *
     * @param profile     The profile of the member
     * @param expire      The expiration date of the membership
     * @param homeStudio  The home studio location of the member
     * @param numClasses  The number of classes attended by the member
     */
    public Basic(Profile profile, Date expire, Location homeStudio, int numClasses) {
        super(profile, expire, homeStudio);
        this.numClasses = numClasses;
    }

    /**
     * Overrides the toString method to include membership type and number of classes attended.
     *
     * @return A string representation of the basic membership
     */
    @Override
    public String toString() {
        String expireString = String.valueOf(numClasses);
        if (this.getExpire().compareTo(getExpire().currentTime()) <= 0)
            expireString = "not eligible";
        return super.toString() + " (Basic) number of classes attended: " + numClasses;
    }

    /**
     * Calculates the bill amount for the basic membership.
     *
     * @return The bill amount for the basic membership
     */
    @Override
    public double bill() {
        double bill = 39.99;
        if (numClasses > 4)
            bill += (numClasses - 4) * 10;
        return bill;
    }

    /**
     * Gets the number of classes attended by the member.
     *
     * @return The number of classes attended
     */
    public int getNumClasses() {
        return numClasses;
    }

    /**
     * Sets the number of classes attended by the member.
     *
     * @param numClasses The number of classes to set
     */
    public void setNumClasses(int numClasses) {
        this.numClasses = numClasses;
    }
}