package model;

public class Form {
	private int id;
	private int emp_id;
	private String event_date;
	private String event_location;
	private String event_description;
	private int cost;
	private int  grade_format;
	private String event_type;
	private String comments;
	private int override;
	private int grade;
	private int previous_approval;
	private int status;
	public Form(int id, int emp_id, String event_date, String event_location, String event_description, int cost,
			int grade_format, String event_type, String comments, int override, int grade, int previous_approval,
			int status) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.event_date = event_date;
		this.event_location = event_location;
		this.event_description = event_description;
		this.cost = cost;
		this.grade_format = grade_format;
		this.event_type = event_type;
		this.comments = comments;
		this.override = override;
		this.grade = grade;
		this.previous_approval = previous_approval;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public String getEvent_description() {
		return event_description;
	}
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getGrade_format() {
		return grade_format;
	}
	public void setGrade_format(int grade_format) {
		this.grade_format = grade_format;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getOverride() {
		return override;
	}
	public void setOverride(int override) {
		this.override = override;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getPrevious_approval() {
		return previous_approval;
	}
	public void setPrevious_approval(int previous_approval) {
		this.previous_approval = previous_approval;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Form [id=" + id + ", emp_id=" + emp_id + ", event_date=" + event_date + ", event_location="
				+ event_location + ", event_description=" + event_description + ", cost=" + cost + ", grade_format="
				+ grade_format + ", event_type=" + event_type + ", comments=" + comments + ", override=" + override
				+ ", grade=" + grade + ", previous_approval=" + previous_approval + ", status=" + status + "]";
	}
	
	
	
	
	
}


