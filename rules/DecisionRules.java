package com.interviewbubble.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class DecisionRules {
	public static List<Sentence> checkRules(List<Sentence> sentences) {
		String[] keywords = { "fast", "slow", "perform", "latency", "throughput", "optimiz", "optimis", "speed",
				"waste", "efficien", "necessary", "redundan", "too many times", "lot of time", "too much time" };
		for (Sentence sentence : sentences) {
			Set<Integer> numbers = new HashSet<>();
			Set<String> names = new HashSet<>();
			Set<String> matched_keywords = new HashSet<>();
			for (String keyword : keywords) {
				if (sentence.getText().toLowerCase().contains(keyword)) {
					matched_keywords.add(keyword);
				}
			}

			if (gk1_efficiency(sentence)) {
				numbers.add(101);
				names.add("gk1_efficiency");
			}
			if (gk2_complexity(sentence)) {
				numbers.add(102);
				names.add("gk2_complexity");
			}

			if (gk4_performance(sentence)) {
				numbers.add(104);
				names.add("gk4_performance");
			}
			if (gk5_latency(sentence)) {
				numbers.add(105);
				names.add("gk5_latency");
			}
			if (gk6_expensive(sentence)) {
				numbers.add(106);
				names.add("gk6_expensive");
			}
			if (gk7_speed(sentence)) {
				numbers.add(107);
				names.add("gk7_speed");
			}

			if (gk9_throughput(sentence)) {
				numbers.add(109);
				names.add("gk9_throughput");
			}

			if (sk2_block_hang_crash(sentence)) {
				numbers.add(202);
				names.add("sk2_block_hang_crash");
			}
			if (sk5_hotspot(sentence)) {
				numbers.add(205);
				names.add("sk5_hotspot");
			}

			if (sk12_over_again(sentence)) {
				numbers.add(212);
				names.add("sk12_over_again");
			}
			if (sk13_regression(sentence)) {
				numbers.add(213);
				names.add("sk13_regression");
			}
			if (sk14_overhead(sentence)) {
				numbers.add(214);
				names.add("sk14_overhead");
			}
			if (sk16_garbage(sentence)) {
				numbers.add(216);
				names.add("sk16_garbage");
			}
			if (sk18_throttle(sentence)) {
				numbers.add(218);
				names.add("sk18_throttle");
			}

			if (tk6_iteration(sentence)) {
				numbers.add(306);
				names.add("tk6_iteration");
			}

			if (tk16_big_O(sentence)) {
				numbers.add(316);
				names.add("tk16_big_O");
			}

			if (tk18_brute_force(sentence)) {
				numbers.add(318);
				names.add("tk18_brute_force");
			}

			if (pf2_duration(sentence)) {
				numbers.add(402);
				names.add("pf2_duration");
			}
			if (pf3_profiling(sentence)) {
				numbers.add(403);
				names.add("pf3_profiling");
			}
			if (pf4_benchmark(sentence)) {
				numbers.add(404);
				names.add("pf4_benchmark");
			}
			if (ss4_memory(sentence)) {
				numbers.add(504);
				names.add("ss4_memory");
			}
			if (ss5_cpu(sentence)) {
				numbers.add(505);
				names.add("ss5_cpu");
			}

			if (ss10_called_frequently(sentence)) {
				numbers.add(510);
				names.add("ss10_called_frequently");
			}
			if (ss11_rework(sentence)) {
				numbers.add(511);
				names.add("ss11_rework");
			}
			if (ss12_spend_time(sentence)) {
				numbers.add(512);
				names.add("ss12_spend_time");
			}
			if (ss13_cache(sentence)) {
				numbers.add(513);
				names.add("ss13_cache");
			}
			if (ss14_perform(sentence)) {
				numbers.add(514);
				names.add("ss14_perform");
			}
			if (ss18_fast_to(sentence)) {
				numbers.add(518);
				names.add("ss18_fast_to");
			}

			if (sentence.getFittedRules() == null) {
				sentence.setFittedRules(numbers);
			} else {
				Set<Integer> temp_numbers = sentence.getFittedRules();
				temp_numbers.addAll(numbers);
				sentence.setFittedRules(temp_numbers);
			}
			if (sentence.getFittedPerfRules() == null) {
				sentence.setFittedPerfRules(names);
			} else {
				Set<String> temp_names = sentence.getFittedPerfRules();
				temp_names.addAll(names);
				sentence.setFittedPerfRules(temp_names);
			}
			sentence.setMatchedKeywords(matched_keywords);
		}

		return sentences;
	}

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
			if (word.equals("complex") || word.equals("complexity") || word.equals("complicated")
					|| word.equals("uncomplex")) {
				return true;
			}
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
			if (word.equals("latency") || word.equals("latencies"))
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
		String text = sentence.getText().toLowerCase();
		int speed = -1, sped = -1;
		boolean b1 = false, b2 = false;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("speed") || words.get(i).equals("speeds")) {
				b1 = true;
				speed = i;
			}
			if (words.get(i).equals("average") || words.get(i).contains("increas")
					|| words.get(i).contains("decreas")) {
				b2 = true;
			}
			if (words.get(i).equals("sped")) {
				sped = i;
			}
			if (words.get(i).contains("speedup") || words.get(i).equals("faster") || words.get(i).contains("accelerat")
					|| words.get(i).equals("quick") || words.get(i).equals("quickly") || words.get(i).equals("slow")
					|| words.get(i).equals("slowness") || words.get(i).equals("slows")
					|| words.get(i).equals("slower")) {
				return true;
			}
		}
		if (text.contains("great speed") || text.contains("fast speed") || text.contains("low performing")
				|| text.contains("low-velocity") || text.contains("paused is longer than usual")
				|| text.contains("for a long moment"))
			return true;
		if (b1 && b2) {
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

	public static boolean gk9_throughput(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("throughput"))
				return true;
		}
		return false;
	}

	public static boolean sk2_block_hang_crash(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		List<String> postTags = sentence.getPosTag();

		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("block") || words.get(i).equals("blocks")) {
				if (postTags.get(i).contains("VB")) {
					return true;
				}
			}
		}
		for (String word : words) {
			if (word.equals("blocked") || word.equals("blocking") || word.contains("bottleneck")) {
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

	public static boolean sk5_hotspot(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("hot spot") || text.contains("hotspot") || text.contains("hot-spot"))
			return true;
		return false;
	}

	public static boolean sk12_over_again(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("over again") || text.contains("again and again"))
			return true;
		return false;
	}

	public static boolean sk13_regression(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("regression") || word.equals("regress") || word.equals("regresses")
					|| word.equals("regressed") || word.equals("regressing"))
				return true;
		}
		return false;
	}

	public static boolean sk14_overhead(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("overhead") || word.equals("overheads")) {
				return true;
			}
		}
		return false;
	}

	public static boolean sk16_garbage(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("garbage") || word.equals("garbages"))
				b1 = true;
			if (word.equals("generate") || word.equals("generates") || word.equals("generated")
					|| word.equals("generating"))
				b2 = true;
			if (word.equals("produce") || word.equals("produces") || word.equals("produced")
					|| word.equals("producing"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean sk18_throttle(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("throttling") || word.equals("throttle") || word.equals("throttles"))
				return true;
		}
		return false;
	}

	public static boolean tk6_iteration(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("loop") || word.equals("loops") || word.contains("iterat") || word.equals("recursion")
					|| word.equals("recursive") || word.equals("recursions")) {
				b1 = true;
			}
			if (word.equals("break") || word.equals("breaks") || word.equals("breaking") || word.equals("broke")
					|| word.equals("broken") || word.equals("end") || word.equalsIgnoreCase("ended")
					|| word.contains("immediate")) {
				b2 = true;
			}
		}
		if (b1 && b2) {
			return true;
		}
		return false;
	}

	public static boolean tk16_big_O(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("o(n*log(n))") || text.contains("o(n)") || text.contains("o(n^2)") || text.contains("o(1)")) {
			return true;
		}
		return false;
	}

	public static boolean tk18_brute_force(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("brute force") || text.contains("brute-force")) {
			return true;
		}
		return false;
	}

	public static boolean pf2_duration(Sentence sentence) {
		List<String> nerTags = sentence.getNerTag();
		List<String> words = sentence.getWords();
		for (int i = 0; i < nerTags.size(); i++) {
			if (nerTags.get(i).equals("DURATION")) {
				if (words.get(i).contains("day") || words.get(i).contains("month") || words.get(i).contains("year")
						|| words.get(i).contains("centur")) {
					continue;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean pf3_profiling(Sentence sentence) {
		List<String> words = sentence.getWords();
		List<String> posTag = sentence.getPosTag();
		for (String word : words) {
			if (word.equals("<profiling>") || word.equals("ms") || word.equals("ops/sec")
					|| word.equals("megabytes/sec") || word.equals("mb/sec") || word.equals("mb/s"))
				return true;
		}
		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			if (word.equals("profile") || word.equals("profiles") || word.equals("profiling")) {
				if (posTag.get(i).contains("VB")) {
					return true;
				}
			}
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

	public static boolean ss4_memory(Sentence sentence) {
		List<String> words = sentence.getWords();
		String text = sentence.getText().toLowerCase();
		if (text.contains("out of memory") || text.contains("out-of-memory"))
			return true;
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("oom") || word.equals("outofmemory") || word.equals("oome"))
				return true;
			if (word.equals("memory"))
				b1 = true;
			if (word.equalsIgnoreCase("usage") || word.equals("overflow") || word.equals("hold") || word.equals("bloat")
					|| word.equals("limit") || word.equals("limitation") || word.equals("consume")
					|| word.equals("consumes") || word.equals("consuming") || word.contains("consumption")
					|| word.equals("excessive") || word.equals("utilization") || word.contains("accumulat")
					|| word.equals("high") || word.equals("backpressure") || word.equals("management")
					|| word.equals("lower") || word.equals("higher") || word.equals("shuffle") || word.equals("leak")
					|| word.equals("leaks") || word.equals("leakage") || word.equals("leaking")) {
				b2 = true;
			}
		}

		boolean b3 = false, b4 = false;
		for (String word : words) {
			if (word.equals("fit") || word.equals("fits") || word.equals("fitting") || word.equals("sorting")
					|| word.contains("index"))
				b3 = true;
		}
		if (sentence.getText().contains("in memory") || sentence.getText().contains("in-memory")
				|| sentence.getText().contains("into memory") || sentence.getText().contains("to memory"))
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
		String text = sentence.getText().toLowerCase();
		for (String word : words) {
			if (word.equals("cpu"))
				b1 = true;
			if (word.equals("higher") || word.equals("lower") || word.contains("limit") || word.equals("usage")
					|| word.equals("utilization") || word.equals("utilisation") || word.equals("waiting"))
				b2 = true;
		}
		if (text.contains("save cpu cycles")) {
			return true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean ss10_called_frequently(Sentence sentence) {
		boolean b1 = false, b2 = false;
		boolean b3 = false, b4 = false;
		boolean b5 = false, b6 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("call") || word.contains("invoke"))
				b1 = true;
			if (word.contains("request")) {
				b5 = true;
			}
			if (word.contains("frequent") || word.contains("repeat") || word.equals("extra")
					|| word.equals("additional"))
				b2 = true;
			if (word.equals("every") || word.equals("each"))
				b4 = true;
		}
		String text = sentence.getText().toLowerCase();
		if (text.contains("many time") || text.contains("lot of") || text.contains("multiple times")
				|| text.contains("nearly every") || text.contains("a lot") || text.contains("on every")
				|| text.contains("very often")) {
			b2 = true;
		}
		if (b1 && b2)
			return true;

		if (text.contains("at least")) {
			b3 = true;
		}
		if (text.contains("too many")) {
			b6 = true;
		}
		if (b1 && b3 && b4)
			return true;
		if (b5 && b6) {
			return true;
		}
		return false;
	}

	public static boolean ss11_rework(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("calculated again"))
			return true;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("redo") || word.contains("recalculat") || word.contains("rework")
					|| word.contains("resurrect") || word.contains("reindex") || word.contains("rewrit")
					|| word.contains("reload"))
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
					|| word.equals("waste") || word.equals("wastes") || word.equals("wasting") || word.equals("loose")
					|| word.equals("looses") || word.equals("loosed") || word.equals("go") || word.equals("goes")) {
				b1 = true;
			}
			if (word.equals("most") || word.equals("most") || word.equals("long") || word.equals("part")
					|| word.equals("part") || word.contains("significant") || word.equals("longer")
					|| word.equals("majority") || word.equals("minority") || word.equals("dominating")) {
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
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
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
					|| word.equals("additional") || word.equals("heavy") || word.contains("optimiz")
					|| word.contains("benefit") || word.equals("extra") || word.equals("speed")
					|| word.contains("parallel") || word.equals("configurable") || word.equals("drop")
					|| word.equals("dropping") || word.equals("drops") || word.equals("maximize")
					|| word.contains("maximise") || word.equals("maximizes") || word.equals("maximises")
					|| word.equals("minimise") || word.equals("minimize") || word.equals("minimises")
					|| word.equals("minimizes") || word.equals("capacity") || word.equals("mess")
					|| word.equals("preload") || word.equals("in-memory")) {
				b2 = true;
			}
			if (word.equals("disk") || word.equals("disks")) {
				b3 = true;
			}
			if (word.equals("save") || word.equals("saves")) {
				b4 = true;
			}
		}
		String text = sentence.getText().toLowerCase();
		if (text.contains("all over") || text.contains("on heap") || text.contains("on-heap")
				|| text.contains("off heap") || text.contains("off-heap"))
			b2 = true;
		if (b1 && b2) {
			return true;
		}
		if (b1 && b3 && b4) {
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
		if (text.contains("fail fast") || text.contains("fails fast") || text.contains("fast way")
				|| text.contains("fast pace") || text.contains("as fast as") || text.contains("extreme fast"))
			return true;
		return false;
	}
}
