package com.wndexx.team.service;

import com.wndexx.team.domain.Architect;
import com.wndexx.team.domain.Designer;
import com.wndexx.team.domain.Employee;
import com.wndexx.team.domain.Equipment;
import com.wndexx.team.domain.NoteBook;
import com.wndexx.team.domain.PC;
import com.wndexx.team.domain.Printer;
import com.wndexx.team.domain.Programmer;
import static com.wndexx.team.service.Data.*;

/**
 * @Description 负责将 Data 中的数据封装到 Employee[] 数组中，同时提供相关操作 Employee[] 的方法
 * @author wndexx
 * @version
 * @date 2022年2月16日下午2:16:46
 */
public class NameListService {
	/**
	 * 保存公司所有员工对象
	 */
	private Employee[] employees;

	/**
	 * 给 employees 数组及数组元素进行初始化
	 */
	public NameListService() {

		// 1. 根据项目提供的Data类构建相应大小的employees数组
		employees = new Employee[EMPLOYEES.length];

		// 2.
		// 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
		for (int i = 0; i < employees.length; i++) {

			// 获取员工的类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);

			// 获取 Employee 的 4 个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);

			Equipment equipment;
			double bonus;
			int stock;

			switch (type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}

	/**
	 * @Description 获取指定 index 上的员工的设备
	 * @author wndexx
	 * @date 2022年2月16日下午3:00:26
	 * @param i
	 * @return
	 */
	private Equipment createEquipment(int i) {

		int type = Integer.parseInt(EQUIPMENTS[i][0]);

		switch (type) {
		case PC:
			return new PC(EQUIPMENTS[i][1], EQUIPMENTS[i][2]);
		case NOTEBOOK:
			return new NoteBook(EQUIPMENTS[i][1], Double.parseDouble(EQUIPMENTS[i][2]));
		case PRINTER:
			return new Printer(EQUIPMENTS[i][1], EQUIPMENTS[i][2]);
		}

		return null;
	}

	/**
	 * @Description 获取当前所有员工
	 * @author wndexx
	 * @date 2022年2月16日下午3:01:47
	 * @return 包含所有员工对象的数组
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}

	/**
	 * @Description 获取指定ID的员工对象
	 * @author wndexx
	 * @date 2022年2月16日下午3:02:20
	 * @param id 指定员工的ID
	 * @return 指定员工对象
	 * @throws TeamException
	 */
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			// Integer 类型比较是否相等，一定要用 equals，即使存在 IntegerCache
			if (employees[i].getId() == id)
				return employees[i];
		}
		throw new TeamException("找不到指定的员工");
	}
}
