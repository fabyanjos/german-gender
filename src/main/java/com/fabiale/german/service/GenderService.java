package com.fabiale.german.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.german.model.Gender;
import com.fabiale.german.repositories.GenderRepository;

@Service
public class GenderService {
	
	@Autowired
	private GenderRepository repository;

	public List<Gender> getAll() {
		return this.repository.getAll();
	}

	public Integer create(Gender gender) {
		return this.repository.create(gender);
	}
}
