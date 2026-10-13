# Java OOP Practical Mini Project

**Student:** Shaik Ibrahim\
**SRN:** R24SA038\
**Program:** B.Sc. (BSTCs), Semester V\
**Subject:** Java Programming\
**Project:** Hospital Pharmacy Management System

## 1. Project Overview

This is a console-based Hospital Pharmacy Management System developed in
Java. It supports medicine inventory, patient registration, medicine
dispensing, bill calculation, and an OOP demonstration menu.

The implementation is organized into two custom packages: -
`com.hospitalpharmacy.model` --- domain classes, enum, abstract class,
and interface. - `com.hospitalpharmacy.service` --- pharmacy and billing
services.

The application entry point is `com.hospitalpharmacy.Main`.

## 2. How to Compile and Run

From the project root, open Windows Command Prompt and run:

``` cmd
javac -d bin src\\com\\hospitalpharmacy\\model\\*.java src\\com\\hospitalpharmacy\\service\\*.java src\\com\\hospitalpharmacy\\Main.java
java -cp bin com.hospitalpharmacy.Main
```

The submitted source was successfully compiled using `javac`, and an
end-to-end console run was tested. See `docs/sample_output.txt`.

## 3. Main Features

1.  View medicines and stock.
2.  View registered patients.
3.  Register a new patient.
4.  Add a medicine to inventory.
5.  Dispense medicine after validating patient/medicine/quantity.
6.  Generate a medicine bill with tax and senior-citizen discount logic.
7.  Demonstrate inheritance, dynamic binding, interface access, string
    operations, static counters, operator precedence, and type casting.

## 4. Mandatory Feature Traceability

  --------------------------------------------------------------------------------
  Requirement             Implementation                   File/Class
  ----------------------- -------------------------------- -----------------------
  3--4 encapsulated       Private fields + public          `Person`, `Patient`,
  classes                 getters/setters                  `Pharmacist`,
                                                           `Medicine`

  Varied data types,      `int`, `double`, `String`, enum; `Medicine`,
  final constants, scope  constants and                    `PharmacyService`,
                          instance/static/local variables  `Main`, `Prescription`

  Operators + precedence  Arithmetic operators and         `Main`
                          `10 + 5 * 2`                     

  Type conversion/casting Explicit `(int) bill`            `BillingService`

  Enum                    `MedicineType`                   `MedicineType.java`,
                                                           `Medicine.java`

  if-else, switch, loops  Menu switch, validation if/else, `Main`,
                          for/while loops                  `PharmacyService`

  break, continue, return Menu `break`, input validation   `Main`,
                          `continue`, methods using        `PharmacyService`,
                          `return`                         `Medicine`

  Arrays of objects       `Medicine[]`, `Patient[]`,       `PharmacyService`,
                          `Person[]`                       `Main`

  Console I/O + formatted `Scanner`, `printf`,             `Main`, `Medicine`,
  output                  `String.format`                  `Patient`

  Constructor overloading Default and parameterized        `Person`, `Patient`,
                          constructors                     `Pharmacist`,
                                                           `Medicine`;
                                                           `Prescription`
                                                           parameterized

  Method overloading      `Prescription.calculateBill()`   `Prescription.java`
                          and `calculateBill(double)`      

  Static fields/methods   Object counters and static       `Patient`, `Medicine`
                          getters                          

  `this` reference        Constructor assignments such as  `Person`, `Patient`,
                          `this.name = name`               `Medicine`,
                                                           `Prescription`

  String methods          `trim`, `split`,                 `MedicalRecord`,
                          `equalsIgnoreCase`,              `PharmacyService`,
                          `toLowerCase`, `contains`        `Main`

  Base class + 2          `Person` → `Patient`,            `model` package
  subclasses              `Pharmacist`                     

  `super` keyword         Parent constructor and parent    `Patient`, `Pharmacist`
                          method call                      

  Overriding + dynamic    Overridden `getRoleDescription`; `Person`, `Patient`,
  binding                 parent `Person` reference holds  `Pharmacist`, `Main`
                          child objects                    

  Abstract class +        `Person` and                     `Person.java`
  abstract method         `getRoleDescription()`           

  Interface + interface   `Payable`; `Prescription`        `Payable.java`,
  reference               implements it;                   `Prescription.java`,
                          `Payable payable = ...`          `Main.java`

  Object method override  `toString()` and `equals()`      `Patient.java`;
                                                           `toString()` also in
                                                           `Medicine.java`

  Final method/class      `Medicine` is final to prevent   `Medicine.java`
                          subclassing in this application  

  2 custom packages +     `model` and `service` packages   All source files
  imports                                                  
  --------------------------------------------------------------------------------

## 5. Important OOP Design Notes

-   `Person` is abstract because the application should work with
    specific people such as patients and pharmacists rather than a
    generic person record.
-   `Patient` and `Pharmacist` inherit common contact information from
    `Person`.
-   `Payable` separates billing behavior from the concrete prescription
    class.
-   `Medicine` is final because the project treats medicine records as a
    fixed domain entity rather than a base class for specialized
    medicine subclasses.
-   Static counters demonstrate class-level state and track how many
    objects have been created.

## 6. Testing

A test run was performed with these actions: - View medicine
inventory. - Dispense 2 Paracetamol tablets to patient 201. - Generate a
bill for 3 Paracetamol tablets. - Open the OOP Feature Demonstration
menu. - Exit the program.

The captured result is stored in `docs/sample_output.txt`.

## 7. Submission Contents

-   `src/` --- complete Java source code with package folders.
-   `bin/` --- compiled `.class` files generated during testing.
-   `docs/README.md` --- project report and traceability mapping.
-   `docs/sample_output.txt` --- captured console output.

## 8. Project Screenshots

### Main Menu

![Hospital Pharmacy Management System Main
Menu](screenshots/Screenshot%202026-10-13%20135644.png)

### Medicine Inventory

![Medicine Inventory
Display](screenshots/Screenshot%202026-10-13%20135703.png)
### Patient Registration

![Patient Registration](screenshots/Screenshot%202026-10-13%20143401.png)

### Medicine Dispensing

![Medicine Dispensing](screenshots/Screenshot%202026-10-13%20143438.png)

### Medicine Billing

![Medicine Billing](screenshots/Screenshot%202026-10-13%20143615.png)

### OOP Feature Demonstration

![OOP Feature Demonstration](screenshots/Screenshot%202026-10-13%20143640.png)

### Pharmacy System Output

![Pharmacy System Output](screenshots/Screenshot%202026-10-13%20143704.png)

### Additional Project Screenshot

![Additional Project Screenshot](screenshots/Screenshot%202026-10-13%20143721.png)
