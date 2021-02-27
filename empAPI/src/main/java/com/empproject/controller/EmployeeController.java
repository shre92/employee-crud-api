package com.empproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empproject.model.Employee;
import com.empproject.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces="application/json")
	public List<Employee> getListOfEmployees(){
		return employeeService.getListOfEmployees();
	}
	
	@RequestMapping(value = "/employees/add", method = RequestMethod.POST, produces = "text/plain")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return "Employee Added SuccessFully......";
	}
	
	@RequestMapping(value = "/employees/update/{empId}", method = RequestMethod.PUT, produces = "text/plain")
	public String updateEmployee(@PathVariable("empId")Integer empId, @RequestBody Employee employee) {
		employee.setEmpId(empId);
		employeeService.saveEmployee(employee);
		return "Employee Updated SuccessFully......";
	}
	
	@RequestMapping(value = "/employees/delete/{empId}", method = RequestMethod.DELETE, produces = "text/plain")
	public String deleteEmployee(@PathVariable("empId")Integer empId) {
		employeeService.deleteEmployee(empId);
		return "Employee Deleted SuccessFully......";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces="text/html")
	public String apiHome(){
		StringBuilder sb = new StringBuilder();
		sb.append("<div align=\"center\">");
		sb.append("   <table>");
		sb.append("      <tr>");
		sb.append("         <td style=\"font-weight:bold;font-size:20px;\"> Employee Management API v0.0.1</td>");
		sb.append("      </tr>");
		sb.append("   </table>");
		sb.append("</div>");
		return sb.toString();
	}
}
