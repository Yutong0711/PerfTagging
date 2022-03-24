package com.interviewbubble.rules;

import java.util.List;

import com.interviewbubble.entity.Sentence;

public class ProfilingRules {
	public static boolean pf1_percentage(Sentence sentence) {
		List<String> nerTags = sentence.getNerTag();
		for (String nerTag : nerTags) {
			if (nerTag.equals("PERCENT"))
				return true;
		}
		return false;
	}

	public static boolean pf2_duration(Sentence sentence) {
		List<String> nerTags = sentence.getNerTag();
		for (String nerTag : nerTags) {
			if (nerTag.equals("DURATION"))
				return true;
		}
		return false;
	}

	public static boolean pf3_profiling(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("<profiling>") || word.equals("profile") || word.equals("profiles")
					|| word.equals("profiling") || word.equals("ms"))
				return true;
		}
		return false;
	}

	public static boolean pf4_benchmark(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("benchmark"))
				return true;
		}
		return false;
	}
}
