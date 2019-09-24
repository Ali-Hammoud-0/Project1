package model;

public class Department {
	private int id;
	private String name;
	private int head;	//this is the employee id that corresponds to this department's head
	
	public Department(int id, String name, int head) {
		super();
		this.id = id;
		this.name = name;
		this.head = head;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getHead() {
		return head;
	}
	
}
