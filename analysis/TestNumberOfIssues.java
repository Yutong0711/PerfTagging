package com.interviewbubble.analysis;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.interviewbubble.utils.Utils;

public class TestNumberOfIssues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "./perf-label-issues-list.csv";
		TestNumberOfIssues testNumberOfIssues = new TestNumberOfIssues();
		Map<String, Integer> list = testNumberOfIssues.getPerfIssueKeyList(path);
		Map<String, Integer> sorted = testNumberOfIssues.sortByValue(list);
		for (Map.Entry<String, Integer> en : sorted.entrySet()) {
			System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
		}
	}

	public static HashMap<String, Integer> sortByValue(Map<String, Integer> list2) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(list2.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public Map<String, Integer> getPerfIssueKeyList(String path) {
		Map<String, Integer> res = new HashMap<>();
		try {
			List<String[]> list = Utils.readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				String key = list.get(r)[0];
				String project = key.split("-")[0];
				if (res.containsKey(project)) {
					int temp = res.get(project);
					temp = temp + 1;
					res.put(project, temp);
				} else {
					res.put(project, 1);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
