package com.interviewbubble.rules;

import java.util.List;

import com.interviewbubble.entity.Sentence;

public class TerminologyKeywordRules {
	public static boolean tk1_contended_lock(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("contended")) {
				b1 = true;
			}
			if (word.equalsIgnoreCase("lock") || word.equals("locks")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean tk2_bound(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("bound") || word.equals("inbound"))
				return true;
		}
		return false;
	}

	public static boolean tk3_memory_unit(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("kb") || word.equals("mb") || word.equals("gb") || word.equals("tb"))
				return true;
		}
		return false;
	}

	public static boolean tk4_cpi(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("cpi"))
				return true;
		}
		return false;
	}

	public static boolean tk5_execution_skew(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("execution")) {
				b1 = true;
			}
			if (word.equals("skew")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean tk6_iteration(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("loop") || word.equals("loops") || word.contains("iterat") || word.equals("recursion")
					|| word.equals("recursive") || word.equals("recursions"))
				return true;
		}
		return false;
	}

	public static boolean tk7_concurrent(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("concurren"))
				return true;
		}
		return false;
	}
}
