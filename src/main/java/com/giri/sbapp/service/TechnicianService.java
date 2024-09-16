package com.giri.sbapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.giri.sbapp.model.Technician;


@Service
public interface TechnicianService {
	
	public Optional<Technician> findbyemail(String email);
    public Optional<Technician> techLogin(String email, String password);
	public String addTechnician(Technician tech);
	public Technician getTechnician(int id);
//	  Optional<Technician> getTechnician(Long id);
	public List<Technician> getAllTechnician();
	public void updateTechnician(Technician tech);
	public String deleteTechnicianId(int id);
//	public Optional<Technician> getTechnician(Long id);
	//void updateTechnicianTotalHours(int technicianId, double hoursToAdd);
	 void updateTotalHours(int technicianId, double totalHours);
	 boolean updatePassword(int id, String newPassword);

}
