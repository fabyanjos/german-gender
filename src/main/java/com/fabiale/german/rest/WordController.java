package com.fabiale.german.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabiale.german.model.Gender;
import com.fabiale.german.model.ListWord;
import com.fabiale.german.model.Word;
import com.fabiale.german.service.WordService;

@Controller
public class WordController {
	
	@Autowired WordService service;
	
	
	@RequestMapping(value="/rest/word", produces={"application/json"})
	@ResponseBody
	public ListWord list() {
        ListWord list = new ListWord(service.getAll());
		return list;
	}
	
	@RequestMapping(value="/rest/word/masculine", produces={"application/json"})
	@ResponseBody
	public ListWord listMasculine() {
        ListWord list = new ListWord(service.getByGender(Gender.Masculine));
		return list;
	}
	
	private void add() {
		Word word1 = new Word();
		word1.setName("Lampe");
		word1.setImage("lampe.jpg");
		word1.setPlural("Lampen");
		word1.setGender(Gender.Feminine);
		service.create(word1);
		
		Word word2 = new Word();
		word2.setName("Stuhl");
		word2.setImage("stuhl.jpg");
		word2.setPlural("Stühlen");
		word2.setGender(Gender.Masculine);
		service.create(word2);
	}
}
