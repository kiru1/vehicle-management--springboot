package com.vehicle.service;

import com.vehicle.model.Vehicle;
import com.vehicle.repository.VehicleRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    @Transactional
    public Vehicle createVehicle(Vehicle vehicle) {
    	
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Optional<Vehicle> existing = vehicleRepository.findById(id);
        Vehicle vehicle=existing.get();
        vehicle.setRegistrationNumber(vehicleDetails.getRegistrationNumber());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setManufacturer(vehicleDetails.getManufacturer());
        vehicle.setYearOfManufacture(vehicleDetails.getYearOfManufacture());
        vehicle.setColor(vehicleDetails.getColor());
        vehicle.setOwnerDetails(vehicleDetails.getOwnerDetails());
        vehicle.setUpdatedBy(vehicleDetails.getUpdatedBy());
        vehicle.setUpdatedAt(OffsetDateTime.now());


        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
