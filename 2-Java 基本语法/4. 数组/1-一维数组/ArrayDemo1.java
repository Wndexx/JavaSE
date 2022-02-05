import java.util.Scanner;

public class ArrayDemo1 {

	public static void main(String[] args) {

		/*
			2. 从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
			
				成绩>=最高分-10    等级为’A’   
				成绩>=最高分-20    等级为’B’
				成绩>=最高分-30    等级为’C’   
				其余                               等级为’D’
				
			提示：先读入学生人数，根据人数创建int数组，存放学生成绩。
		*/
		
		Scanner scan = new Scanner(System.in);

		System.out.print("请输入学生人数：");
		int stuNumber = scan.nextInt();

		System.out.println("请输入 " + stuNumber + " 个成绩");

		int[] scores = new int[stuNumber];
		int maxScore = -1;

		for (int i = 0; i < stuNumber; i++) {
			scores[i] = scan.nextInt();
			if (maxScore < scores[i]) {
				maxScore = scores[i];
			}
		}

		System.out.println("最高分是：" + maxScore);

		char level;
		for (int i = 0; i < stuNumber; i++) {
			if (scores[i] >= maxScore - 10) {
				level = 'A';
			} else if (scores[i] >= maxScore - 20) {
				level = 'B';
			} else if (scores[i] >= maxScore - 30) {
				level = 'C';
			} else {
				level = 'D';
			}
			System.out.println("student " + i + " score is " + scores[i] + " grade is " + level);
		}

	}

}
