package com.kanth.springbootjerseydemo.bo;

public class Employee {

	private String empID;

	private String name;

	public Employee() {
	}

	private Integer age;

	private Long mobileno;

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public Employee(String empID, String name, Integer age, Long mobileno) {
		super();
		this.empID = empID;
		this.name = name;
		this.age = age;
		this.mobileno = mobileno;
	}

}
