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
    
//    @GetMapping("/by-ac-unit-and-date/{acUnitId}")
//    public List<Log> getLogsByAcUnitIdAndDate(@PathVariable Long acUnitId, @RequestParam("date") String date) {
//        LocalDate localDate = LocalDate.parse(date);
//        return logService.getLogsByAcUnitIdAndDate(acUnitId, localDate);
//    }
    
    @GetMapping("/by-ac-unit-and-date/{acUnitId}")
    public List<Log> getLogsByAcUnitIdAndDate(@PathVariable Long acUnitId, @RequestParam("date") String date) {
        
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date parameter cannot be empty");
        }
        
        LocalDate localDate = LocalDate.parse(date);
        return logService.getLogsByAcUnitIdAndDate(acUnitId, localDate);
    }

    


    
}

