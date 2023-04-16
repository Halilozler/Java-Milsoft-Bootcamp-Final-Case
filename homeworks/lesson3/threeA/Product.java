package homework.threeA;

public class Product {
    private long productId;
    private String productName;
    private Double salesPrice;

    public Product() {}

    public Product(long productId, String productName, Double salesPrice) {
        this.productId = productId;
        this.productName = productName;
        this.salesPrice = salesPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }
}
