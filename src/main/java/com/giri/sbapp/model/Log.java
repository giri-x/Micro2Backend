//package com.giri.sbapp.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "log")
//public class Log {
//	
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    @ManyToOne
//	    @JoinColumn(name = "ac_unit_id", nullable = false)
//	    private ACUnit acUnit;
//
//	    @ManyToOne
//	    @JoinColumn(name = "technician_id", nullable = false)
//	    private Technician technician;
//
//	    @Column(nullable = false)
//	    private Double hoursUsed;
//
//	    @Column(nullable = false)
//	    private String purpose;
//
//		public Log() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//		public Log(Long id, ACUnit acUnit, Technician technician, Double hoursUsed, String purpose) {
//			super();
//			this.id = id;
//			this.acUnit = acUnit;
//			this.technician = technician;
//			this.hoursUsed = hoursUsed;
//			this.purpose = purpose;
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
//		public ACUnit getAcUnit() {
//			return acUnit;
//		}
//
//		public void setAcUnit(ACUnit acUnit) {
//			this.acUnit = acUnit;
//		}
//
//		public Technician getTechnician() {
//			return technician;
//		}
//
//		public void setTechnician(Technician technician) {
//			this.technician = technician;
//		}
//
//		public Double getHoursUsed() {
//			return hoursUsed;
//		}
//
//		public void setHoursUsed(Double hoursUsed) {
//			this.hoursUsed = hoursUsed;
//		}
//
//		public String getPurpose() {
//			return purpose;
//		}
//
//		public void setPurpose(String purpose) {
//			this.purpose = purpose;
//		}
//
//		@Override
//		public String toString() {
//			return "Log [id=" + id + ", acUnit=" + acUnit + ", technician=" + technician + ", hoursUsed=" + hoursUsed
//					+ ", purpose=" + purpose + "]";
//		}
//	    
//	    
//
//}

//package com.giri.sbapp.model;
//
//import java.time.LocalDateTime;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Transient;
//
//@Entity
//@Table(name = "log")
//public class Log {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "ac_unit_id", nullable = false)
//    private ACUnit acUnit;
//
//    @ManyToOne
//    @JoinColumn(name = "technician_id", nullable = false)
//    private Technician technician;
//
//    @Column(nullable = false)
//    private LocalDateTime fromTime;
//
//    @Column(nullable = false)
//    private LocalDateTime toTime;
//
//    @Transient
//    private Double totalHours; // This will not be persisted in the database
//
//    public Log() {
//        super();
//    }
//
//    public Log(Long id, ACUnit acUnit, Technician technician, LocalDateTime fromTime, LocalDateTime toTime) {
//        super();
//        this.id = id;
//        this.acUnit = acUnit;
//        this.technician = technician;
//        this.fromTime = fromTime;
//        this.toTime = toTime;
//        this.totalHours = calculateTotalHours();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public ACUnit getAcUnit() {
//        return acUnit;
//    }
//
//    public void setAcUnit(ACUnit acUnit) {
//        this.acUnit = acUnit;
//    }
//
//    public Technician getTechnician() {
//        return technician;
//    }
//
//    public void setTechnician(Technician technician) {
//        this.technician = technician;
//    }
//
//    public LocalDateTime getFromTime() {
//        return fromTime;
//    }
//
//    public void setFromTime(LocalDateTime fromTime) {
//        this.fromTime = fromTime;
//        this.totalHours = calculateTotalHours(); // Update totalHours when fromTime is set
//    }
//
//    public LocalDateTime getToTime() {
//        return toTime;
//    }
//
//    public void setToTime(LocalDateTime toTime) {
//        this.toTime = toTime;
//        this.totalHours = calculateTotalHours(); // Update totalHours when toTime is set
//    }
//
//    public Double getTotalHours() {
//        return totalHours;
//    }
//
//    // This method calculates total hours based on fromTime and toTime
//    private Double calculateTotalHours() {
//        if (fromTime != null && toTime != null) {
//            return (double) (java.time.Duration.between(fromTime, toTime).toMinutes() / 60.0);
//        }
//        return 0.0;
//    }
//
//    @Override
//    public String toString() {
//        return "Log [id=" + id + ", acUnit=" + acUnit + ", technician=" + technician +
//               ", fromTime=" + fromTime + ", toTime=" + toTime + ", totalHours=" + totalHours + "]";
//    }
//}

//
//package com.giri.sbapp.model;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Transient;
//
//@Entity
//@Table(name = "log")
//public class Log {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "ac_unit_id", nullable = false)
//    private ACUnit acUnit;
//
//    @ManyToOne
//    @JoinColumn(name = "technician_id", nullable = false)
//    private Technician technician;
//
//    @Column(nullable = false)
//    private LocalDateTime fromTime;
//
//    @Column(nullable = false)
//    private LocalDateTime toTime;
//
//    @Column(nullable = false)
//    private LocalDate date; // New field for storing the date of the log
//
//    @Transient
//    private Double totalHours; // This will not be persisted in the database
//
//    public Log() {
//        super();
//    }
//
//    public Log(Long id, ACUnit acUnit, Technician technician, LocalDateTime fromTime, LocalDateTime toTime, LocalDate date) {
//        super();
//        this.id = id;
//        this.acUnit = acUnit;
//        this.technician = technician;
//        this.fromTime = fromTime;
//        this.toTime = toTime;
//        this.date = date;
//        this.totalHours = calculateTotalHours();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public ACUnit getAcUnit() {
//        return acUnit;
//    }
//
//    public void setAcUnit(ACUnit acUnit) {
//        this.acUnit = acUnit;
//    }
//
//    public Technician getTechnician() {
//        return technician;
//    }
//
//    public void setTechnician(Technician technician) {
//        this.technician = technician;
//    }
//
//    public LocalDateTime getFromTime() {
//        return fromTime;
//    }
//
//    public void setFromTime(LocalDateTime fromTime) {
//        this.fromTime = fromTime;
//        this.totalHours = calculateTotalHours(); // Update totalHours when fromTime is set
//    }
//
//    public LocalDateTime getToTime() {
//        return toTime;
//    }
//
//    public void setToTime(LocalDateTime toTime) {
//        this.toTime = toTime;
//        this.totalHours = calculateTotalHours(); // Update totalHours when toTime is set
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public Double getTotalHours() {
//        return totalHours;
//    }
//
//    // This method calculates total hours based on fromTime and toTime
//    private Double calculateTotalHours() {
//        if (fromTime != null && toTime != null) {
//            return (double) (java.time.Duration.between(fromTime, toTime).toMinutes() / 60.0);
//        }
//        return 0.0;
//    }
//
//    @Override
//    public String toString() {
//        return "Log [id=" + id + ", acUnit=" + acUnit + ", technician=" + technician +
//               ", fromTime=" + fromTime + ", toTime=" + toTime + ", date=" + date +
//               ", totalHours=" + totalHours + "]";
//    }
//}
//
package com.giri.sbapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

//@Entity
//@Table(name = "log")
//public class Log {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//   
//    @ManyToOne
//    @JoinColumn(name = "ac_unit_id", nullable = false)
//    private ACUnit acUnit;
//
////    @ManyToOne
////    @JoinColumn(name = "technician_id", nullable = false)
////    private Technician technician;
//
//    @Column(nullable = false)
//    private LocalDateTime fromTime;
//
//    @Column(nullable = false)
//    private LocalDateTime toTime;
//
//    @Column(nullable = false)
//    private LocalDate date;
//
//    @Column(name = "purpose", nullable = true)
//    private String purpose; // New field for storing the purpose of the AC usage
//
//    @Transient
//    private Double totalHours; // This will not be persisted in the database
//
//    public Log() {
//        super();
//    }
//
//    public Log(Long id, ACUnit acUnit, Technician technician, LocalDateTime fromTime, LocalDateTime toTime, LocalDate date, String purpose) {
//        super();
//        this.id = id;
//        this.acUnit = acUnit;
////        this.technician = technician;
//        this.fromTime = fromTime;
//        this.toTime = toTime;
//        this.date = date;
//        this.purpose = purpose;
//        this.totalHours = calculateTotalHours();
//    }
//
//    // Getters and setters for all fields including the new purpose field
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public ACUnit getAcUnit() {
//        return acUnit;
//    }
//
//    public void setAcUnit(ACUnit acUnit) {
//        this.acUnit = acUnit;
//    }
//
////    public Technician getTechnician() {
////        return technician;
////    }
////
////    public void setTechnician(Technician technician) {
////        this.technician = technician;
////    }
//
//    public LocalDateTime getFromTime() {
//        return fromTime;
//    }
//
//    public void setFromTime(LocalDateTime fromTime) {
//        this.fromTime = fromTime;
//        this.totalHours = calculateTotalHours(); // Update totalHours when fromTime is set
//    }
//
//    public LocalDateTime getToTime() {
//        return toTime;
//    }
//
//    public void setToTime(LocalDateTime toTime) {
//        this.toTime = toTime;
//        this.totalHours = calculateTotalHours(); // Update totalHours when toTime is set
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public String getPurpose() {
//        return purpose;
//    }
//
//    public void setPurpose(String purpose) {
//        this.purpose = purpose;
//    }
//
//    public Double getTotalHours() {
//        return totalHours;
//    }
//
//    private Double calculateTotalHours() {
//        if (fromTime != null && toTime != null) {
//            return (double) (java.time.Duration.between(fromTime, toTime).toMinutes() / 60.0);
//        }
//        return 0.0;
//    }
//
//    @Override
//    public String toString() {
//        return "Log [id=" + id + ", fromTime=" + fromTime + ", toTime=" + toTime + ", date=" + date +
//               ", purpose=" + purpose + ", totalHours=" + totalHours + "]";
//    }
//}


// correct code above 

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ac_unit_id", nullable = false)
    private ACUnit acUnit;

    @Column(nullable = false)
    private LocalDateTime fromTime;

    @Column(nullable = false)
    private LocalDateTime toTime;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "purpose", nullable = true)
    private String purpose;

    @Transient
    private Double totalHours;

    public Log() {
        super();
    }

    public Log(Long id, ACUnit acUnit, LocalDateTime fromTime, LocalDateTime toTime, LocalDate date, String purpose) {
        this.id = id;
        this.acUnit = acUnit;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.date = date;
        this.purpose = purpose;
        this.totalHours = calculateTotalHours();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ACUnit getAcUnit() {
        return acUnit;
    }

    public void setAcUnit(ACUnit acUnit) {
        this.acUnit = acUnit;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime fromTime) {
        this.fromTime = fromTime;
        this.totalHours = calculateTotalHours(); // Update totalHours when fromTime is set
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
        this.totalHours = calculateTotalHours(); // Update totalHours when toTime is set
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getTotalHours() {
        return totalHours;
    }
//
//    private Double calculateTotalHours() {
//        if (fromTime != null && toTime != null) {
//            return (double) (java.time.Duration.between(fromTime, toTime).toMinutes() / 60.0);
//        }
//        return 0.0;
//    }
    
    private Double calculateTotalHours() {
        if (fromTime != null && toTime != null) {
            long minutes = java.time.Duration.between(fromTime, toTime).toMinutes();
            return minutes / 60.0;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", fromTime=" + fromTime + ", toTime=" + toTime + ", date=" + date +
               ", purpose=" + purpose + ", totalHours=" + totalHours + "]";
    }
}

