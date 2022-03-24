package com.interviewbubble.rules.restruct;

import java.util.List;

import com.interviewbubble.entity.Sentence;

public class CheckingHelper {
	public List<Sentence> check_all_rules(List<Sentence> sentences) {
		SingleKeywordRule singleKeywordRule = new SingleKeywordRule();
		DoubleKeywordsRule doubleKeywordsRule = new DoubleKeywordsRule();
		TextContainsRule textContainsRule = new TextContainsRule();
		POSTagRule posTagRule = new POSTagRule();
		NERTagRule nerTagRule = new NERTagRule();

		for (Sentence sentence : sentences) {
			sentence.setMatchedKeywords(singleKeywordRule.check_keywords(sentence));
			sentence.setFittedPerfRules(singleKeywordRule.check_rules(sentence));
			sentence.setFittedPerfRules(doubleKeywordsRule.check_rules(sentence));
			sentence.setFittedPerfRules(textContainsRule.check_rules(sentence));
			sentence.setFittedPerfRules(posTagRule.check_rules(sentence));
			sentence.setFittedPerfRules(nerTagRule.check_rules(sentence));
		}
		return sentences;
	}
}
