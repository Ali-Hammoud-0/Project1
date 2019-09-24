package service;

import java.util.List;

import dao.EmployeeDAOImpl;
import model.Employee;

public class EmployeeService {
	public static EmployeeDAOImpl ed = new EmployeeDAOImpl();
	
	public static Employee getEmployee(int id) {
		return ed.getEmployee(id);
	}
	public static Employee getEmployee(String username) {
		return ed.getEmployee(username);
	}
	public static List<Employee> allEmployees() {
		return ed.allEmployees();
	}
	public static boolean addEmployee(Employee e) {
		return ed.addEmployee(e);
	}
}
