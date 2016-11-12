package main2;

public class Solution_35_Search_Insert_Position {
	public static int searchInsert(int[] nums, int target) {
		int index = 0;
		int f = 0;
		for(int i = 0;i<nums.length;i++){
			if(nums[i]>=target){
				f = 1;
				index = i;
				break;
			}
		}
		if(f==0)
			index = nums.length;
		return index;
	}

	public static void main(String[] args) {
//		int[] nums = {1,3,5,6};
//		int target = 5;
		
		int[] nums = {1,3,5,6};
		int target = 0;
		
		System.out.println("result: "+searchInsert(nums, target));
	}

}
