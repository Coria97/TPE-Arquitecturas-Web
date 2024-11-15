package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.dto.BillingResponseDTO;
import com.tpe.microservicio_travels.dto.MonthBillingDTO;
import com.tpe.microservicio_travels.entity.Billing;
import com.tpe.microservicio_travels.entity.BillingMethod;
import com.tpe.microservicio_travels.feign.UserFeignClient;
import com.tpe.microservicio_travels.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Autowired
    private UserFeignClient userFeignClient;

    public BillingResponseDTO getBillingByMonthRange(Long userId, int year, int startMonth, int endMonth){
        if (!this.isAdmin(userId))
            return null;

        List<MonthBillingDTO> billingList = billingRepository.getBillingByMonthRange(year, startMonth, endMonth);
        double total = billingList.stream()
                .mapToDouble(MonthBillingDTO::getAmount)
                .sum();
        return new BillingResponseDTO(total, billingList);
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

    private boolean isAdmin(Long userId) {
        ResponseEntity<?> response = userFeignClient.getUserRol(userId);

        if (response.getStatusCode() == HttpStatus.OK) {
            String role = (String) response.getBody();
            return "ADMIN".equals(role);
        }
        return false;
    }
}
