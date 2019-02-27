package com.kanth.springbootjerseydemo.bo;

public class Employee {

	private String empID;

	private String name;

	private Integer age;

	private Long mobileno;

	public String getEmpID() {
		return empID;
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
