// 10

// 打印任意三位数整数的个位数、十位数、百位数
class AriExer {
	public static void main(String[] args) {
		int num = 538;
		System.out.println("个位数：" + num % 10);
		// System.out.println("十位数：" + num / 10 % 10);
		System.out.println("十位数：" + num % 100 / 10);
		System.out.println("百位数：" + num / 100);
	}
	
}