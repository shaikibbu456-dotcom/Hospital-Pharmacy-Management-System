package com.hospitalpharmacy.model;

public class MedicalRecord {
    private Patient patient;
    private String diagnosis;
    private String notes;

    public MedicalRecord(Patient patient, String diagnosis, String notes) {
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public Patient getPatient() { return patient; }
    public String getDiagnosis() { return diagnosis; }
    public String getNotes() { return notes; }

    public String summary() {
        String[] words = diagnosis.trim().split("\\s+");
        return patient.getName() + " - Diagnosis: " + diagnosis + " (" + words.length + " word(s))";
    }
}
