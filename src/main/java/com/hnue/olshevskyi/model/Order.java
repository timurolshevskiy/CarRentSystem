package com.hnue.olshevskyi.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String description;

    private int termDays;

    private boolean withDriver;

    private String status;

    private String passportSeries;

    private String passportNumber;

    private LocalDate date;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car", nullable = false)
    private Car car;

    public Order() {

    }

    public Order(long id, String description, int termDays, boolean withDriver, String status, String passportSeries, String passportNumber, LocalDate date, User user, Car car) {
        this.id = id;
        this.description = description;
        this.termDays = termDays;
        this.withDriver = withDriver;
        this.status = status;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.date = date;
        this.user = user;
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (termDays != order.termDays) return false;
        if (withDriver != order.withDriver) return false;
        if (description != null ? !description.equals(order.description) : order.description != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (passportSeries != null ? !passportSeries.equals(order.passportSeries) : order.passportSeries != null)
            return false;
        if (passportNumber != null ? !passportNumber.equals(order.passportNumber) : order.passportNumber != null)
            return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        return car != null ? car.equals(order.car) : order.car == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + termDays;
        result = 31 * result + (withDriver ? 1 : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (passportSeries != null ? passportSeries.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }
}
