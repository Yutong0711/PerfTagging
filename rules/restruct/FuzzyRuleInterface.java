package com.interviewbubble.rules.restruct;

import java.util.Set;

import com.interviewbubble.entity.Sentence;

public interface FuzzyRuleInterface {

	public Set<String> check_rules(Sentence sentence);

}
