package com.fabiale.german.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabiale.german.model.Article;
import com.fabiale.german.model.Gender;
import com.fabiale.german.model.ListWord;
import com.fabiale.german.model.Word;
import com.fabiale.german.service.WordService;

@Controller
public class WordController {
	
	@Autowired WordService service;
	
	@RequestMapping(value="/")
	 public String index() {
	  return "index.jsp";
	 }
	
	@RequestMapping(value="/rest/word", produces={"application/json"})
	@ResponseBody
	public ListWord list() {
        ListWord list = new ListWord(service.getAll());
		return list;
	}
	
	@RequestMapping(value="/rest/word/random", produces={"application/json"})
	@ResponseBody
	public Word random() {
		return service.getRandom();
	}
	
	@RequestMapping(value="/rest/word/xml", produces={"application/xml"})
	@ResponseBody
	public Word xml() {
		return service.getRandom();
	}
	
	@RequestMapping(value="/rest/word/masculine", produces={"application/json"})
	@ResponseBody
	public ListWord listMasculine() {
        ListWord list = new ListWord(service.getByGender(Gender.Masculine));
        this.add();
		return list;
	}
	
	private void add() {
		Word word1 = new Word();
		word1.setName("Lampe");
		word1.setImage("lampe.jpg");
		word1.setPlural("Lampen");
		word1.setGender(Gender.Feminine);
		word1.setArticle(Article.Die);
		service.create(word1);
		
		Word word2 = new Word();
		word2.setName("Stuhl");
		word2.setImage("stuhl.jpg");
		word2.setPlural("Stühlen");
		word2.setGender(Gender.Masculine);
		word2.setArticle(Article.Der);
		service.create(word2);
		
		Word word3 = new Word();
		word3.setName("Kamera");
		word3.setImage("kamera.jpg");
		word3.setPlural("Kameras");
		word3.setGender(Gender.Feminine);
		word3.setArticle(Article.Die);
		service.create(word3);
		
		Word word4 = new Word();
		word4.setName("Waschbecken");
		word4.setImage("waschbecken.jpg");
		word4.setPlural("Waschbecken");
		word4.setGender(Gender.Neutral);
		word4.setArticle(Article.Das);
		service.create(word4);
	}
}
