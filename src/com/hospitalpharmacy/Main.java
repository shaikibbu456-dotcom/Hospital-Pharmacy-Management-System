package com.hospitalpharmacy;

import java.util.Scanner;
import com.hospitalpharmacy.model.*;
import com.hospitalpharmacy.service.*;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PharmacyService pharmacy = new PharmacyService();
    private static final BillingService billing = new BillingService();

    public static void main(String[] args) {
        System.out.println("\n========================================================");
        System.out.println("      REVA CARE HOSPITAL PHARMACY MANAGEMENT SYSTEM");
        System.out.println("========================================================");

        // Parent reference holding child objects demonstrates dynamic binding.
        Person[] staffAndPatients = {
            new Patient(999, "Demo Patient", "9000000000", 30, "Check-up"),
            new Pharmacist("EMP-101", "Ibrahim", "9999999999", "B.Pharm")
        };
        for (Person person : staffAndPatients) {
            System.out.println(person.getRoleDescription());
        }

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: listMedicines(); break;
                case 2: listPatients(); break;
                case 3: addPatient(); break;
                case 4: addMedicine(); break;
                case 5: dispenseMedicine(); break;
                case 6: viewBill(); break;
                case 7: demonstrateFeatures(); break;
                case 8: running = false; break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using " + PharmacyService.PHARMACY_NAME + ".");
        SCANNER.close();
    }

    private static void printMenu() {
        System.out.println("\n---------------- MENU ----------------");
        System.out.println("1. View Medicines");
        System.out.println("2. View Patients");
        System.out.println("3. Register Patient");
        System.out.println("4. Add Medicine");
        System.out.println("5. Dispense Medicine");
        System.out.println("6. Generate Bill");
        System.out.println("7. OOP Feature Demonstration");
        System.out.println("8. Exit");
    }

    private static void listMedicines() {
        System.out.printf("%-5s %-18s %-10s %8s %5s%n", "ID", "Medicine", "Type", "Price", "Stock");
        System.out.println("-------------------------------------------------------");
        for (Medicine medicine : pharmacy.getMedicines()) {
            if (medicine == null) continue;
            System.out.println(medicine);
        }
    }

    private static void listPatients() {
        for (Patient patient : pharmacy.getPatients()) {
            if (patient == null) continue;
            System.out.println(patient);
        }
    }

    private static void addPatient() {
        int id = readInt("Patient ID: ");
        System.out.print("Name: ");
        String name = SCANNER.nextLine().trim();
        System.out.print("Phone: ");
        String phone = SCANNER.nextLine().trim();
        int age = readInt("Age: ");
        System.out.print("Disease/Reason: ");
        String disease = SCANNER.nextLine().trim();
        if (pharmacy.addPatient(new Patient(id, name, phone, age, disease))) {
            System.out.println("Patient registered successfully.");
        } else {
            System.out.println("Patient storage is full.");
        }
    }

    private static void addMedicine() {
        int id = readInt("Medicine ID: ");
        System.out.print("Medicine name: ");
        String name = SCANNER.nextLine().trim();
        System.out.println("Type: 1.TABLET  2.CAPSULE  3.SYRUP  4.INJECTION");
        int typeChoice = readInt("Choose type: ");
        MedicineType type;
        switch (typeChoice) {
            case 1: type = MedicineType.TABLET; break;
            case 2: type = MedicineType.CAPSULE; break;
            case 3: type = MedicineType.SYRUP; break;
            case 4: type = MedicineType.INJECTION; break;
            default: System.out.println("Invalid type."); return;
        }
        double price = readDouble("Price: ");
        int stock = readInt("Stock: ");
        pharmacy.addMedicine(new Medicine(id, name, type, price, stock));
        System.out.println("Medicine added successfully.");
    }

    private static void dispenseMedicine() {
        int patientId = readInt("Patient ID: ");
        System.out.print("Medicine name/ID: ");
        String search = SCANNER.nextLine();
        int quantity = readInt("Quantity: ");
        Medicine medicine = pharmacy.findMedicine(search);
        Patient patient = pharmacy.findPatient(patientId);
        if (patient == null || medicine == null) {
            System.out.println("Patient or medicine not found.");
            return;
        }
        if (pharmacy.dispense(patientId, search, quantity)) {
            System.out.println("Medicine dispensed to " + patient.getName() + ". Remaining stock: " + medicine.getStock());
        } else {
            System.out.println("Dispensing failed. Check quantity and stock.");
        }
    }

    private static void viewBill() {
        int patientId = readInt("Patient ID: ");
        System.out.print("Medicine name/ID: ");
        String search = SCANNER.nextLine();
        int quantity = readInt("Quantity: ");
        Patient patient = pharmacy.findPatient(patientId);
        Medicine medicine = pharmacy.findMedicine(search);
        if (patient == null || medicine == null) {
            System.out.println("Patient or medicine not found.");
            return;
        }
        double bill = billing.calculateForPatient(patient, medicine, quantity);
        System.out.printf("Patient: %s%nMedicine: %s%nQuantity: %d%nTotal Bill: Rs. %.2f%n", patient.getName(), medicine.getName(), quantity, bill);
        System.out.println("Rounded bill (type casting): Rs. " + billing.roundedBill(bill));
    }

    private static void demonstrateFeatures() {
        System.out.println("\n--- OOP Demonstration ---");
        Pharmacist pharmacist = new Pharmacist("EMP-500", "Ibrahim", "9999999999", "B.Pharm");
        pharmacist.displayContact(); // super.method() is used inside child class.

        Person person = new Pharmacist("EMP-501", "Asha", "8888888888", "D.Pharm");
        System.out.println("Dynamic binding: " + person.getRoleDescription());

        MedicalRecord record = new MedicalRecord(pharmacy.findPatient(201), "Fever and body pain", "Rest and hydration advised");
        System.out.println(record.summary());

        Payable payable = new Prescription(pharmacy.findPatient(201), pharmacy.findMedicine("Paracetamol"), 3);
        System.out.printf("Interface reference bill: Rs. %.2f%n", payable.calculateBill(0.05));

        System.out.println("Total Medicine objects created: " + Medicine.getMedicineCount());
        System.out.println("Total Patient objects created: " + Patient.getPatientCount());
        System.out.println("Low-stock medicines: " + pharmacy.countLowStock());
        System.out.println("Operator precedence example: 10 + 5 * 2 = " + (10 + 5 * 2));
        System.out.println("String contains 'pain': " + record.getDiagnosis().toLowerCase().contains("pain"));
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(SCANNER.nextLine().trim());
                if (value < 0) { System.out.println("Enter a non-negative value."); continue; }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
