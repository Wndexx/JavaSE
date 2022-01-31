/*
	分支结构

		条件判断结构 if-else

			// 结构1
			if (条件表达式) {
		
			}

		
			// 结构2		二选一
			if (条件表达式) {
				表达式1
			} else {
				表达式2
			}


			// 结构3		多选一
			if (条件表达式1) {
				表达式1
			} else if (条件表达式2) {
				表达式2
			} else if (条件表达式3) {
				表达式3
			}
			...
			 else {
		
			}
			

		注意
		
			else 可省略
			
			条件表达式之间互斥，顺序无关

			条件表达式之间有交集，需要考虑顺序

			条件表达式之间有包含，通常范围小在上

			可嵌套

			执行语句一行  {} 可省略  不建议


*/

class IfTest {
	public static void main(String[] args) {

		int heartBeats = 179;
		if (heartBeats < 60 || heartBeats > 100) {
			System.out.println("需要做进一步检查");
		}
		System.out.println("检查结束");


		int age = 23;
		if (age < 18) {
			System.out.println("未成年");
		} else {
			System.out.println("成年");
		}


		if (age < 0) {
			System.out.println("数据非法");
		} else if (age < 18) {
			System.out.println("未成年");
		} else if (age < 35) {
			System.out.println("青壮年");
		} else if (age < 60) {
			System.out.println("中年");
		} else if (age < 120){
			System.out.println("老年");
		} else {
			System.out.println("!!!");
		}


		System.out.println("---------------------------------");


		// 练习
		/*
			int x = 4;
			int y = 1;
			if (x > 2) {
				if (y > 2) 
					System.out.println(x + y);
					System.out.println("hh");
			} else 
				System.out.println("x is " + x);
			
			// 有输出 "hh"


			int x = 4;
			int y = 1;
			if (x > 2) 
				if (y > 2) 
					System.out.println(x + y);
				else // 就近原则 !!!
					System.out.println("x is " + x);

			// "x is 4"


			boolean b = true;
			// 如果 改成 if (b = false) 输出 "c"
			if (b == false)
				System.out.println("a");
			else if (b)
				System.out.println("b");
			else if (!b)
				System.out.println("c");
			else 
				System.out.println("d")

			// 有输出 "b"

		*/

		
		

	}
}