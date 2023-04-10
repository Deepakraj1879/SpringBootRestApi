package com.deepak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.deepak.model.Customer;
import com.deepak.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer insert(Customer customer) {
		Customer insert = customerRepository.save(customer);
		return insert;
	}

	public Customer update(Customer customer, Integer id) {

		Customer update = customerRepository.save(customer);
		return update;
	}

	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}

	public Customer getById(Integer id) {
		Customer get = customerRepository.findById(id).get();
		return get;

	}

	public List<Customer> getAll() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	
	public List<Customer> findByAddress(String address) {
		// TODO Auto-generated method stub
		return customerRepository.findByAddress(address);
	}

	public Customer findByAge(Integer age) {
		// TODO Auto-generated method stub
		return customerRepository.findByAge(age);
	}

	
	public List<Customer> findByIdAndName(Integer id, String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByIdAndName(id, name);
	}

	
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.getAllCustomer();
	}

	
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerById(id);
	}

	
	public List<Customer> getCustomerByNameOrAddress(String name, String address) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerByNameOrAddress(name, address);
	}

	
	public List<Customer> getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerByName(name);
	}
	

	public List<String> getCustomerNames() {
		return  customerRepository.getCustomerNames();
	}
	
	
	
	
	
}
