package com.giri.sbapp.model;

import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ac_unit")
public class ACUnit {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = true)
	    private String location;

	    @Column(nullable = true)
	    private String dimensions;

	    @Column(nullable = true)
	    private Integer count;

//	    @OneToMany
//	    private Set<Log> logs;
//
//	    @OneToMany(mappedBy = "acUnit")
//	    private Set<ServiceRequest> serviceRequests;
	    
	    @OneToOne
	    private Technician technician;

		public ACUnit() {
			super();
			
		}

		public ACUnit(Long id, String location, String dimensions, Integer count, Set<Log> logs,
				Set<ServiceRequest> serviceRequests, Technician technician) {
			super();
			this.id = id;
			this.location = location;
			this.dimensions = dimensions;
			this.count = count;
//			this.logs = logs;
//			this.serviceRequests = serviceRequests;
			this.technician = technician;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getDimensions() {
			return dimensions;
		}

		public void setDimensions(String dimensions) {
			this.dimensions = dimensions;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

//		public Set<Log> getLogs() {
//			return logs;
//		}
//
//		public void setLogs(Set<Log> logs) {
//			this.logs = logs;
//		}

//		public Set<ServiceRequest> getServiceRequests() {
//			return serviceRequests;
//		}
//
//		public void setServiceRequests(Set<ServiceRequest> serviceRequests) {
//			this.serviceRequests = serviceRequests;
//		}

		public Technician getTechnician() {
			return technician;
		}

		public void setTechnician(Technician technician) {
			this.technician = technician;
		}
		
		

	   


}
