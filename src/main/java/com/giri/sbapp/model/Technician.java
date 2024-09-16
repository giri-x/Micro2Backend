//package com.giri.sbapp.model;

//
//import java.util.Set;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//
//
//@Entity
//@Table(name = "technician")
//
//public class Technician {
//	
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    @Column(nullable = false)
//	    private String name;
//
//	    @Column(nullable = false, unique = true)
//	    private String email;
//
//	    @Column(nullable = false)
//	    private String passwordHash;
//
//	    @OneToMany(mappedBy = "technician")
//	    private Set<Log> logs;
//
//	    @OneToMany(mappedBy = "technician")
//	    private Set<ServiceRequest> serviceRequests;
//
//	    @OneToOne
//	    private ACUnit acunit;
//
//		public Technician() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//		public Technician(Long id, String name, String email, String passwordHash, Set<Log> logs,
//				Set<ServiceRequest> serviceRequests, ACUnit acunit) {
//			super();
//			this.id = id;
//			this.name = name;
//			this.email = email;
//			this.passwordHash = passwordHash;
//			this.logs = logs;
//			this.serviceRequests = serviceRequests;
//			this.acunit = acunit;
//		}
//
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getEmail() {
//			return email;
//		}
//
//		public void setEmail(String email) {
//			this.email = email;
//		}
//
//		public String getPasswordHash() {
//			return passwordHash;
//		}
//
//		public void setPasswordHash(String passwordHash) {
//			this.passwordHash = passwordHash;
//		}
//
//		public Set<Log> getLogs() {
//			return logs;
//		}
//
//		public void setLogs(Set<Log> logs) {
//			this.logs = logs;
//		}
//
//		public Set<ServiceRequest> getServiceRequests() {
//			return serviceRequests;
//		}
//
//		public void setServiceRequests(Set<ServiceRequest> serviceRequests) {
//			this.serviceRequests = serviceRequests;
//		}
//
//		public ACUnit getAcunit() {
//			return acunit;
//		}
//
//		public void setAcunit(ACUnit acunit) {
//			this.acunit = acunit;
//		}
//
//		@Override
//		public String toString() {
//			return "Technician [id=" + id + ", name=" + name + ", email=" + email + ", passwordHash=" + passwordHash
//					+ ", logs=" + logs + ", serviceRequests=" + serviceRequests + ", acunit=" + acunit + "]";
//		}
//	    
////	    @JoinTable(
////	        name = "technician_acunit",
////	        joinColumns = @JoinColumn(name = "technician_id"),
////	        inverseJoinColumns = @JoinColumn(name = "ac_unit_id")
////	    )
////	    private Set<ACUnit> assignedACUnits;
//	    
//	    
//
//}

package com.giri.sbapp.model;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "technician")
public class Technician {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true)
    private String passwordHash;

//    @OneToMany
//    private Set<Log> logs;
//
//    @OneToMany(mappedBy = "technician")
//    private Set<ServiceRequest> serviceRequests;

//    @OneToOne
//    private ACUnit acunit;

    @Lob
    @Column(name = "technicianimage", length=1000000000)
    private byte[] technicianImage;
    
    @Column(name = "total_hours_consumed")
    private Double totalHoursConsumed; // New field for total hours consumed

    public Technician() {
        super();
        // Default constructor
    }

	public Technician(int id, String name, String email, String passwordHash, byte[] technicianImage,
			double totalHoursConsumed) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.technicianImage = technicianImage;
		this.totalHoursConsumed = totalHoursConsumed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public byte[] getTechnicianImage() {
		return technicianImage;
	}

	public void setTechnicianImage(byte[] technicianImage) {
		this.technicianImage = technicianImage;
	}
//
//	public double getTotalHoursConsumed() {
//		return totalHoursConsumed;
//	}

//	public void setTotalHoursConsumed(double totalHoursConsumed) {
//		this.totalHoursConsumed = totalHoursConsumed;
//	}

//	public void setTotalHoursConsumed(Double totalHoursConsumed) {
//		this.totalHoursConsumed = totalHoursConsumed;
//	}
//	
	
	public Double getTotalHoursConsumed() {
        return totalHoursConsumed;
    }

    public void setTotalHoursConsumed(Double totalHoursConsumed) {
        this.totalHoursConsumed = totalHoursConsumed;
    }
	

   
}

