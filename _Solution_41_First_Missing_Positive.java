package main2;

public class _Solution_41_First_Missing_Positive {
	
	/*
	 * The basic idea is to traversal and try to move the current value to 
	 * position whose index is exactly the value (swap them). Then travelsal 
	 * again to find the first unusal value, which can not be corresponding to 
	 * its index.
	 */
	public static int firstMissingPositive(int[] nums) {
		int res = -1;
		for(int i = 0;i<nums.length;i++){
			if(i!=nums[i]-1){ 
				//cur要放在的位置已经等于cur了，即nums[cur]==cur，或者cur的值大于nums.length,下一个
				if(nums[i]<=0||nums[i]>=nums.length||nums[i]==nums[nums[i]-1])
					continue;
				swap(nums, i, nums[i]-1);
				if((nums[i]-1)!=i)
					i--;
			}
		}
		displayNums(nums);
		int j = 0;
		for(;j<nums.length;j++){
			if((j+1)!=nums[j]){
				res = j+1;
				break;
			}
		}
		if(j==nums.length)
			res = nums.length+1;
		return res;
	} 
	
	private static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void displayNums(int[] nums) {
		System.out.println("output nums:");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		int[] nums = { 3, 4, -1, 1 };
//		int[] nums = { 3, 4, -1, 1, 8, -7,-9,-10,3,4,-22};
		int[] nums = { 1, 2, 0};
		System.out.println(firstMissingPositive(nums));
	}
}
