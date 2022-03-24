package com.interviewbubble.rules.restruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class SingleKeywordRule extends FuzzyRule {
	Map<String, String[]> rules;

	public SingleKeywordRule() {
		rules = new HashMap<>();

		String[] gk1_efficiency = { "efficient", "efficiency", "inefficient", "inefficiency" };
		rules.put("gk1_efficiency", gk1_efficiency);

		// String[] gk2_complexity = { "complex", "complexity", "complicated",
		// "uncomplex" };
		// rules.put("gk2_complexity", gk2_complexity);

		String[] gk3_reduce = { "reduce" };
		rules.put("gk3_reduce", gk3_reduce);

		String[] gk4_performance = { "performance" };
		rules.put("gk4_performance", gk4_performance);

		String[] gk5_latency = { "latency" };
		rules.put("gk5_latency", gk5_latency);

		String[] gk6_expensive = { "expensive" };
		rules.put("gk6_expensive", gk6_expensive);

		String[] gk7_speed = { "speed", "speedup", "accelerate", "velocity", "fast", "faster", "slow", "slowness",
				"slower" };
		rules.put("gk7_speed", gk7_speed);

		String[] gk8_spilling = { "spilling" };
		rules.put("gk8_spilling", gk8_spilling);

		String[] gk9_throughput = { "throughput" };
		rules.put("gk9_throughput", gk9_throughput);

		String[] sk1_negative_necessary = { "unnecessary", "unneeded", "redundant", "redundancy", "wasteful" };
		rules.put("sk1_negative_necessary", sk1_negative_necessary);

		String[] sk2_block_hang_crash = { "blocked", "blocking", "bottleneck", "bottlenecked", "hang" };
		rules.put("sk2_block_hang_crash", sk2_block_hang_crash);

		String[] sk4_prefetch = { "prefetch", "pre-fetch" };
		rules.put("sk4_prefetch", sk4_prefetch);

		String[] sk5_hotspot = { "hotspot" };
		rules.put("sk5_hotspot", sk5_hotspot);

		String[] sk13_regression = { "regress", "regressed", "regression" };
		rules.put("sk13_regression", sk13_regression);

		String[] sk14_overhead = { "overhead" };
		rules.put("sk14_overhead", sk14_overhead);

		String[] sk18_throttle = { "throttle", "throttling", "throttled" };
		rules.put("sk18_throttle", sk18_throttle);

		String[] tk3_memory_unit = { "kb", "mb", "gb", "tb" };
		rules.put("tk3_memory_unit", tk3_memory_unit);

		String[] tk4_cpi = { "cpi" };
		rules.put("tk4_cpi", tk4_cpi);

		String[] tk16_big_O = { "o(n*log(n))", "o(nlog(n))", "o(n)", "o(n^2)", "o(1)", "o(2^n)", "o(n!)" };
		rules.put("tk16_big_O", tk16_big_O);

		String[] tk18_brute_force = { "brute-force" };
		rules.put("tk18_brute_force", tk18_brute_force);

		// String[] tk19_deadlock = { "deadlock", "deadlocked" };
		// rules.put("tk19_deadlock", tk19_deadlock);

		String[] pf3_profiling = { "<profiling>", "ms", "ops/sec", "megabytes/sec", "mb/sec", "mb/s" };
		rules.put("pf3_profiling", pf3_profiling);

		String[] pf4_benchmark = { "benchmark" };
		rules.put("pf4_benchmark", pf4_benchmark);

		String[] ss4_outofmemory = { "oom", "outofmemory", "out-of-memory", "oome" };
		rules.put("ss4_outofmemory", ss4_outofmemory);

		String[] ss11_rework = { "redo", "recalculate", "recalculation", "rework", "resurrect", "rewrite", "reload",
				"resize" };
		rules.put("ss11_rework", ss11_rework);

	}

	public Map<String, String[]> getRules() {
		return rules;
	}

	public Set<String> check_rules(Sentence sentence) {
		// TODO Auto-generated method stub
		Set<String> matched_rules = new HashSet<>();
		int length = Math.min(sentence.getWords().size(), sentence.getLemmas().size());
		for (Map.Entry<String, String[]> entry : rules.entrySet()) {
			for (String keyword : entry.getValue()) {
				for (int i = 0; i < length; i++) {
					if (sentence.getWords().get(i).equals(keyword) || sentence.getLemmas().get(i).equals(keyword)) {
						matched_rules.add(entry.getKey());
					}
				}
			}
		}
		return matched_rules;
	}
}
