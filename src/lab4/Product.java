
package lab4;

public class Product implements recordInterfaces {
private String productID,productName,manufacturerName,supplierName;
private int quantity;
private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

   
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String lineRepresentation(){
    return String.join(",",productID,productName,manufacturerName,supplierName,Integer.toString(quantity),Float.toString(price));
    }
    @Override
    public String getSearchKey() {
     return productID; }
     
    //try
    public tryal{return 0;}
}
