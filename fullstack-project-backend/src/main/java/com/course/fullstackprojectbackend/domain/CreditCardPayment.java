package com.course.fullstackprojectbackend.domain;

import com.course.fullstackprojectbackend.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class CreditCardPayment extends Payment{

    private Integer installments;

    public CreditCardPayment(){
    }

    public CreditCardPayment(Integer id, PaymentStatus status, PurchaseOrder purchaseOrder, Integer installments) {
        super(id, status, purchaseOrder);
        this.installments = installments;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
