package com.xc.justforjoy.jdbc.exer;

public class Employee {

	private int id;
	private String lastName;
	private String eamil;
	int dept_id;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", eamil=" + eamil + ", dept_id=" + dept_id + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String lastName, String eamil, int dept_id) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.eamil = eamil;
		this.dept_id = dept_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

}
