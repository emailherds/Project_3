package com.example.project_3;
import java.util.Calendar;
/**
 Date class which contains month, day, and year of a date and checks if the date is valid and compares two dates
 @author Omkar Kadam, Colin Lee
 */
public class Date implements Comparable < Date > {
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THIRTYONE = 31;
    public static final int THIRTY = 30;

    public static final int TWENTYEIGHT = 28;
    public static final int TWENTYNINE = 29;

    public static final int MONTHSINYEAR = 12;
    public static final int EIGHTEEN = 18;

    private int year;
    private int month;
    private int day;

    /**
     Constructor for Date class
     @param month month of the date
     @param day day of the month for the date
     @param year year of the date
     */
    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }


    /**
     isValid() checks if the current date is a valid date
     @return true or false if the date is valid or not
     */
    public boolean isValid() {
        boolean leap = false;
        if (this.getYear() % QUADRENNIAL == 0) {
            if (this.getYear() % CENTENNIAL == 0) {
                if (this.getYear() % QUATERCENTENNIAL == 0) {
                    leap = true;
                }
            } else {
                leap = true;
            }
        }
        if (this.getMonth() > 0 && this.getMonth() <= MONTHSINYEAR && isDay(leap) && this.getYear() >= 1900) {
            //if(this.compareTo(currentTime()) < 0)
            return true;
        }
        return false;
    } //check if the date is a valid calendar date

    /**
     isPast() checks if the date is in the past
     @return true or false if the date is in the past or not
     */
    public boolean isPast() {
        if (this.compareTo(currentTime()) < 0)
            return true;
        return false;
    }

    /**
     isLeap() checks if the year is leap year
     @return true or false if the year is leap year
     */
    public boolean isLeap() {
        boolean leap = false;
        if (this.getYear() % QUADRENNIAL == 0) {
            if (this.getYear() % CENTENNIAL == 0) {
                if (this.getYear() % QUATERCENTENNIAL == 0) {
                    leap = true;
                }
            } else {
                leap = true;
            }
        }
        return leap;
    }

    /**
     getNextDate() gets date after certain number of months from date
     @param months number of months to add
     @return date after certain number of months from date
     */
    public Date getNextDate(int months) {
        Date expire = this; // this is current time
        expire.setMonth(expire.getMonth() + months);
        if (expire.getMonth() > MONTHSINYEAR) {
            expire.setYear(expire.getYear() + 1);
            expire.setMonth(expire.getMonth() - MONTHSINYEAR);
        }
        if (!expire.isValid()) {
            if (expire.getDay() > expire.daysInMonth()) {
                expire.setDay(expire.daysInMonth());
            }
        }
        return expire;
    }

    /**
     daysInMonth() checks how many days in a certain month
     @return how many days in a certain month
     */
    public int daysInMonth() {
        int days = 0;
        int february;
        if (this.isLeap())
            february = TWENTYNINE;
        else
            february = TWENTYEIGHT;
        days =
                switch (this.getMonth()) {
                    case 1 -> THIRTYONE;
                    case 2 -> february;
                    case 3 -> THIRTYONE;
                    case 4, 11 -> THIRTY;
                    case 5 -> THIRTYONE;
                    case 6 -> THIRTY;
                    case 7 -> THIRTYONE;
                    case 8 -> THIRTYONE;
                    case 9 -> THIRTY;
                    case 10 -> THIRTYONE;
                    case 12 -> THIRTYONE;
                    default -> days;
                };
        return days;
    }

    /**
     isValid() checks if the DOB means person is older than 18
     @return true or false if the date is valid or not
     */
    public boolean dobIsEighteen() {
        if (currentTime().getYear() - this.getYear() > EIGHTEEN ||
                (currentTime().getYear() - this.getYear() == EIGHTEEN &&
                        currentTime().getMonth() - this.getMonth() > 0)) {
            return true;
        }
        return false;
    }


    /**
     currentTime uses the calendar class to find the current date
     @return the current date
     */
    public Date currentTime() {
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.YEAR));
    }

    /**
     isDay checks whether a day is a valid day based on which month it is. It also accounts for leap years.
     @param leap whether the current year is a leap year
     @return true or false if the day exists in the month
     */
    private boolean isDay(boolean leap) {
        int days = 0;
        int february;
        if (leap)
            february = TWENTYNINE;
        else
            february = TWENTYEIGHT;
        days =
                switch (this.getMonth()) {
                    case 1 -> THIRTYONE;
                    case 2 -> february;
                    case 3 -> THIRTYONE;
                    case 4, 11 -> THIRTY;
                    case 5 -> THIRTYONE;
                    case 6 -> THIRTY;
                    case 7 -> THIRTYONE;
                    case 8 -> THIRTYONE;
                    case 9 -> THIRTY;
                    case 10 -> THIRTYONE;
                    case 12 -> THIRTYONE;
                    default -> days;
                };
        if (this.getDay() <= days && this.getDay() > 0)
            return true;
        return false;
    }

    /**
     Compares two dates based on their years, months, and dates
     @param o the date to be compared.
     @return 0 if the dates are equal, -1 if the first date is before the compared date, 1 if the first date is after the compared date
     */
    @Override
    public int compareTo(Date o) {
        if (this.getYear() == o.getYear()) {
            if (this.getMonth() == o.getMonth()) {
                if (this.getDay() == o.getDay()) {
                    return 0;
                } else if (this.getDay() < o.getDay()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.getMonth() < o.getMonth()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.getYear() < o.getYear()) {
            return -1;
        }
        return 1;
    }


    /**
     Prints date in mm/dd/yyyy format
     @return string of date
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     Get year of date
     @return year of date
     */
    public int getYear() {
        return year;
    }

    /**
     Get month of date
     @return month of date
     */
    public int getMonth() {
        return month;
    }

    /**
     Get day of date
     @return day of date
     */
    public int getDay() {
        return day;
    }

    /**
     Set year of date
     @param year year to set for date
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     Set month of date
     @param month month to set for date
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     Set day of date
     @param day day to set for date
     */
    public void setDay(int day) {
        this.day = day;
    }
}