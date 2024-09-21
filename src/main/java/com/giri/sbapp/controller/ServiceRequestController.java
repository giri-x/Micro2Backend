package com.giri.sbapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.sbapp.model.ServiceRequest;
import com.giri.sbapp.model.Technician;
import com.giri.sbapp.service.EmailService;
import com.giri.sbapp.service.ServiceRequestService;
import com.giri.sbapp.service.TechnicianService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/service-requests")
@CrossOrigin("*")
public class ServiceRequestController {
	
	    @Autowired
	    private ServiceRequestService serviceRequestService;
	    
	    @Autowired
	    private TechnicianService technicianService;
	    
	    @Autowired
	    private EmailService emailService; 

//	    @PostMapping("/request")
//	    public ResponseEntity<ServiceRequest> requestService(@RequestBody ServiceRequest serviceRequest) {
//	        ServiceRequest createdRequest = serviceRequestService.createServiceRequest(serviceRequest);
//	        return ResponseEntity.ok(createdRequest);
//	    }
//	    
	    
	    @PostMapping("/request")
	    public ResponseEntity<ServiceRequest> requestService(@RequestBody ServiceRequest serviceRequest) {
	        try {
	            // Create the service request
	            ServiceRequest createdRequest = serviceRequestService.createServiceRequest(serviceRequest);

	            // Fetch technician's email
//	            Optional <Technician> technicianOpt = technicianService.getTechnician(serviceRequest.getTechnician().getId());
//	            if (technicianOpt.isPresent()) {
//	                Technician technician = technicianOpt.get();
//	                String technicianEmail = technician.getEmail();
	            Integer technicianId = serviceRequest.getTechnician().getId();
	            Technician technician = technicianService.getTechnician(technicianId);
	            if (technician != null) {
	                String technicianEmail = technician.getEmail();
	                
	                if (technicianEmail != null) {
	                  
	                    sendServiceRequestEmail(technicianEmail, createdRequest);
	                }
	            }

	            return ResponseEntity.ok(createdRequest);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    private void sendServiceRequestEmail(String technicianEmail, ServiceRequest serviceRequest) {
	        String subject = "New Service Request";
	        String body = "Dear Technician,\n\n" +
	                "A new service request has been made with the following details:\n\n" +
	                "AC Unit ID: " + serviceRequest.getAcUnit().getId() + "\n" +
	                "Request Type: " + serviceRequest.getRequestType() + "\n" +
	                "Description: " + serviceRequest.getDescription() + "\n\n" +
	                "Please review and take necessary actions.\n\n" +
	                "Best regards,\n" +
	                "The Service Team";

	        emailService.sendSimpleMessage(technicianEmail, subject, body);
	    }

//	    @PutMapping("/approve/{id}")
//	    public ResponseEntity<ServiceRequest> approveServiceRequest(@PathVariable Long id) {
//	        ServiceRequest approvedRequest = serviceRequestService.approveServiceRequest(id);
//	        return ResponseEntity.ok(approvedRequest);
//	    }

	    @GetMapping("/ac-unit/{acUnitId}")
	    public ResponseEntity<List<ServiceRequest>> getRequestsByAcUnitId(@PathVariable Long acUnitId) {
	        List<ServiceRequest> requests = serviceRequestService.getRequestsByAcUnitId(acUnitId);
	        return ResponseEntity.ok(requests);
	    }
	    
	    
	    @PutMapping("/approve/{id}")
	    public ResponseEntity<ServiceRequest> approveServiceRequest(@PathVariable Long id) {
	        try {
	            // Approve the service request
	            ServiceRequest serviceRequest = serviceRequestService.approveServiceRequest(id);

	            // Fetch the technician's email
	            Integer technicianId = serviceRequest.getTechnician().getId();
	            Technician technician = technicianService.getTechnician(technicianId);
	            if (technician != null) {
	                String technicianEmail = technician.getEmail();

	                if (technicianEmail != null) {
	                    // Send an email to the technician
	                    String subject = "Service Request Approved";
	                    String body = "Dear " + technician.getName() + ",\n\n" +
	                            "Your service request with ID " + id + " has been assigned to GS AC Agency.\n\n" +
	                            "Please review the request and take necessary actions.\n\n" +
	                            "Best regards,\n" +
	                            "The Service Team";
	                    emailService.sendSimpleMessage(technicianEmail, subject, body);
	                }
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }

	            return new ResponseEntity<>(serviceRequest, HttpStatus.OK);
	        } catch (EntityNotFoundException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } catch (IllegalStateException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    
	    @GetMapping("/")
	    public ResponseEntity <List<ServiceRequest>> getAllServiceRequests() {
	        List<ServiceRequest> requests = serviceRequestService.getAllServiceRequests();
	        return ResponseEntity.ok(requests);
	    }
	    
	    @GetMapping("/ac-unit/{acUnitId}/request/{requestId}")
	    public ResponseEntity<ServiceRequest> getRequestByAcUnitIdAndRequestId(
	            @PathVariable Long acUnitId,
	            @PathVariable Long requestId) {
	        ServiceRequest request = serviceRequestService.getRequestByAcUnitIdAndRequestId(acUnitId, requestId);
	        if (request != null) {
	            return ResponseEntity.ok(request);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}



