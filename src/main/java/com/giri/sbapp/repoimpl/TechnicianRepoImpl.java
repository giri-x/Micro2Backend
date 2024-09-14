package com.giri.sbapp.repoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.giri.sbapp.model.Technician;
import com.giri.sbapp.repo.TechnicianRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TechnicianRepoImpl implements TechnicianRepo {
	
	@Autowired
	EntityManager em;

	@Override
	public String save(Technician tech) {
		if(tech != null) {
			em.persist(tech);
			return "Success";
			
		}else {
			return "Failure";
		}
	}

	@Override
	public Technician findById(int id) {
		return em.find(Technician.class, id);
	}

	@Override
	public List<Technician> findAll() {
		String hql = "from Technician";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void update(Technician tech) {
		em.merge(tech);

	}

	@Override
	public String deleteById(int id) {
		if(id != 0) {
			Technician a = em.find(Technician.class, id);
			em.remove(a);
			return "deleted";
			}
			else
			{
				return "Failed";
			}
	}

	@Override
	public Optional<Technician> findbyemail(String email) {
		return em.createQuery("SELECT a FROM Technician a WHERE a.email = :email", Technician.class)
				.setParameter("email", email).getResultStream().findFirst();
	}

	@Override
	public Technician techLogin(String email, String password) {
		Query q = (Query) em.createQuery("from Technician log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Technician) q.getSingleResult();
	}

}
