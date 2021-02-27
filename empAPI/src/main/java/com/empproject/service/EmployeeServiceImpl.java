package com.empproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empproject.dao.EmployeeDao;
import com.empproject.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getListOfEmployees() {
		return employeeDao.getListOfEmployees();
	}

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}


	public void deleteEmployee(Integer empId) {
		employeeDao.deleteEmployee(empId);
	}
}
