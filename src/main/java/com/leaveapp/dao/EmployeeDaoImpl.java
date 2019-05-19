package com.leaveapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leaveapp.bean.Employee;
import com.leaveapp.bean.Leave;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public int applylve(Leave lvedet) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, lvedet.getEmpid());
		int empid = lvedet.getEmpid();
		lvedet.setMgrid(employee.getMgrid());
		lvedet.setEmpname(employee.getName());
		int leavebal = employee.getLeavebal() - lvedet.getNoofdays();
		lvedet.setLvebal(leavebal);

		employee = (Employee) session.load(Employee.class, lvedet.getEmpid());
		employee.setLeavebal(leavebal);
		int retval = (int) session.save(lvedet);
		String sql = "update leavedetails set lvebal = " + leavebal + " where empid=" + empid;
		session.createSQLQuery(sql).executeUpdate();
		return retval;
	}

	public List<Employee> getEmployee() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> list = session.createCriteria(Employee.class).list();
		return list;
	}

	public Employee findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}

	public Employee findMgrById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		int mgrid = employee.getMgrid();
		employee = (Employee) session.get(Employee.class, mgrid);
		return employee;
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = findById(id);
		session.delete(employee);
	}

	public List<Leave> getLveDet(int empno) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Criteria criteria = session.createCriteria(Leave.class);
		Criterion c1 = Restrictions.eq("empid", empno);
		criteria.add(c1);
		List<Leave> list = criteria.list();
		return list;
	}

	public List<Leave> getrptLveDet(int empno) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Criteria criteria = session.createCriteria(Leave.class);
		Criterion c1 = Restrictions.eq("mgrid", empno);
		criteria.add(c1);
		Criterion c2 = Restrictions.eq("status", "Pending");
		criteria.add(c2);
		List<Leave> list = criteria.list();
		return list;
	}

	public int aprvelve(Leave lvedet) {
		Session session = sessionFactory.getCurrentSession();
		String status = lvedet.getStatus();
		String mgrcmnt = lvedet.getMgrcmnt();
		Leave lvedet1 = (Leave) session.load(Leave.class, lvedet.getId());
		lvedet1.setStatus(status);
		lvedet1.setMgrcmnt(mgrcmnt);
		if (status.equals("Denied")) {
			Employee employee = (Employee) session.get(Employee.class, lvedet.getEmpid());
			int leavebal = employee.getLeavebal() + lvedet.getNoofdays();
			employee = (Employee) session.load(Employee.class, lvedet.getEmpid());
			employee.setLeavebal(leavebal);
			lvedet1.setLvebal(leavebal);
			String sql = "update leavedetails set lvebal = " + leavebal + " where empid=" + lvedet.getEmpid();
			session.createSQLQuery(sql).executeUpdate();
		}
		return (lvedet.getId());
	}

}
