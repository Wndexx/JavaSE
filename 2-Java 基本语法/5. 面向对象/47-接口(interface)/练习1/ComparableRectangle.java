package com.wndexx.exer4;

public class ComparableRectangle extends Rectangle implements CompareObject {

	public ComparableRectangle(double width, double height) {
		super(width, height);
	}

	@Override
	public int compareTo(Object o) {
		if (this == o)
			return 0;
		if (o instanceof ComparableRectangle) {
			if (this.findArea() - ((ComparableRectangle) o).findArea() > 0)
				return 1;
			else if (this.findArea() - ((ComparableRectangle) o).findArea() == 0)
				return 0;
			else
				return 1;
		}
		throw new RuntimeException("传入的数据类型不匹配");
	}
}
