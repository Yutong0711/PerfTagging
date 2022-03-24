package com.interviewbubble.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class ImpalaRules {
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

			if (ImpalaRules.gk1_efficiency(sentence)) {
				numbers.add(101);
				names.add("gk1_efficiency");
			}
			if (ImpalaRules.gk2_complexity(sentence)) {
				numbers.add(102);
				names.add("gk2_complexity");
			}
			if (ImpalaRules.gk3_reduce(sentence)) {
				numbers.add(103);
				names.add("gk3_reduce");
			}
			if (ImpalaRules.gk4_performance(sentence)) {
				numbers.add(104);
				names.add("gk4_performance");
			}
			if (ImpalaRules.gk5_latency(sentence)) {
				numbers.add(105);
				names.add("gk5_latency");
			}
			if (ImpalaRules.gk6_expensive(sentence)) {
				numbers.add(106);
				names.add("gk6_expensive");
			}
			if (ImpalaRules.gk7_speed(sentence)) {
				numbers.add(107);
				names.add("gk7_speed");
			}
			if (ImpalaRules.gk8_spilling(sentence)) {
				numbers.add(108);
				names.add("gk8_spilling");
			}
			if (ImpalaRules.sk1_negative_necessary(sentence)) {
				numbers.add(201);
				names.add("sk1_negative_necessary");
			}
			if (ImpalaRules.sk2_block_hang_crash(sentence)) {
				numbers.add(202);
				names.add("sk2_block_hang_crash");
			}
			if (ImpalaRules.sk3_byte(sentence)) {
				numbers.add(203);
				names.add("sk3_byte");
			}
			if (ImpalaRules.sk4_prefetch(sentence)) {
				numbers.add(204);
				names.add("sk4_prefetch");
			}
			if (ImpalaRules.sk5_hotspot(sentence)) {
				numbers.add(205);
				names.add("sk5_hotspot");
			}
			if (ImpalaRules.sk6_enough_space(sentence)) {
				numbers.add(206);
				names.add("sk6_enough_space");
			}
			if (ImpalaRules.sk7_buffer(sentence)) {
				numbers.add(207);
				names.add("sk7_buffer");
			}
			if (ImpalaRules.sk8_timeout_expiration(sentence)) {
				numbers.add(208);
				names.add("sk8_timeout_expiration");
			}
			if (ImpalaRules.sk9_frequency(sentence)) {
				numbers.add(209);
				names.add("sk9_frequency");
			}
			if (ImpalaRules.sk10_skip(sentence)) {
				numbers.add(210);
				names.add("sk10_skip");
			}
			if (ImpalaRules.sk11_infinity(sentence)) {
				numbers.add(211);
				names.add("sk11_infinity");
			}
			if (ImpalaRules.sk12_over_again(sentence)) {
				numbers.add(212);
				names.add("sk12_over_again");
			}
			if (ImpalaRules.sk13_regression(sentence)) {
				numbers.add(213);
				names.add("sk13_regression");
			}
			if (ImpalaRules.tk1_contended_lock(sentence)) {
				numbers.add(301);
				names.add("tk1_contended_lock");
			}
			if (ImpalaRules.tk2_bound(sentence)) {
				numbers.add(302);
				names.add("tk2_bound");
			}
			if (ImpalaRules.tk3_memory_unit(sentence)) {
				numbers.add(303);
				names.add("tk3_memory_unit");
			}
			if (ImpalaRules.tk4_cpi(sentence)) {
				numbers.add(304);
				names.add("tk4_cpi");
			}
			if (ImpalaRules.tk5_execution_skew(sentence)) {
				numbers.add(305);
				names.add("tk5_execution_skew");
			}
			if (ImpalaRules.tk6_iteration(sentence)) {
				numbers.add(306);
				names.add("tk6_iteration");
			}
			if (ImpalaRules.tk7_concurrent(sentence)) {
				numbers.add(307);
				names.add("tk7_concurrent");
			}
			if (ImpalaRules.tk8_probe_filter(sentence)) {
				numbers.add(308);
				names.add("tk8_probe_filter");
			}

			if (ImpalaRules.pf1_percentage(sentence)) {
				numbers.add(401);
				names.add("pf1_percentage");
			}
			if (ImpalaRules.pf2_duration(sentence)) {
				numbers.add(402);
				names.add("pf2_duration");
			}
			if (ImpalaRules.pf3_profiling(sentence)) {
				numbers.add(403);
				names.add("pf3_profiling");
			}
			if (ImpalaRules.pf4_benchmark(sentence)) {
				numbers.add(404);
				names.add("pf4_benchmark");
			}
			if (ImpalaRules.ss1_one_per(sentence)) {
				numbers.add(501);
				names.add("ss1_one_per");
			}
			if (ImpalaRules.ss2_all_to_one(sentence)) {
				numbers.add(502);
				names.add("ss2_all_to_one");
			}
			if (ImpalaRules.ss3_in_one_go(sentence)) {
				numbers.add(503);
				names.add("ss3_in_one_go");
			}
			if (ImpalaRules.ss4_memory(sentence)) {
				numbers.add(504);
				names.add("ss4_memory");
			}
			if (ImpalaRules.ss5_cpu(sentence)) {
				numbers.add(505);
				names.add("ss5_cpu");
			}
			if (ImpalaRules.ss6_per_per(sentence)) {
				numbers.add(506);
				names.add("ss6_per_per");
			}
			if (ImpalaRules.ss7_nn_by_nn(sentence)) {
				numbers.add(507);
				names.add("ss7_nn_by_nn");
			}
			if (ImpalaRules.ss8_load_nn(sentence)) {
				numbers.add(508);
				names.add("ss8_load_nn");
			}
			if (ImpalaRules.ss9_respond_until(sentence)) {
				numbers.add(509);
				names.add("ss9_respond_until");
			}
			if (ImpalaRules.ss10_called_frequently(sentence)) {
				numbers.add(510);
				names.add("ss10_called_frequently");
			}
			if (ImpalaRules.ss11_rework(sentence)) {
				numbers.add(511);
				names.add("ss11_rework");
			}
			if (ImpalaRules.ss12_spend_time(sentence)) {
				numbers.add(512);
				names.add("ss12_spend_time");
			}
			if (ImpalaRules.ss13_cache(sentence)) {
				numbers.add(513);
				names.add("ss13_cache");
			}
			if (ImpalaRules.ss14_perform(sentence)) {
				numbers.add(514);
				names.add("ss14_perform");
			}
			if (ImpalaRules.ss15_each_one(sentence)) {
				numbers.add(515);
				names.add("ss15_each_one");
			}
			if (ImpalaRules.ss16_close_immediately(sentence)) {
				numbers.add(516);
				names.add("ss16_close_immediately");
			}
			if (ImpalaRules.ss17_cardinality_cost(sentence)) {
				numbers.add(517);
				names.add("ss17_cardinality_cost");
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

	public static boolean gk8_spilling(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("spilling"))
				return true;
		}
		return false;
	}

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

	public static boolean sk10_skip(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("skip") || word.equals("skips") || word.equals("skipped") || word.equals("skipping")
					|| word.equals("skiped"))
				return true;
		}
		return false;
	}

	public static boolean sk11_infinity(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("infinite") || word.equals("infinity") || word.equals("forever"))
				return true;
		}
		return false;
	}

	public static boolean sk12_over_again(Sentence sentence) {
		if (sentence.getText().contains("over again"))
			return true;
		return false;
	}

	public static boolean sk13_regression(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.contains("regress"))
				return true;
		}
		return false;
	}

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

	public static boolean tk8_probe_filter(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("probe filter"))
			return true;
		return false;
	}

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
}
