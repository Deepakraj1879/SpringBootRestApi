
package com.deepak.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.deepak.model.Customer;

public interface CustomerService {

	public Customer insert(Customer customer);

	public Customer update(Customer customer, Integer id);

	public void delete(Integer id);

	public Customer getById(Integer id);

	public List<Customer> getAll();
	
	public List<Customer> findByAddress(String address);
	
	public Customer findByAge(Integer age);
	
	public List<Customer> findByIdAndName(Integer id,String name);
	
	public List<Customer> getAllCustomer();
	
	public Customer getCustomerById(Integer id);
	
	public List<Customer> getCustomerByNameOrAddress(String name,String address);
	
	public List<Customer> getCustomerByName(String name);
	
	public List<String> getCustomerNames();

	
	
	

}
