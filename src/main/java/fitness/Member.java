package fitness;

/**
 * The Member class represents a fitness club member.
 * Author: Omkar Kadam, Colin Lee
 */
public class Member implements Comparable < Member > {
    private Profile profile;
    private Date expire;
    private Location homeStudio;

    /**
     * Constructor for the Member class.
     *
     * @param profile     The profile of the member
     * @param expire      The expiration date of the membership
     * @param homeStudio  The home studio location of the member
     */
    public Member(Profile profile, Date expire, Location homeStudio) {
        this.profile = profile;
        this.expire = expire;
        this.homeStudio = homeStudio;
    }

    /**
     * Calculates the bill amount for the member.
     *
     * @return The bill amount for the member (currently returns 0)
     */
    public double bill() {
        return 0;
    }

    /**
     * Overrides the toString method to provide a string representation of the member.
     *
     * @return A string representation of the member
     */
    @Override
    public String toString() {
        String expireString = "";
        if (expire.compareTo(expire.currentTime()) > 0)
            expireString = "expires";
        else
            expireString = "expired";
        return profile.toString() +
                "Membership " + expireString + " " + expire +
                ", Home Studio: " + homeStudio + ", " + getZipCode() + ", " + getCounty() + ",";
    }

    /**
     * Compares this member to another member based on their profile, expiration date, and home studio location.
     *
     * @param o The member to compare to
     * @return 0 if the members are equal, a negative value if this member is less than the other member,
     *         a positive value if this member is greater than the other member
     */
    @Override
    public int compareTo(Member o) {
        if (this.getProfile().compareTo(o.getProfile()) == 0) {
            if (this.getExpire().compareTo(o.getExpire()) == 0) {
                return this.getHomeStudio().compareTo(o.getHomeStudio());
            } else {
                return this.getExpire().compareTo(o.getExpire());
            }
        } else {
            return this.getProfile().compareTo(o.getProfile());
        }
    }

    /**
     * Checks if this member is equal to another object.
     *
     * @param o The object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        Member member = (Member) o;
        return getProfile().equals(member.getProfile()) &&
                getExpire().compareTo(member.getExpire()) == 0 &&
                getHomeStudio().equals(member.getHomeStudio());
    }

    /**
     * Gets the profile of the member.
     *
     * @return The profile of the member
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Sets the profile of the member.
     *
     * @param profile The profile to set
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Gets the expiration date of the membership.
     *
     * @return The expiration date of the membership
     */
    public Date getExpire() {
        return expire;
    }

    /**
     * Sets the expiration date of the membership.
     *
     * @param expire The expiration date to set
     */
    public void setExpire(Date expire) {
        this.expire = expire;
    }

    /**
     * Gets the home studio location of the member.
     *
     * @return The home studio location of the member
     */
    public Location getHomeStudio() {
        return homeStudio;
    }

    /**
     * Sets the home studio location of the member.
     *
     * @param homeStudio The home studio location to set
     */
    public void setHomeStudio(Location homeStudio) {
        this.homeStudio = homeStudio;
    }

    /**
     * Gets the county based on the home studio location of the member.
     *
     * @return The county of the home studio location
     */
    public String getCounty() {
        if (this.homeStudio.toString().toLowerCase().equals("bridgewater") ||
                this.homeStudio.toString().toLowerCase().equals("franklin") ||
                this.homeStudio.toString().toLowerCase().equals("somerville")) {
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
        switch (this.homeStudio.toString().toLowerCase()) {
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
}