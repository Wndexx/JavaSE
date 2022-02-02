/*
	switch-case 结构

		不同 case 中不能定义同名变量


	代码优劣标准

		正确性

		可读性

		健壮性

		高效率 低存储 时间复杂度 空间复杂度  算法好坏

*/
public class FamilyAccount {
	public static void main(String[] args) {

		int balance = 10000;
		String record = "收支\t账户金额\t\t收支金额\t\t说  明\n";

		label:while (true) {

				System.out.print("--------------------- 家庭收支记账软件 ----------------------\n\n");
				System.out.print("                        1 收支明细\n");
				System.out.print("                        2 登记收入\n");
				System.out.print("                        3 登记支出\n");
				System.out.print("                        4 退    出\n\n");
				System.out.print("                        请选择(1-4): ");

				char selection = Utility.readMenuSelection();
				switch (selection) {

					case '1':
						System.out.println();
						System.out.println("--------------------- 当前收支明细记录 ----------------------");
						System.out.println(record);
						System.out.println("-------------------------------------------------------------");
						System.out.println();
						break;

					case '2':
						System.out.println();
						System.out.print("本次收入金额: ");
						int income = Utility.readNumber();

						System.out.print("本次收入说明: ");
						String incomeInfo = Utility.readString();

						balance += income;
						record += "收入\t" + balance + "\t\t" + income + "\t\t" + incomeInfo + "\n";

						System.out.println("------------------------- 登记完成 --------------------------");
						System.out.println();
						break;

					case '3':
						System.out.println();
						System.out.print("本次支出金额: ");
						int expend = Utility.readNumber();

						System.out.print("本次支出说明: ");
						String expendInfo = Utility.readString();

						if (balance >= expend) {
							balance -= expend;
							record += "支出\t" + balance + "\t\t" + expend + "\t\t" + expendInfo + "\n";
							System.out.println("------------------------- 登记完成 --------------------------");
						} else {
							System.out.println("支出超出账户额度。支付失败");
						}
						
						break;

					case '4':
						System.out.println();
						System.out.print("确认是否退出(Y/N): ");
						char confirm = Utility.readConfirmSelection();

						if (confirm == 'Y') {
							break label;
						}

						break;
				}

		}
	}
		
}