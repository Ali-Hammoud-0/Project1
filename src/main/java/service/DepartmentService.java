package service;

import java.util.List;

import dao.DepartmentDAOImpl;
import model.Department;

public class DepartmentService {
	public static DepartmentDAOImpl dd = new DepartmentDAOImpl();
	public static Department getDept(int id) {
		return dd.getDept(id);
	}
	public static List<Department> allDepts() {
		return dd.allDepts();
	}
}
