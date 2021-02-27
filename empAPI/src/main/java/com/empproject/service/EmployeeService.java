package com.empproject.service;

import java.util.List;

import com.empproject.model.Employee;

public interface EmployeeService {

	List<Employee> getListOfEmployees();
	void saveEmployee(Employee employee);
	void deleteEmployee(Integer empId);
}
