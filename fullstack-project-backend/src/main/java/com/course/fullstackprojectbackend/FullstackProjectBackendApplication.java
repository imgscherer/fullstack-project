package com.course.fullstackprojectbackend;

import com.course.fullstackprojectbackend.domain.*;
import com.course.fullstackprojectbackend.enums.ClientType;
import com.course.fullstackprojectbackend.enums.PaymentStatus;
import com.course.fullstackprojectbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

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

        Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PESSOAFISICA);
        cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

        Address adr1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cit1);
        Address adr2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cit2);

        cli1.getAddresses().addAll(Arrays.asList(adr1, adr2));

        clientRepository.saveAll(Arrays.asList(cli1));
        addressRepository.saveAll(Arrays.asList(adr1, adr2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        PurchaseOrder ord1 = new PurchaseOrder(null, sdf.parse("30/09/2017 10:32"), cli1, adr1);
        PurchaseOrder ord2 = new PurchaseOrder(null, sdf.parse("10/10/2017 19:35"), cli1, adr2);

        Payment pay1 = new CreditCardPayment(null, PaymentStatus.QUITADO, ord1, 6);
        ord1.setPayment(pay1);

        Payment pay2 = new SlipPayment(null, PaymentStatus.PENDENTE, ord2, sdf.parse("20/10/2017 00:00"), null);
        ord2.setPayment(pay2);

        cli1.getOrders().addAll(Arrays.asList(ord1, ord2));

        purchaseOrderRepository.saveAll(Arrays.asList(ord1, ord2));
        paymentRepository.saveAll(Arrays.asList(pay1, pay2));

    }
}
