package main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Solution_40_Combination_Sum_II {
	
	static List<List<Integer>> resList = new ArrayList<List<Integer>>();
	static List<Integer> temp = new ArrayList<Integer>();
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
		int pre = 0;
		for(int i = level;i<candidates.length;i++){
			if(pre==candidates[i])
				continue;
			sum = sum + candidates[i];
			temp.add(candidates[i]);
			getCombination(candidates, target, sum, i+1);
			temp.remove(temp.size()-1);
			sum = sum - candidates[i];
			pre = candidates[i];
		}
	}

	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 1;
		List<List<Integer>> resList = combinationSum2(candidates, target);
		for (int i = 0; i < resList.size(); i++) {
			List<Integer> tempList = resList.get(i);
			for (int j = 0; j < tempList.size(); j++) {
				System.out.print(tempList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
