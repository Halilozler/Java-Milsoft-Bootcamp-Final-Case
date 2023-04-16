package homework;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Product product = new Product(345, "Halil3", 999);
        try{
            PostgreConnect connect = new PostgreConnect();
            ProductManager manager = new ProductManager(connect.getConnection());
            //manager.insert(product);
            Product updateProduct = manager.find(4);
            updateProduct.setProductName("halillllllll2423");
            manager.update(updateProduct);
            updateProduct = manager.find(4);
            System.out.println(updateProduct.getProductName());
            //List<Product> productList = manager.findAll();
            manager.delete(4);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
