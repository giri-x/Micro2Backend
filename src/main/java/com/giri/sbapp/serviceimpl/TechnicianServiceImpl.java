package com.giri.sbapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.sbapp.model.Technician;
import com.giri.sbapp.repo.TechnicianRepo;
import com.giri.sbapp.service.TechnicianService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class TechnicianServiceImpl implements TechnicianService {
	
	@Autowired
	EntityManager entitymanager;
	
	TechnicianRepo repo;
	

	public TechnicianServiceImpl(TechnicianRepo repo) {
		super();
		this.repo=repo;
	}

	@Override
	public String addTechnician(Technician tech) {
		return(repo.save(tech));
	}

	@Override
	public Technician getTechnician(int id) {
		return repo.findById(id);
	}
	
//	 @Override
//	    public Optional<Technician> getTechnician(int id) {
//	        return repo.findById(id);
//	    }

	@Override
	public List<Technician> getAllTechnician() {
		return repo.findAll();
	}

	@Override
	public void updateTechnician(Technician tech) {
		repo.update(tech);
		
	}

	@Override
	public String deleteTechnicianId(int id) {
		return(repo.deleteById(id));
	}

	@Override
	public Optional<Technician> findbyemail(String email) {
		return this.repo.findbyemail(email);
	}

	@Override
	public Optional<Technician> techLogin(String email, String password) {
		return repo.findbyemail(email);
	}
	
//	 @Override
//	    public void updateTechnicianTotalHours(int technicianId, double hoursToAdd) {
//	        Technician technician = repo.findById(technicianId);
//	        if (technician == null) {
//	            throw new RuntimeException("Technician not found with ID: " + technicianId);
//	        }
//	        double newTotalHours = technician.getTotalHoursConsumed() + hoursToAdd;
//	        technician.setTotalHoursConsumed(newTotalHours);
//	        repo.update(technician);
//	    }
	  @Override
	    public void updateTotalHours(int technicianId, double totalHours) {
	        Technician technician = getTechnician(technicianId);
	        technician.setTotalHoursConsumed(totalHours);
	        repo.save(technician);
	    }
	  
	  @Transactional
	    @Override
	    public boolean updatePassword(int id, String newPassword) {
	        try {
	            Technician technician = entitymanager.find(Technician.class, id);
	            if (technician != null) {
	                technician.setPasswordHash(newPassword); // Update password
	                entitymanager.merge(technician); // Save changes
	                return true;
	            }
	            return false;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	

}
