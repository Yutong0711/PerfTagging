package com.interviewbubble.analysis;

import java.util.ArrayList;
import java.util.List;

import com.interviewbubble.entity.Sentence;
import com.interviewbubble.utils.Utils;

public class QuickCheckSentences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String me_path = "./input/sentences-checking/impala-perf-issues-sentences.csv";
		String other_path = "./input/sentences-checking/Rana.csv";
		List<Sentence> mine = loadFromCsv(me_path);
		List<Sentence> others = loadFromCsv(other_path);
		int same = 0, differ = 0;
		for (Sentence s1 : others) {
			for (Sentence s2 : mine) {
				if (s1.getKey().equals(s2.getKey())) {
					if (s1.getNumber() == s2.getNumber() || s1.getText().equals(s2.getText())) {
						if (s1.getPerfTag().equals(s2.getPerfTag())) {
							same++;
						} else if (s1.getPerfTag().equalsIgnoreCase("maybe")
								&& s2.getPerfTag().equalsIgnoreCase("unsure")) {
							same++;
						} else {
							differ++;
						}
					}
				}
			}
		}
		System.out.println("Same: " + same);
		System.out.println("Disagreement: " + differ);
	}

	private static List<Sentence> loadFromCsv(String path) {
		List<Sentence> result = new ArrayList<>();
		try {
			List<String[]> list = Utils.readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				Sentence sentence = new Sentence();
				sentence.setKey(list.get(r)[0]);
				sentence.setNumber(Integer.parseInt(list.get(r)[1]));
				sentence.setText(list.get(r)[2]);
				sentence.setPerfTag(list.get(r)[3]);
				result.add(sentence);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Load " + result.size() + " sentences.");
		return result;
	}
}
