package com.tpe.microservicio_stops.controller;
import com.tpe.microservicio_stops.dto.ScooterStatesDTO;
import com.tpe.microservicio_stops.dto.ScooterStatsUpdateDTO;
import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.entity.Scooter;
import com.tpe.microservicio_stops.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/scooters")
public class ScooterController {

    @Autowired
    private ScooterService scooterService;

    @GetMapping("/usage")
    public ResponseEntity<List<ScooterUsageDTO>> getScootersUsage(){
        return ResponseEntity.status(HttpStatus.OK).body(scooterService.getScootersUsage());
    }

    @GetMapping("/admin/state")
    public ResponseEntity<?> getScootersStates(@RequestParam Long userId){
        List<ScooterStatesDTO> response = scooterService.getScooterStates(userId);
        if (response == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No tiene los permisos necesarios");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping
    public ResponseEntity<Scooter> createScooter(@RequestBody Scooter scooter) {
        Scooter createdScooter = scooterService.createScooter(scooter);
        return new ResponseEntity<>(createdScooter, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScooter(@PathVariable Long id) {
        scooterService.deleteScooter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Scooter> updateScooter(@PathVariable Long id, @RequestBody Scooter scooter) {
        Scooter updatedScooter = scooterService.updateScooter(id, scooter);
        if (updatedScooter != null) {
            return new ResponseEntity<>(updatedScooter, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Scooter> getScooterById(@PathVariable Long id) {
        Scooter scooter = scooterService.getScooterById(id);
        if (scooter != null) {
            return new ResponseEntity<>(scooter, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Scooter>> getAllScooters() {
        List<Scooter> scooters = scooterService.getAllScooters();
        return new ResponseEntity<>(scooters, HttpStatus.OK);
    }

    @PutMapping("/{id}/stats")
    public ResponseEntity<Scooter> updateStatsScooter(@PathVariable Long id, @RequestBody ScooterStatsUpdateDTO scooterStatsUpdateDTO) {
        Scooter updatedScooter = scooterService.updateStatsScooter(id, scooterStatsUpdateDTO);

        return ResponseEntity.ok(updatedScooter);
    }


}
