package ru.flynt3650.project.furniture.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class Client implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "name must be between 3 and 50")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 50, message = "name must be between 3 and 50")
    private String lastName;

    @NotNull
    @Size(min = 3, max = 100, message = "name must be between 3 and 100")
    private String email;

    @NotNull
    @Size(min = 3, max = 20, message = "name must be between 3 and 20")
    private String phoneNumber;

    @NotNull
    @Size(min = 3, max = 255, message = "name must be between 3 and 255")
    private String address;

    public Client() {
    }

    public Client(int id, String firstName, String lastName, String email, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
