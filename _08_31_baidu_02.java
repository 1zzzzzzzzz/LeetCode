package enterp_program;


import java.util.Scanner;

public class _08_31_baidu_02 {
	/*
	 * 	1	0	0	0	0
	 *  2	3	0	0	0
	 *  4	5	6	0	0
	 *  10	1	7	8	0
	 *  1	1	4	5	6
	 */
	public static int getMinCos(int[][] nums, int n, int i, int j, int flag){
		//System.out.println("i: "+i+" j:"+j);
		int Lsum = Integer.MAX_VALUE, Rsum = Integer.MAX_VALUE, LXsum = Integer.MAX_VALUE, RXsum = Integer.MAX_VALUE;
		if(i == n-1)
			return nums[i][j];
		//宸�
		if(j-1>=0&&flag!=1){
			Lsum = getMinCos(nums, n, i, j-1, 2) + nums[i][j];
		}
		//鍙�
		if(j+1<=i&&flag!=2){
			Rsum = getMinCos(nums, n, i, j+1, 1) + nums[i][j];
		}
		//宸︿笅鏂�
		if(j-1>=0){
			LXsum = getMinCos(nums, n, i+1, j-1, 0) + nums[i][j];
		}
		//鍙充笅鏂�
		if(j+1<=i+1){
			RXsum = getMinCos(nums, n, i+1, j+1, 0) + nums[i][j];
		}
		//System.out.println(Lsum+" "+Rsum+" "+LXsum+" "+RXsum);
		//int tempMin = Math.min(Math.min(Lsum, Rsum), Math.min(LXsum, RXsum));
		return Math.min(Math.min(Lsum, Rsum), Math.min(LXsum, RXsum));
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int nums[][] = new int[n][n];
			int flag[][] = new int[n][n];
			for(int i = 0;i<n;i++){
				for(int j = 0;j<=i;j++){
					nums[i][j] = scan.nextInt();
				}
			}
			
			System.out.println(getMinCos(nums, n, 0, 0, 0));
		}
		scan.close();
	}

}
