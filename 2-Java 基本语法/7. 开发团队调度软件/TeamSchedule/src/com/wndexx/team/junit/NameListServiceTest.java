package com.wndexx.team.junit;

import org.junit.jupiter.api.Test;

import com.wndexx.team.domain.Employee;
import com.wndexx.team.service.NameListService;
import com.wndexx.team.service.TeamException;

/**
 * @Description 对 NameListService 类的测试
 * @author wndexx
 * @version
 * @date 2022年2月17日下午1:40:34
 */
public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		
		NameListService service = new NameListService();
		
		Employee[] employees = service.getAllEmployees();
		
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
		
	}
	
	@Test
	public void testGetEmployee() {
		
		NameListService service = new NameListService();
		
		int id = 1;
		id = 10;
		id = 101;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee.toString());
			
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
