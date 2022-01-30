// 7

class ReviewTest {
	public static void main(String[] args) {
		char c1 = 'a';

		// 可直接赋 Unicode 值
		char c2 = 97;
		System.out.println(c2); // a

		char c3 = 5;
		char c4 = '5';

		System.out.println(c3);

		int i1 = c4;
		// 也可以写 int i1 = (int)c4;
		System.out.println(i1); // 53
	}
}