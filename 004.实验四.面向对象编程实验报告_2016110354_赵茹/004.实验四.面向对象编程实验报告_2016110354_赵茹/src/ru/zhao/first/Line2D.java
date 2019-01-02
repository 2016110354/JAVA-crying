package ru.zhao.first;
import java.math.BigDecimal;
import java.util.Scanner;
public class Line2D {
	 private double A,B,C,K;
	 private boolean JudgeLine = true;
	 //直线是否构造成功
	 public boolean getJudgeLine() {
		 return true;
	 }
	 //构造参数
	 public double getA() {
		return A;
	}
	 public double getB() {
		return B;
	}
	 public double getC() {
		return C;
	}
	 public double getK() {
		return K;
	}
	//一般式三个参数,a,b不同时为0
	 public Line2D(double a,double b ,double c) {
		 if(a == 0 && b == 0) {
				System.out.println("输入不合法！");
		 }else {
		A = BigDecimal.valueOf(a).doubleValue();
		B = BigDecimal.valueOf(b).doubleValue();
		C = BigDecimal.valueOf(c).doubleValue();
		JudgeLine = true;
	 }
	 }
	
	 //构造点斜式两个参数 
	 public Line2D(Point2D a,Double k) {
		 //直线
		 BigDecimal x1 = BigDecimal.valueOf(a.getX());
		 BigDecimal y1 = BigDecimal.valueOf(a.getY());
		 //无穷大
		 if(Double.isInfinite(k)) {
			 A = 1;
			 B = -x1.doubleValue();
			 JudgeLine = true;
		 }else {
			 BigDecimal k1 = BigDecimal.valueOf(k);
				 A = k.doubleValue();
				 B = -1;
				 C = (y1.subtract(k1.multiply(x1))).doubleValue();
			 JudgeLine = true;
		 }
	 }

	 
	 //两点式，两个点不能重复
	 //A = y2-y1 B = x1-x2 C = y1x2 - x1y2
	 public Line2D(Point2D a,Point2D b) {
		BigDecimal x1 = BigDecimal.valueOf(a.getX());
		BigDecimal y1 = BigDecimal.valueOf(a.getY());
		BigDecimal x2 = BigDecimal.valueOf(b.getX());
		BigDecimal y2 = BigDecimal.valueOf(b.getY());
		//斜率
		double k = (b.getY()-a.getY())/(b.getX()-a.getX());
		if(!a.equals(b)) {
			//直线垂直于x轴，x = x1
			if(a.getX()==b.getX()&&a.getY()!=b.getY()) {
				A = 1;
				B = 0;
				C = -x1.doubleValue();
				JudgeLine = true; 
				//直线垂直于y轴，y = y1
			}else if(a.getY()==b.getY()||a.getX()!=b.getX()) { 
				A = 0;
				B = 1;
				C = -y2.doubleValue();
				JudgeLine = true;
			}else {
				A = (y2.subtract(y1)).doubleValue();
				B = (x1.subtract(x2)).doubleValue();
				C = ((x2.multiply(y1)).subtract((x1).multiply(y2))).doubleValue();
				JudgeLine = true;
			}
		}else {
			System.out.println("输入不合法!");
		}
	 }
	 //截距式,不适用于和任意坐标轴垂直的直线

		public Line2D(double a,double b) { 
		    //a,b不能为0，或者无穷
			if((a==0&&b==0)||(Double.isInfinite(a)&&Double.isInfinite(b))) {
				System.out.println("输入不合法！");
			}else if(Double.isInfinite(a)&&!Double.isInfinite(b)) {
				B = 1;
				C = -BigDecimal.valueOf(b).doubleValue();
				JudgeLine = true;
			}else if(Double.isInfinite(b)&&!Double.isInfinite(a)) {
				A = 1;
				C = -BigDecimal.valueOf(a).doubleValue();
				JudgeLine = true;
			}else {
				BigDecimal x1 = BigDecimal.valueOf(a);
				BigDecimal y1 = BigDecimal.valueOf(b);
				A = y1.doubleValue();
				B = x1.doubleValue();
				C = -x1.multiply(y1).doubleValue();
				JudgeLine = true;
			}
		}
	 //重写重写 Line2D 类的 equals()方法，判断两条直线是否是同一条。
		public boolean equals(Object obj){
			if(this == obj) {
				return true;
			}
			if(obj == null)
				return false;
			if(getClass() != obj.getClass()) {
				return false;
			}
			Line2D line = (Line2D)obj;
			
			if(A*line.getB()==B*line.getA()&&B*line.getC()==C*line.getB()){
				
				return true;
			}
			return false;
		}
		
	 public boolean isParallel(Line2D line ) {
		 if(A*line.B==B*line.A && (!this.equals(line))){
			 return true;
		 }else {
			 return false;
		 }
	 }
	 //输出直线
	 public String toString() {
		 if(JudgeLine == true) {
		 return "您输入的直线为:" + A + "x+(" + B + ")y+("+ C + ")=0";
		  }	else {
			  return "不能构成直线！";
		  }
	}
}








