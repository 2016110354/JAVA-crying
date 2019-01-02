package ru.zhao.first;

public class Point2D {
	//私有属性横坐标，纵坐标
	private double x;
	private double y;

	//private Double a,b,c;
	//构造函数
	public Point2D(double x,double y){
			this.x = x;
			this.y = y;
	}
	
	//重写 Point2D 类的 equals()方法，来判断两个点是否是同一个点。
	@Override
	public boolean equals(Object point) {
		if(this.getX()==Double.POSITIVE_INFINITY||this.getY()==Double.POSITIVE_INFINITY) {
			return false;
		}
		if(this==point) {
			return true;
		}
		if(getClass()!=point.getClass()) {
			return false;
		}
		if(Double.doubleToRawLongBits(x)==Double.doubleToRawLongBits(((Point2D) point).x)&&Double.doubleToRawLongBits(y)==Double.doubleToRawLongBits(((Point2D) point).y)){
			return true;
		}else {
			return false;
		}
	}
	


	
	//getter/setter方法
	public double getX(){
		return x;
	}
	public double getY() {
		return y;
	}
	
}






