package model;

import java.util.List;

import service.DepartmentService;
import service.EmployeeService;

public class Playground {

	public static void main(String args[]) {
		System.out.println("hello");
		Employee e = EmployeeService.getEmployee("shigal");
		System.out.println(e.getLastname());
		System.out.println(DepartmentService.getDept(1).getName());
		List<Employee> emps = EmployeeService.allEmployees();

		//Employee e = new Employee(999, "Game", "Genie", "genie", "galoob", 1, 2);
		//EmployeeService.addEmployee(e);
		
		List<Employee> emps2 = EmployeeService.allEmployees();
		
		for (Employee emp : emps) {
			System.out.println(emp.getUsername());
		}
		System.out.println();
		for (Employee emp : emps2) {
			System.out.println(emp.getUsername());
		}

	}
	
}
