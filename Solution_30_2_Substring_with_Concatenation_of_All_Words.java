package main2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Solution_30_2_Substring_with_Concatenation_of_All_Words {
	//Time Limit Exceeded
	static HashSet<String> wordSet = new HashSet<String>();
	static List<Integer> res = new ArrayList<Integer>();
	//运用组合方式，先组合words，生成字符串，再一个个匹配
	public static List<Integer> findSubstring(String s, String[] words) {
		res.clear();
		wordSet.clear();
		permutation(words, 0, words.length-1);
		
		Iterator<String> it = wordSet.iterator();
		while(it.hasNext()){
			String search = it.next();
			findIndex(s, search, words[0].length());
		}
		return res;
	}
	
//	public static void findIndex(String s, String search, int singleLen){
//		//System.out.println("s: "+s+" search: "+search);
//		int pos = s.indexOf(search);
//		while(pos!=-1){
//			res.add(pos);
//			pos = s.indexOf(search, pos+singleLen-1);
//			//break;
//		}
//	}
	public static void findIndex(String s, String search, int singleLen){
		//System.out.println("s: "+s+" search: "+search);
		int pos = s.indexOf(search);
		int pre = 0;
		while(pos!=-1){
			res.add(pos);
			pre = pos;
			pos = s.indexOf(search, pos+singleLen);
			if(pre==pos)
				break;
			//break;
		}
	}
	
	public static void permutation(String[] words, int index, int len){
		if(index==len){
			String t = "";
			for(int p = 0;p<words.length;p++)
				t = t + words[p];
			//System.out.println(t);
			wordSet.add(t);
		}else{
			for(int i = index;i<=len;i++){
				String temp = words[index];
				words[index] = words[i];
				words[i] = temp;
				
				permutation(words, index+1, len);
				
				temp = words[index];
				words[index] = words[i];
				words[i] = temp;
			}
		}
	}
	

	public static void main(String[] args) {
//		String s = "barfoofoobarthefoobarman";
//		String[] words = {"bar","foo", "the"}; //same length
		String s = "aaaaaaaa";
		String[] words = {"aa","aa","aa"}; //same length
		List<Integer> res = findSubstring(s, words);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i)+" ");
		}
	}

}
