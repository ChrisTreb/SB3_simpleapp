package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.Payment;
import com.ctrl.simpleapp.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/save-payment")
    public Payment savePayment(@Valid @RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("/payment")
    public List<Payment> fetchPaymentList() {
        return paymentService.fetchPaymentList();
    }

    @PutMapping("/put-payment/{id}")
    public Payment updatePayment(@RequestBody Payment payment, @PathVariable("id") Long paymentId) {
        return paymentService.updatePayment(payment, paymentId);
    }

    @DeleteMapping("/delete-payment/{id}")
    public String deletePaymentById(@PathVariable("id") Long paymentId) {
        paymentService.deletePaymentById(paymentId);
        return "Payment deleted successfully - id : " + paymentId;
    }

}
