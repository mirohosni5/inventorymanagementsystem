package lab4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminRole admin = new AdminRole();
        EmployeeRole empRole = new EmployeeRole();

        while (true) {
            System.out.println("\n=== Inventory Management ===");
            System.out.println("1. Admin menu");
            System.out.println("2. Employee menu");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();
            if (choice.equals("0")) break;

            if (choice.equals("1")) adminMenu(sc, admin);
            else if (choice.equals("2")) employeeMenu(sc, empRole);
            else System.out.println("Invalid choice!");
        }

        admin.logout();
        empRole.logout();
        System.out.println("Goodbye!");
    }

    private static void adminMenu(Scanner sc, AdminRole admin) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add employee");
            System.out.println("2. List employees");
            System.out.println("3. Remove employee");
            System.out.println("4. Back to main menu");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();

            if (c.equals("4")) break;

            switch (c) {
                case "1":
                    System.out.print("Employee ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Email: ");
                    String email = sc.nextLine().trim();
                    System.out.print("Address: ");
                    String address = sc.nextLine().trim();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine().trim();
                    admin.addEmployee(id, name, email, address, phone);
                    break;

                case "2":
                    EmployeeUser[] list = admin.getListOfEmployees();
                    if (list.length == 0)
                        System.out.println("No employees found.");
                    else {
                        System.out.println("\n--- Employee List ---");
                        for (EmployeeUser e : list) {
                            System.out.println(
                                    "ID: " + e.getEmployeeId() +
                                            ", Name: " + e.getName() +
                                            ", Email: " + e.getEmail() +
                                            ", Address: " + e.getAddress() +
                                            ", Phone: " + e.getPhoneNumber()
                            );
                        }
                    }
                    break;

                case "3":
                    System.out.print("Employee ID to remove: ");
                    String removeId = sc.nextLine().trim();
                    admin.removeEmployee(removeId);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void employeeMenu(Scanner sc, EmployeeRole emp) {
        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add product");
            System.out.println("2. List products");
            System.out.println("3. Purchase product");
            System.out.println("4. Return product");
            System.out.println("5. Apply payment");
            System.out.println("6. List purchases");
            System.out.println("7. Back to main menu");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();

            if (c.equals("7")) break;

            try {
                switch (c) {
                    case "1":
                        System.out.print("Product ID: ");
                        String pid = sc.nextLine().trim();
                        System.out.print("Product name: ");
                        String pname = sc.nextLine().trim();
                        System.out.print("Manufacturer: ");
                        String mname = sc.nextLine().trim();
                        System.out.print("Supplier: ");
                        String sname = sc.nextLine().trim();
                        System.out.print("Quantity: ");
                        int qty = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Price: ");
                        float price = Float.parseFloat(sc.nextLine().trim());
                        emp.addProduct(pid, pname, mname, sname, qty, price);
                        break;

                    case "2":
                        Product[] products = emp.getListOfProducts();
                        if (products.length == 0)
                            System.out.println("No products available.");
                        else {
                            System.out.println("\n--- Product List ---");
                            for (Product p : products) {
                                System.out.println(
                                        "ID: " + p.getProductID() +
                                                ", Name: " + p.getProductName() +
                                                ", Manufacturer: " + p.getManufacturerName() +
                                                ", Supplier: " + p.getSupplierName() +
                                                ", Quantity: " + p.getQuantity() +
                                                ", Price: " + p.getPrice()
                                );
                            }
                        }
                        break;

                    case "3":
                        System.out.print("Customer SSN: ");
                        String ssn = sc.nextLine().trim();
                        System.out.print("Product ID: ");
                        String productId = sc.nextLine().trim();
                        System.out.print("Purchase date (dd-MM-yyyy): ");
                        LocalDate pd = LocalDate.parse(sc.nextLine().trim(), DF);
                        boolean ok = emp.purchaseProduct(ssn, productId, pd);
                        System.out.println(ok ? "Purchase recorded." : "Purchase failed!");
                        break;

                    case "4":
                        System.out.print("Customer SSN: ");
                        String rssn = sc.nextLine().trim();
                        System.out.print("Product ID: ");
                        String rid = sc.nextLine().trim();
                        System.out.print("Purchase date (dd-MM-yyyy): ");
                        LocalDate purDate = LocalDate.parse(sc.nextLine().trim(), DF);
                        System.out.print("Return date (dd-MM-yyyy): ");
                        LocalDate retDate = LocalDate.parse(sc.nextLine().trim(), DF);
                        double refund = emp.returnProduct(rssn, rid, purDate, retDate);
                        if (refund < 0)
                            System.out.println("Return rejected!");
                        else
                            System.out.println("Return accepted. Refund amount: " + refund);
                        break;

                    case "5":
                        System.out.print("Customer SSN: ");
                        String paySsn = sc.nextLine().trim();
                        System.out.print("Purchase date (dd-MM-yyyy): ");
                        LocalDate payDate = LocalDate.parse(sc.nextLine().trim(), DF);
                        boolean paid = emp.applyPayment(paySsn, payDate);
                        System.out.println(paid ? "Payment applied." : "No unpaid purchase found.");
                        break;

                    case "6":
                        CustomerProduct[] purchases = emp.getListOfPurchasingOperations();
                        if (purchases.length == 0)
                            System.out.println("No purchases found.");
                        else {
                            System.out.println("\n--- Purchase List ---");
                            for (CustomerProduct cp : purchases) {
                                System.out.println(
                                        "Customer SSN: " + cp.getCustomerSSN() +
                                                ", Product ID: " + cp.getProductID() +
                                                ", Purchase Date: " + cp.getPurchaseDate() +
                                                ", Returned: " + (cp.getPurchaseDate() != null ? "Yes" : "No")
                                );
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}