package com.giri.sbapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.giri.sbapp.model.Technician;

@Repository
public interface TechnicianRepo {
	
	String save(Technician tech);

	Technician findById(int id);

	List<Technician>findAll();

	void update(Technician tech);

	String deleteById(int id);
	
	public Optional<Technician> findbyemail(String email);

	public Technician techLogin(String email, String password);
	
	
	
	

}
