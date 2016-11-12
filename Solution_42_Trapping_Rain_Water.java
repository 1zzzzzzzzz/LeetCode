package main2;


// AC  ����ͷ����
public class Solution_42_Trapping_Rain_Water {
	public static int trap(int[] height) {
		if(height.length<3)
			return 0;
		int sum = 0;
		int len = height.length;
		int preV = height[0], preIndex = 0, aftV = height[len-1], aftIndex = len-1;
		while(preIndex!=aftIndex){
			//�ҵ���preV��� 
			for(int i = preIndex+1;i<=aftIndex;i++){
				if(height[i]>=preV){
					//����preIndex~i��sumֵ
					int interval = i - preIndex - 1;
					int tempSum = preV * interval;
					for(int k = preIndex+1;k<i;k++){
						tempSum = tempSum - height[k];
					}
					sum = sum + tempSum;
					//����
					preV = height[i];
					preIndex = i;
					break;
				}
			}
			
			// �ҵ���aftV���
			for(int j = aftIndex - 1;j>=preIndex;j--){
				if(height[j]>=aftV){
					//����j~aftIndex��sumֵ
					int interval = aftIndex - j - 1;
					int tempSum = aftV * interval;
					for(int k = j+1;k<aftIndex;k++){
						tempSum = tempSum - height[k];
					}
					sum = sum + tempSum;
					//����
					aftV = height[j];
					aftIndex = j;
					break;
				}
			}
		} // while
		return sum;
	}

	public static void main(String[] args) {
		//int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};//6
//		int[] height = {4, 1, 0, 2, 0, 3, 0, 5}; //18
		int[] height = {3,0,3};
		System.out.println(trap(height));
	}

}
