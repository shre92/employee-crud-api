package com.empproject.dao;

import java.util.List;

import com.empproject.model.Employee;

public interface EmployeeDao {
	
	List<Employee> getListOfEmployees();
	void saveEmployee(Employee employee);
	void deleteEmployee(Integer empId);
	
}
