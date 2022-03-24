package com.interviewbubble.rules.restruct;

import java.util.HashSet;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class POSTagRule {
	public Set<String> check_rules(Sentence sentence) {
		Set<String> matched_rules = new HashSet<>();
		boolean b1 = false, b2 = false;
		int length = Math.min(sentence.getLemmas().size(), sentence.getPosTag().size());
		for (int i = 0; i < length; i++) {
			if (sentence.getLemmas().get(i).equals("load") && sentence.getPosTag().get(i).contains("NN")) {
				matched_rules.add("ss8_load_nn");
			}
			if (sentence.getLemmas().get(i).equals("bound") || sentence.getLemmas().get(i).equals("inbound")) {
				if (sentence.getPosTag().get(i).contains("NN")) {
					matched_rules.add("tk2_bound");
				}
			}
			if (sentence.getLemmas().get(i).equals("block")) {
				if (sentence.getPosTag().get(i).contains("VB")) {
					matched_rules.add("sk2_block_vb");
				}
			}
		}
		return matched_rules;
	}
}
