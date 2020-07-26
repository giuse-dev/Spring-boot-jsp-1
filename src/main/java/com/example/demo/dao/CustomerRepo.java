package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	List<Customer> findBycName(String cName);
	List<Customer> findBycEmail(String cEmail);
	
	
}
