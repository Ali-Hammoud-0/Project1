package dao;

import java.util.List;

import model.Department;

public interface DepartmentDAO {
	public Department getDept (int id);
	public List<Department> allDepts();
}
