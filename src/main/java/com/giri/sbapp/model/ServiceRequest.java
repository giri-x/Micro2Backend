package com.giri.sbapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_request")
public class ServiceRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ac_unit_id", nullable = false)
    private ACUnit acUnit;

    @ManyToOne
    @JoinColumn(name = "technician_id", nullable = false)
    private Technician technician;

//    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String
    requestType;

    @Column(nullable = false)
    private String description;

//    @Enumerated(EnumType.STRING)
    @Column
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

	public ServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceRequest(Long id, ACUnit acUnit, Technician technician, String requestType, String description,
			String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.acUnit = acUnit;
		this.technician = technician;
		this.requestType = requestType;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ACUnit getAcUnit() {
		return acUnit;
	}

	public void setAcUnit(ACUnit acUnit) {
		this.acUnit = acUnit;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", acUnit=" + acUnit + ", technician=" + technician + ", requestType="
				+ requestType + ", description=" + description + ", status=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

    // Getters and Setters}
    
    
    



}
