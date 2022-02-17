package com.wndexx.team.service;

import com.wndexx.team.domain.Architect;
import com.wndexx.team.domain.Designer;
import com.wndexx.team.domain.Employee;
import com.wndexx.team.domain.Programmer;

public class TeamService {
	/**
	 * 静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId
	 */
	private static int counter = 1;
	/**
	 * 开发团队最大成员数
	 */
	private final int MAX_MEMBER = 5;
	/**
	 * 保存当前团队中的各成员对象
	 */
	private Programmer[] team = new Programmer[MAX_MEMBER];
	/**
	 * 记录团队成员的实际人数
	 */
	private int total;

	/**
	 * @Description 返回当前团队的所有对象
	 * @author wndexx
	 * @date 2022年2月16日下午3:20:14
	 * @return 包含所有成员对象的数组，数组大小与成员人数一致
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < total; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/**
	 * @Description 向团队中添加成员
	 * @author wndexx
	 * @date 2022年2月16日下午3:23:13
	 * @param e 待添加成员的对象
	 * @throws TeamException
	 */
	public void addMember(Employee e) throws TeamException {
		if (total >= MAX_MEMBER)
			throw new TeamException("成员已满，无法添加");

		if (!(e instanceof Programmer))
			throw new TeamException("该成员不是开发成员，无法添加");

		if (isExists(e))
			throw new TeamException("该员工已在本开发团队中");

		if ("BUSY".equalsIgnoreCase(((Programmer) e).getStatus().getNAME()))
			throw new TeamException("该员工已是某团队成员");

		if ("VOCATION".equalsIgnoreCase(((Programmer) e).getStatus().getNAME()))
			throw new TeamException("该员工正在休假，无法添加");

		// 获取 team 已有成员中架构师，设计师，程序员的人数
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
				continue;
			}
			if (team[i] instanceof Designer) {
				numOfDes++;
				continue;
			}
			numOfPro++;
		}

		// if (e instanceof Architect) {
		// if (numOfArch >= 1)
		// throw new TeamException("团队中至多只能有一名架构师");
		// } else if (e instanceof Designer) {
		// if (numOfDes >= 2)
		// throw new TeamException("团队中至多只能有两名设计师");
		// } else if (e instanceof Programmer) {
		// if (numOfPro >= 3)
		// throw new TeamException("团队中至多只能有三名程序员");
		// }

		// add(e);

		// 错误的
		// if(e instanceof Architect && numOfArch >= 1)
		// throw new TeamException("团队中至多只能有一名架构师");
		// else if(e instanceof Designer && numOfDes >= 2)
		// throw new TeamException("团队中至多只能有两名设计师");
		// else if(e instanceof Programmer && numOfPro >= 3)
		// throw new TeamException("团队中至多只能有三名程序员");

		if (e instanceof Architect) {
			if (numOfArch >= 1)
				throw new TeamException("团队中至多只能有一名架构师");
			add(e);
			return;
		}

		if (e instanceof Designer) {
			if (numOfDes >= 2)
				throw new TeamException("团队中至多只能有两名设计师");
			add(e);
			return;
		}

		if (e instanceof Programmer) {
			if (numOfPro >= 3)
				throw new TeamException("团队中至多只能有三名程序员");
			add(e);
		}
	}

	/**
	 * @Description 判断指定的员工是否已经存在于现有的开发团队中
	 * @author wndexx
	 * @date 2022年2月17日下午2:37:47
	 * @param e
	 * @return
	 */
	private boolean isExists(Employee e) {
		for (int i = 0; i < total; i++) {
			if (e.getId() == team[i].getId())
				return true;
		}
		return false;
	}

	/**
	 * @Description 当满足添加条件时，将员工加入团队
	 * @author wndexx
	 * @date 2022年2月17日下午3:12:08
	 * @param e
	 */
	private void add(Employee e) {
		Programmer p = (Programmer) e;
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		team[total++] = p;
	}

	/**
	 * @Description 从团队中删除成员
	 * @author wndexx
	 * @date 2022年2月16日下午3:24:40
	 * @param memberId 待删除成员的 memberId
	 * @throws TeamException
	 */
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}

		if (i == total)
			throw new TeamException("找不到指定员工，删除失败");

		for (int j = i; j < total - 1; j++) {
			team[j] = team[j + 1];
		}
		team[--total] = null;
	}
}
