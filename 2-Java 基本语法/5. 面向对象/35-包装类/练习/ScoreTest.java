package com.wndexx.exer4;

import java.util.Scanner;
import java.util.Vector;

import org.junit.Test;

/*
	利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
	
	提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。而向量类java.util.Vector可以根据需要动态伸缩。
	
	创建 Vector 对象：Vector v = new Vector();
	
	给向量添加元素：v.addElement(Object obj); // obj必须是对象
	
	取出向量中的元素：Object obj = v.elementAt(0);
	
	注意第一个元素的下标是0，返回值是Object类型的。
	
	计算向量的长度：v.size();
	
	若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等
	
 */
public class ScoreTest {

	@Test
	public void test1() {
		// 1. 实例化 Scanner ，用于从键盘获取学生成绩
		Scanner scanner = new Scanner(System.in);

		// 2. 创建 Vector 对象，相当于原来的数组
		Vector v = new Vector();

		// 3. 通过 for(;;) 或 while(true) 方式，给 Vector 添加数据
		System.out.println("请输入学生成绩(负数代表结束)：");
		int maxScore = -1;
		for (;;) {
			int score = scanner.nextInt();

			// 当输入是负数时，跳出循环
			if (score < 0)
				break;
			if (score > 100) {
				System.out.println("输入的数据非法，请重新输入");
				continue;
			}

			// 添加数据
			// jdk 5.0 之前：
			// Integer inScore = new Integer(score);
			// v.addElement(inScore); // 多态
			// jdk 5.0 之后：
			v.addElement(score); // 自动装箱

			// 获取学生成绩的最大值
			if (maxScore < score)
				maxScore = score;
		}

		// 4. 遍历 Vector ，得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级
		char level;
		for (int i = 0; i < v.size(); i++) {

			// jdk 5.0 之前：
			// Integer inScore = (Integer)v.elementAt(i);
			// int score = inScore.intValue();

			// jdk 5.0 之后：
			 int score = (Integer) v.elementAt(i); // 自动拆箱
			// 或
			//int score = (int) v.elementAt(i);

			if (maxScore - score <= 10) {
				level = 'A';
			} else if (maxScore - score <= 20) {
				level = 'B';
			} else if (maxScore - score <= 30) {
				level = 'C';
			} else {
				level = 'D';
			}
			System.out.println("student-" + i + " score is " + score + ", level is " + level);
		}
	}
}
