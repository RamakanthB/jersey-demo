package com.kanth.springbootjerseydemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.kanth.springbootjerseydemo.bo.Employee;
import com.kanth.springbootjerseydemo.util.BeanUtil;

@Component
public class EmployeeListService {

	private static final String DUMMY = "dummy";

	private Map<String, Employee> empMap = new HashMap<>();

	@PostConstruct
	public void setIntialEmpData() {
		this.empMap.put("001", new Employee("916", "Kanth", 27, 9886345345l));
		this.empMap.put("234", new Employee("916", "Sanjay", 29, 26646546434l));
		this.empMap.put("636", new Employee("916", "Anil", 17, 578457457457l));
		this.empMap.put("654", new Employee("916", "Vinod", 30, 865326446324l));
		this.empMap.put("134", new Employee("916", "VIkram", 40, 12475273134l));
		this.empMap.put(DUMMY, new Employee(DUMMY, DUMMY, 00, 00000000000l));
	}

	public Boolean updateEmpData(Employee emp) {

		try {
			if (empMap.containsKey(emp.getEmpID())) {
				this.empMap.put(emp.getEmpID(), emp);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean updateEmpBeanData(Employee emp) {

		try {
			if (empMap.containsKey(emp.getEmpID())) {
				Employee src = this.empMap.get(emp.getEmpID());
				BeanUtils.copyProperties(src, emp, BeanUtil.getNullPropertyNames(src));
				this.empMap.put(emp.getEmpID(), emp);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public void insertEmpData(Employee emp) {
		this.empMap.put(emp.getEmpID(), emp);
	}

	public Employee getEmpData(String id) {
		if (this.empMap.containsKey(id)) {
			return this.empMap.get(id);
		} else {
			return this.empMap.get(DUMMY);
		}

	}

	public Boolean deleteEmp(String id) {
		if (this.empMap.containsKey(id)) {
			this.empMap.get(id);
			return true;
		}
		return false;
	}

	public List<Employee> getAllEmployees() {
		return this.empMap.values().stream().collect(Collectors.toList());
	}
}
