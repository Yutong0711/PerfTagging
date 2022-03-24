package com.interviewbubble.rules.restruct;

import java.util.HashSet;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class FuzzyRule implements FuzzyRuleInterface {

	@Override
	public Set<String> check_rules(Sentence sentence) {
		// TODO Auto-generated method stub
		return new HashSet<>();
	}

	public Set<String> check_keywords(Sentence sentence) {
		String[] keywords = { "fast", "slow", "perform", "latency", "throughput", "optimiz", "optimis", "speed",
				"waste", "efficien", "necessary", "redundan", "too many times", "lot of time", "too much time" };
		Set<String> matched_keywords = new HashSet<>();
		for (String keyword : keywords) {
			if (sentence.getText().toLowerCase().contains(keyword)) {
				matched_keywords.add(keyword);
			}
		}

		return matched_keywords;
	}

}
