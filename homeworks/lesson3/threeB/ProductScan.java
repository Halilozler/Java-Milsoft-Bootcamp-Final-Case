package homework.threeB;

import homework.threeA.Product;

import java.util.Scanner;

public class ProductScan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id: ");
        long id = scanner.nextLong();
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Sales Price: ");
        Double salesPrice = scanner.nextDouble();

        Product product = new Product(id, name, salesPrice);
    }
}
