package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.records.Payment;
import com.ctrl.simpleapp.rest.api.repository.PaymentRepository;
import com.ctrl.simpleapp.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> fetchPaymentList() {
        return (List<Payment>) paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment, Long paymentId) {

        if (paymentRepository.findById(paymentId).isPresent()) {
            Payment paymentDB = paymentRepository.findById(paymentId).get();
            return paymentRepository.save(paymentDB);
        } else {
            LOGGER.error("Payment not found in our database - id : {}", payment.id());
            return null;
        }
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        paymentRepository.findById(paymentId);
        LOGGER.info("Payment deleted - id : {}", paymentId);
    }
}
