//package com.giri.sbapp.controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.giri.sbapp.model.Log;
//import com.giri.sbapp.service.LogService;
//
//@RestController
//@RequestMapping("/log")
//public class LogController {
//	
//	@Autowired
//    private LogService logService;
//
//    @PostMapping
//    public Log createLog(@RequestBody Log log) {
//        return logService.createLog(log);
//    }
//
//    @PutMapping
//    public Log updateLog(@RequestBody Log log) {
//        return logService.updateLog(log);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteLog(@PathVariable Long id) {
//        logService.deleteLog(id);
//    }
//
//    @GetMapping("/{id}")
//    public Log getLogById(@PathVariable Long id) {
//        return logService.getLogById(id);
//    }
//
//    @GetMapping("/all")
//    public List<Log> getAllLogs() {
//        return logService.getAllLogs();
//    }
//
//    @GetMapping("/daily/{acUnitId}")
//    public List<Log> getDailyLogs(@PathVariable Long acUnitId, @RequestParam("date") String date) {
//        LocalDateTime from = LocalDateTime.parse(date + "T00:00:00");
//        LocalDateTime to = LocalDateTime.parse(date + "T23:59:59");
//        return logService.getLogsByACUnitAndDate(acUnitId, from, to);
//    }
//
//}

package com.giri.sbapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.giri.sbapp.model.Log;
import com.giri.sbapp.service.LogService;

@RestController
@RequestMapping("/log")
@CrossOrigin("*")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.createLog(log);
    }
    
//    @PostMapping("/by-ids")
//    public Log createLogByIds(@RequestBody LogCreationRequest request) {
//        return logService.createLogByIds(request.getTechnicianId(), request.getAcUnitId(), request.getFromTime(), request.getToTime(), request.getDate(), request.getPurpose());
//    }

    @PutMapping
    public Log updateLog(@RequestBody Log log) {
        return logService.updateLog(log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);
    }

    @GetMapping("/{id}")
    public Log getLogById(@PathVariable Long id) {
        return logService.getLogById(id);
    }

    @GetMapping("/all")
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/daily/{acUnitId}")
    public List<Log> getDailyLogs(@PathVariable Long acUnitId, @RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return logService.getLogsByACUnitAndDate(acUnitId, localDate);
    }
    
    @GetMapping("/by-ac-unit/{acUnitId}")
    public List<Log> getLogsByAcUnitId(@PathVariable Long acUnitId) {
        return logService.getLogsByAcUnitId(acUnitId);
        
    }
    
    @GetMapping("/by-date")
    public List<Log> getLogsByDate(@RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return logService.getLogsByDate(localDate);
    }
    


    
}

