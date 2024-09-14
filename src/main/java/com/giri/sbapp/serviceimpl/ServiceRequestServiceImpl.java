package com.giri.sbapp.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.sbapp.model.ServiceRequest;
import com.giri.sbapp.repo.ServiceRequestRepo;
import com.giri.sbapp.service.ServiceRequestService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {
	
	    @PersistenceContext
	    private EntityManager entityManager;

	    @Autowired
	    private ServiceRequestRepo serviceRequestRepository;

	    @Override
	    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
	        serviceRequest.setCreatedAt(LocalDateTime.now());
	        serviceRequest.setUpdatedAt(LocalDateTime.now());
	        entityManager.persist(serviceRequest);
	        return serviceRequest;
	    }

//	    @Override
//	    public ServiceRequest approveServiceRequest(Long id) {
//	        ServiceRequest serviceRequest = entityManager.find(ServiceRequest.class, id);
//	        if (serviceRequest != null && "pending".equals(serviceRequest.getStatus())) {
//	            serviceRequest.setStatus("approved");
//	            serviceRequest.setUpdatedAt(LocalDateTime.now());
//	            entityManager.merge(serviceRequest);
//	            // Implement email sending logic here
//	        }
//	        return serviceRequest;
//	    }
	    
	    
	    @Override
	    public ServiceRequest approveServiceRequest(Long id) {
	        // Find the existing service request
	        ServiceRequest serviceRequest = entityManager.find(ServiceRequest.class, id);

	        if (serviceRequest == null) {
	            throw new EntityNotFoundException("ServiceRequest not found");
	        }

	        // Check if the request is already approved
	        if ("approved".equals(serviceRequest.getStatus())) {
	            throw new IllegalStateException("ServiceRequest is already approved");
	        }

	        // Update the status to approved
	        serviceRequest.setStatus("approved");
	        serviceRequest.setUpdatedAt(LocalDateTime.now());

	        entityManager.merge(serviceRequest);
	        return serviceRequest;
	    }

	    @Override
	    public List<ServiceRequest> getRequestsByAcUnitId(Long acUnitId) {
	        return entityManager.createQuery("SELECT sr FROM ServiceRequest sr WHERE sr.acUnit.id = :acUnitId", ServiceRequest.class)
	                            .setParameter("acUnitId", acUnitId)
	                            .getResultList();
	    }
	    
	    @Override
	    public List<ServiceRequest> getAllServiceRequests() {
	        return serviceRequestRepository.findAll();
	    }

}
