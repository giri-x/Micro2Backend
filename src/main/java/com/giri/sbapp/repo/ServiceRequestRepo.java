package com.giri.sbapp.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.giri.sbapp.model.ServiceRequest;

@Repository
public interface ServiceRequestRepo {
	
	void save(ServiceRequest serviceRequest);
    ServiceRequest findById(Long id);
    List<ServiceRequest> findByAcUnitId(Long acUnitId);
    List<ServiceRequest> findAll();

}
