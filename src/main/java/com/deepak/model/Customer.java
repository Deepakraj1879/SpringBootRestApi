package com.deepak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	
	private Integer id;
	
	@Column(name="cust_name",columnDefinition="Varchar(60)" )
	@NotEmpty
	private String name;
	
	
	@Column(columnDefinition = "varchar(15)")
	@NotEmpty
	private String gender;
	
	@NotNull
	@Min(18)
	private Integer age;
	
	@Column(columnDefinition = "varchar(80)")
	@NotEmpty
	private String address;

}
