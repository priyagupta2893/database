package com.cdp.spring.database.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.cdp.spring.database.entity.Person;

@Repository
@Transactional // Required this annotation usually in service and to rollback or commit all
				// transactions
public class PersonJpaRepository {
	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person insert(Person p) {
		return entityManager.merge(p);
	}
	
	public Person update(Person p) {
		return entityManager.merge(p);
	}

}
