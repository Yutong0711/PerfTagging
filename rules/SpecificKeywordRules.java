package com.interviewbubble.rules;

import java.util.List;

import com.interviewbubble.entity.Sentence;

public class SpecificKeywordRules {
	public static boolean sk1_negative_necessary(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("unnecessary") || word.equals("unneeded") || word.equals("redundant")
					|| word.equals("redundancy"))
				return true;
		}

		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		if (sentence.getText().contains("no longer"))
			b1 = true;
		for (String word : words) {
			if (word.equals("only") || word.equals("not"))
				b1 = true;
			if (word.equalsIgnoreCase("necessary") || word.equals("needed"))
				b2 = true;
			if (word.equals("useful") || word.equals("unuseful")) {
				b3 = true;
			}
			if (word.equals("work") || word.equals("works")) {
				b4 = true;
			}
		}
		if (b1 && b2)
			return true;
		if (b3 && b4)
			return true;
		return false;
	}

	public static boolean sk2_block_hang_crash(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("block") || word.equals("blocks") || word.equals("blocked") || word.equals("blocking")
					|| word.contains("bottleneck")) {
				return true;
			}
			if (word.equals("hang") || word.equals("hangs") || word.equals("hanging")) {
				return true;
			}
			if (word.equals("process") || word.equals("processes"))
				b1 = true;
			if (word.contains("crash"))
				b2 = true;
		}
		if (sentence.getText().toLowerCase().contains("long running"))
			return true;
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean sk3_byte(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("byte") || word.equals("bytes") || word.contains("-byte"))
				return true;
		}
		return false;
	}

	public static boolean sk4_prefetch(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("prefetch") || word.contains("pre-fetch")) {
				return true;
			}
		}
		return false;
	}

	public static boolean sk5_hotspot(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("hot spot") || text.contains("hotspot"))
			return true;
		return false;
	}

	public static boolean sk6_enough_space(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("space") || word.equals("spaces"))
				b1 = true;
			if (word.equals("enough"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean sk7_buffer(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("buffer"))
				b1 = true;
			if (word.equals("additional") || word.equals("size") || word.equals("sizes") || word.contains("optimiz"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean sk8_timeout_expiration(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("timeout"))
				return true;
			if (word.equals("expire") || word.equalsIgnoreCase("expires") || word.equals("expiration"))
				return true;
		}
		return false;
	}

	public static boolean sk9_frequency(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("frequen"))
				return true;

		}
		return false;
	}

	public static boolean sk10_overhead(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("overhead") || word.equals("overheads")) {
				return true;
			}
		}
		return false;
	}

	public static boolean sk11_skip(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("skip") || word.equals("skips") || word.equals("skipped") || word.equals("skipping")
					|| word.equals("skiped"))
				return true;
		}
		return false;
	}

	public static boolean sk12_infinity(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("infinite") || word.equals("infinity") || word.equals("forever"))
				return true;
		}
		return false;
	}

	public static boolean sk13_over_again(Sentence sentence) {
		if (sentence.getText().contains("over again"))
			return true;
		return false;
	}

	public static boolean sk14_regression(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("regress"))
				return true;
		}
		return false;

	}
}
