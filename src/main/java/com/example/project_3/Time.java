package com.example.project_3;
/**
 * The Time enum represents different times of the day for com.example.project_3.fitness classes.
 * Author: Omkar Kadam, Colin Lee
 */
public enum Time {
    MORNING (9, 30),
    AFTERNOON (14, 00),
    EVENING (18, 30);

    private int hour;
    private int min;
    /**
     * Constructor for the Time enum.
     *
     * @param hour The hour of the time
     * @param min  The minute of the time
     */
    Time(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    /**
     * Overrides the toString method to provide a string representation of the time.
     *
     * @return A string representation of the time in HH:MM format
     */
    @Override
    public String toString() {
        String minString = String.valueOf(min);
        if(min == 0){
            minString = "00";
        }
        return hour + ":" + minString;
    }
}