package com.course.fullstackprojectbackend;

import com.course.fullstackprojectbackend.domain.Category;
import com.course.fullstackprojectbackend.domain.Product;
import com.course.fullstackprojectbackend.repositories.CategoryRepository;
import com.course.fullstackprojectbackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class FullstackProjectBackendApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(FullstackProjectBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Informática");
        Category cat2 = new Category(null, "Escritório");

        Product prod1 = new Product(null, "Computador", 2000.00);
        Product prod2 = new Product(null, "Impressora", 800.00);
        Product prod3 = new Product(null, "Mouse", 80.00);

        cat1.getProducts().addAll(Arrays.asList(prod1,prod2,prod3));
        cat2.getProducts().addAll(Arrays.asList(prod2));

        prod1.getCategories().addAll(Arrays.asList(cat1));
        prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
        prod3.getCategories().addAll(Arrays.asList(cat1));


        categoryRepository.saveAll(Arrays.asList(cat1,cat2));
        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3));

    }
}
