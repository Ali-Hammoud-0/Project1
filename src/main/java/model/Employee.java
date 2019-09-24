package model;

public class Employee {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int dep_id;
	private int role;	//1 = regular employee, 2 =supervisor, 3 = head of dept
	public Employee(int id, String firstname, String lastname, String username, String password, int dep_id, int role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.dep_id = dep_id;
		this.role = role;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getDep_id() {
		return dep_id;
	}
	public int getRole() {
		return role;
	}
	
	
}
