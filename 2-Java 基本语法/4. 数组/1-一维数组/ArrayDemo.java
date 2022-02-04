/**
 * 
 * @Description
 * @author wndexx 
 * @version
 * @date 2022年2月2日下午3:38:25
 *
 */
public class ArrayDemo {

	/**
	 * 
	 * @Description
	 * @author wndexx
	 * @date 2022年2月2日下午3:39:05
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		// 练习1 输出结果
		int[] arr = new int[] { 8, 2, 1, 0, 3 };
		int[] index = new int[] { 2, 0, 3, 2, 4, 0, 1, 3, 2, 3, 3 };
		String tel = "";
		for (int i = 0; i < index.length; i++) {
			tel += arr[index[i]];
		}
		System.out.println("联系方式：" + tel);

		// 输出 联系方式：18013820100

	}

}
