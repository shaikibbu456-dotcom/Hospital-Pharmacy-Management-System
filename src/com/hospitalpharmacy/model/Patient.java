package com.hospitalpharmacy.model;

public class Patient extends Person {
    private int patientId;
    private int age;
    private String disease;
    private static int patientCount = 0;

    public Patient() {
        this(0, "Unknown", "Not Provided", 0, "Not Specified");
    }

    public Patient(int patientId, String name, String phone, int age, String disease) {
        super(name, phone);
        this.patientId = patientId;
        this.age = age;
        this.disease = disease;
        patientCount++;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }
    public static int getPatientCount() { return patientCount; }

    @Override
    public String getRoleDescription() {
        return "Patient receiving pharmacy services";
    }

    @Override
    public String toString() {
        return String.format("Patient{id=%d, name='%s', age=%d, disease='%s'}", patientId, getName(), age, disease);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;
        Patient other = (Patient) obj;
        return patientId == other.patientId;
    }
}
