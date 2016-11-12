package main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//全排列中去掉重复的规则——去重的全排列就是从第一个数字起每个数分别与它后面非重复出现的数字交换
public class Solution_47_Permutations_II {
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> permuteUnique(int[] nums) {
		res.clear();
		Arrays.sort(nums);
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
				if(!isDuplicate(nums, start, i)){
					swap(i, start, nums);
					getPermute(start+1, nums);
					swap(i, start, nums);
				}
			}
		}
	}
	
	//查找在[start,i)区间内是否有与i相等的元素
	private static boolean isDuplicate(int[] nums, int start, int i) {
        for (int j = start; j < i; j++) {
            if (nums[j] == nums[i]) {
                return true;
            }
        }
        return false;
    }

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int nums[] = { 1, 1, 2, 2};
		List<List<Integer>> res = permuteUnique(nums);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> list = res.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}
}
