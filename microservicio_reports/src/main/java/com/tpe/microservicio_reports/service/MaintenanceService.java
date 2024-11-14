package com.tpe.microservicio_reports.service;

import com.tpe.microservicio_reports.entity.Maintenance;
import com.tpe.microservicio_reports.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;


    public Maintenance createMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }


    public void deleteMaintenance(int id) {
        maintenanceRepository.deleteById(id);
    }


    public Maintenance updateMaintenance(int id, Maintenance maintenance) {
        Optional<Maintenance> existingMaintenance = maintenanceRepository.findById(id);
        if (existingMaintenance.isPresent()) {
            Maintenance updatedMaintenance = existingMaintenance.get();
            updatedMaintenance.setState(maintenance.getState());
            updatedMaintenance.setDateMaintenance(maintenance.getDateMaintenance());
            updatedMaintenance.setObservation(maintenance.getObservation());
            return maintenanceRepository.save(updatedMaintenance);
        }
        return null;
    }


    public Maintenance getMaintenanceById(int id) {
        return maintenanceRepository.findById(id).orElse(null);
    }


    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }
}
