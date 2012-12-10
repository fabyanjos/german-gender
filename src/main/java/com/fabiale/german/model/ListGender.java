package com.fabiale.german.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListGender {
	
	private List<Gender> genders;
	
	public ListGender() {
	}

	public ListGender(List<Gender> genders) {
		super();
		this.genders = genders;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}
	

}
