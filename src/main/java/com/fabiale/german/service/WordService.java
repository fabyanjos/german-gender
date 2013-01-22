package com.fabiale.german.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.german.model.Gender;
import com.fabiale.german.model.Word;
import com.fabiale.german.repositories.WordRepository;

@Service
public class WordService {
	
	@Autowired
	private WordRepository repository;

	public List<Word> getAll() {
		return this.repository.getAll();
	}
	
	public List<Word> getByGender(Gender gender) {
		return this.repository.getByGender(gender);
	}

	public Integer create(Word word) {
		return this.repository.create(word);
	}
	
	public Word getRandom() {
		Random random = new Random();
		Integer id = random.nextInt(4) + 1;
		Word word = this.repository.getById(id);
		if (word != null) 
			return word;
		else return getRandom();
	}
}
