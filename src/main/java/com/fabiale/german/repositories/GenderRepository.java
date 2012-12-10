package com.fabiale.german.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.german.model.Gender;

@Repository
public class GenderRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Gender> getAll() {
		return this.factory.openSession().createCriteria(Gender.class).list();
	}

    @Transactional
	public Integer create(Gender gender) {
		this.factory.getCurrentSession().save(gender);
		return gender.getId();
	}
}
