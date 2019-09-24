package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.JDBCConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static Connection conn = JDBCConnection.getConnection();

	public Employee getEmployee(int id) {
		try {
			String sql = "SELECT * FROM employees WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Employee( rs.getInt("emp_id"),
									 rs.getString("firstname"),
									 rs.getString("lastname"),
									 rs.getString("username"),
									 rs.getString("Password"),
									 rs.getInt("dep_id"),
									 rs.getInt("role"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Employee getEmployee(String username) {
		try {
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Employee( rs.getInt("emp_id"),
									 rs.getString("firstname"),
									 rs.getString("lastname"),
									 rs.getString("username"),
									 rs.getString("Password"),
									 rs.getInt("dep_id"),
									 rs.getInt("role"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> allEmployees() {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			String sql = "SELECT * FROM employees ORDER BY emp_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(new Employee(  rs.getInt("emp_id"),
											 rs.getString("firstname"),
											 rs.getString("lastname"),
											 rs.getString("username"),
											 rs.getString("Password"),
											 rs.getInt("dep_id"),
											 rs.getInt("role")));
			}
			return employees;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addEmployee(Employee emp) {
		try {
			String sql = "CALL create_employee(?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, emp.getFirstname());
			cs.setString(2, emp.getLastname());
			cs.setString(3, emp.getUsername());
			cs.setString(4, emp.getPassword());
			cs.setString(5, Integer.toString(emp.getDep_id()));
			cs.setString(6, Integer.toString(emp.getRole()));
			
			cs.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

}
