package com.giri.sbapp.repoimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giri.sbapp.model.Log;
import com.giri.sbapp.repo.LogRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class LogRepoImpl implements LogRepo {

	 @PersistenceContext
    private EntityManager em;

    @Override
    public Log save(Log log) {
        if (log.getId() == null) {
            em.persist(log);
            return log;
        } else {
            return em.merge(log);
        }
    }

    @Override
    public void deleteById(Long id) {
        Log log = em.find(Log.class, id);
        if (log != null) {
            em.remove(log);
        }
    }

    @Override
    public java.util.Optional<Log> findById(Long id) {
        return java.util.Optional.ofNullable(em.find(Log.class, id));
    }

    @Override
    public List<Log> findAll() {
        TypedQuery<Log> query = em.createQuery("SELECT l FROM Log l", Log.class);
        return query.getResultList();
    }

    @Override
    public List<Log> findLogsByACUnitAndDate(Long acUnitId, LocalDate date) {
        LocalDateTime from = date.atStartOfDay();
        LocalDateTime to = date.atTime(23, 59, 59);
        TypedQuery<Log> query = em.createQuery(
            "SELECT l FROM Log l WHERE l.acUnit.id = :acUnitId AND l.date = :date", Log.class);
        query.setParameter("acUnitId", acUnitId);
        query.setParameter("date", date);
        return query.getResultList();
    }
    
    @Override
    public List<Log> findByAcUnitId(Long acUnitId) {
        String jpql = "SELECT l FROM Log l WHERE l.acUnit.id = :acUnitId";
        TypedQuery<Log> query = em.createQuery(jpql, Log.class);
        query.setParameter("acUnitId", acUnitId);
        return query.getResultList();
    }
    
    @Override
    public List<Log> findByDate(LocalDate date) {
        String query = "SELECT l FROM Log l WHERE l.date = :date";
        TypedQuery<Log> typedQuery = em.createQuery(query, Log.class);
        typedQuery.setParameter("date", date);
        return typedQuery.getResultList();
    }
    
    @Override
    public List<Log> findLogsByAcUnitIdAndDate(Long acUnitId, LocalDate date) {
        String jpql = "SELECT l FROM Log l WHERE l.acUnit.id = :acUnitId AND l.date = :date";
        TypedQuery<Log> query = em.createQuery(jpql, Log.class);
        query.setParameter("acUnitId", acUnitId);
        query.setParameter("date", date);
        return query.getResultList();
    }
}
