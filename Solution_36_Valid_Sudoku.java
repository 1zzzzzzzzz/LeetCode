package main2;

public class Solution_36_Valid_Sudoku {
	public static boolean isValidSudoku(char[][] board){
		int row = board.length;
		int col = board[0].length;
		for(int i = 0;i<row;i++){
			for(int j = 0;j<col;j++){
				if(board[i][j]=='.')
					continue;
//				System.out.println("search: "+board[i][j]+" pos-i: "+i+" j:"+j);
				//验证 board[i][j]的当前i行是否有重复的
				for(int k = 0;k<col&&k!=j;k++){
					if(board[i][k]==board[i][j])
						return false;
				}
				//验证board[i][j]的当前j列是否有重复的
				for(int m = 0;m<col&&m!=i;m++){
					if(board[m][j]==board[i][j])
						return false;
				}
				//验证board[i][j]的当前方格中是否有重复的
//				if(i==1&&j==3)
//					System.out.println("startRow: "+(i/3)*3+" startCol: "+(j/3)*3);
				if(!isExist(board[i][j], board, (i/3)*3, (j/3)*3, i, j))
					return false;
			}
		} //for
		return true;
	}
	
	public static boolean isExist(int x, char[][] board, int startRow, int startCol, int xI, int xJ){
		for(int i = startRow;i<startRow+3;i++){
			for(int j = startCol;j<startCol+3;j++){
				if(i==xI&&j==xJ)
					continue;
				if(board[i][j]==x){
					return false;
				}
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
//		char[][] a = {{'.','8','7','6','5','4','3','2','1'},
//				      {'2','.','.','.','.','.','.','.','.'},
//				      {'3','.','.','.','.','.','.','.','.'},
//				      {'4','.','.','.','.','.','.','.','.'},
//				      {'5','.','.','.','.','.','.','.','.'},
//				      {'6','.','.','.','.','.','.','.','.'},
//				      {'7','.','.','.','.','.','.','.','.'},
//				      {'8','.','.','.','.','.','.','.','.'},
//				      {'9','.','.','.','.','.','.','.','.'}};
		
		char[][] a = {{'.','.','.','.','5','.','.','1','.'},
				      {'.','4','.','3','.','.','.','.','.'},
				      {'.','.','.','.','.','3','.','.','1'},
				      {'8','.','.','.','.','.','.','2','.'},
				      {'.','.','2','.','7','.','.','.','.'},
				      {'.','1','5','.','.','.','.','.','.'},
				      {'.','.','.','.','.','2','.','.','.'},
				      {'.','2','.','9','.','.','.','.','.'},
				      {'.','.','4','.','.','.','.','.','.'}};
		
		System.out.println("ressult: "+isValidSudoku(a));
	}

}
