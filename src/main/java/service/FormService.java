package service;

import java.util.List;

import dao.FormDAOImpl;
import model.Form;

public class FormService {
	public static FormDAOImpl fd = new FormDAOImpl();
	
	public static Form getForm(int id) {
		return fd.getForm(id);
	}
	public static List<Form> allForms() {
		return fd.allForms();
	}
	public static boolean addForm(Form f) {
		return fd.addForm(f);
	}
	public static boolean updateForm(Form f) {
		return fd.updateForm(f);
	}
	public static boolean deleteForm(int id) {
		return fd.deleteForm(id);
	}
}
