package com.giri.sbapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giri.sbapp.model.ACUnit;
import com.giri.sbapp.repo.ACUnitRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ACUnitRepoImpl implements ACUnitRepo {

	@Autowired
	EntityManager em;
	
	@Override
	public String save(ACUnit ac) {
		if(ac != null) {
			em.persist(ac);
			return "Success";
			
		}else {
			return "Failure";
		}
	}

	@Override
	public ACUnit findById(int id) {
		return em.find(ACUnit.class,id);
	}

	@Override
	public List<ACUnit> findAll() {
		String hql = "from ACUnit";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void update(ACUnit ac) {
		em.merge(ac);
	}

	@Override
	public String deleteById(int id) {
		if(id != 0) {
			ACUnit a = em.find(ACUnit.class, id);
			em.remove(a);
			return "deleted";
			}
			else
			{
				return "Failed";
			}
	}

	@Override
	public List<ACUnit> findACUnitsByTechnician(Long technicianId) {
		String hql = "SELECT a FROM ACUnit a WHERE a.technician.id = :technicianId";
        TypedQuery<ACUnit> query = em.createQuery(hql, ACUnit.class);
        query.setParameter("technicianId", technicianId);
        return query.getResultList();
	}

}
