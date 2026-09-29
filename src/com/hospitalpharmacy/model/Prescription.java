package com.hospitalpharmacy.model;

public class Prescription implements Payable {
    private Patient patient;
    private Medicine medicine;
    private int quantity;
    private static final double TAX_RATE = 0.05;

    public Prescription(Patient patient, Medicine medicine, int quantity) {
        this.patient = patient;
        this.medicine = medicine;
        this.quantity = quantity;
    }

    public Patient getPatient() { return patient; }
    public Medicine getMedicine() { return medicine; }
    public int getQuantity() { return quantity; }

    @Override
    public double calculateBill(double discountRate) {
        double subtotal = medicine.getPrice() * quantity;
        return subtotal - (subtotal * discountRate) + (subtotal * TAX_RATE);
    }

    public double calculateBill() {
        return calculateBill(0.0);
    }
}
