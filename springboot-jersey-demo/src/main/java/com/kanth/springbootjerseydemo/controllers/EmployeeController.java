package com.kanth.springbootjerseydemo.controllers;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kanth.springbootjerseydemo.bo.Employee;
import com.kanth.springbootjerseydemo.service.EmployeeListService;

/**
 * 
 * @author ramakanth.b
 *  example : http://localhost:9981/rest/api/getAllEmp
 */
@Component
@Path("/api")
public class EmployeeController {

	private static final String APPLICATIONJSON = "application/json";

	@Autowired
	private EmployeeListService employeeService;

	public EmployeeController(EmployeeListService employeeService) {
		this.employeeService = employeeService;
	}

	@GET
	@Path("/getAllEmp")
	@Produces(APPLICATIONJSON)
	public List<Employee> getAllEmployeesList() {
		return employeeService.getAllEmployees();
	}

	@GET
	@Path("/employeeData/{id}")
	@Produces(APPLICATIONJSON)
	public Employee getAllEmployeesList(@PathParam("id") String empid) {
		return employeeService.getEmpData(empid);
	}

	@POST
	@Path("/employeeData")
	@Consumes(APPLICATIONJSON)
	public Response insertEmpData(Employee emp) {
		employeeService.insertEmpData(emp);
		return Response.created(URI.create("/getEmp/" + emp.getEmpID())).build();
	}

	@PUT
	@Path("/employeeData")
	@Consumes(APPLICATIONJSON)
	public Response updateEmpDate(Employee emp) {
		employeeService.updateEmpData(emp);
		return Response.noContent().build();
	}

	@PATCH
	@Path("/employeeData")
	@Consumes(APPLICATIONJSON)
	public Response updateEmpBeanDate(Employee emp) {
		employeeService.updateEmpBeanData(emp);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/employeeData/{id}")
	public Response deleteEmployeeData(@PathParam("id") String empid) {
		employeeService.deleteEmp(empid);
		return Response.ok().build();
	}

}
