package com.giri.sbapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.giri.sbapp.model.ACUnit;
import com.giri.sbapp.service.ACUnitService;

@RestController
@RequestMapping("/ac")
@CrossOrigin("*")
public class ACUnitController {
	
	@Autowired
	ACUnitService service;
	
//	@PutMapping("/update/{projectId}")
//	public ResponseEntity<Object> addUserToProject(@RequestBody Integer userId,                                                 
//			@PathVariable("projectId") int projectId) {     
//		if (projectService.addUserToProject(userId, projectId)) {         
//			return ResponseEntity.ok(null);     
//			} else {         
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 
//				} }
	
	@PostMapping
	public String insertACUnit(@RequestBody ACUnit acunit) {
		
		String msg="";
		try {
			service.addACUnit(acunit);
			msg+="add Sucess";
			
		}catch(Exception e) {
			
			msg+="add Failure";
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public ACUnit getACUnitById (@PathVariable("id") int id) {
		return service.getACUnit(id);
	}
	@GetMapping("/all")
	public List<ACUnit> getACUnits () {
		return service.getAllACUnit();
	}
	
	@PutMapping
	public String updateACUnit(@RequestBody ACUnit acunit) {
		
		String msg="";
		try {
			service.updateACUnit(acunit);
			msg+="update Success";
			
		}catch(Exception e) {
			
			msg+="update Failure";
		}
		return msg;
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteACUnitById(@PathVariable("id") int id) {
		String msg="";
		try {
			service.deleteACUnitid(id);
			msg+="deleteSuccess";
			
		}catch(Exception e) {
			
			msg+="deleteFailure";
		}
		return msg;
		
		
	}
	

    @GetMapping("/technician/{technicianId}")
    public List<ACUnit> getACUnitsByTechnician(@PathVariable("technicianId") Long technicianId) {
        return service.getACUnitsByTechnician(technicianId);
    }

}
