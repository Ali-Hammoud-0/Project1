package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import util.JDBCConnection;

public class DepartmentDAOImpl implements DepartmentDAO {
	public static Connection conn = JDBCConnection.getConnection();

	public Department getDept(int id) {
		try {
			String sql = "SELECT * FROM departments WHERE dep_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Department (	Integer.parseInt(rs.getString("DEP_ID")),
										rs.getString("DEP_NAME"),
										Integer.parseInt(rs.getString("DEP_HEAD"))
									);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Department> allDepts() {
		String sql = "SELECT * FROM departments ORDER BY dep_id ";
		List<Department> depts = new ArrayList<Department>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				depts.add(new Department (
							Integer.parseInt(rs.getString("DEP_ID")),
							rs.getString("DEP_NAME"),
							Integer.parseInt(rs.getString("DEP_HEAD"))
							));
			}
			return depts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
