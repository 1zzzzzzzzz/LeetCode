package main2;

public class Solution_33_Search_in_Rotated_Sorted_Array {
	public static int search1(int[] nums, int target) {
		int index = -1;
		for(int i = 0;i<nums.length;i++){
			if(nums[i]==target){
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	public static int search2(int[] nums, int target) {
		int index = -1;
		int left = 0, right = nums.length-1;
		int middle = (left+right)/2;
		if(target==nums[left])
			return left;
		if(target==nums[right])
			return right;
		if(target==nums[middle])
			return middle;
		
		while(left<=right){
			//数组没有发生旋转
			if(nums[left]<=nums[right])
				return subSearch2(nums, left, right, target);
			
			//target在左边有序的部分
			if(nums[middle]>=nums[left]){
				if(target>=nums[left]&&target<=nums[middle])
					return subSearch2(nums, left, middle, target);
				
				//target在右边无序的部分
				if(target<=nums[left]){
					left = middle+1;
					middle = (left+right)/2;
					continue;
				}else{
					right = right - 1;
					continue;
				}
				
			}else{
				if(target>=nums[middle]&&target<=nums[right])
					return subSearch2(nums, middle, right, target);
				
				if(target>=nums[right]){
					right = middle-1;
					middle = (left+right)/2;
					continue;
				}else{
					left = left + 1;
					continue;
				}
			}
		}
		return index;
	}
	
	public static int subSearch2(int[] nums, int left, int right, int target){
		int index = -1;
		while(left<=right){
			int middle = (left+right)/2;
			if(nums[middle]==target){
				index = middle;
				break;
			}
			if(nums[middle]>target)
				right = middle - 1;
			if(nums[middle]<target)
				left = middle + 1;
		}
		return index;
	}

	public static void main(String[] args) {
//		int nums[] = {0, 1, 2, 4, 5, 6, 7};
//		int target = 4;
//		int nums[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
//		int target = 2;
//		int nums[] = {1};
//		int target = 1;
//		int nums[] = {3,1};
//		int target = 2;
//		int nums[] = {4,5,6,7,0,1,2};
//		int target = 6;
		int nums[] = {4,5,6,7,8,1,2,3};
		int target = 9;
		System.out.println("Result: "+search2(nums, target));
//		System.out.println("Result: "+subSearch2(nums, 0, nums.length-1,  target));
	}

}
