package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.Payment;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);

    List<Payment> fetchPaymentList();

    Payment updatePayment(Payment payment, Long paymentId);

    void deletePaymentById(Long paymentId);
}
