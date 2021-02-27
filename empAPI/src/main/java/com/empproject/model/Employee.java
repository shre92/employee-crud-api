package com.empproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	private Integer empId;
	private String empFirstname;
	private String empLastname;
	private String empMobile;
	private String empAddress;
	private String empGender;
	private Double empAnnualSalary;
	private String empEmail;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id", nullable = false)
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	@Column(name = "emp_firstname")
	public String getEmpFirstname() {
		return empFirstname;
	}
	public void setEmpFirstname(String empFirstname) {
		this.empFirstname = empFirstname;
	}
	
	@Column(name = "emp_lastname")
	public String getEmpLastname() {
		return empLastname;
	}
	public void setEmpLastname(String empLastname) {
		this.empLastname = empLastname;
	}
	
	@Column(name = "emp_mobile")
	public String getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	
	@Column(name = "emp_address")
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	@Column(name = "emp_gender")
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	
	@Column(name = "emp_annual_salary")
	public Double getEmpAnnualSalary() {
		return empAnnualSalary;
	}
	public void setEmpAnnualSalary(Double empAnnualSalary) {
		this.empAnnualSalary = empAnnualSalary;
	}
	
	@Column(name = "emp_email")
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
}
