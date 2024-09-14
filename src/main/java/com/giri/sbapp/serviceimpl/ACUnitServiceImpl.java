package com.giri.sbapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.sbapp.model.ACUnit;
import com.giri.sbapp.repo.ACUnitRepo;
import com.giri.sbapp.service.ACUnitService;

@Service
public class ACUnitServiceImpl implements ACUnitService {
	
	@Autowired
	ACUnitRepo repo;

	@Override
	public String addACUnit(ACUnit acunit) {
		return(repo.save(acunit));
	}

	@Override
	public ACUnit getACUnit(int id) {
		return repo.findById(id);
	}

	@Override
	public List<ACUnit> getAllACUnit() {
		return repo.findAll();
	}

	@Override
	public void updateACUnit(ACUnit acunit) {
		repo.update(acunit);
		
	}

	@Override
	public String deleteACUnitid(int id) {
		return(repo.deleteById(id));
	}

	@Override
	public List<ACUnit> getACUnitsByTechnician(Long technicianId) {
		return repo.findACUnitsByTechnician(technicianId);
	}

}
