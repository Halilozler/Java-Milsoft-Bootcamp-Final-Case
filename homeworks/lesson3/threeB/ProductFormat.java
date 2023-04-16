package homework.threeB;

import homework.threeA.Product;

public class ProductFormat {
    public static void main(String[] args) {
        Product product = new Product(123, "Halil", 3456.45);
        System.out.printf("id: %d İsim: %s Satış Fiyatı: %f\n", product.getProductId(), product.getProductName(), product.getSalesPrice());
    }
}
