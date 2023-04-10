package com.deepak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepak.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	//custom methods
	
	public List<Customer> findByAddress(String address);
	
	public Customer findByAge(Integer age);
	
	public List<Customer> findByIdAndName(Integer id,String name);

	// using jpql(java persistence query language)
	
	@Query("select c from Customer c")
	public List<Customer> getAllCustomer();
	
	//id is bind to variable i(where condition) using @param annotation and c is like alias name
	@Query("select c from Customer c where c.id=:i")  
	public Customer getCustomerById(@Param("i")Integer id);
	
	@Query("select c from Customer c where c.name=:n OR c.address=:a")
	public List<Customer> getCustomerByNameOrAddress(@Param("n")String name,
			                                 @Param("a")String address);
	
	@Query(value="select * from Customer cust where cust.cust_name=:name",
			nativeQuery = true)
	public List<Customer> getCustomerByName(String name);
	
	
	@Query(value="select cust_name from Customer cust",
			nativeQuery = true)
	public List<String> getCustomerNames();
	
	
	
	
	
	
	
	
	
	
	
}
