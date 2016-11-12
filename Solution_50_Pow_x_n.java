package main2;

import java.util.Scanner;

public class Solution_50_Pow_x_n {

	public static double myPow(double x, int n) {
		String xStr = String.valueOf(x);
		int pointIndex = xStr.indexOf('.');
		int num = 0;
		if(pointIndex!=-1){
			for(int i = xStr.length()-1;i>pointIndex;i--){
				if(xStr.charAt(i)!='0'){
					num = i - pointIndex;
					break;
				}
			} // for
		} // if
		//得到小数点后几位的个数了
		System.out.println("num: "+num);
		int sign = 0;
		if(n<0){
			sign = 1;
			n = n*(-1);
		}
		int times = 0;
		while(n>0){
			times++;
			n=n>>>1;
		}
		--times;
		System.out.println("times:"+times);
		double tempX = x*Math.pow(10, num);
		System.out.println("tempX:"+tempX);
		tempX = (long)tempX<<times; 
		for(int k = 1;k<=(n-times);k++){
			tempX = tempX * x;
		}
		return tempX;
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			double x = scan.nextDouble();
			int n = scan.nextInt();
			System.out.println(myPow(x, n));
		}
	}

}
