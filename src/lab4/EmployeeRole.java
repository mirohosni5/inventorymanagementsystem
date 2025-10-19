package lab4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class EmployeeRole implements roleinterface {
    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;
    public EmployeeRole() {
        productsDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();
    }
    public void addProduct(String productID,String productName,String manufacturerName,String supplierName,int quantity,float price) {
        if (productsDatabase.contains(productID)) {
            System.out.println("Product with id " + productID + " already exists.");
            return;
        }
        Product p = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productsDatabase.insertRecord(p);
        productsDatabase.saveToFile();
        System.out.println("Product added.");
    }
    public Product[] getListOfProducts(){
        ArrayList<Prod> list = productsDatabase.returnAllRecords();
        return list.toArray(new Product[0]);

    }
    public CustomerProduct[] getListOfPurchasingOperations(){
        ArrayList<CustomerProduct> list = customerProductDatabase.returnAllRecords();
        return list.toArray(new CustomerProduct[0]);

    }
    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate){
        Product p = productsDatabase.getRecord(productID);
        if (p == null) {
            System.out.println("Product not found!");
            return false;
        }
        if (p.getQuantity() == 0) {
            System.out.println("Product out of stock!");
            return false;
        }
        p.setQuantity(p.getQuantity() - 1);
        CustomerProduct c= new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProductDatabase.insertRecord(c);
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
        System.out.println("Purchase recorded successfully.");
        return true;
    }
    public double returnProduct(String customerSSN,String productID,LocalDate purchaseDate ,LocalDate returnDate){
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();
        if (returnDate.isBefore(purchaseDate)) return -1;
        Product p = productsDatabase.getRecord(productID);
        if (p == null) return -1;
        String key = customerSSN + "," + productID + "," + purchaseDate.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if (!customerProductDatabase.contains(key)) return -1;
        long days = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if (days > 14) return -1;
        p.setQuantity(p.getQuantity() + 1);
        customerProductDatabase.deleteRecord(key);
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
        return p.getPrice();
    }
    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        customerProductDatabase.readFromFile();
        boolean changed = false;
        for (CustomerProduct c : new ArrayList<>(customerProductDatabase.returnAllRecords())) {
            if (c.getCustomerSSN().equals(customerSSN) && c.getPurchaseDate().equals(purchaseDate)) {
                if (!c.isPaid()) {
                    c.setPaid(true);
                    changed = true;
                }
            }
        }
        if (changed) customerProductDatabase.saveToFile();
        return changed;
    }
    public void logout() {
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}
