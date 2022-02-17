package com.wndexx.team.view;

import com.wndexx.team.domain.Architect;
import com.wndexx.team.domain.Designer;
import com.wndexx.team.domain.Employee;
import com.wndexx.team.domain.Programmer;
import com.wndexx.team.service.NameListService;
import com.wndexx.team.service.TeamException;
import com.wndexx.team.service.TeamService;

public class TeamView {

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	/**
	 * @Description 主界面显示及控制方法
	 * @author wndexx
	 * @date 2022年2月16日下午4:08:04
	 */
	public void enterMainMenu() {
		char selection = 0;
		l: for (;;) {
			if(selection != '1')
				listAllEmployees();
			System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)：");

			selection = TSUtility.readMenuSelection();
			switch (selection) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N)：");
				char confirm = TSUtility.readConfirmSelection();
				if(confirm == 'Y') 
					break l;
			}
		}
	}

	/**
	 * @Description 以表格形式列出公司所有成员
	 * @author wndexx
	 * @date 2022年2月16日下午4:10:53
	 */
	private void listAllEmployees() {
		System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
		
		Employee[] employees = listSvc.getAllEmployees();
		
		if(employees == null || employees.length == 0) {
			System.out.println("没有任何员工的信息");
			return;
		}
		
		System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
		
		System.out.println("--------------------------------------------------------------------------------------");
	}

	/**
	 * @Description 显示团队成员列表操作
	 * @author wndexx
	 * @date 2022年2月16日下午4:11:47
	 */
	private void getTeam() {
		System.out.println("--------------------团队成员列表---------------------");
		
		Programmer team[] = teamSvc.getTeam();
		
		try {
			
			if (team == null || team.length == 0) {
				System.out.println("该开发团队没有成员");
				return;
			}
			
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\t");
			
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			} 
			
		} finally {
			System.out.println("-------------------------------------------------");
		}
	}

	/**
	 * @Description 添加成员操作
	 * @author wndexx
	 * @date 2022年2月16日下午4:12:31
	 */
	private void addMember() {
		System.out.println("---------------------添加成员----------------------");
		System.out.print("请输入要添加的员工ID: ");
		int id = TSUtility.readInt();
		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		// 按回车键继续...
		TSUtility.readReturn();
	}

	/**
	 * @Description 删除成员操作
	 * @author wndexx
	 * @date 2022年2月16日下午4:13:08
	 */
	private void deleteMember() {
		System.out.println("---------------------删除成员----------------------");
		System.out.print("请输入要删除的员工TID: ");
		int memberId = TSUtility.readInt();
		System.out.print("确认是否删除(Y/N)：");
		char confirm = TSUtility.readConfirmSelection();
		if(confirm == 'N')
			return;
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}
		// 按回车键继续...
		TSUtility.readReturn();
	}
}
