package com.example.demo.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.EmployeeDAO;

@Controller
public class DatabaseHealthService implements HealthIndicator{

	@Autowired
	EmployeeDAO employeeDAO;
	public boolean healthCheck() {
		if(employeeDAO.findAll().isEmpty()) {
			return false;
		}
		return true;
	}
	@Override
	public Health health() {
		if(healthCheck()) {
			return Health.up().withDetail("5432", "Servie is UP").build();
		}
		return Health.down().withDetail("It's down", "Port 5432").build();
	}

}
