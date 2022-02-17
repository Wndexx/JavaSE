package com.wndexx.team.domain;

/**
 * @Description 架构师
 * @author wndexx
 * @version
 * @date 2022年2月16日上午11:41:06
 */
public class Architect extends Designer {
	/**
	 * 公司奖励的股票数量
	 */
	private int stock;

	public Architect(int id, String name, int age, double salary, Equipment equipment, Double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return getDetails() + "\t架构师\t" + getStatus().toString() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam() {
		return getTeamBaseDetail() + "\t架构师\t" + getBonus() + "\t" + stock;
	}
}
