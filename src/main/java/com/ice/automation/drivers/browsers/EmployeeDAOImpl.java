package com.ice.automation.drivers.browsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistEmployee(Employee employee) {
        sessionFactory.getCurrentSession().persist(employee);
	}

	@Override
	public Employee findEmployeeById(String id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);

	}
	@Override
	public void deleteEmployee(Employee employee) {
	sessionFactory.getCurrentSession().delete(employee);

	}

}