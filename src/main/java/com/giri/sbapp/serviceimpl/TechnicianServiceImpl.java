package com.giri.sbapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giri.sbapp.model.Technician;
import com.giri.sbapp.repo.TechnicianRepo;
import com.giri.sbapp.service.TechnicianService;

@Service
public class TechnicianServiceImpl implements TechnicianService {
	
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
	
	

}
