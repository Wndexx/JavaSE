package com.wndexx.team.domain;

/**
 * @Description 设计师
 * @author wndexx
 * @version
 * @date 2022年2月16日上午11:40:54
 */
/**
 * @Description
 * @author wndexx
 * @version
 * @date 2022年2月17日下午1:49:29
 */
public class Designer extends Programmer {
	/**
	 * 奖金
	 */
	private Double bonus;

	public Designer(int id, String name, int age, double salary, Equipment equipment, Double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return getDetails() + "\t设计师\t" + getStatus().toString() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam() {
		return getTeamBaseDetail() +"\t设计师\t" + bonus;
	}
}
