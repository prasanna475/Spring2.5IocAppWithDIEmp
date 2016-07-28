package com.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	public void insertEmployeeData(Employee employee) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			pstmt = con.prepareStatement("insert into Employee values(?,?,?)");
			pstmt.setInt(1, employee.getEmpId());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setDouble(3, employee.getEmpSal());
			pstmt.executeUpdate();
			System.out.println("row inserted ");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					pstmt.close();
					con.close();
				} else {
					System.out.println("data base connection not opened");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}		
		
	}

	public List<Employee> fetchEmp(int empId) {
		List<Employee> employeeList=new ArrayList<Employee>();
       Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			pstmt=con.prepareStatement("select * from Employee where empId=?");
           pstmt.setInt(1, empId);
           rs=pstmt.executeQuery();
           while(rs.next()){
        	 Employee employee=new Employee();
           	    employee.setEmpId(rs.getInt("empId"));
           	 employee.setEmpName(rs.getString("empName"));
           	employee.setEmpSal(rs.getDouble("empSal"));
           	employeeList.add(employee);
           }
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					pstmt.close();
					con.close();
				} else {
					System.out.println("data base connection not opened");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return employeeList;

	}
}
