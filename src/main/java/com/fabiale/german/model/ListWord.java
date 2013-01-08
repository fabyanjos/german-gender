package com.fabiale.german.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListWord {

	private List<Word> words;

	public ListWord() {
	}

	public ListWord(List<Word> words) {
		this.words = words;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

}
