package ru.zhao.first;
import java.util.Scanner;
public class test {
	public static  void main(String[] args) {
		Line2D line = new Line2D(0.0,0.0,0.0);
		Line2D line1 = new Line2D(0.0,0.0,0.0);
		//输出第一条直线的判断
		System.out.println("请选择构造第一条直线的方法：");
		System.out.println("1.一般式：");
		System.out.println("2.点斜式：");
		System.out.println("3.两点式：");
		System.out.println("4.截距式：");
		System.out.println("请输入选择(1-4)的整数：");
		while(true) {
			try {
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				////选择直线构造方法输出，确定A,B,C
				if(choice >=1 && choice <=4) {
					switch(choice) {
				case 1:
					System.out.println("请输入一般式的A、B、C参数,以空格隔开");
					Double A = input.nextDouble();
					Double B = input.nextDouble();
					Double C = input.nextDouble();
					line = new Line2D(A,B,C);
					System.out.println(line);	
					
					//打印输出直线
					//System.out.println(line);
					break;
				case 2:
					System.out.println("请输入点斜式的一点");
					Double x = input.nextDouble();
					Double y = input.nextDouble();
					Point2D a = new Point2D(x,y);
					System.out.println("请输入点斜式的斜率k");
					Double k = input.nextDouble();
					line = new Line2D(a,k);
					//打印输出直线
					System.out.println(line);
					break;
				case 3:
					System.out.println("请输入两点式的第一点");
					Double x0 = input.nextDouble();
					Double y0 = input.nextDouble();
					Point2D a1 = new Point2D(x0,y0);
					System.out.println("请输入两点式的第二点");
					Double x1 = input.nextDouble();
					Double y1 = input.nextDouble();
					Point2D b1 = new Point2D(x1,y1);
					System.out.println("您输入的两个点为：");
					System.out.println(a1.getX()+","+a1.getY());
					System.out.println(b1.getX()+","+b1.getY());
					line = new Line2D(a1,b1);
					//打印输出直线
					System.out.println(line);	
					break;
				case 4:
					System.out.println("请输入截距式的x,y轴的截距a,b");
					Double xa = input.nextDouble();
					Double yb = input.nextDouble();
					line = new Line2D(xa,yb);
					//打印输出直线
					System.out.println(line);	
					break;
				default:
					break;
			}	
				}else {
					System.out.println("请输入1到4的整数！");
					continue;
				}
			}catch(Exception e) {
					System.out.println("输入错误(输入整数），请重新输入！");
					//choice = input.nextDouble();
					}
			
			//输入第二条直线的判断
			System.out.println("请选择构造第二条直线的方法：");
			System.out.println("1.一般式：");
			System.out.println("2.点斜式：");
			System.out.println("3.两点式：");
			System.out.println("4.截距式：");
			System.out.println("请输入选择(1-4)的整数：");
			while(true) {
				try {
				Scanner input = new Scanner(System.in);
				//选择直线构造方法输出确定A,B,C
				int choice1 = input.nextInt();
				if(choice1 >=1 && choice1 <=4) {
					switch(choice1) {
				case 1:
					System.out.println("请输入一般式的A、B、C参数,以空格隔开");
					Double A = input.nextDouble();
					Double B = input.nextDouble();
					Double C = input.nextDouble();
					line1 = new Line2D(A,B,C);
					//打印输出直线
					System.out.println(line1);
//					//判断是否为同一直线
//					line1.equals(line);
//					//判断两条直线是否平行
//					line1.isParallel(line);
					break;
				case 2:
					System.out.println("请输入点斜式的一点");
					Double x = input.nextDouble();
					Double y = input.nextDouble();
					Point2D a = new Point2D(x,y);
					System.out.println("请输入点斜式的斜率k");
					Double k = input.nextDouble();
					line1 = new Line2D(a,k);
					//打印输出直线
					System.out.println(line1);
//					//判断是否为同一直线
//					line1.equals(line);
//					//判断两条直线是否平行
//					line1.isParallel(line);
					break;
				case 3:
					System.out.println("请输入两点式的第一点");
					Double x0 = input.nextDouble();
					Double y0 = input.nextDouble();
					Point2D a1 = new Point2D(x0,y0);
					System.out.println("请输入两点式的第二点");
					Double x1 = input.nextDouble();
					Double y1 = input.nextDouble();
					Point2D b1 = new Point2D(x1,y1);
					System.out.println("您输入的两个点为：");
					System.out.println(a1.getX()+","+a1.getY());
					System.out.println(b1.getX()+","+b1.getY());
					line1 = new Line2D(a1,b1);
					//line1.equals(line);
					//打印输出直线
					System.out.println(line1);
//					//判断是否为同一直线
//					line1.equals(line);
//					//判断两条直线是否平行
//					line1.isParallel(line);
					break;
				case 4:
					System.out.println("请输入截距式的x,y轴的截距a,b");
					Double xa = input.nextDouble();
					Double yb = input.nextDouble();
					
				    line1 = new Line2D(xa,yb);
				    //打印输出直线
					System.out.println(line1);
//					//判断是否为同一直线
//					line1.equals(line);
//					//判断两条直线是否平行
//					line1.isParallel(line);
					break;
				default:
					break;
				}
					if(line.getJudgeLine()==true && line1.getJudgeLine() == true) {
						if(line.equals(line1)) {
							System.out.println("两直线是同一条！");
						}else {
							System.out.println("两直线不是同一条！");
						}
						if(line.isParallel(line1)) {
							System.out.println("两直线平行!");
						}else {
							System.out.println("两直线不平行!");
						}
					}
			}else {
				System.out.println("请输入1到4的整数！");
				break;	
			}	
			}catch(Exception e) {
				System.out.println("输入错误(输入整数），请重新输入！");
				//choice = input.nextDouble();
						}
			   }
				}
			}
			}
		
		
			
		
				
			
	
			
	
			
	
	
	
	
