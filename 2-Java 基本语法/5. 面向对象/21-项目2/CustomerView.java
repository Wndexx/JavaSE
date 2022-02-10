package com.wndexx.p2;

public class CustomerView {

	public static void main(String[] args) {
		CustomerView cv = new CustomerView();
		cv.enterMainMenu();
	}

	private CustomerList customerList = new CustomerList(10);

	public void enterMainMenu() {
		l: while (true) {
			System.out.print("----------------------客户信息管理软件----------------------\n\t\t\t1 添加客户\n\t\t\t2 修改客户\n\t\t\t3 删除客户\n\t\t\t4 客户列表\n\t\t\t5 退出\n\n\t\t\t请选择(1-5): ");
			switch (CMUtility.readMenuSelection()) {
				case '1':
					// 添加客户
					addNewCustomer();
					break;
				case '2':
					// 修改客户
					modifyCustomer();
					break;
				case '3':
					// 删除客户
					deleteCustomer();
					break;
				case '4':
					// 列出所有客户
					listAllCustomers();
					break;
				case '5':
					System.out.print("确认是否退出(Y/N): ");
					char isExit = CMUtility.readConfirmSelection();
					if(isExit == 'N') {
						break;
					}
					break l;
			}
		}
	}

	// 添加客户
	private void addNewCustomer() {
		// 获取用户输入的信息
		System.out.println("------------------------添加客户-------------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(20);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(12);
		System.out.print("邮箱：");
		String email = CMUtility.readString(50);

		Customer cust = new Customer(name, gender, age, phone, email);
		boolean isAdd = customerList.addCustomer(cust);
		if (isAdd) {
			System.out.println("------------------------添加完成-------------------------");
		} else {
			System.out.println("------------------------添加失败-------------------------");
		}
	}

	private void modifyCustomer() {
		System.out.println("------------------------修改客户-------------------------");
		while(true) {
			System.out.println("请选择待修改客户编号(-1退出)：");
			int index = CMUtility.readInt();
			if (index == -1) {
				return;
			}
			Customer cust = customerList.getCustomer(index - 1);
			if(cust == null) {
				System.out.println("无法找到指定客户！");
				continue;
			}
			// 获取用户输入的信息
			System.out.print("姓名(" + cust.getName() + "): ");
			String name = CMUtility.readString(20, cust.getName());
			System.out.print("性别(" + cust.getGender() + "): ");
			char gender = CMUtility.readChar(cust.getGender());
			System.out.print("年龄(" + cust.getAge() + "): ");
			int age = CMUtility.readInt(cust.getAge());
			System.out.print("电话(" + cust.getPhone() + "): ");
			String phone = CMUtility.readString(12, cust.getPhone());
			System.out.print("邮箱(" + cust.getEmail() + "): ");
			String email = CMUtility.readString(50, cust.getEmail());

			customerList.replaceCustomer(index - 1, new Customer(name, gender, age, phone, email));
			break;
		}
		System.out.println("--------------------------修改完成-------------------------");
	}

	private void deleteCustomer() {
		System.out.println("------------------------删除客户-------------------------");
		while(true) {
			System.out.print("请选择待删除客户编号(-1退出)：");
			int index = CMUtility.readInt();
			if (index == -1) {
				return;
			}
			if(customerList.getCustomer(index - 1) == null) {
				System.out.println("无法找到指定客户！");
				continue;
			}
			System.out.print("是否确认删除(Y/N):");
			if(CMUtility.readConfirmSelection() == 'N') {
				break;
			}
			customerList.deleteCustomer(index - 1);
			System.out.println("------------------------删除完成-------------------------");
			break;
		}
	}

	private void listAllCustomers() {
		System.out.println("------------------------客户列表-------------------------");
		System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱\n");
		Customer[] custs = customerList.getAllCusomers();
		for (int i = 0; i < custs.length; i++) {
			System.out.println(i + 1 + "\t\t" + custs[i].getName() + "\t\t" + custs[i].getGender() + "\t\t"
					+ custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t\t" + custs[i].getEmail());
		}
		System.out.println("----------------------客户列表完成-------------------------");
	}

}
