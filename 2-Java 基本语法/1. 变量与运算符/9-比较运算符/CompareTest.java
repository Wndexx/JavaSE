// 12

/*
	3. 比较运算符

		结果 boolean

		==  !=  		可以使用在数值型和引用类型变量

		>	<	>=	<= 	只能使用在数值型
		
		instanceof 检查是否为类的对象		"Hello" instanceof String


*/
class CompareTest {
	public static void main(String[] args) {
		int i = 10;
		int j = 20;

		System.out.println(i == j); // false
		System.out.println(i = j);  // 20

		boolean b1 = true;
		boolean b2 = false;

		System.out.println(b2 == b1); // false
		System.out.println(b2 = b1);  // true


		// Account acct1 = new Account(1000);
		// Account acct2 = new Account(2000);

		// boolean b1 = (acct1 == acct2); // 比较是否为同一对象
		// boolean b2 = (acct1 != acct2); // 比较是否为同一对象
	}
}