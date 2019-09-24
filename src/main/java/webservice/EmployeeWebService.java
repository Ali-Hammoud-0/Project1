package webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Employee;
import model.Form;
import service.EmployeeService;
import service.FormService;
public class EmployeeWebService {
	public static ObjectMapper om = new ObjectMapper();
	public static Employee e = new Employee();
	
	public static void getCreds(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("id");
		String password = request.getParameter("pass");
		e = EmployeeService.getEmployee(username);
		try {
			String employeeJSON = om.writeValueAsString(e);
			response.getWriter().append(employeeJSON).close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
	}
	public static void initForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			String employeeJSON = om.writeValueAsString(e);
			response.getWriter().append(employeeJSON).close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public static void addForm(HttpServletRequest request, HttpServletResponse response) {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String event_date = request.getParameter("event_date");
		String event_location = request.getParameter("event_location");
		String event_description = request.getParameter("event_description");
		int cost = Integer.parseInt(request.getParameter("cost"));
		boolean grade_format = request.getParameter("grade_format").charAt(0) == 'g';
		String event_type = request.getParameter("event_type");
		String comments = request.getParameter("comments");
		Form f = new Form(999, emp_id, event_date, event_location, event_description, cost, grade_format ? 1 : 0, event_type, comments, 0, 0, 1, 10);
		FormService.addForm(f);
	}
	public static void initFormView(HttpServletRequest request, HttpServletResponse response) {
		List<Form> forms = FormService.allForms();
		List<Object> objects = new ArrayList<Object>();
		objects.add(e);
		objects.add(forms);
		try {
			String objectsJSON = om.writeValueAsString(objects);
			response.getWriter().append(objectsJSON).close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
