package com.wndexx.team.domain;

import com.wndexx.team.service.Status;

/**
 * @Description 程序员
 * @author wndexx
 * @version
 * @date 2022年2月16日上午11:35:44
 */
public class Programmer extends Employee {
	/**
	 * 成员加入开发团队后在团队中的ID
	 */
	private int memberId;
	/**
	 * 成员的状态 FREE-空闲 BUSY-已加入开发团队 VOCATION-正在休假
	 */
	private Status status = Status.FREE;
	/**
	 * 该成员领用的设备
	 */
	private Equipment equipment;

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return getDetails() + "\t程序员\t" + status.toString() + "\t\t\t" + equipment.getDescription();
	}
	
	public String getTeamBaseDetail() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge()+ "\t" + getSalary();
	}
	
	public String getDetailsForTeam() {
		return getTeamBaseDetail() +"\t程序员";
	}
}
