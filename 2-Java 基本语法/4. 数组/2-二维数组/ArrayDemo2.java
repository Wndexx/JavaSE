package com.wndexx.exer;

import java.util.Scanner;

/**
 * 
 * @Description
 * @author wndexx
 * @version
 * @date 2022年2月3日下午1:58:11
 *
 */
public class ArrayDemo2 {

	public static void main(String[] args) {
		// 练习
		// 数组元素之和
		// arr = {{3, 5, 8}, {12, 9}, {7, 0, 6, 4}}
		int[][] arr = { { 3, 5, 8 }, { 12, 9 }, { 7, 0, 6, 4 } };

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}

		System.out.println(sum);

		System.out.println("****************************************");

		// int[] x, y[] 判断是否通过编译
		// x int 型一维数组 y int 型二维数组
		// x[0] = y; 否
		// y[0] = x; 是
		// y[0][0] = x; 否
		// x[0][0] = x; 否
		// y[0][0] = x[0]; 是
		// x = y; 否 ！！！      类型一样或者可以自动类型提升时，才可以赋值。 x [I@6d06d69c y [[I@15db9742  @前面的格式可以区分类型是否一致

		System.out.println("****************************************");

		// 打印 10 行杨辉三角
		// 杨辉三角
		// 第一行 1 个元素 第 n 行 n 个元素
		// 每一行第一个元素 最后一个元素 是 1
		// 第三行开始，非第一个元素和最后一个元素，满足 yh[i][j] = yh[i-1][j-1] + yh[i-1][j];

		int[][] yh = new int[10][];
		for (int i = 0; i < yh.length; i++) {
			yh[i] = new int[i + 1];
			for (int j = 0; j < yh[i].length; j++) {
				yh[i][j] = j == 0 || j == i ? 1 : yh[i - 1][j - 1] + yh[i - 1][j];
			}
		}

		for (int i = 0; i < yh.length; i++) {
			for (int j = 0; j < yh[i].length; j++) {
				System.out.print(yh[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("****************************************");

		// 笔试题
		// 创建长度6 int 型数组
		// 元素值在 1~30 之间
		// 各元素值各不相同
		int[] ran = new int[6];
		for (int i = 0; i < ran.length; i++) {
			l: while (true) {
				ran[i] = (int) (Math.random() * 30 + 1);
				for (int j = 0; j < i; j++) {
					if (ran[i] == ran[j]) {
						continue l;
					}
				}
				break l;
			}
		}

		for (int i = 0; i < ran.length; i++) {
			System.out.print(ran[i] + " ");
		}

		// 回形数
		/*
			System.out.println("请输入回形数：");

			Scanner scan = new Scanner(System.in);
			int plies = scan.nextInt();

			int[][] clip = new int[plies][plies];
			for (int i = 0; i < clip.length; i++) {
				for (int j = 0; j < clip[i].length; j++) {
					for (int k = 1; k < plies / 2 + 1; k++) {
						if (i + 1 == k && j + 1 >= k && j <= plies - k) {
							clip[i][j] = 4 * (plies * (k - 1)) - 4 * (k - 1) * (k - 1) + (j + 1) - (k - 1);
							break;
						} else if (j == plies - k && i + 1 >= k && i <= plies - k) {
							clip[i][j] = 4 * (plies * (k - 1)) - 4 * (k - 1) * (k - 1) + (plies + 2 * (1 - k)) + i - (k - 1);
							break;
						} else if (i == plies - k && j + 1 >= k && j <= plies - k) {
							clip[i][j] = 4 * (plies * (k - 1)) - 4 * (k - 1) * (k - 1) + (plies + 2 * (1 - k)) + (plies + 2 * (1 - k) - 1) + (plies - 1 - j) - (k - 1);
							break;
						} else if (j + 1 == k && i + 1 >= k && i <= plies - k) {
							clip[i][j] = 4 * (plies * (k - 1)) - 4 * (k - 1) * (k - 1) + (plies + 2 * (1 - k)) + (plies + 2 * (1 - k) - 1) + (plies + 2 * (1 - k) - 1) + (plies - 1 - i) - (k - 1);
							break;
						}
					}
					if (plies % 2 != 0) clip[plies / 2][plies / 2] = plies * plies;
					System.out.print(clip[i][j] + "\t");
				}
				System.out.println();
			}
		*/

	}

}
