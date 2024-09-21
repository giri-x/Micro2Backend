package com.giri.sbapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.giri.sbapp.model.ServiceRequest;
import com.giri.sbapp.repo.ServiceRequestRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ServiceRequestRepoImpl implements ServiceRequestRepo {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	 @Override
	    public void save(ServiceRequest serviceRequest) {
	        if (serviceRequest.getId() == null) {
	            entityManager.persist(serviceRequest);
	        } else {
	            entityManager.merge(serviceRequest);
	        }
	    }

	    @Override
	    public ServiceRequest findById(Long id) {
	        return entityManager.find(ServiceRequest.class, id);
	    }

	    @Override
	    public List<ServiceRequest> findByAcUnitId(Long acUnitId) {
	        return entityManager.createQuery("SELECT sr FROM ServiceRequest sr WHERE sr.acUnit.id = :acUnitId", ServiceRequest.class)
	                            .setParameter("acUnitId", acUnitId)
	                            .getResultList();
	    }
	    
	    @Override
	    public List<ServiceRequest> findAll() {
	        return entityManager.createQuery("FROM ServiceRequest", ServiceRequest.class).getResultList();
	    }

}
