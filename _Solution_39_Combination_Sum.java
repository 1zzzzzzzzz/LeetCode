package main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Solution_39_Combination_Sum {

	static List<List<Integer>> resList = new ArrayList<List<Integer>>();
	static List<Integer> temp = new ArrayList<Integer>();
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates.length==0)
			return null;
		Arrays.sort(candidates);
		resList.clear();
		temp.clear();
		getCombination(candidates, target, 0, 0);
		return resList;
	}

	private static void getCombination(int[] candidates, int target, int sum, int level) {
		if(sum>target)
			return;
		if(sum==target){
			resList.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = level;i<candidates.length;i++){
			sum = sum + candidates[i];
			temp.add(candidates[i]);
			getCombination(candidates, target, sum, i);
			temp.remove(temp.size()-1);
			sum = sum - candidates[i];
		}
	}

	public static void main(String[] args) {
//		int[] candidates = { 2, 3, 6, 7 };
//		int target = 7;
		int[] candidates = { 2, 3, 6, 7, 8 };
		int target = 10;
		List<List<Integer>> resList = combinationSum(candidates, target);
		for (int i = 0; i < resList.size(); i++) {
			List<Integer> tempList = resList.get(i);
			for (int j = 0; j < tempList.size(); j++) {
				System.out.print(tempList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
