package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.dto.BillingResponseDTO;
import com.tpe.microservicio_travels.dto.MonthBillingDTO;
import com.tpe.microservicio_travels.entity.Billing;
import com.tpe.microservicio_travels.repository.BillingRepository;
import com.tpe.microservicio_travels.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private UserUtil userUtil;

    public BillingResponseDTO getBillingByMonthRange(Long userId, int year, int startMonth, int endMonth){
        if (!userUtil.isAdmin(userId))
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
}
