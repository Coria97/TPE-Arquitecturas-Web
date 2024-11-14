package com.tpe.microservicio_travels.controller;

import com.tpe.microservicio_travels.entity.BillingMethod;
import com.tpe.microservicio_travels.service.BillingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billing-methods")
public class BillingMethodController {

    private final BillingMethodService billingMethodService;

    @Autowired
    public BillingMethodController(BillingMethodService billingMethodService) {
        this.billingMethodService = billingMethodService;
    }

    @GetMapping
    public ResponseEntity<List<BillingMethod>> getAllBillingMethods() {
        List<BillingMethod> billingMethods = billingMethodService.findAll();
        return new ResponseEntity<>(billingMethods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingMethod> getBillingMethodById(@PathVariable Long id) {
        Optional<BillingMethod> billingMethod = billingMethodService.findById(id);
        return billingMethod.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BillingMethod> createBillingMethod(@RequestBody BillingMethod billingMethod) {
        BillingMethod newBillingMethod = billingMethodService.save(billingMethod);
        return new ResponseEntity<>(newBillingMethod, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingMethod> updateBillingMethod(@PathVariable Long id, @RequestBody BillingMethod billingMethodDetails) {
        Optional<BillingMethod> billingMethodData = billingMethodService.findById(id);

        if (billingMethodData.isPresent()) {
            BillingMethod billingMethod = billingMethodData.get();
            billingMethod.setPrice(billingMethodDetails.getPrice());
            billingMethod.setType(billingMethodDetails.getType());
            // Nota: Si deseas actualizar la lista de `billings`, agrégalo aquí también.

            return new ResponseEntity<>(billingMethodService.save(billingMethod), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBillingMethod(@PathVariable Long id) {
        try {
            billingMethodService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
