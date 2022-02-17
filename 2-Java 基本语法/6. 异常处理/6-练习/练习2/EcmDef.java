package com.wndexx.java2;

/*
	编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
	对数据类型不一致 (NumberFormatException) 、 缺少命令行参数(ArrayIndexOutOfBoundsException、除0(ArithmeticException)及输入负数(EcDef 自定义的异常)进行异常处理。
*/
public class EcmDef {
	public static void main(String[] args) {

		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int res = devision(num1, num2);
			System.out.println(res);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("缺少命令行参数");
		} catch (NumberFormatException e) {
			System.out.println("数据类型不一致");
		} catch (ArithmeticException e) {
			System.out.println("除0");
		} catch (EcDefException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(1);
	}

	static int devision(int num1, int num2) {
		if (num1 < 0 || num2 < 0)
			throw new EcDefException("不能输入负数");
		return num1 / num2;
	}
}

// 自定义异常类
class EcDefException extends RuntimeException {
	static final long serialVersionUID = -703485766939L;

	public EcDefException() {

	}

	public EcDefException(String msg) {
		super(msg);
	}
}
