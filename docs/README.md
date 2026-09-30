# Java OOP Practical Mini Project

**Student:** Shaik Ibrahim  
**SRN:** R24SA038  
**Program:** B.Sc. (BSTCs), Semester V  
**Subject:** Java Programming  
**Project:** Hospital Pharmacy Management System

## 1. Project Overview

This is a console-based Hospital Pharmacy Management System developed in Java. It supports medicine inventory, patient registration, medicine dispensing, bill calculation, and an OOP demonstration menu.

The implementation is organized into two custom packages:
- `com.hospitalpharmacy.model` — domain classes, enum, abstract class, and interface.
- `com.hospitalpharmacy.service` — pharmacy and billing services.

The application entry point is `com.hospitalpharmacy.Main`.

## 2. How to Compile and Run

From the project root:

```text
javac -d bin $(find src -name "*.java")
java -cp bin com.hospitalpharmacy.Main
```

On Windows Command Prompt, from the project root:

```text
javac -d bin src\com\hospitalpharmacy\model\*.java src\com\hospitalpharmacy\service\*.java src\com\hospitalpharmacy\Main.java
java -cp bin com.hospitalpharmacy.Main
```

The submitted source was successfully compiled using `javac`, and an end-to-end console run was tested. See `sample_output.txt`.

## 3. Main Features

1. View medicines and stock.
2. View registered patients.
3. Register a new patient.
4. Add a medicine to inventory.
5. Dispense medicine after validating patient/medicine/quantity.
6. Generate a medicine bill with tax and senior-citizen discount logic.
7. Demonstrate inheritance, dynamic binding, interface access, string operations, static counters, operator precedence, and type casting.

## 4. Mandatory Feature Traceability

| Requirement | Implementation | File/Class |
|---|---|---|
| 3–4 encapsulated classes | Private fields + public getters/setters | `Person`, `Patient`, `Pharmacist`, `Medicine` |
| Varied data types, final constants, scope | `int`, `double`, `String`, enum; constants and instance/static/local variables | `Medicine`, `PharmacyService`, `Main`, `Prescription` |
| Operators + precedence | Arithmetic operators and `10 + 5 * 2` | `Main` |
| Type conversion/casting | Explicit `(int) bill` | `BillingService` |
| Enum | `MedicineType` | `MedicineType.java`, `Medicine.java` |
| if-else, switch, loops | Menu switch, validation if/else, for/while loops | `Main`, `PharmacyService` |
| break, continue, return | Menu `break`, input validation `continue`, methods using `return` | `Main`, `PharmacyService`, `Medicine` |
| Arrays of objects | `Medicine[]`, `Patient[]`, `Person[]` | `PharmacyService`, `Main` |
| Console I/O + formatted output | `Scanner`, `printf`, `String.format` | `Main`, `Medicine`, `Patient` |
| Constructor overloading | Default and parameterized constructors | `Person`, `Patient`, `Pharmacist`, `Medicine`; `Prescription` parameterized |
| Method overloading | `Prescription.calculateBill()` and `calculateBill(double)` | `Prescription.java` |
| Static fields/methods | Object counters and static getters | `Patient`, `Medicine` |
| `this` reference | Constructor assignments such as `this.name = name` | `Person`, `Patient`, `Medicine`, `Prescription` |
| String methods | `trim`, `split`, `equalsIgnoreCase`, `toLowerCase`, `contains` | `MedicalRecord`, `PharmacyService`, `Main` |
| Base class + 2 subclasses | `Person` → `Patient`, `Pharmacist` | `model` package |
| `super` keyword | Parent constructor and parent method call | `Patient`, `Pharmacist` |
| Overriding + dynamic binding | Overridden `getRoleDescription`; parent `Person` reference holds child objects | `Person`, `Patient`, `Pharmacist`, `Main` |
| Abstract class + abstract method | `Person` and `getRoleDescription()` | `Person.java` |
| Interface + interface reference | `Payable`; `Prescription` implements it; `Payable payable = ...` | `Payable.java`, `Prescription.java`, `Main.java` |
| Object method override | `toString()` and `equals()` | `Patient.java`; `toString()` also in `Medicine.java` |
| Final method/class | `Medicine` is final to prevent subclassing in this application | `Medicine.java` |
| 2 custom packages + imports | `model` and `service` packages | All source files |

## 5. Important OOP Design Notes

- `Person` is abstract because the application should work with specific people such as patients and pharmacists rather than a generic person record.
- `Patient` and `Pharmacist` inherit common contact information from `Person`.
- `Payable` separates billing behavior from the concrete prescription class.
- `Medicine` is final because the project treats medicine records as a fixed domain entity rather than a base class for specialized medicine subclasses.
- Static counters demonstrate class-level state and track how many objects have been created.

## 6. Testing

A test run was performed with these actions:
- View medicine inventory.
- Dispense 2 Paracetamol tablets to patient 201.
- Generate a bill for 3 Paracetamol tablets.
- Open the OOP Feature Demonstration menu.
- Exit the program.

The captured result is stored in `sample_output.txt`.

## 7. Submission Contents

- `src/` — complete Java source code with package folders.
- `bin/` — compiled `.class` files generated during testing.
- `docs/README.md` — project report and traceability mapping.
- `docs/sample_output.txt` — captured console output.
