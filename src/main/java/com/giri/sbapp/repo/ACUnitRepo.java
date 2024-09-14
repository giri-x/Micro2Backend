package com.giri.sbapp.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.giri.sbapp.model.ACUnit;

public interface ACUnitRepo {
	
	String save(ACUnit ac);

	ACUnit findById(int id);

	List<ACUnit> findAll();

	void update(ACUnit ac);

	String deleteById(int id);
	
	List<ACUnit> findACUnitsByTechnician(Long technicianId);

}
