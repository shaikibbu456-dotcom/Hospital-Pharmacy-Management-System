package com.hospitalpharmacy.model;

// Final because medicine records should not be subclassed in this application.
public final class Medicine {
    private int medicineId;
    private String name;
    private MedicineType type;
    private double price;
    private int stock;
    private static int medicineCount = 0;

    public Medicine() {
        this(0, "Unknown", MedicineType.TABLET, 0.0, 0);
    }

    public Medicine(int medicineId, String name, MedicineType type, double price, int stock) {
        this.medicineId = medicineId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
        medicineCount++;
    }

    public int getMedicineId() { return medicineId; }
    public void setMedicineId(int medicineId) { this.medicineId = medicineId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public MedicineType getType() { return type; }
    public void setType(MedicineType type) { this.type = type; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public static int getMedicineCount() { return medicineCount; }

    public boolean reduceStock(int quantity) {
        if (quantity <= 0 || quantity > stock) return false;
        stock -= quantity;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-18s %-10s %8.2f %5d", medicineId, name, type, price, stock);
    }
}
