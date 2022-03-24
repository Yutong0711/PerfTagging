package com.interviewbubble.rules;

import java.util.List;

import com.interviewbubble.entity.Sentence;

public class PerformanceRules {
	public static boolean p1_negative_necessary(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("necessar"))
				return true;
		}
		return false;
	}

	public static boolean p2_called_frequently(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("call") || word.contains("invoke"))
				b1 = true;
			if (word.contains("frequent") || word.contains("repeat"))
				b2 = true;
		}
		if (sentence.getText().contains("many time") || sentence.getText().contains("lot of")
				|| sentence.getText().contains("multiple times")) {
			b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p3_recalculate(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("recalculat") || word.contains("redo"))
				return true;
		}
		return false;
	}

	public static boolean p4_negative_useful(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		List<String> posTags = sentence.getPosTag();
		for (String word : words) {
			if (word.equals("useful"))
				b1 = true;
		}
		for (String posTag : posTags) {
			if (posTag.equals("RB")) {
				b2 = true;
				break;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p5_negative_required(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		List<String> posTags = sentence.getPosTag();
		for (String word : words) {
			if (word.equals("required"))
				b1 = true;
		}
		for (String posTag : posTags) {
			if (posTag.equals("RB")) {
				b2 = true;
				break;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p6_contain_duration(Sentence sentence) {
		List<String> nerTags = sentence.getNerTag();
		for (String nerTag : nerTags) {
			if (nerTag.equals("DURATION"))
				return true;
		}
		return false;
	}

	public static boolean p7_percent(Sentence sentence) {
		List<String> words = sentence.getWords();
		List<String> nerTags = sentence.getNerTag();
		for (String nerTag : nerTags) {
			if (nerTag.equals("PERCENT"))
				return true;
		}

		return false;
	}

	public static boolean p8_as_much_time(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("as much time") || text.contains("factor of"))
			return true;
		return false;
	}

	public static boolean p9_profiling(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("<profiling>") || words.equals("<PROFILING>"))
				return true;
		}
		return false;
	}

	public static boolean p10_slow(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("slow"))
				return true;
		}
		return false;
	}

	public static boolean p11_load_nn(Sentence sentence) {
		List<String> words = sentence.getWords();
		List<String> posTags = sentence.getPosTag();
		int index = -1;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("load")) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			if (posTags.get(index).contains("NN")) {
				return true;
			}
		}
		return false;
	}

	public static boolean p12_time_consumption(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("time"))
				b1 = true;
			if (word.contains("consum") || word.equals("many") || word.equalsIgnoreCase("much") || word.equals("most"))
				b2 = true;
		}
		if (sentence.getText().toLowerCase().contains("out of") || sentence.getText().toLowerCase().contains("lot of"))
			b2 = true;
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p13_performance(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("performance"))
				return true;
		}
		return false;
	}

	public static boolean p14_efficiency(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("efficien")) {
				return true;
			}
		}
		return false;
	}

	public static boolean p15_only_required(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("only"))
				b1 = true;
			if (word.equalsIgnoreCase("required"))
				b2 = true;
		}
		if (b1 && b2) {
			return true;
		}
		return false;
	}

	public static boolean p16_memory(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("memory"))
				b1 = true;
			if (word.equalsIgnoreCase("usage") || word.equals("overflow") || word.equals("hold")
					|| word.equals("remove") || word.equals("bloat") || word.equals("limit")
					|| word.equals("limitation") || word.equals("lot"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p17_cache(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("cache") || word.equalsIgnoreCase("caching") || word.equals("caches"))
				return true;
		}
		return false;
	}

	public static boolean p18_waste(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("waste"))
				return true;
		}
		return false;
	}

	public static boolean p19_one_by_one(Sentence sentence) {
		List<String> words = sentence.getWords();
		List<String> posTags = sentence.getPosTag();
		int index = -1;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("by"))
				index = i;
		}
		if (index != -1) {
			if (index > 1 && index < words.size() - 2) {
				if (words.get(index - 1).equals(words.get(index + 1)) && posTags.get(index - 1).contains("NN")
						&& posTags.get(index + 1).contains("NN")) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean p20_only_when_needed(Sentence sentence) {
		boolean b1 = false, b2 = false;
		if (sentence.getText().toLowerCase().contains("only if")
				|| sentence.getText().toLowerCase().contains("only when"))
			b1 = true;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("required") || word.contains("need"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p21_as_one(Sentence sentence) {
		if (sentence.getText().toLowerCase().contains("as one")
				|| sentence.getText().toLowerCase().contains("in one go"))
			return true;
		return false;
	}

	public static boolean p22_speed_up(Sentence sentence) {
		List<String> words = sentence.getWords();
		int index = -1;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("speed") || words.get(i).equals("sped")) {
				index = i;
				break;
			}
		}
		if (index > 0 && index < words.size() - 1) {
			if (words.get(index + 1).equals("up"))
				return true;
		}
		return false;
	}

	public static boolean p23_OOM(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equalsIgnoreCase("oom"))
				return true;
		}
		return false;
	}

	public static boolean p24_loop_break(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("loop") || word.contains("iterat"))
				b1 = true;
			if (word.contains("break") || word.equals("broken") || word.contains("execut"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p25_big_data_structure(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("big") || word.equals("large") || word.equalsIgnoreCase("huge")) {
				b1 = true;
			}
			if (word.contains("map") || word.contains("list") || word.contains("array") || word.contains("matri")
					|| word.equals("string") || word.equals("strings")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p26_in_a_single(Sentence sentence) {
		if (sentence.getText().toLowerCase().contains("in a single"))
			return true;
		return false;
	}

	public static boolean p27_skip(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("skip"))
				return true;
		}
		return false;
	}

	public static boolean p28_quick(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("quick") || word.equals("quickly"))
				return true;
		}
		return false;
	}

	public static boolean p29_avoid_blocking(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("avoid")) {
				b1 = true;
			}
			if (word.contains("block")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p30_should_immediately(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("should")) {
				b1 = true;
			}
			if (word.equals("immediately")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p31_only_once(Sentence sentence) {
		if (sentence.getText().toLowerCase().contains("only once")
				|| sentence.getText().toLowerCase().contains("just one time")) {
			return true;
		}
		return false;
	}

	public static boolean p32_complexity(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("complexity") || word.equals("complexities")) {
				return true;
			}
		}
		return false;
	}

	public static boolean p33_display_time(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.contains("display")) {
				b1 = true;
			}
			if (word.equals("time")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p34_faster(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("faster")) {
				return true;
			}
		}
		return false;
	}

	public static boolean p35_hotspot(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.contains("hotspot")) {
				return true;
			}
			if (word.equals("hot")) {
				b1 = true;
			}
			if (word.equalsIgnoreCase("spot") || word.equals("spots")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean p36_nested_loop(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.contains("loop")) {
				b1 = true;
			}
			if (word.contains("jump") || word.equals("nested") || word.contains("overrid")) {
				b2 = true;
			}
		}
		if (b1 && b2) {
			return true;
		}

		return false;
	}

	public static boolean p37_percall(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("per call") || text.contains("per-call")) {
			return true;
		}
		return false;
	}

	public static boolean p38_redundant(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("redundant") || word.equals("redundancy") || word.equals("redundancies")) {
				return true;
			}
		}
		return false;
	}

	public static boolean p39_speedup_NN(Sentence sentence) {
		List<String> words = sentence.getWords();
		List<String> posTags = sentence.getPosTag();
		int index = -1;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).contains("speedup")) {
				index = i;
			}
		}
		if (index != -1) {
			if (posTags.get(index).contains("NN")) {
				return true;
			}
		}
		return false;
	}

	public static boolean p40_speed_penalty(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.contains("speed")) {
				b1 = true;
			}
			if (word.equals("penalty") || word.equals("penalties")) {
				b2 = true;
			}
		}
		if (b1 && b2) {
			return true;
		}
		return false;
	}
}
