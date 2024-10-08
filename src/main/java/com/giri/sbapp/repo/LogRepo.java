package com.giri.sbapp.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.giri.sbapp.model.Log;

public interface LogRepo {
    Log save(Log log);
    void deleteById(Long id);
    java.util.Optional<Log> findById(Long id);
    List<Log> findAll();
    List<Log> findLogsByACUnitAndDate(Long acUnitId, LocalDate date);
    List<Log> findByAcUnitId(Long acUnitId);
    List<Log> findByDate(LocalDate date);
    List<Log> findLogsByAcUnitIdAndDate(Long acUnitId, LocalDate date);
}
