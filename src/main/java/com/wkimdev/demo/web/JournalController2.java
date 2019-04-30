package com.wkimdev.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wkimdev.demo.domain.Journal;
import com.wkimdev.demo.repository.JournalRepository2;

@Controller
public class JournalController2 {
	
	@Autowired
	JournalRepository2 repo;
	
	//@RequestMapping(value = "/journal", produces = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping(value = "/journal", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody List<Journal> getJournal(){
		return repo.findAll();
	}
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("journal", repo.findAll());
		return "index";
	}
}
