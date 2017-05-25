package com.hnue.olshevskyi.dto;

public class UserRegistrationDto {

    private String login;

    private String password;

    private String passwordConfirmation;

    private String email;

    private String firstName;

    private String lastName;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String login, String password, String passwordConfirmation, String email, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
