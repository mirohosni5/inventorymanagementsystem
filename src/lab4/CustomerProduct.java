package lab4;
// CustomerProduct.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct implements Record {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false;
    }

    public String getCustomerSSN() { return customerSSN; }
    public String getProductID() { return productID; }
    public LocalDate getPurchaseDate() { return purchaseDate; }

    @Override
    public String lineRepresentation() {
        return String.join(",", customerSSN, productID, purchaseDate.format(F), Boolean.toString(paid));
    }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }

    @Override
    public String getSearchKey() {
        return customerSSN + "," + productID + "," + purchaseDate.format(F);
    }

    public static CustomerProduct createFromLine(String line) {
        String[] parts = line.split(",", -1);
        String ssn = parts.length>0? parts[0].trim() : "";
        String pid = parts.length>1? parts[1].trim() : "";
        LocalDate d = LocalDate.now();
        try { if (parts.length>2) d = LocalDate.parse(parts[2].trim(), F); } catch (Exception e) {}
        CustomerProduct cp = new CustomerProduct(ssn, pid, d);
        if (parts.length>3) cp.setPaid(Boolean.parseBoolean(parts[3].trim()));
        return cp;
    }
}
