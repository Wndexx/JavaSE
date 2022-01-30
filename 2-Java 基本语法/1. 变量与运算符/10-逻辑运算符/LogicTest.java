// 13

/*
	4. 逻辑运算符

		两侧  boolean 型 

		结果  boolean 型

		&  逻辑与	左右都运算

		&& 短路与	左为 false 右不运算 				推荐

		|  逻辑或    左右都运算

		|| 短路或    左为 true  又不运算				推荐

		！ 逻辑非	取反

		^  逻辑异或	左右不同 true  左右相同 false

*/

class LogicTest {
	public static void main(String[] args) {

		// 区分 & 与 &&
		// 相同点 运算结果相同；左为 true，右参与运算
		// 不同点 左为 false		& 右参与运算   && 右不参与运算
		boolean b1 = true;
		b1 = false;
		int num1 = 10;
		if (b1 & (num1++ >0)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		System.out.println("num1 = " + num1); // 11

		boolean b2 = true;
		b2 = false;
		int num2 = 10;
		if (b2 && (num2++ >0)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		System.out.println("num2 = " + num2);  // 10


		// 区分 | 与 ||
		// 相同点 运算结果相同；左为 false，右参与运算
		// 不同点 左为 true		| 右参与运算   || 右不参与运算
		boolean b3 = false;
		b3 = true;
		int num3 = 10;
		if (b3 | (num3++ >0)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		System.out.println("num3 = " + num3); // 11


		boolean b4 = false;
		b4 = true;
		int num4 = 10;
		if (b4 || (num4++ >0)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		System.out.println("num4 = " + num4);  // 10


		System.out.println("------------------------------------------------");


		// 练习
		/*
			int x = 1;
			int y = 1;
			if (x++ == 2 & ++y == 2) {
				x = 7;
			} 
			System.out.println("x = " + x + ", y = " + y);  // x = 2, y = 2

			int x = 1, y = 1;
			if (x++ == 2 && ++y == 2) {
				x = 7;
			}
			System.out.println("x = " + x + ", y = " + y);  // x = 2, y = 1

			int x = 1;
			int y = 1;
			if (x++ == 1 | ++y == 1) {
				x = 7;
			} 
			System.out.println("x = " + x + ", y = " + y);  // x = 7, y = 2

			int x = 1;
			int y = 1;
			if (x++ == 1 || ++y == 1) {
				x = 7;
			} 
			System.out.println("x = " + x + ", y = " + y);  // x = 7, y = 1
		*/

		// 面试题
		boolean x = true;
		boolean y = false;
		short z = 42;
		if ((z++ == 42) && (y = true)) z++;
		if ((x = false) || (++z == 45)) z++;
		System.out.println("z = " + z);  // 46
		
	}
}