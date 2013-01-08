package com.fabiale.german.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.german.model.Gender;
import com.fabiale.german.model.Word;

@Repository
public class WordRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Word> getAll() {
		return this.factory.openSession().createCriteria(Word.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Word> getByGender(Gender gender) {
		Criteria criteria = this.factory.openSession().createCriteria(Word.class);
		criteria.add(Restrictions.eq("gender", gender));
		return criteria.list();
	}

    @Transactional
	public Integer create(Word word) {
		this.factory.getCurrentSession().save(word);
		return word.getId();
	}
    
    public Word getById(Integer id) {
    	return (Word) this.factory.getCurrentSession().get(Word.class, id);
    }
}
