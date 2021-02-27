package com.empproject.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empproject.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Employee> getListOfEmployees() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		criteriaQuery.from(Employee.class);
		return getSession().createQuery(criteriaQuery).getResultList();
	}

	public void saveEmployee(Employee employee) {
		getSession().saveOrUpdate(employee);
	}

	public void deleteEmployee(Integer empId) {
		 CriteriaBuilder cb = getSession().getCriteriaBuilder();
         CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
         Root<Employee> e = delete.from(Employee.class);
         delete.where(cb.equal(e.get("empId"), empId));
         getSession().createQuery(delete).executeUpdate();
	}

}
