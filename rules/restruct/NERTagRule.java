package com.interviewbubble.rules.restruct;

import java.util.HashSet;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class NERTagRule {
	public Set<String> check_rules(Sentence sentence) {
		Set<String> matched_rules = new HashSet<>();
		int length = Math.min(sentence.getLemmas().size(), sentence.getNerTag().size());
		for (int i = 0; i < length; i++) {
			if (sentence.getNerTag().get(i).equals("PERCENT")) {
				for (String lemma : sentence.getLemmas()) {
					if (lemma.equals("time")) {
						matched_rules.add("pf1_time_percentage");
					}
				}
			}
			if (sentence.getNerTag().get(i).equals("DURATION")) {
				String lemma = sentence.getLemmas().get(i);
				if (lemma.contains("min") || lemma.contains("sec") || lemma.contains("ms")) {
					matched_rules.add("pf2_duration");
				}
			}
		}
		return matched_rules;
	}
}
