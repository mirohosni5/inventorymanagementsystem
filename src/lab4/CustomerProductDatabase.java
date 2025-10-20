package lab4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProductDatabase extends databases {
    public CustomerProductDatabase(String filename) {
        super(filename);
    }

    @Override
    public recordInterfaces createRecord(String line) {
        String[] parts = line.split(",");
        if (parts.length < 4) return null;

        String customerSSN = parts[0];
        String productID = parts[1];
        DateTimeFormatter F = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate purchaseDate = LocalDate.parse(parts[2], F);
        boolean paid = Boolean.parseBoolean(parts[3]);

        CustomerProduct c = new CustomerProduct(customerSSN, productID, purchaseDate);
        c.setPaid(paid);
        return c;

    }

}
