package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Form;
import util.JDBCConnection;

public class FormDAOImpl implements FormDAO {
	public static Connection conn = JDBCConnection.getConnection();
	public Form getForm(int id) {
		try {
			String sql = "SELECT * FROM forms WHERE f_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Form (	rs.getInt("F_ID"),
									rs.getInt("EMP_ID"),
									rs.getString("EVENT_DATE"),
									rs.getString("EVENT_LOCATION"),
									rs.getString("EVENT_DESCRIPTION"),
									rs.getInt("COST"),
									rs.getInt("GRADE_FORMAT"),
									rs.getString("EVENT_TYPE"),
									rs.getString("COMMENTS"),
									rs.getInt("OVERRIDE"),
									rs.getInt("GRADE"),
									rs.getInt("PREVIOUS_APPROVAL"),
									rs.getInt("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Form> allForms() {
		String sql = "SELECT * FROM forms ORDER BY f_id ";
		List<Form> forms = new ArrayList<Form>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				forms.add(new Form (	rs.getInt("F_ID"),
										rs.getInt("EMP_ID"),
										rs.getString("EVENT_DATE"),
										rs.getString("EVENT_LOCATION"),
										rs.getString("EVENT_DESCRIPTION"),
										rs.getInt("COST"),
										rs.getInt("GRADE_FORMAT"),
										rs.getString("EVENT_TYPE"),
										rs.getString("COMMENTS"),
										rs.getInt("OVERRIDE"),
										rs.getInt("GRADE"),
										rs.getInt("PREVIOUS_APPROVAL"),
										rs.getInt("STATUS")));
			}
			return forms;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addForm(Form f) {
		String sql = "CALL create_form(?,?,?,?,?,?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			//TODO: fix these
			cs.setString(1, Integer.toString(f.getEmp_id()));
			cs.setString(2, f.getEvent_date());
			cs.setString(3, f.getEvent_location());
			cs.setString(4, f.getEvent_description());
			cs.setString(5, Integer.toString(f.getCost()));
			cs.setString(6, Integer.toString(f.getGrade_format()));
			cs.setString(7, f.getEvent_type());
			cs.setString(8, f.getComments());
			
			cs.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		return false;
	}
	
	
	public boolean updateForm(Form f) {
		try {
			String sql = "UPDATE forms SET emp_id = ?, " + "event_date = ?, " + "event_location  = ?, "
					+ "event_description = ?, " + "cost = ?, " + "grade_format = ?, " + "event_type = ?, "
					+ "comments = ?, " + "override = ?, " + "grade = ?, " + "previous_approval = ?, "
					+ "status = ? WHERE f_id = ?";
			//TODO: fix this
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,  Integer.toString(f.getEmp_id()));
			ps.setString(2, f.getEvent_date());
			ps.setString(3, f.getEvent_location());
			ps.setString(4, f.getEvent_description());
			ps.setString(5,  Integer.toString(f.getCost()));
			ps.setString(6,  Integer.toString(f.getGrade_format()));
			ps.setString(7, f.getEvent_type());
			ps.setString(8, f.getComments());
			ps.setString(9,  Integer.toString(f.getOverride()));
			ps.setString(10,  Integer.toString(f.getGrade()));
			ps.setString(11,  Integer.toString(f.getPrevious_approval()));
			ps.setString(12,  Integer.toString(f.getStatus()));
			ps.setString(13,  Integer.toString(f.getId()));
			
			ps.execute();	
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteForm(int id) {
		String sql = "DELETE FROM forms WHERE f_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  Integer.toString(id));
			
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
