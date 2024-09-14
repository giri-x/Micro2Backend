package com.giri.sbapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.giri.sbapp.model.ACUnit;


public interface ACUnitService {
	
	public String addACUnit(ACUnit acunit);
	public ACUnit getACUnit(int id);
	public List<ACUnit> getAllACUnit();
	public void updateACUnit(ACUnit acunit);
	public String deleteACUnitid(int id);
	public List<ACUnit> getACUnitsByTechnician(Long technicianId);

}
