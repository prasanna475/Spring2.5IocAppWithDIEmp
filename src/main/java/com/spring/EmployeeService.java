package com.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {
   private EmployeeDAO employeeDAO;

public EmployeeDAO getEmployeeDAO() {
	return employeeDAO;
}

public void setEmployeeDAO(EmployeeDAO employeeDAO) {
	this.employeeDAO = employeeDAO;
}

public void insertEmployeeData(Employee employee) {
	employeeDAO.insertEmployeeData(employee);
}

public List<Employee> getEmployeeData(int empId) {
	List<Employee> employeeList=employeeDAO.fetchEmp(empId);
	List<Employee> uni=fileterEmps(employeeList);
	return uni;
}

private List<Employee> fileterEmps(List<Employee> employeeList) {
     List<Employee> l=new ArrayList<Employee>();
     Map<Integer,Employee> m=new HashMap<Integer,Employee>();
     for(Employee uniq:employeeList){
    	 if(!m.containsKey(uniq.getEmpId())){
    		 m.put(uniq.getEmpId(), uniq);
    	 }
     }
     l.addAll(m.values());
    //return new ArrayList<Employee>(m.values());
	return l;
}

}
