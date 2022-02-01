/*

	1. 退出循环结构

		循环条件 false

		break


	2. 输出结果

		l:for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 10; j++) {
				if (j % 4 == 0) {
	 				continue l;
				}
				System.out.print(j);
			}
			System.out.println(); 
		}

		// 123123123123


	3. 1000 以内所有完数
	// 完数 因子之和等于该数  6 = 1 + 2 + 3
 	// 因子 除去该数本身的其它约数

	 	for (int i = 1; i <= 1000; i++) {
	 		int sum = 0;
			for (int j = 1; j <= i/2; j++) {
				if (i % j == 0) sum += j;
			}
			if (i == sum) System.out.print(i + ' ');
	 	}


 	4. break continue 相同点 不同点

	 	相同点 	其后不能声明语句，编译不通过

	 	不同点 	break      switch-case 、循环结构    跳出当前循环 

	 		    continue   循环结构 				   跳出当次循环


*/