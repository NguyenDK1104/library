package com.nguyendk.employeeservice.query.model;

public class EmployeeResponseModel {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String skin;
    private Boolean isDiscriplined;

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
