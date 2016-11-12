package enterp_program;


import java.util.Scanner;



public class _08_31_baidu_01 {
	public static int getRes(int[] nums){
		int num = 1;
		int pre = nums[0];
		for(int i = 1;i<nums.length;i++){
			if(nums[i]>pre){
				num++;
				pre = nums[i];
			}else if(nums[i]==pre){
				continue;
			}else{
				break;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int T = scan.nextInt();
			for(int i = 0;i<T;i++){
				int n = scan.nextInt();
				int[] nums = new int[n];
				for(int j = 0;j<n;j++){
					nums[j] = scan.nextInt();
				}
				System.out.println(getRes(nums));
			}
		}
	}
}
