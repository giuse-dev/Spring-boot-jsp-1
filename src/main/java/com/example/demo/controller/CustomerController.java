package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CustomerRepo;
import com.example.demo.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepo repo;
	
	@GetMapping("/add")
	public String addCustomer() {
		return "AddCustomer.jsp";
	}
	
	@PostMapping("/add")
	public String addCustomer(@RequestParam("cid") Integer cid,
							@RequestParam("cname") String cname,
							@RequestParam("cemail") String cemail) {
		Customer customer = new Customer(cid, cname, cemail);
		
		repo.save(customer);
		
		return "AddCustomer.jsp";
	}
	
	
	@GetMapping("/search")
	public String searchCustomer() {
		return "SearchCustomer.jsp";
	}
	
	
	@PostMapping("/show")
	public ModelAndView showCustomer(@RequestParam("cid") Integer cid) {
		ModelAndView mv = new ModelAndView();
		Customer customer = repo.findById(cid).orElse(null);
		
		mv.addObject("customerName", customer.getcName());
		mv.addObject("customerEmail", customer.getcEmail());
		mv.setViewName("ShowCustomer.jsp");
		return mv;
	}
}
