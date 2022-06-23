package com.course.fullstackprojectbackend;

import com.course.fullstackprojectbackend.domain.Category;
import com.course.fullstackprojectbackend.domain.City;
import com.course.fullstackprojectbackend.domain.Product;
import com.course.fullstackprojectbackend.domain.State;
import com.course.fullstackprojectbackend.repositories.CategoryRepository;
import com.course.fullstackprojectbackend.repositories.CityRepository;
import com.course.fullstackprojectbackend.repositories.ProductRepository;
import com.course.fullstackprojectbackend.repositories.StateRepository;
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

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;
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

        State sta1 = new State(null, "Minas Gerais");
        State sta2 = new State(null, "São Paulo");

        City cit1 = new City(null, "Uberlândia", sta1);
        City cit2 = new City(null, "São Paulo", sta2);
        City cit3 = new City(null, "Campinas", sta2);

        sta1.getCities().addAll(Arrays.asList(cit1));
        sta2.getCities().addAll(Arrays.asList(cit2, cit3));

        stateRepository.saveAll(Arrays.asList(sta1, sta2));
        cityRepository.saveAll(Arrays.asList(cit1, cit2, cit3));

    }
}
