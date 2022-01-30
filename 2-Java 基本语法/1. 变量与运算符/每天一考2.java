// 17

/*
	1. & && 异同

		同：结果相同；左为true 右运算

		异：左为false  & 右运算  && 右不运算

	2. 程序输出

		class OperatorTest {
			public static void main(String[] args) {

				boolean x = true;
				boolean y = false;
				short z = 40;

				if ((z++ ==40) && (y = true)) {
					z++;  // 42
				}

				if ((x = false) || (++z == 43)) {
					z++; // 44
				}

				System.out.println("z = " + z);  // 44
			}
		} 

	3. 取三个 int 型变量的最大值

		int n1 = 1;
		int n2 = 2;
		int n3 = 3;

		int max = n1 > n2 ? n1 : n2;
		max = max > n3 ? max : n3;

		if (n1 >= n2 && n1 >=m3 ){
			max = n1; 
		} else if (n2 >= n1 && n2 >=n3) {
			max = n2;
		} else {
			max = n3;
		}
		

	4. 2个 double型变量 d1 d2，d1 > 10.0 && d2 < 20.0，d1 + d2，否则 d1 * d2

		double d1 = 10.1;
		double d2 = 19.9;

		d1 > 10.0 && d2 < 20.0 ? d1 + d2 : d1 * d2;

	5. 交换两个变量值

		int m = 1;
		int n = 2;

		int temp;
		temp = m;
		m = n;
		n = temp;

		m = m + n;
		n = m - n;
		m = m - n;

		m = m ^ n;
		n = m ^ n;
		m = m ^ n;

*/