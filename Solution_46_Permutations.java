package main2;

import java.util.ArrayList;
import java.util.List;

public class Solution_46_Permutations {
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> permute(int[] nums) {
		res.clear();
		getPermute(0, nums);
		return res;
	}
	
	private static void getPermute(int start, int[] nums){
		if(start==nums.length){
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0;j<nums.length;j++){
				list.add(nums[j]);
			}
			res.add(list);
		}else{
			for(int i = start;i<nums.length;i++){
				//交换i与其后的
				swap(i, start, nums);
				getPermute(start+1, nums);
				swap(i, start, nums);
			}
		}
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4};
		List<List<Integer>> res = permute(nums);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> list = res.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}

}
