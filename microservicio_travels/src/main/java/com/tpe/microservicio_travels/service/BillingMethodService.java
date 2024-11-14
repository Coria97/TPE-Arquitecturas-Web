package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.entity.BillingMethod;
import com.tpe.microservicio_travels.repository.BillingMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingMethodService {

    private final BillingMethodRepository billingMethodRepository;

    @Autowired
    public BillingMethodService(BillingMethodRepository billingMethodRepository) {
        this.billingMethodRepository = billingMethodRepository;
    }

    public List<BillingMethod> findAll() {
        return billingMethodRepository.findAll();
    }

    public Optional<BillingMethod> findById(Long id) {
        return billingMethodRepository.findById(id);
    }

    public BillingMethod save(BillingMethod billingMethod) {
        return billingMethodRepository.save(billingMethod);
    }

    public void deleteById(Long id) {
        billingMethodRepository.deleteById(id);
    }
}
