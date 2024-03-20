package com.example.project_3;

/**
 * The Location enum represents the different locations of the com.example.project_3.fitness studio.
 * @author Colin Lee and Omkar Kadam
 */

public enum Location {
    BRIDGEWATER,
    EDISON,
    FRANKLIN,
    PISCATAWAY,
    SOMERVILLE,
    UNKNOWN;

    @Override
    public String toString() {
        switch (this) {
            case BRIDGEWATER:
                return "BRIDGEWATER";
            case EDISON:
                return "EDISON";
            case FRANKLIN:
                return "FRANKLIN";
            case PISCATAWAY:
                return "PISCATAWAY";
            case SOMERVILLE:
                return "SOMERVILLE";
            default:
                return "";
        }
    }
    public String getCounty() {
        if (this.toString().toLowerCase().equals("bridgewater") ||
                this.toString().toLowerCase().equals("franklin") ||
                this.toString().toLowerCase().equals("somerville")) {
            return "SOMERSET";
        }
        else if (this.toString().toLowerCase().equals("edison") ||
                this.toString().toLowerCase().equals("piscataway")){
            return "MIDDLESEX";
        }
        return "";
    }

    /**
     * Gets the zip code based on the home studio location of the member.
     *
     * @return The zip code of the home studio location
     */
    public String getZipCode() {
        switch (this.toString().toLowerCase()) {
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