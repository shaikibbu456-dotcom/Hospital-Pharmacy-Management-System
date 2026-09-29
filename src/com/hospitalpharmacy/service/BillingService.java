package com.hospitalpharmacy.service;

import com.hospitalpharmacy.model.*;

public class BillingService {
    public static final double SENIOR_DISCOUNT = 0.10;

    public double calculateForPatient(Patient patient, Medicine medicine, int quantity) {
        Prescription prescription = new Prescription(patient, medicine, quantity);
        double discount = patient.getAge() >= 60 ? SENIOR_DISCOUNT : 0.0;
        return prescription.calculateBill(discount);
    }

    public int roundedBill(double bill) {
        return (int) bill;
    }
}
