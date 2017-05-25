package com.hnue.olshevskyi.dto;

import com.hnue.olshevskyi.model.User;

public class OrderDto {

    private String description;

    private int termDays;

    private boolean withDriver;

    private String passportSeries;

    private String passportNumber;

    private User user;

    private long carId;

    public OrderDto() {

    }

    public OrderDto(String description, int termDays, boolean withDriver, String passportSeries, String passportNumber, User user, long carId) {
        this.description = description;
        this.termDays = termDays;
        this.withDriver = withDriver;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.user = user;
        this.carId = carId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTermDays() {
        return termDays;
    }

    public void setTermDays(int termDays) {
        this.termDays = termDays;
    }

    public boolean isWithDriver() {
        return withDriver;
    }

    public void setWithDriver(boolean withDriver) {
        this.withDriver = withDriver;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }
}
