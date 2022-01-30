// 11

/*
	2. 赋值运算符

		=

		+=	-=	*=	/=	%=  不改变数据类型


*/ 

class SetValueTest {
	public static void main(String[] args) {
		// 赋值运算符 =
		int i1 = 10;
		int j1 = 10;

		int i2, j2;
		// 连续赋值
		i2 = j2 = 10;

		int i3 = 10, j3 = 20;


		System.out.println("---------------------------------");


		int num1 = 10;
		// num1 = num1 + 2
		num1 += 2;
		System.out.println(num1);

		int num2 = 12;
		// num2 = num2 % 5
		num2 %= 5;
		System.out.println(num2);

		short s1 = 10;
		// s1 = s1 + 2; // 编译失败
		// 不改变数据类型
		s1 += 2;
		System.out.println(s1);


		System.out.println("-------------------------------");


		// int 变量 +2 方法
		// num = num + 1;
		// num += 2;		// 推荐
		// num++++ 			// 不行


		// int 变量 +1 方法
		// num = num +1;
		// num += 1;
		// num ++;			// 推荐


		System.out.println("------------------------------");


		// 思考1
		short s = 3;
		s = s + 2;		// 编译不通过
		s += 2；			// short

		// 思考2
		int i = 1;
		i *= 0.1;
		System.out.println(i); // 0
		i++;
		System.out.println(i); // 1

		// 思考3
		int m = 2;
		int n = 3;
		n *= m++;
		System.out.println("m = " + m); // m = 3
		System.out.println("n = " + n); // n = 6

		// 思考4
		int n = 10;
		// n = n + (n++) + (++n)
		n += (n++) + (++n);
		System.out.println(n); // 32



	}
}