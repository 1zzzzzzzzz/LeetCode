package main2;

import java.util.ArrayList;
import java.util.List;

public class Solution_30_1_Substring_with_Concatenation_of_All_Words {
	
	//Time Limit Exceeded
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		int singleLen = words[0].length();
		int endLen = words.length*singleLen;
		//开始查找
		for(int start = 0; start<= s.length()-endLen;start++){
			String subStr = s.substring(start, start+endLen);
			if(findExist(words, subStr)){
				res.add(start);
			}
		}
		return res;
	}
	
	public static boolean findExist(String[] words, String search){
		boolean b = true;
		//设置标志位
		int[] flag = new int[words.length];
		for(int i = 0;i<flag.length;i++){
			flag[i] = 0;
		}
		
		int singleLen = words[0].length();
		for(int start = 0;start<=search.length()-singleLen;start+=singleLen){
			String word = search.substring(start, start+singleLen);
			if(getIndex(flag, words, word)==-1){
				b = false;
				break;
			}
		}
		return b;
	}
	
	public static int getIndex(int[] flag, String[] words, String search){
		int index = -1;
		for(int i = 0;i<words.length;i++){
			if(flag[i]==1)
				continue;
			if(search.equals(words[i])){
				index = i;
				flag[i] = 1;
				break;
			} // if
		} // for
		return index;
	}
	

	public static void main(String[] args) {
		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words = {"fooo","barr","wing","ding","wing"}; //same length
//		String s = "barfoothefoobarman";
//		String[] words = {"foo", "bar"}; //same length
		List<Integer> res = findSubstring(s, words);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i)+" ");
		}
	}

}
