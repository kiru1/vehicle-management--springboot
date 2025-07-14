package com.vehicle.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vehicle.entity.jsons.Owner;


@Entity
@Table(name = "vehicle_details",schema="dbo")

public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long vehicleId;

	@Column(name = "registration_number", nullable = false, unique = true, length = 20)
	private String registrationNumber;

	@Column(name = "model", nullable = false, length = 50)
	private String model;

	@Column(name = "manufacturer", nullable = false, length = 50)
	private String manufacturer;

	@Column(name = "year_of_manufacture")
	private Integer yearOfManufacture;

	@Column(name = "color", length = 30)
	private String color;
	
	@JdbcTypeCode(SqlTypes.JSON)

	@Column(name = "owner_details", nullable = true, columnDefinition = "jsonb")
	
	private Owner ownerDetails;
	
	@Column(name = "created_by", nullable = false, length = 50)
	private String createdBy;

	@Column(name = "created_at", nullable = false)
	private OffsetDateTime createdAt = OffsetDateTime.now();

	@Column(name = "updated_by", length = 50)
	private String updatedBy;

	@Column(name = "updated_at")
	private OffsetDateTime updatedAt = OffsetDateTime.now();

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(Integer yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Owner getOwnerDetails() {
		return ownerDetails;
	}

	public void setOwnerDetails(Owner ownerDetails) {
		this.ownerDetails = ownerDetails;
	}
	 
		

}
