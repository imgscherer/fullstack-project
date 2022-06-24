package com.course.fullstackprojectbackend.domain;

import com.course.fullstackprojectbackend.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class SlipPayment extends Payment {

    private Date dueDate;
    private Date paymentDate;

    public SlipPayment(){
    }


    public SlipPayment(Integer id, PaymentStatus status, PurchaseOrder purchaseOrder, Date dueDate, Date paymentDate) {
        super(id, status, purchaseOrder);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }


}
