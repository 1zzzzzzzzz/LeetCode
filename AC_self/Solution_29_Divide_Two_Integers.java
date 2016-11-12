package main2;

public class Solution_29_Divide_Two_Integers {
	
	public static int divide(int dividend, int divisor){
		String res = "";
		int flag = 1, f = 0;
		//判断符号
		if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))
			flag = -1;
		//特殊情况
		if(dividend==Integer.MIN_VALUE){
			if(divisor==Integer.MIN_VALUE)
				return 1;
			if(isTrue(divisor))
				f = 1;
			dividend = Integer.MAX_VALUE;
		}
		if(dividend==0||divisor == Integer.MIN_VALUE)
			return 0;
		if(dividend<0&&dividend>Integer.MIN_VALUE)
			dividend = dividend * (-1);
		if(divisor<0)
			divisor = divisor * (-1);
		String str1 = Integer.toBinaryString(dividend);
		String str2 = Integer.toBinaryString(divisor);
		
		int times = str1.length() - str2.length();
		while(times>=0){
			int d1 = dividend>> times;
		    if(d1>=divisor){
		    	res = res + "1";
		    	int temp = d1 - divisor;
		    	String next = str1.substring(str1.length()-times, str1.length());
		    	dividend = Integer.valueOf(Integer.toBinaryString(temp)+next, 2);
		    	times--;
		    }else{
		    	res = res + "0";
		    	times--;
		    }
		}
		if(res.equals(""))
			return 0;
		if(flag==-1&&f==1)
			f = -1;
		int re = Integer.valueOf(res, 2)*flag+f;
//		if(dividend==Integer.MAX_VALUE&&)
		return re;
	}
	
	//如果divisor是2的幂，且dividend为Integer.MIN_VALUE的话，应将结果加1
	//如 -2147483648/4 = 2147483647/4 + 1
	private static boolean isTrue(int divisor) {
		if(divisor==-1)
			return false;
		if(divisor<0)
			divisor = divisor*(-1);
		char dArr[] = Integer.toBinaryString(divisor).toCharArray();
		int count = 0;
		for(int i = 0;i<dArr.length;i++){
			if(dArr[i]=='1')
				count++;
		}
		return count==1;
	}

	public static void main(String[] args) {
//		int dividend = 18;//Integer.MAX_VALUE:2147483647
//		int divisor = -2;
		int dividend = -2147483648;//Integer.MAX_VALUE:2147483647
		int divisor = -1;
		System.out.println("get res: "+divide(dividend, divisor));
		System.out.println("true res: "+dividend/divisor);
	}

}
