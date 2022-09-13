package com.interview.model;

public class EmployeeResponse {

	private long id;
	private String name;
	private String firstName;
	private String lastName;
	private String gender;
	private String salary;
	private String position;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeResponse(long id, String name, String firstName, String lastName, String gender, String salary,
			String position) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.salary = salary;
		this.position = position;
	}
	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", salary=" + salary + ", position=" + position + "]";
	}
	

}
