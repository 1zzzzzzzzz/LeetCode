package main2;

public class Solution_26_Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] nums){
		if(nums.length<=1)
			return nums.length;
		int same = 0, len = nums.length;
		int pre = nums[0];
		for(int i = 1;i<len-same;i++){
//			System.out.println("now processing "+nums[i]+" and pre: "+pre+" i:"+i);
			if(nums[i]==pre){
				//将从i+1~nums.length-1的元素向前移动一个单位
				for(int j = i+1;j<len;j++){
					nums[j-1] = nums[j];
				}
				i--;
				same++;
			}else{
				pre = nums[i];
			}
		} // for
		
		return len - same;
	}
	
	public static void main(String[] args) {
//		int nums[] = {1,1,2};
		int nums[] = {1,1,1,1,1,1,1};
//		int nums[] = {1,2,3,3,4,4,5,5,5,6};
		int newLen = removeDuplicates(nums);
		for(int i = 0;i<newLen;i++){
			System.out.print(nums[i]+" ");
		}
	}

}
