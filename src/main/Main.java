package main;

import service.MedicalService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MedicalService service = new MedicalService();

        while (true) {

            System.out.println("\n=== MEDICAL STORE SYSTEM ===");
            System.out.println("1. View Medicines");
            System.out.println("2. Add Medicine");
            System.out.println("3. Sell Medicine");
            System.out.println("4. Delete Medicine");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.viewMedicines();
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    service.addMedicine(name, price, qty);
                    break;

                case 3:
                    System.out.print("Enter Medicine ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int q = sc.nextInt();

                    service.sellMedicine(id, q);
                    break;

                case 4:
                    System.out.print("Enter Medicine ID: ");
                    int deleteId = sc.nextInt();

                    service.deleteMedicine(deleteId);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}