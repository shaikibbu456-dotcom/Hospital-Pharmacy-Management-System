package com.hospitalpharmacy.model;

public abstract class Person {
    private String name;
    private String phone;

    public Person() {
        this("Unknown", "Not Provided");
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public abstract String getRoleDescription();

    public void displayContact() {
        System.out.println("Contact: " + name + " | Phone: " + phone);
    }
}
