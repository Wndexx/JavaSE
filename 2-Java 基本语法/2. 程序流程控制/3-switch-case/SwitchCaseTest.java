/*
	switch-case 结构

		格式

			switch(表达式){
				case 常量1:
					语句1;
					//break;
				case 常量2:
					语句2;
					//break;
				...
				case 常量n:
					语句n;
					//break;
				default
					语句;
					//default;
			}

		switch表达式值 匹配 case常量值 成功 执行对应语句

			没有 break 继续执行下面语句 不判断

			有 break 终止

		switch 表达式 类型

			byte  short  char  int  枚举  String

		case 后跟常量 不能跟范围 ！！

		break 跳出 switch-case 结构 可选 不写 编译不报错 结果不一样

		default 可选 位置灵活

		可转换为 if-else 不复杂时 优先 switch-case  效率稍高

		多个 case 执行语句相同 可以合并

*/
class SwitchCaseTest {
	public static void main(String[] args) {
		
		// int
		int num = 2;
		switch(num) {
			case 0:
				System.out.println("zero");
				break;
			case 1:
				System.out.println("one");
				break;
			case 2:
				System.out.println("two");
				break;
			case 3:
				System.out.println("three");
				break;
			default:
				System.out.println("other");
				break;
		}

		// String
		String season = "summer";
		switch (season) {
			case "spring":
				System.out.println("春");
				break;
			case "summer":
				System.out.println("夏");
				break;
			case "autumn":
				System.out.println("秋");
				break;
			case "winter":
				System.out.println("冬");
				break;
			default:
				System.out.println("输入有误");
				break;
		}

		// default 位置灵活
		int num1 = 2;
		switch(num1) {
			default:
				System.out.println("other");
				break;
			case 0:
				System.out.println("zero");
				break;
			case 1:
				System.out.println("one");
				break;
			case 2:
				System.out.println("two");
				break;
			case 3:
				System.out.println("three");
				break;
		}


		System.out.println("---------------------------------------");

		// switch 表达式类型 不能是 boolean
		// 编译失败
		/*
			boolean isHandsome = true;
			switch(isHandsome) {
				case true:
					System.out.println("帅");
					break;
				case false:
					System.out.println("丑");
					break;
				default:
					System.out.println("输入格式有误");
					break;
			}
		*/

		// case 不能跟范围
		// 编译失败
		/*
			int age = 10;
			switch (age) {
				case age > 18:
					System.out.println("成年");
					break;
				default:
					System.out.println("成年");
					break;
			}
		*/

	}
}