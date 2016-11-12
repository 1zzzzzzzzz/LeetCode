public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        for(int i = 0;i<nums.length;i++){
            int temp = target - nums[i];
            int index = getIndex(nums, temp, i);
            if(index != -1){
                res[0] = i;
                res[1] = index;
                break;
            }
        }
        return res;
    }
    
    public int getIndex(int[] nums, int x, int nowId){
        int index = -1;
        for(int i = 0;i<nums.length;i++){
            if(i==nowId){
                continue;
            }
            if(nums[i]==x){
                index = i;
                break;
            }// if
        }// for
        return index;
    }
}