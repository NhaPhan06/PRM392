package com.example.myapplication.Ex3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FootBall {
    public FootBall(String fullName, Date dateOfBirth, int countryFlag, int imageResource) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.countryFlag = countryFlag;
        this.imageResource = imageResource;
    }
    private String fullName;
    private Date dateOfBirth;
    private int countryFlag;
    private int imageResource;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(int countryFlag) {
        this.countryFlag = countryFlag;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
