package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/customer/all")
	@ResponseBody
	public List<Customer> getAllCustomers(){
		return repo.findAll();
	}
	
	@GetMapping("/customer/{cid}")
	@ResponseBody
	public Customer getSingleCustomer(@PathVariable("cid") Integer cid) {
		Customer customer = repo.findById(cid).orElse(null);
		return customer;
	}
	
	@PostMapping("/customer/create")
	public void createCustomer(@RequestBody Customer customer) {
		repo.save(customer);
	}
	
	@DeleteMapping("/customer/delete/{cid}")
	public void deleteCustomer(@PathVariable("cid") Integer cid) {
		Customer customer = repo.findById(cid).orElseThrow(() -> new IllegalArgumentException("customer's id not found"));
		repo.delete(customer);
	}
	
	@PutMapping(path = "/customer/update" , consumes = {"application/json"})
	public void updateCustomer(@RequestBody Customer customer) {
		repo.save(customer);
	}
	
}