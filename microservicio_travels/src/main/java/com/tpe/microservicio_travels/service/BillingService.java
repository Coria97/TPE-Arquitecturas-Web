package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.entity.Billing;
import com.tpe.microservicio_travels.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public List<Billing> findAll() {
        return billingRepository.findAll();
    }

    public Optional<Billing> findById(Long id) {
        return billingRepository.findById(id);
    }

    public Billing save(Billing billing) {
        return billingRepository.save(billing);
    }

    public void deleteById(Long id) {
        billingRepository.deleteById(id);
    }
}
