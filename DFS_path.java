package main2;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_path {
	
	static int minRes = Integer.MAX_VALUE;
	static ArrayList<Integer> X = new ArrayList<Integer>();
	static ArrayList<Integer> Y = new ArrayList<Integer>();
	
	private static void getStep1(int[][] arr, boolean[][] f, int i, int j, int n, int min) {
		if(i==n-1&&j==n-1){
			outPutQueue();
			if(min<minRes)
				minRes = min;
			return;
		}
		// 上
		if (i - 1 >= 0 && f[i-1][j]==false && arr[i - 1][j] == 0) {
			X.add(i-1);
			Y.add(j);
			f[i-1][j] = true;
			++min;
			getStep1(arr, f, i - 1, j, n, min);
			--min;
			f[i-1][j] = false;
			X.remove(X.size()-1);
			Y.remove(Y.size()-1);
		}
		// 下
		if (i + 1 < n && f[i+1][j]==false && arr[i + 1][j] == 0) {
			X.add(i+1);
			Y.add(j);
			f[i+1][j] = true;
			++min;
			getStep1(arr, f, i + 1, j, n, min);
			--min;
			f[i+1][j] = false;
			X.remove(X.size()-1);
			Y.remove(Y.size()-1);
		}
		// 左
		if (j - 1 >= 0 && f[i][j - 1] == false && arr[i][j - 1] == 0) {
			X.add(i);
			Y.add(j-1);
			f[i][j-1] = true;
			++min;
			getStep1(arr, f, i, j-1, n, min);
			--min;
			f[i][j-1] = false;
			X.remove(X.size()-1);
			Y.remove(Y.size()-1);
		}
		// 右
		if (j + 1 < n && f[i][j + 1] == false && arr[i][j + 1] == 0) {
			X.add(i);
			Y.add(j+1);
			f[i][j+1] = true;
			++min;
			getStep1(arr, f, i, j+1, n, min);
			--min;
			f[i][j+1] = false;
			X.remove(X.size()-1);
			Y.remove(Y.size()-1);
		}
	}

	private static void outPutQueue() {
		System.out.print("路径为： ");
		for(int i = 0;i<X.size();i++){
			System.out.print("("+X.get(i)+", "+Y.get(i)+")->");
		}
		System.out.println("end");
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			minRes = Integer.MAX_VALUE;
			int n = scan.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			boolean[][] f = new boolean[n][n];
			for(int i = 0;i<n;i++){
				for(int j = 0;j<n;j++){
					f[i][j] = false;
				}
			}
			f[0][0] = true;
			X.add(0);
			Y.add(0);
			getStep1(arr, f, 0, 0, n, 0);
			System.out.println("minRes: "+minRes);
		}
	}

}