package com.tpe.microservicio_travels.controller;

import com.tpe.microservicio_travels.entity.Billing;
import com.tpe.microservicio_travels.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public ResponseEntity<List<Billing>> getAllBillings() {
        List<Billing> billings = billingService.findAll();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long id) {
        Optional<Billing> billing = billingService.findById(id);
        return billing.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody Billing billing) {
        Billing newBilling = billingService.save(billing);
        return new ResponseEntity<>(newBilling, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable Long id, @RequestBody Billing billingDetails) {
        Optional<Billing> billingData = billingService.findById(id);

        if (billingData.isPresent()) {
            Billing billing = billingData.get();
            billing.setAmount(billingDetails.getAmount());
            billing.setAmountDebt(billingDetails.getAmountDebt());
            billing.setState(billingDetails.getState());
            billing.setAccountId(billingDetails.getAccountId());
            billing.setBillingMethod(billingDetails.getBillingMethod());

            return new ResponseEntity<>(billingService.save(billing), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBilling(@PathVariable Long id) {
        try {
            billingService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
