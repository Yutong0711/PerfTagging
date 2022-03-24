package com.interviewbubble.rules;

import java.util.List;

import com.interviewbubble.entity.Sentence;

public class GeneralKeywordRules {
	public static boolean gk1_efficiency(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("efficien")) {
				return true;
			}
		}
		return false;
	}

	public static boolean gk2_complexity(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("complex") || word.equals("complexity") || word.equalsIgnoreCase("complicated")) {
				return true;
			}
		}
		return false;
	}

	public static boolean gk3_reduce(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("reduce") || word.equals("reducing") || word.equals("reduces") || word.equals("reduction")
					|| word.equalsIgnoreCase("reduced"))
				return true;
		}
		return false;
	}

	public static boolean gk4_performance(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("performance"))
				return true;
		}
		return false;
	}

	public static boolean gk5_latency(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("latency"))
				return true;
		}
		return false;
	}

	public static boolean gk6_expensive(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("expensive"))
				return true;
		}
		return false;
	}

	public static boolean gk7_speed(Sentence sentence) {
		List<String> words = sentence.getWords();
		int speed = -1, sped = -1;

		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("speed") || words.get(i).equals("speeds")) {
				speed = i;
			}
			if (words.get(i).equals("sped")) {
				sped = i;
			}
			if (words.get(i).contains("speedup") || words.get(i).equals("faster") || words.get(i).contains("accelerat")
					|| words.get(i).equals("quick") || words.get(i).equals("quickly") || words.get(i).contains("slow"))
				return true;
		}

		if (speed > -1 && speed < words.size() - 1) {
			if (words.get(speed + 1).equals("up")) {
				return true;
			}
		}

		if (sped > -1 && sped < words.size() - 1) {
			if (words.get(sped + 1).equals("by")) {
				return true;
			}
		}
		return false;
	}

	public static boolean gk8_throughput(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("throughput") || word.equals("throughputs")) {
				return true;
			}
		}
		return false;
	}
}
