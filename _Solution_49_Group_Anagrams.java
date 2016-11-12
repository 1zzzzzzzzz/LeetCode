package main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _Solution_49_Group_Anagrams {
    // Time Limit Exceeded
	public static List<List<String>> groupAnagrams(String[] strs) {
		String[] sortedStrs = new String[strs.length];
		for(int i = 0;i<strs.length;i++){
			sortedStrs[i] = getSortedStr(strs[i]);
		}
		List<List<String>> resList = new ArrayList<List<String>>();
		for(int j = 0;j<strs.length;j++){
			String curStr = strs[j];
			List<String> cur = isExist(resList, curStr);
			if(cur!=null){
				cur.add(strs[j]);
			}else{
				cur = new ArrayList<String>();
				cur.add(strs[j]);
				resList.add(cur);
			}
		}
		return resList;
	}
	
	private static String getSortedStr(String str){
		char[] tempArr = str.toCharArray();
		Arrays.sort(tempArr);
		return String.valueOf(tempArr);
	}
	
	private static List<String> isExist(List<List<String>> resList, String s){
		List<String> list = null;
		s = getSortedStr(s);
		for(int i = 0;i<resList.size();i++){
			if(resList.get(i).size()>0){
				String tempStr = resList.get(i).get(0);
				if(getSortedStr(tempStr).equals(s)){
					list = resList.get(i);
					break;
				}
				
			}
		}
		return list;
	}
    
	//AC1
	public static List<List<String>> groupAnagrams2(String[] strs) {
		if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
	}
	//AC2
	public static List<List<String>> groupAnagrams3(String[] strs) {
		int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//×î¶à10609¸öz
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<String>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
	}
	
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> resList = groupAnagrams(strs);
		for (int i = 0; i < resList.size(); i++) {
			List<String> tempList = resList.get(i);
			for (int j = 0; j < tempList.size(); j++) {
				System.out.print(tempList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
