package com.excelr.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Customer;
import com.excelr.exception.IdNotFoundException;
import com.excelr.exception.InValidFirstnameOrLastnameException;
import com.excelr.exception.NotDeleted;
import com.excelr.repository.CustomerRepository;
import com.excelr.utility.AppConstant;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		if(customer.getFirst_name() ==""|| customer.getLast_name()=="")
		{
			throw new InValidFirstnameOrLastnameException(AppConstant.FIRSTNAME_OR_LASTNAME_NOT_FOUND_MESSAGE);
		}
		
		
	    Customer customer2=customerRepository.save(customer);
		return customer2;
	}

	
	@Override
	public List<Customer> getAllCustomer() {
		 
		return customerRepository.findAll();
	}
	
	

	@Override
	public Customer getCustomerById(int id) {
	   Optional<Customer> optionalCustomer =  customerRepository.findById(id);
	  Customer customer=null;
	  
	  if(optionalCustomer.isPresent())
	   {
		   customer= optionalCustomer.get();
	   }
	  else
	  {
		  throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
	  }
		
		return customer;
	}

	
	
	@Override
	public String deleteCustomer(int id) {
		String msg="";
		   if(customerRepository.existsById(id))
		   {
			   customerRepository.deleteById(id);
			   msg="200, Successfully customer deleted";
		   }
		   else if(customerRepository.existsById(id)) {
			   throw new NotDeleted(AppConstant.NOT_DELETED_MESSAGE);
		   }
		   else
		   {
			   throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
			  
		   }
		
		return msg;
	}

	
	
	@Override
	public String updateCustomer(int id, Customer customer) {
		String msg="";
		   if(customerRepository.existsById(id))
		   {
			    Customer product2 = customerRepository.findById(id).get();
			    product2.setFirst_name(customer.getFirst_name());
			    product2.setLast_name(customer.getLast_name());;
			    product2.setStreet(customer.getStreet());
			    product2.setAddress(customer.getAddress());
			    product2.setCity(customer.getCity());
			    product2.setState(customer.getState());
			    product2.setEmail(customer.getEmail());
			    product2.setPhone(customer.getPhone());
			    
			    customerRepository.save(product2);
			    msg="customer successfully updated";
			    
		   }
		   else
		   {
			   throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
		   }
		return msg;
	}

	

}
