package com.course.fullstackprojectbackend.repositories;

import com.course.fullstackprojectbackend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
