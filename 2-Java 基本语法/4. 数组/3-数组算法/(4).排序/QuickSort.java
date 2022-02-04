package com.wndexx.java;

/*
 * 
 * 快速排序
 * 	通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 	则分别对这两部分继续进行排序，直到整个序列有序。
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] data = { 9, -16, 30, 23, -30, -49, 25, 21, 30 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		quickSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}

	public static void quickSort(int[] data) {
		subSort(data, 0, data.length - 1);
	}

	private static void subSort(int[] data, int start, int end) {
		if (start < end) {
			// 界点
			int pivot = data[start];
			// 待划分区域首元素
			int low = start + 1;
			// 待划分区域尾元素
			int high = end;
			while (true) {
				while (low < end && data[low] <= pivot) {
					low++;
				};

				while (high > start && data[high] >= pivot) {
					high--;
				};
				
				if (low < high) {
					swap(data, low, high);
				} else {
					break;
				}
			}
			swap(data, start, high);

			// 递归调用
			subSort(data, start, high - 1);
			subSort(data, high + 1, end);
		}
	}

	// 交换数组的两个元素的值
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
