package com.fabiale.german.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "genders")
@XmlRootElement
public class Gender implements Serializable {

	private static final long serialVersionUID = 4064262783442995949L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String gender;
	private String article;
	private String pluralArticle;
	@OneToMany(mappedBy = "gender")
	private List<Word> words;

	public Gender() {
	}

	public Gender(String gender, String article) {
		this.gender = gender;
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public String getPluralArticle() {
		return pluralArticle;
	}

	public void setPluralArticle(String pluralArticle) {
		this.pluralArticle = pluralArticle;
	}
}
