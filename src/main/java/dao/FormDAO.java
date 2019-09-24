package dao;

import java.util.List;

import model.Form;

public interface FormDAO {
	public Form getForm(int id);
	public List<Form> allForms();
	public boolean addForm(Form f);
	public boolean updateForm(Form f);
	public boolean deleteForm(int id);
}
