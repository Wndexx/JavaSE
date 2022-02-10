package com.wndexx.p2;

public class CustomerList {
	
	public static void main(String[] args) {
		
	}

	private Customer[] customers; // 保存客户对象的数组
	private int total; // 记录已保存客户对象的数量

	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	// 添加用户
	public boolean addCustomer(Customer customer) {
		if (total == customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}

	// 更改用户
	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}

	// 删除用户
	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}
		for (int i = index; i < total; i++) {
			customers[i] = customers[i + 1];
		}
		total--;
		return true;
	}

	// 获取全部用户
	public Customer[] getAllCusomers() {
		Customer[] custs = new Customer[total];
		for (int i = 0; i < custs.length; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}

	// 获取指定用户
	public Customer getCustomer(int index) {
		if (index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}

	// 获取总的用户数量
	public int getTotal() {
		return total;
	}

}
