/*
	while 循环
	
		初始化条件;

		while (循环条件){

			循环体;

			迭代条件;

		}

	

*/
class WhileTest {
	public static void main(String[] args) {
		
		// 遍历 100 以内的所有偶数
		int i = 1;
		while (i <= 100){
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
}