package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {	
	public Employee getEmployee(int id);
	public Employee getEmployee(String username);
	public List<Employee> allEmployees();
	public boolean addEmployee(Employee e);
	
}
