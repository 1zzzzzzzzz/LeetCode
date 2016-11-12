package main2;

//AC，原地进行旋转，自己写的有点复杂，可参考：
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 * 
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
public class Solution_48_Rotate_Image {
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int j = 0;
		for(int i = n;i>=1;i-=2){
			System.out.println("i:"+i);
			getRotate(matrix, j, j, i-1, n);
			++j;
		}
	}
	
	public static void getRotate(int[][] matrix, int begin_row, int begin_col, int interval, int n){
		System.out.println("begin_row: "+begin_row+" begin_col: "+begin_col+" interval: "+interval);
		//最后一个元素不能再次交换
		for(int i = begin_col;i<begin_row+interval;i++){
			int temp = matrix[begin_row][i];
			int temp_row = begin_row;
			int temp_col = i;
			for(int j = 0;j<4;j++){
				System.out.println("temp:"+temp);
				int next_i = temp_col;
				int next_j = n - 1 - temp_row;
				int next = matrix[next_i][next_j];
				swap(matrix, next_i, next_j, temp);
				temp_row = next_i;
				temp_col = next_j;
				temp = next;
			}
		}
	}

	private static void swap(int[][] matrix, int i, int j, int value) {
		int temp = matrix[i][j];
		matrix[i][j] = value;
		value = temp;
	}

	public static void main(String[] args) {
//		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] matrix = {{1,2},{3,4}};
		int[][] matrix = {{1}};
		rotate(matrix);
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
