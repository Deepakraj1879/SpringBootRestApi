package com.deepak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.model.Customer;
import com.deepak.service.CustomerService;
import com.deepak.service.CustomerServiceImpl;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/save")
	public String customer(@Valid  @RequestBody Customer customer) {
		Customer save = service.insert(customer);
		String message = null;
		if (save != null) {
			message = "customer saved successfully";
		} else {
			message = "no record in database";
		}
		return message;
	}

	@PutMapping("/update/{id}")
	public Customer update(@Valid @RequestBody Customer customer, @PathVariable Integer id) {
		Customer cust = service.update(customer, id);
		return cust;
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@GetMapping("/get/{id}")
	public Customer getById(@PathVariable Integer id) {
		Customer customer = service.getById(id);
		return customer;
	}

	@GetMapping("/getAll")
	public List<Customer> findAll() {
		List<Customer> list = service.getAll();
		return list;
	}

	// custom methods

	@GetMapping("/getCity/{address}")
	public List<Customer> getCustomerByCity(@PathVariable String address) {
		return service.findByAddress(address);
	}

	@GetMapping("/getAge/{age}")
	public Customer getCustomerByAge(@PathVariable Integer age) {
		return service.findByAge(age);
	}

	@GetMapping("/getCustomer/{id}/{name}")
	public List<Customer> getCustomerByIdAndName(@PathVariable Integer id, @PathVariable String name) {
		return service.findByIdAndName(id, name);
	}

	// jpql

	@GetMapping("/getAllCustomerUsingJpql")
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
	}

	@GetMapping("/getCustomerByIdUsingJpql/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		return service.getCustomerById(id);
	}

	@GetMapping("/getByNameOrAddress/{name}/{address}")
	public List<Customer> findByNameOrAddress(@PathVariable String name, @PathVariable String address) {
		return service.getCustomerByNameOrAddress(name, address);
	}
	
	@GetMapping("/getByNameUsingNative/{name}")
	public List<Customer> getAllByName(@PathVariable String name)
	{
		return service.getCustomerByName(name);
	}
	
	
	@GetMapping("/getNames")
	public List<String> getCustomerNames() {
		return  service.getCustomerNames();
	}
	
	

	
}
