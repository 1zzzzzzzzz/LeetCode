package main2;

import java.util.Scanner;

public class Main {
	static int pos = 0;
	static Node[] node = new Node[100005 * 4];

	class Node {
		public int next[] = new int[3];
		public int nm;

		public Node() {
		}
	}

	public static int makend() {
		int i;
		pos++;
		if(node[pos]==null)
			node[pos] = new Main().new Node();
		for (i = 0; i < 2; i++)
			node[pos].next[i] = -1;
		node[pos].nm = 0;
		return pos;
	}

	public static void _insert(int x) {
		int cur = 0, i=0;
		for (i = 0; i < 30; i++) {
			int flag = 0;
			if((x!=0)&((1 << i)!=0)){
				flag = 1;
			}else{
				flag = 0;
			}
			if (node[cur].next[flag] == -1)
				node[cur].next[flag] = makend();
			cur = node[cur].next[flag];
		}
		node[cur].nm = x;
	}

	public static int findd(int x) {
		int cur = 0, i;
		for (i = 0; i < 30; i++) {
			int flag = 0;
			if((x!=0)&((1 << i)!=0)){
				flag = 1;
			}else{
				flag = 0;
			}
			if (flag == 1) {
				if (node[cur].next[0] != -1)
					cur = node[cur].next[0];
				else
					cur = node[cur].next[1];
			} else if (flag == 0) {
				if (node[cur].next[1] != -1)
					cur = node[cur].next[1];
				else
					cur = node[cur].next[0];
			}

		}
		return x ^ node[cur].nm;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] arr = new int[n];
			int mx = 0;
			pos = 0;
			node[pos] = new Main().new Node();
			for(int i = 0;i<2;i++){
				node[pos].next[i] = -1;
			}
			node[pos].nm = 0;
			for(int i = 0;i<n;i++){
				arr[i] = scan.nextInt();
				if(i!=0){
					if(findd(arr[i])>m){
						mx++;
					}
							
				}
				_insert(arr[i]);
			}
			System.out.println(mx);
		}
	}
}