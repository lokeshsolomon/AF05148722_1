package service;

import dao.MedicineDAO;

public class MedicalService {

    MedicineDAO dao = new MedicineDAO();

    public void addMedicine(String name, double price, int qty) {
        dao.addMedicine(name, price, qty);
    }

    public void viewMedicines() {
        dao.viewMedicines();
    }

    public void sellMedicine(int id, int qty) {
        dao.sellMedicine(id, qty);
    }

    public void deleteMedicine(int id) {
        dao.deleteMedicine(id);
    }
}