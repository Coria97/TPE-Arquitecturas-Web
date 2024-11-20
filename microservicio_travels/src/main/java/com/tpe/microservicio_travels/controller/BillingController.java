package com.tpe.microservicio_travels.controller;

import com.tpe.microservicio_travels.dto.BillingResponseDTO;
import com.tpe.microservicio_travels.dto.MonthBillingDTO;
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

    @GetMapping("/admin/bills")
    public ResponseEntity<?> getBillingByMonthRange(@RequestParam Long userId, @RequestParam int year, @RequestParam int startMonth, @RequestParam int endMonth) {
        // To do: cuando implementemos el tokenJWT la verificacion de admin cambiara
        BillingResponseDTO billingResume = billingService.getBillingByMonthRange(userId, year, startMonth, endMonth);
        if (billingResume == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No tiene los permisos necesarios");
        return new ResponseEntity<>(billingResume, HttpStatus.OK);
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
}
