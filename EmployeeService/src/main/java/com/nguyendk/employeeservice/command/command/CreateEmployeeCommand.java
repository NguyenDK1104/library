package com.nguyendk.employeeservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateEmployeeCommand {
    @TargetAggregateIdentifier
    private String employeeId;
    private String firstName;
    private String lastName;
    private String skin;
    private Boolean isDiscriplined;

    public CreateEmployeeCommand(String employeeId, String firstName, String lastName, String skin, Boolean isDiscriplined) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skin = skin;
        this.isDiscriplined = isDiscriplined;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public Boolean getIsDiscriplined() {
        return isDiscriplined;
    }

    public void setIsDiscriplined(Boolean isDiscriplined) {
        this.isDiscriplined = isDiscriplined;
    }
}
