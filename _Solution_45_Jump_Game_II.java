package main2;


//Time Limit Exceeded
public class _Solution_45_Jump_Game_II {
	static int minStep = Integer.MAX_VALUE;
	public static int jump1(int[] nums) {
		int step = 0;
		if(nums.length==1)
			return 0;
		minStep = Integer.MAX_VALUE;
		getRes(0, nums, nums.length, step);
		return minStep;
	}

	private static void getRes(int index, int[] nums, int size, int step) {
		if(index >= size)
			return;
		if(step>=minStep)
			return;
		if(index==size-1){
			if(step<minStep)
				minStep = step;
			//System.out.println("minStep: "+minStep);
		}
		if(nums[index]==0)
			return;
		int end = nums[index];
		if(nums[index]>size-index)
			end = size - 1 -index;
		for(int i = end;i>=1;--i){
			System.out.println("nums[index]:"+nums[index]+" i:"+i);
			getRes(index+i, nums, size, step+1);
		}
	}
	
	//Accept
	public static int jump2(int[] nums) {
		int cur = nums[0];//当前一跳可达最远距
		int last = 0;    //上一跳可达的最远距离
		int minstep = 0;  //当前跳数
		
		for(int i = 1; i < nums.length; i++) {
			if (i > last) {
				minstep += 1;
				last = cur;
				if(last > nums.length - 1)
					return minstep;
			}
			cur = Math.max(cur, nums[i] + i);
			if (cur == i)
				return -1;
		}
		
		return minstep;
	}
	
	//后推法：反过来想，要达到最后一条，倒数第二条至少应该到哪个位置，以此类推直到我们倒推到第一位时便可知最小跳数
	public static int jump3(int[] nums) {
		int n = nums.length;
		int pre = 0;  
        int cur = n - 1;  
        int count = 0;  
        while(true)  
        {  
            if(pre == cur)  
            {  
                return 0;  
            }  
            count++;  
            pre = cur;  
            for(int i = n - 2; i >= 0; i--)  
            {  
                if(i + nums[i] >= pre)  
                {  
                    if(cur > i)  
                    {  
                        cur = i;  
                    }  
                }  
            }  
            if(cur == 0)  
            {  
                return count;  
            }  
        }
	}
	//动态规划DP：DP[i]代表到达i的最小跳数，显然DP是一个递增的数组。每次循环只需要尽量找到最小的DP[k]，使其满足k+A[k]>=n。
	public static int jump4(int[] nums) {
		int n = nums.length;
		if(n==0)  
        {  
            return -1;  
        }  
        int[] dp = new int[n];  
        dp[0] = 0;  
        for(int i=1;i<n;i++)  
        {  
            dp[i] = Integer.MAX_VALUE;  
        }  
        for(int i=1;i<n;i++)  
        {  
            for(int j=0;j<i;j++)  
            {  
                if(j+nums[j]>=i)  
                {  
                    int tmp = dp[j]+1;  
                    if(tmp < dp[i])  
                    {  
                        dp[i] = tmp;  
                        break;  
                    }  
                }  
            }  
        }  
          
        return dp[n-1];  
	}

	public static void main(String[] args) {
		//int nums[] = { 2, 3, 1, 1, 4 }; // 2
		//int nums[] = { 2, 3}; // 1
		//int nums[] = { 2, 3, 2}; // 1
		//int nums[] = { 2}; // 0
		//int nums[] = { 2, 9, 8, 3, 4}; // 2
		//int nums[] = { 2, 2, 1, 3, 4}; // 3
		//int nums[] = { 1, 2}; // 1
		//int nums[] = { 1, 2,8,3,1,1,1,5,4,9,5,7}; // 4
		//int nums[] = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}; // 5
		int nums[] = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}; // 13
		
		System.out.println(jump4(nums));
	}

}
