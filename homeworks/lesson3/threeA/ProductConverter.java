package homework.threeA;

public class ProductConverter {
    public String format(Product product){
        return new StringBuilder("id: ").append(product.getProductId()).append(" name: ").append(product.getProductName()).append(" salesPrice: ").append(product.getSalesPrice()).toString();
    }

    public Product parse(String line){
        String[] newLine = line.split(" ");
        return new Product(Long.parseLong(newLine[1]), newLine[3], Double.parseDouble(newLine[5]));
    }
}
