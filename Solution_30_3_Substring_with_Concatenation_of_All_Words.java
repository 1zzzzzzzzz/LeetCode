package main2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution_30_3_Substring_with_Concatenation_of_All_Words {
	/*
	 * "aaaaaaaa"
     * ["aa","aa","aa"]
     * [0,1,2]
	 */
	
	//运用组合方式，先组合words，生成字符串，再一个个匹配
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		
		//存放words单词次数
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0;i<words.length;i++){
			Integer integer = map.get(words[i]);
			if(integer!=null)
				map.put(words[i], ++integer);
			else
				map.put(words[i], 1);
		}
		//滑动窗口原理
		int singleLen = words[0].length();
		for(int start = 0;start<=s.length()-singleLen*words.length;start++){
			String subStr = s.substring(start, start+singleLen);
			//如果subStr中的
			System.out.println("start:"+start);
			if(map.containsKey(subStr)&&getIndexFromStr(map, start, s, singleLen, words.length)){
				res.add(start);
			}
		}
		return res;
	}
	
	public static boolean getIndexFromStr(Map<String, Integer> map, int start, String s, int singleLen, int L){
		boolean b = true;
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		for(int i = 0; i<L;i++){
			String word = s.substring(start+i*singleLen, start+(i+1)*singleLen);
			Integer integer = tempMap.get(word);
			
			if(integer==null){
				tempMap.put(word, 1);
			}else{
				tempMap.put(word, ++integer);
			}
		}
		
		//Accept
		if(!map.equals(tempMap))
			b = false;
		//使用此法比较会Time Limit Exceeded
//		Iterator<Entry<String, Integer>> it1 = map.entrySet().iterator();
//		while(it1.hasNext()){
//			Entry<String, Integer> entry1 = it1.next();
//			Integer integer2 = tempMap.get(entry1.getKey());
//			if(integer2 == null||(!integer2.equals(entry1.getValue()))){
//				b = false;
//				break;
//			}
//		}
//			
		return b;
	}
	
	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"bar","foo"}; //null
//		String s = "wordgoodgoodgoodbestword";
//		String[] words = {"word","good","best","good"}; //null
//		String s = "aaa";
//		String[] words = {"a","b"}; //null
//		String s = "aaaaaaaa";
//		String[] words = {"aa","aa", "aa"}; //0，1，2
//		String s = "barfoofoobarthefoobarman";
//		String[] words = {"bar","foo", "the"}; //6，9，12
		List<Integer> res = findSubstring(s, words);
		if(res.size()==0){
			System.out.println("res 为 空！");
			return;
		}
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i)+" ");
		}
	}

}
