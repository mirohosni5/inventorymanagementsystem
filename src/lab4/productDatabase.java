package lab4;

import java.util.ArrayList;

public class productDatabase extends databases {
    public productDatabase(String filename){
        super(filename);
    }

    @Override 
    public recordInterfaces createRecord(String line) {
        String[] parts = line.split(",");
        if (parts.length < 6) return null;

        String productID = parts[0];
        String productName = parts[1];
        String manufacturerName = parts[2];
        String supplierName = parts[3];
        int quantity = Integer.parseInt(parts[4]);
        float price = Float.parseFloat(parts[5]);

        return new Product(productID, productName, manufacturerName, supplierName, quantity, price);
    }






}
