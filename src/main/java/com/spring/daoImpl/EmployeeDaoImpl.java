package com.spring.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Employee> getEmployees() {
		
		List<Employee> empList=new ArrayList<Employee>();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Employee");
		empList=query.list();
		
		return empList;
	}

	public int saveEmployee(Employee emp) {
		Session session=sessionFactory.openSession();
		int count=(Integer) session.save(emp);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return count;
	}

	public int deleteEmployee(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery q=session.createSQLQuery("delete from Employee where empId= ? ");
		q.setParameter(0, id);
		int i = q.executeUpdate();
		tx.commit();
		return i;
	}

	public int updateEmployee(Employee emp) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery q=session.createSQLQuery("update employee set empname='"+emp.getEmpName()+"',empcity='"+emp.getEmpCity()+"', empsal='"+emp.getEmpSal()+"' where empId='"+emp.getEmpId()+"'");
		
	    int x = q.executeUpdate();
		tx.commit();
		return x;
	}

	public Employee getEmployeeById(int id) {
		

		Employee emp=new Employee();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Employee where empId= ?");
		query.setParameter(0, id);
		emp=(Employee) query.uniqueResult();
		
		return emp;

}
}
