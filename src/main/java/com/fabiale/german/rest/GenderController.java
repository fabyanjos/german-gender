package com.fabiale.german.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabiale.german.model.ListGender;
import com.fabiale.german.service.GenderService;

@Controller
public class GenderController {
	
	@Autowired GenderService service;
	
	
	@RequestMapping(value="/rest/gender", produces={"application/xml"})
	@ResponseBody
	public ListGender listGender() {
        
//        Gender g = new Gender("Feminine", "die");
//        Integer id = service.create(g);
//        System.out.println("Newly created Item Id="+id);
        
        ListGender list = new ListGender(service.getAll());
        
		return list;
	}

}
