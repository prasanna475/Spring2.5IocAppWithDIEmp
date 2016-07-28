package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		Employee employee = getEmployee();
		employeeService.insertEmployeeData(employee);
		List<Employee> employeeList = employeeService.getEmployeeData(1234);
		System.out.println(employeeList);
	}

	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmpId(1234);
		employee.setEmpName("sandy");
		employee.setEmpSal(1400.0);
		return employee;
	}

}
