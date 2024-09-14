package com.giri.sbapp.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.giri.sbapp.model.ServiceRequest;

@Repository
public interface ServiceRequestRepo {
	
//	String save(ServiceRequest req);
//
//	ServiceRequest findById(int id);
//
//	List<ServiceRequest>findAll();
//
//	void update(ServiceRequest req);
//
//	String deleteById(int id);
	
	void save(ServiceRequest serviceRequest);
    ServiceRequest findById(Long id);
    List<ServiceRequest> findByAcUnitId(Long acUnitId);
    List<ServiceRequest> findAll();

}
