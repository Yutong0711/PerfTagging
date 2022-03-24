package com.interviewbubble.rules;

import java.util.ArrayList;
import java.util.List;

import com.interviewbubble.entity.Sentence;

public class SentenceStructureRules {
	public static boolean ss1_one_per(Sentence sentence) {
		List<String> words = sentence.getWords();
		int one = -1, per = -1;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("one") || words.get(i).equals("1")) {
				one = i;
				break;
			}
		}

		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("per")) {
				per = i;
			}
		}

		if (one != 0 && per != -1) {
			if (per > one) {
				return true;
			}
		}
		return false;
	}

	public static boolean ss2_all_to_one(Sentence sentence) {
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("all") || word.equals("overall"))
				b1 = true;
			if (word.equalsIgnoreCase("each"))
				b3 = true;
		}
		if (sentence.getText().contains("to a") || sentence.getText().contains("to one")) {
			b2 = true;
		}
		if (sentence.getText().contains("in its own") || sentence.getText().contains("in own"))
			b4 = true;
		if (b1 && b2) {
			return true;
		}
		if (b3 && b4)
			return true;

		return false;
	}

	public static boolean ss3_in_one_go(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("in one time") || text.contains("in one go") || text.contains("at the same time")
				|| text.contains("only once") || text.contains("just one time") || text.contains("in a single")
				|| text.contains("in one operation") || text.contains("at once"))
			return true;
		return false;
	}

	public static boolean ss4_memory(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("oom"))
				return true;
			if (word.equals("memory"))
				b1 = true;
			if (word.equalsIgnoreCase("usage") || word.equals("overflow") || word.equals("hold")
					|| word.equals("remove") || word.equals("bloat") || word.equals("limit")
					|| word.equals("limitation") || word.equals("lot") || word.equals("plenty")
					|| word.equals("consume") || word.equals("consumes") || word.equals("consuming")
					|| word.contains("consumption") || word.equals("excessive") || word.equals("usage")
					|| word.equals("utilization") || word.equals("pack") || word.contains("accumulat")
					|| word.equals("high") || word.contains("increas") || word.equals("access")
					|| word.contains("allocat") || word.equals("much"))
				b2 = true;
		}

		boolean b3 = false, b4 = false;
		for (String word : words) {
			if (word.equals("fit") || word.equals("fits") || word.equals("fitting") || word.equals("sorting")
					|| word.contains("index"))
				b3 = true;
		}
		if (sentence.getText().contains("in memory") || sentence.getText().contains("in-memory")
				|| sentence.getText().contains("into memory"))
			b4 = true;

		if (b1 && b2)
			return true;
		if (b3 && b4)
			return true;
		return false;
	}

	public static boolean ss5_cpu(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("cpu"))
				b1 = true;
			if (word.equals("higher") || word.equals("lower") || word.contains("limit") || word.equals("usage")
					|| word.equals("utilization") || word.equals("utilisation") || word.equals("waiting"))
				b2 = true;
		}
		if (sentence.getText().contains("lot of") || sentence.getText().contains("lots of"))
			b2 = true;
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss6_per_per(Sentence sentence) {
		List<Integer> pers_indices = new ArrayList<>();
		List<String> words = sentence.getWords();
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("per")) {
				pers_indices.add(i);
			}
		}
		for (Integer index : pers_indices) {
			if (index >= 0 && index < words.size() - 2) {
				if (words.get(index + 2).equals("per")) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean ss7_nn_by_nn(Sentence sentence) {
		int by = -1;
		List<String> words = sentence.getWords();
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("by"))
				by = i;
		}
		if (by > 0 && by < words.size() - 1) {
			if (words.get(by - 1).equals(words.get(by + 1)))
				return true;
		}
		return false;
	}

	public static boolean ss8_load_nn(Sentence sentence) {
		List<String> words = sentence.getWords();
		List<String> posTags = sentence.getPosTag();
		int index = -1;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("load") || words.get(i).equals("loads")) {
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

	public static boolean ss9_respond_until(Sentence sentence) {
		int index = -1;
		boolean b1 = false, b2 = true;
		List<String> words = sentence.getWords();
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).contains("respond") && !words.get(i).contains("correspond")) {
				b1 = true;
				index = i;
			}
			if (words.get(i).contains("stop")) {
				b2 = true;
			}
		}
		if (index > 0 && index < words.size() - 1) {
			if (words.get(index + 1).equals("until"))
				return true;
		}
		if (b1 && b2) {
			return true;
		}
		return false;
	}

	public static boolean ss10_called_frequently(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("call") || word.contains("invoke"))
				b1 = true;
			if (word.contains("frequent") || word.contains("repeat"))
				b2 = true;
		}
		if (sentence.getText().contains("many time") || sentence.getText().contains("lot of")
				|| sentence.getText().contains("multiple times") || sentence.getText().contains("nearly every")
				|| sentence.getText().contains("a lot")) {
			b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss11_rework(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("calculated again"))
			return true;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("redo") || word.contains("recalculat") || word.contains("rework") || word.startsWith("re-")
					|| word.contains("resurrect") || word.contains("reindex") || word.contains("rewrit"))
				return true;
		}
		return false;
	}

	public static boolean ss12_spend_time(Sentence sentence) {
		boolean b1 = false, b2 = false, b3 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("take") || word.equals("took") || word.equals("takes") || word.equals("taken")
					|| word.equals("spend") || word.equals("spends") || word.equals("spent") || word.equals("wasted")
					|| word.equals("waste") || word.equals("wastes") || word.equals("wasting")) {
				b1 = true;
			}
			if (word.equals("most") || word.equals("most") || word.equals("long") || word.equals("part")
					|| word.equals("part") || word.contains("significant")) {
				b2 = true;
			}
			if (word.equals("time") || word.equals("resource") || word.equals("resources")) {
				b3 = true;
			}
		}
		String text = sentence.getText().toLowerCase();
		if (text.contains("lot of") || text.contains("lots of") || text.contains("quite a bit of"))
			b2 = true;
		if (b1 && b2 && b3)
			return true;

		return false;
	}

	public static boolean ss13_cache(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("cache") || word.equals("cached") || word.equals("caching") || word.equals("caches")) {
				b1 = true;
			}
			if (word.equals("cold") || word.equals("warm") || word.equals("buffer") || word.equals("metadata")
					|| word.contains("duplicat") || word.contains("replace") || word.equals("replacing")
					|| word.contains("update") || word.contains("improve") || word.equals("miss")
					|| word.equals("misses") || word.equals("hit") || word.equals("entry") || word.equals("lock")
					|| word.contains("document") || word.contains("execution") || word.equals("add")
					|| word.equals("adds") || word.equals("added") || word.equals("tracker") || word.contains("discard")
					|| word.equals("additional")) {
				b2 = true;
			}
		}
		if (b1 && b2) {
			return true;
		}
		return false;
	}

	public static boolean ss14_perform(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("perform") || word.equals("performs") || word.equals("performed"))
				b1 = true;
			if (word.equals("round") || word.equals("rounds") || word.equals("poor") || word.equals("poorly")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss15_each_one(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("each"))
				b1 = true;
			if (word.equals("one") || word.equals("own") || word.equals("individual"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss16_close_immediately(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("immediate"))
				b1 = true;
			if (word.equals("close") || word.equals("closes") || word.equals("closed") || word.equals("flush")
					|| word.equals("flushes") || word.equals("flushed"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss17_cardinality_cost(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("cardinality"))
				b1 = true;
			if (word.equals("cost") || word.equals("costs") || word.equals("high") || word.equals("improve")
					|| word.equals("improves") || word.equals("improved") || word.equals("improvement"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss18_fast_to(Sentence sentence) {
		int index = -1;
		List<String> words = sentence.getWords();
		List<String> posTags = sentence.getPosTag();
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("fast")) {
				index = i;
				break;
			}
		}
		if (index > 0 && index < words.size() - 1) {
			if (words.get(index + 1).equals("to") || words.get(index + 1).equals("enough")) {
				return true;
			}
			if (words.get(index - 1).equals("ignorably")) {
				return true;
			}
		}

		String text = sentence.getText().toLowerCase();
		if (text.contains("fail fast") || text.contains("fails fast") || text.contains("fast way"))
			return true;
		return false;
	}

	public static boolean ss19_lot_reading(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("read") || word.equals("reads") || word.equals("reading") || word.equals("readings")) {
				b1 = true;
			}
			if (word.equals("lot") || word.equals("many") || word.equals("high") || word.equals("same"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss20_roundtrip(Sentence sentence) {
		boolean b1 = false, b2 = false;
		String text = sentence.getText();
		List<String> words = sentence.getWords();
		if (text.contains("roundtrip") || text.contains("round trip")) {
			b1 = true;
		}
		for (String word : words) {
			if (word.equals("more") || word.equals("less")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss21_traversal(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		String text = sentence.getText();
		if (text.contains("go through") || text.contains("went through") || text.contains("goes through"))
			b1 = true;
		if (text.contains("in time"))
			b2 = true;
		for (String word : words) {
			if (word.equals("traverse") || word.equals("traverses") || word.equals("traversing")
					|| word.equals("traversed") || word.contains("traversal")) {
				b1 = true;
			}
			if (word.equals("entire") || word.equalsIgnoreCase("broad") || word.equals("lot") || word.equals("full"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss22_cd_files(Sentence sentence) {
		boolean b1 = false, b2 = false, b3 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("file") || word.equals("files")) {
				b1 = true;
			}
			if (word.contains("creat") || word.contains("delet")) {
				b2 = true;
			}
			if (word.equalsIgnoreCase("lot") || word.equals("few") || word.equals("more") || word.equals("less")) {
				b3 = true;
			}
		}
		if (b1 && b2 && b3)
			return true;
		return false;
	}

	public static boolean ss23_avoid_if(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("avoid") || word.equals("avoids") || word.equals("avoided")) {
				b1 = true;
			}
			if (word.equals("for") || word.equals("when") || word.equals("if") || word.equals("wasted")
					|| word.equals("again") || word.contains("duplicat")) {
				b2 = true;
			}
		}
		if (sentence.getText().contains("extra work")) {
			b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss24_cost(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("cost") || word.equals("costs")) {
				b1 = true;
			}
			if (word.equals("high") || word.equals("low") || word.equals("higher") || word.equals("lower")
					|| word.equals("minimum") || word.equals("maximum")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss25_sessions(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("session") || word.equals("sessions")) {
				b1 = true;
			}
		}
		String text = sentence.getText().toLowerCase();
		if (text.contains("short-live") || text.contains("short live") || text.contains("lot of")) {
			b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}
}
