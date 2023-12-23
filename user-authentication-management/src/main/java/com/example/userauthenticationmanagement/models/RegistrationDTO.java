package com.example.userauthenticationmanagement.models;

public class RegistrationDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String emailId;
    private String password;
    private Role role;

    public RegistrationDTO(String firstName, String lastName, String username, String emailId, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString() {
        return "Registration info: username: " + this.username + " password: " + this.password + " firstName: " + this.firstName + " lastName: " + this.lastName + " emailId: " + this.emailId + " role: " + this.role;
    }
}
