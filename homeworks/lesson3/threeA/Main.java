package homework.threeA;

public class Main {
    public static void main(String[] args) {
        /*
        1. Bir veri sınıfı yapın:
            Product productId productName salesPrice
        2. Bununla sicim (string) türü arasında çevirici bir sınıf yapın:
            ProductConverter
                String format(Product product)
                Product parse(String line)

        3. ConverterTest sınıfında bir veri nesnesi oluşturun ve çevirici sınıfla sicime çevirin. Sonra bu sicimden yeniden veri nesnesine dönüştürün.
         */
        Product product = new Product(123, "Halil", 3456.45);
        ProductConverter productConverter = new ProductConverter();
        String line = productConverter.format(product);
        System.out.println(line);
        Product product1 = productConverter.parse(line);
        System.out.println("id: " + product1.getProductId());
        System.out.println("Name: " + product1.getProductName());
        System.out.println("SalesPrice: " + product1.getSalesPrice());
    }
}
