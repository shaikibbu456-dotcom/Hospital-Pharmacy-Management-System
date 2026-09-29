package com.hospitalpharmacy.model;

public class Pharmacist extends Person {
    private String employeeId;
    private String qualification;

    public Pharmacist() {
        this("EMP-000", "Unknown", "Not Provided", "D.Pharm");
    }

    public Pharmacist(String employeeId, String name, String phone, String qualification) {
        super(name, phone);
        this.employeeId = employeeId;
        this.qualification = qualification;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    @Override
    public String getRoleDescription() {
        return "Licensed pharmacist managing medicine dispensing";
    }

    @Override
    public void displayContact() {
        super.displayContact();
        System.out.println("Employee ID: " + employeeId + " | Qualification: " + qualification);
    }
}
