package main2;

public class Solution_38_Count_and_Say {
	public static String countAndSay(int n) {
		String res = "";
		res = getStr(n);
		return res;
	}
	
	public static String getStr(int n){
		String res = "";
		if(n==1){
			return "1";
		}else if(n==2){
			return "11";
		}else{
			String temp = getStr(n-1);
			//System.out.println("temp:"+temp);
			char preC = temp.charAt(0);
			int count = 1;
			boolean b = false;
			for(int i = 1;i<=temp.length();i++){
				if(i==temp.length()){
					if(!b){
						res = res + String.valueOf(count)+String.valueOf(preC);
					}
					break;
				}
				char c = temp.charAt(i);
				if(c==preC){
					++count;
					if(i==temp.length()-1){
						res = res + String.valueOf(count)+String.valueOf(preC);
						b = true;
					}
				}else{
					res = res + String.valueOf(count)+String.valueOf(preC);
					count = 1;
					preC = c;
				}
			} // for
		}
		return res;
			
	}

	public static void main(String[] args) {
		int n = 8;
		System.out.println(countAndSay(n));
	}

}
