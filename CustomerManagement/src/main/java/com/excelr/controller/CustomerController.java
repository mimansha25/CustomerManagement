package com.excelr.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Customer;
import com.excelr.exception.IdNotFoundException;
import com.excelr.service.CustomerService;

@CrossOrigin
@RestController

@RequestMapping("qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp")
public class CustomerController {

	@Autowired
		CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addProduct(@RequestBody Customer product)
	{
		return new ResponseEntity<Customer>(customerService.addCustomer(product), HttpStatus.OK);
		
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllProducts()
	{
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(), HttpStatus.OK);
	}
	
	
	@GetMapping("/customer{id}")
	public ResponseEntity<Customer> getProductById(@PathVariable int id)
	{
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/customer{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		return new ResponseEntity<String>(customerService.deleteCustomer(id), HttpStatus.OK);
	}
	 
	@PutMapping("/customer{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Customer product)
	{
		return new ResponseEntity<String>(customerService.updateCustomer(id, product), HttpStatus.OK);
	}
	
	
	
	
}
