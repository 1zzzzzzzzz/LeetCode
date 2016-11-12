package main2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _Solution_40_Combination_Sum_III {

	private static int getRes(int[] nums) {
		int minNum = 0;
		for(int target = 1;target<=100000;target++){
			if(!getRes(nums, target)){
				minNum = target;
				break;
			}
		}
		return minNum;
	}
	
	
	private static boolean getRes(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = nums[0];
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		int now = s.peek();
		while(true){
			if(sum<target){
				now++;
				if(now<nums.length){
					s.push(now);
					sum+=nums[now];
				}else{
					if(s.empty()){
						return false;
					}else{
						now = s.peek();
						s.pop();
						sum-=nums[now];
					}
				}
			}else if(sum>target){
				if(s.size()<2)
					return false;
				sum -= nums[s.peek()];
				s.pop();
				sum-=nums[s.peek()];
				now = s.peek();
				s.pop();
			}else{
				return true;
			}
		}
				
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int nums[] = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = scan.nextInt();
			}
			System.out.println(getRes(nums));
		}
	}

}
