package com.example.demo.service;

import com.example.demo.result.EmployeeDTO;
import com.example.demo.result.Result;

public interface EmployeeService {
	public Result findAllEmployees();

	public Result findEmployeeByEmail(String email);

	public Result addEmployee(EmployeeDTO employeeDTO);
}
