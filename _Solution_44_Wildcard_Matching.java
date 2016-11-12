package main2;

import java.util.Scanner;

public class _Solution_44_Wildcard_Matching {

	// DP answer
	/*
	 * Let's briefly summarize the idea of DP. We define the state P[i][j] to be whether s[0..i) matches p[0..j). 
	 * The state equations are as follows:
	 * P[i][j] = P[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?'), if p[j - 1] != '*';
	 * P[i][j] = P[i][j - 1] || P[i - 1][j], if p[j - 1] == '*'.
	 * 
	 *     p[i][j-1]:   s[0......i-1] match p[0......j-2],p[j-1]='*'
	 *     p[i-1][j]:   s[0......i-2] match p[0......j-2,j-1],p[j-1]='*'
	 */
	public static boolean isMatch1(String s, String p) {
		int m = s.length(), n = p.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*')
				count++;
		}
		if (count == 0 && m != n)
			return false;
		else if (n - count > m)
			return false;

		boolean[] match = new boolean[m + 1];
		match[0] = true;
		for (int i = 0; i < m; i++) {
			match[i + 1] = false;
		}

		// now match: true, false......false
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*') {
				for (int j = 0; j < m; j++) {
					match[j + 1] = match[j] || match[j + 1];
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					match[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s
							.charAt(j)) && match[j];
				}
				match[0] = false;
			}
		}
		return match[m];
	}

	public static boolean isMatch2(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) != '*')
				break;
			else
				match[s.length()][i] = true;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
					match[i][j] = match[i + 1][j + 1];
				else if (p.charAt(j) == '*')
					match[i][j] = match[i + 1][j] || match[i][j + 1];
				else
					match[i][j] = false;
			}
		}
		return match[0][0];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String s = scan.next();
			String p = scan.next();
			System.out.println(isMatch1(s, p));
		} // while
	}

}
