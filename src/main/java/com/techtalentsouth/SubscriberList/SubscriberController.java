package com.techtalentsouth.SubscriberList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubscriberController {
	
	@Autowired
	SubscriberRepository repository;
	
	@GetMapping(value="/")
	public String index(Subscriber subscriber) {
		return "subscriber/index";
	}
	
	@GetMapping("/{userName}")
	public String showSubscriberPage(Subscriber subscriber, Model model) {
		
		Subscriber found = repository.findByUserName(subscriber.getUserName());
		System.out.println(found);
		model.addAttribute("firstName", found.getFirstName());
		
		return "subscriber/user";
	}
	
	@PostMapping("/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		repository.save(new Subscriber( subscriber.getFirstName(), 
		        subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignUp()));
			model.addAttribute("firstName", subscriber.getFirstName());
			model.addAttribute("lastName", subscriber.getLastName());
			model.addAttribute("userName", subscriber.getUserName());
		return "subscriber/result";
	}

}
