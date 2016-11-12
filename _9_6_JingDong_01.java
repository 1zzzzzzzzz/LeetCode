package enterp_program;

import java.util.Scanner;

public class _9_6_JingDong_01 {
	// 解法一：递归超时
	public static String getLucky1(int n) {
		if (n == 1)
			return "4";
		if (n == 2)
			return "7";
		String res = "";
		String pre = getLucky1(n - 1);
		int len = pre.length();
		if (pre.charAt(len - 1) == '4') {
			res = pre.subSequence(0, len - 1) + "7";
		} else {
			// 倒数第一个4
			int pos = get4Pos(pre);
			if (pos == -1) {
				for (int j = 0; j <= len; j++) {
					res += "4";
				}
			} else {
				String tempStr = "";
				for (int k = pos + 1; k < len; k++) {
					tempStr += "4";
				}
				res = pre.substring(0, pos) + "7" + tempStr;
			}
		}
		return res;
	}

	public static int get4Pos(String s) {
		int pos = -1;
		for (int i = s.length() - 1; i >= 0; --i) {
			if (s.charAt(i) == '4') {
				pos = i;
				break;
			}
		}
		return pos;
	}

	// 解法二 输出正确结果
	public static String getLucky2(int n) {
		String res = "";
		int pos = 0, num = 0;
		if(n==1)
			return "4";
		if(n==2)
			return "7";
		for (int x = 0; x < 1000; x++) {
			if (Math.pow(2, x + 1)-2 > n) {
				pos = x - 1;
				break;
			}
		}
		//System.out.println("pos:" + pos);
		num = (int) (Math.pow(2, pos + 1) - 2);
		String str = "";
		if(num==n){
			for (int i = 1; i <= pos; i++) {
				str = "1" + str;
			}
		}else{
			// 偏 x+1长的otherNum个
			str = Integer.toBinaryString(n - num - 1);
			int end = pos+1-str.length();
			for (int i = 1; i <= end; i++) {
				str = "0" + str;
			}
		}
		for(int j = 0;j<str.length();j++){
			if(str.charAt(j)=='0')
				res = res + "4";
			else
				res = res + "7";
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int T = scan.nextInt();
			//for (int i = 1; i <= T; i++) {
				System.out.print(getLucky2(T)+" ");
			//}
		}
	}
}