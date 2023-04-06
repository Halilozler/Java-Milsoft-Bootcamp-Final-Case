package com.example.backendrest;

import com.example.backendrest.data.entity.Category;
import com.example.backendrest.data.entity.Product;
import com.example.backendrest.data.repository.CategoryRepository;
import com.example.backendrest.data.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendRestApplication.class, args);
    }

    //CQRS
    @Configuration
    public class CorsConfiguration {
        @Bean
        WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping( "/**" );
                }
            };
        }
    }

    //Initial Data
    @Bean
    public CommandLineRunner initData(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return (args) -> {
            Category category1 = new Category("Elektronik");
            Category category2 = new Category("Ev, Yaşam, Kırtasiye, Ofis");
            Category category3 = new Category("Moda");
            if (categoryRepository.count() == 0) {
                categoryRepository.save(category1);
                categoryRepository.save(category2);
                categoryRepository.save(category3);
            }
            if(productRepository.count() == 0){

                productRepository.save(new Product("Dizüstü Bilgisayar", 14999.99, category1));
                productRepository.save(new Product("Masaüstü Bilgisayar", 21999.99, category1));
                productRepository.save(new Product("Usb Bellek", 199.99, category1));
                productRepository.save(new Product("Mobilya", 4999.99, category2));
                productRepository.save(new Product("Kalem", 19.99, category2));
                productRepository.save(new Product("Halı", 279.99, category2));
                productRepository.save(new Product("Elbise", 699.99, category3));
                productRepository.save(new Product("Pantolon", 399.99, category3));
                productRepository.save(new Product("Gömlek", 499.99, category3));
            }
        };
    }
}
