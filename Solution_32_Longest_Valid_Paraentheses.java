package main2;

import java.util.Arrays;
import java.util.Stack;

public class Solution_32_Longest_Valid_Paraentheses {

	// longestValidParentheses1  Time Limit Exceeded
	// longestValidParentheses2  Accept!
	
	public static int longestValidParentheses1(String s) {
		int len = s.length();
		if (s.length() == 0)
			return len;
		int[] pre = new int[len];
		int[] f = new int[len];
		int max = 0;
		
		boolean b = true;
		for (int j = 1; j < len; j++) {
			if (s.charAt(j-1) == '(' && s.charAt(j) == ')') {
				f[j] = 1;
				f[j - 1] = 1;
				b = false;
			} // if
		}
		if(b==true)
			return 0;
		// 如果改之后的f和pre数组不相等，继续循环
		while (!Arrays.equals(f, pre)) {
			System.arraycopy(f, 0, pre, 0, len);
			int left = -1, right = -1;
			for (int i = 1; i < len; i++) {
				if (f[i - 1] == 0 && f[i] == 0 || f[i - 1] == 1 && f[i] == 1) {
					continue;
				}

				// left为0和1的分界点
				if (f[i - 1] == 0 && f[i] == 1) {
					left = i - 1;
					continue;
				}

				// right为1和0的分界点
				if (f[i - 1] == 1 && f[i] == 0) {
					right = i;
				}
				if (left != -1 && right != -1) {
					if (s.charAt(left) == '(' && s.charAt(right) == ')') {
						f[left] = 1;
						f[right] = 1;
					}
				}
				left = -1;
				right = -1;
			} // for
		} // while
		outputF(f);

		int cur = 0;
		for (int j = 0; j < len; j++) {
			if (f[j] == 1) {
				++cur;
			} else {
				if (cur > max) {
					max = cur;
				}
				cur = 0;
			}
		}
		if (cur > max)
			max = cur;
		return max;
	}
	public static int longestValidParentheses2(String s) {
		int len = s.length();
		if (s.length() == 0)
			return len;
		int[] f = new int[len];
		int max = 0;
		Stack<Integer> stack  = new Stack<Integer>();
		for(int i = 0;i<len;i++){
			if(s.charAt(i)=='('){
				stack.push(i);
			}else{
				// ')'
				if(!stack.empty()){
					int temp = stack.peek();
					stack.pop();
					f[temp] = 1;
					f[i] = 1;
				}else{
					// 当前是')'，且栈空
					//stack.push(item)
				}
			}
		}
		
		outputF(f);
		
		int cur = 0;
		for (int j = 0; j < len; j++) {
			if (f[j] == 1) {
				++cur;
			} else {
				if (cur > max) {
					max = cur;
				}
				cur = 0;
			}
		}
		if (cur > max)
			max = cur;
		return max;
	}

	// output array f
	public static void outputF(int[] f) {
		for (int i = 0; i < f.length; i++) {
			System.out.print(f[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String s1 = ")()())"; // 4
		String s2 = "()"; // 2
		String s3 = ")))"; // 0
		String s4 = "((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("; // 0
		String s5 = "((()"; // 2
		String s6 = "()))"; // 2
		String s7 = "()()"; // 4
		String s8 = "()(())"; // 6
		String s9 = "()(((())()()()"; // 10
		String s10 = "())(((())))))))()()()"; // 8
		String s11 = ")((()(())))"; // 10
		String s12 = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
		String s13 = "(()"; // 10
		System.out.println("result: " + longestValidParentheses2(s13));
	}

}
