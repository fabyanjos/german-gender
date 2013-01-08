package com.fabiale.german.model;

public enum Gender {

	Masculine("Masculine", "der", "die"), Feminine("Feminie", "die", "die"), Neutral("Neutral", "das", "das");

	private String name;
	private String article;
	private String pluralArticle;

	private Gender(String name, String article, String pluralArticle) {
		this.name = name;
		this.article = article;
		this.pluralArticle = pluralArticle;
	}

	public String getName() {
		return name;
	}

	public String getArticle() {
		return article;
	}

	public String getPluralArticle() {
		return pluralArticle;
	}
	
	public String toString() {
        return name;
    }
}
