package com.giri.sbapp.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.giri.sbapp.model.Technician;
import com.giri.sbapp.service.EmailService;
import com.giri.sbapp.serviceimpl.TechnicianServiceImpl;

@RestController
@RequestMapping("/tech")
@CrossOrigin("*")

public class TechnicianController {
	
	@Autowired
	TechnicianServiceImpl service;
	
	 @Autowired
	 private EmailService emailService;
	
//	@PostMapping
//	public String insertTechnician(@RequestBody Technician tech) {
//		
//		String msg="";
//		try {
//			service.addTechnician(tech);
//			msg+="add Sucess";
//			
//		}catch(Exception e) {
//			
//			msg+="add Failure";
//		}
//		return msg;
//	}
	 
//	  @PostMapping
//	    public String insertTechnician(@RequestBody Technician tech) {
//	        String msg = "";
//	        try {
//	            service.addTechnician(tech);
//	            emailService.sendSimpleMessage(
//	                tech.getEmail(),
//	                "Welcome to AC Service",
//	                "Dear " + tech.getName() + ",\n\n" +
//	                "Welcome to AC Service! Your account has been created successfully.\n\n" +
//	                "Best regards,\n" +
//	                "The AC Service Team"
//	            );
//	            msg += "Add Success";
//	        } catch (Exception e) {
//	            msg += "Add Failure";
//	        }
//	        return msg;
//	    }
//	

@PostMapping
public String insertTechnician(
    @RequestParam("name") String name,
    @RequestParam("email") String email,
    @RequestParam("passwordHash") String passwordHash,
    @RequestParam(value = "technicianImage", required = false) MultipartFile technicianImage) {

    String msg = "";
    try {
        Technician tech = new Technician();
        tech.setName(name);
        tech.setEmail(email);
        tech.setPasswordHash(passwordHash);

        if (technicianImage != null && !technicianImage.isEmpty()) {
            tech.setTechnicianImage(technicianImage.getBytes());
        }

        service.addTechnician(tech);
        emailService.sendSimpleMessage(
            tech.getEmail(),
            "Welcome to AC Service",
            "Dear " + tech.getName() + ",\n\n" +
            "Welcome to AC Service! Your account has been created successfully  "
            + " login with your email ID & your password is 12345 \n\n" +
            "Best regards,\n" +
            "The AC Service Team"
        );
        msg += "Add Success";
    } catch (Exception e) {
        msg += "Add Failure";
    }
    return msg;
}
	@GetMapping("{id}")
	public Technician getTechnicianById (@PathVariable("id") int id) {
		return service.getTechnician(id);
	}

@GetMapping("/image/{id}")
public ResponseEntity<?> getTechnicianImage(@PathVariable("id") int id) {
    try {
        Technician tech = service.getTechnician(id);
        if (tech != null && tech.getTechnicianImage() != null) {
            // Encode the image as a Base64 string
            String base64Image = Base64.getEncoder().encodeToString(tech.getTechnicianImage());
            return ResponseEntity.ok(base64Image);
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error occurred while retrieving image: " + e.getMessage());
    }
}




	@GetMapping("/all")
	public List<Technician> getTechnicians () {
		return service.getAllTechnician();
	}
	
	@PutMapping
	public String updateTechnician(@RequestBody Technician tech) {
		
		String msg="";
		try {
			service.updateTechnician(tech);
			msg+="update Success";
			
		}catch(Exception e) {
			
			msg+="update Failure";
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteTechnicianById(@PathVariable("id") int id) {
		String msg="";
		try {
			service.deleteTechnicianId(id);
			msg+="deleteSuccess";
			
		}catch(Exception e) {
			
			msg+="deleteFailure";
		}
		return msg;
		
		
	}
	
    @PostMapping("/loginTech")
    public ResponseEntity<?> login(@RequestBody Technician tech) {
        try {
            // Find the  by email
            Optional<Technician> techOptional = service.findbyemail(tech.getEmail());
            if (!techOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Invalid email");
            }
 
            Technician userFound = techOptional.get();
            Map<String, Integer> map=new HashMap<>();
            map.put("userId", userFound.getId());
 
            // Check if password matches
            if (!tech.getPasswordHash().equals(userFound.getPasswordHash())) {
                return ResponseEntity.badRequest().body("Invalid password");
            }
 
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during login: " + e.getMessage());
        }
    }
	
    @GetMapping("/techLogin/{email}/{password}	")
   	public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
   		try {
   			Optional<Technician> tech=service.techLogin(email, password);
   			if(tech != null) {
   				System.out.println("tHE"+tech.get().getId());
   				return ResponseEntity.ok(tech.get().getId());
   				
   			}
   		
   		} catch (Exception e) {
   			
   		}
   		
   		return (ResponseEntity<?>) ResponseEntity.badRequest();
   	}
    
    
    
    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String subject = request.get("subject");
        String message = request.get("message");

        try {
            emailService.sendSimpleMessage(email, subject, message);
            return ResponseEntity.ok("Notification sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending notification.");
        }
    }
    
    @PutMapping("/{id}/update-hours")
    public void updateTotalHours(@PathVariable int id, @RequestParam double totalHours) {
        service.updateTotalHours(id, totalHours);
    }
    
    @PutMapping("/{id}/update-password")
    public ResponseEntity<String> updatePassword(@PathVariable int id, @RequestParam String newPassword) {
        try {
            boolean updated = service.updatePassword(id, newPassword);
            if (updated) {
                return ResponseEntity.ok("Password updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update password.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating password: " + e.getMessage());
        }
    }

}
