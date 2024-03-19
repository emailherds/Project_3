package com.example.project_3;

/**
 * The Instructor enum represents the available com.example.project_3.fitness class instructors.
 * @author Colin Lee and Omkar Kadam
 */

public enum Instructor {
    JENNIFER,
    KIM,
    DENISE,
    DAVIS,
    EMMA,
    UNKNOWN;

    @Override
    public String toString() {
        switch (this) {
            case JENNIFER:
                return "JENNIFER";
            case KIM:
                return "KIM";
            case DENISE:
                return "DENISE";
            case DAVIS:
                return "DAVIS";
            case EMMA:
                return "EMMA";
            default:
                return "Unknown";
        }
    }
}