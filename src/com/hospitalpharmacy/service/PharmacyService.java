package com.hospitalpharmacy.service;

import com.hospitalpharmacy.model.*;

public class PharmacyService {
    public static final String PHARMACY_NAME = "REVA Care Hospital Pharmacy";
    public static final double LOW_STOCK_LIMIT = 5.0;
    private Medicine[] medicines;
    private Patient[] patients;
    private int medicineIndex;
    private int patientIndex;

    public PharmacyService() {
        medicines = new Medicine[20];
        patients = new Patient[20];
        medicineIndex = 0;
        patientIndex = 0;
        seedData();
    }

    private void seedData() {
        addMedicine(new Medicine(101, "Paracetamol", MedicineType.TABLET, 2.50, 40));
        addMedicine(new Medicine(102, "Amoxicillin", MedicineType.CAPSULE, 8.00, 12));
        addMedicine(new Medicine(103, "Cough Syrup", MedicineType.SYRUP, 65.00, 4));
        addMedicine(new Medicine(104, "Insulin", MedicineType.INJECTION, 120.00, 10));
        addPatient(new Patient(201, "Rahul", "9876543210", 28, "Fever"));
        addPatient(new Patient(202, "Ananya", "9123456780", 35, "Diabetes"));
    }

    public boolean addMedicine(Medicine medicine) {
        if (medicineIndex >= medicines.length) return false;
        medicines[medicineIndex++] = medicine;
        return true;
    }

    public boolean addPatient(Patient patient) {
        if (patientIndex >= patients.length) return false;
        patients[patientIndex++] = patient;
        return true;
    }

    public Medicine[] getMedicines() { return medicines; }
    public Patient[] getPatients() { return patients; }

    public Medicine findMedicine(String search) {
        String key = search.trim();
        for (int i = 0; i < medicineIndex; i++) {
            if (medicines[i].getName().equalsIgnoreCase(key) || String.valueOf(medicines[i].getMedicineId()).equals(key)) {
                return medicines[i];
            }
        }
        return null;
    }

    public Patient findPatient(int id) {
        for (int i = 0; i < patientIndex; i++) {
            if (patients[i].getPatientId() == id) return patients[i];
        }
        return null;
    }

    public boolean dispense(int patientId, String medicineSearch, int quantity) {
        Patient patient = findPatient(patientId);
        Medicine medicine = findMedicine(medicineSearch);
        if (patient == null || medicine == null) return false;
        return medicine.reduceStock(quantity);
    }

    public int countLowStock() {
        int count = 0;
        for (int i = 0; i < medicineIndex; i++) {
            if (medicines[i].getStock() <= LOW_STOCK_LIMIT) count++;
        }
        return count;
    }

    public int getMedicineIndex() { return medicineIndex; }
    public int getPatientIndex() { return patientIndex; }
}
