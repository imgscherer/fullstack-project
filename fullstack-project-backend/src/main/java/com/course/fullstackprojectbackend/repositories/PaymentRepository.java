package com.course.fullstackprojectbackend.repositories;


import com.course.fullstackprojectbackend.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
