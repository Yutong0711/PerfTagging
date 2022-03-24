package com.interviewbubble.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class SvnHiveSparkCassandraIgniteOakImpalaRules {
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
			if (gk3_reduce(sentence)) {
				numbers.add(103);
				names.add("gk3_reduce");
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
			if (gk8_spilling(sentence)) {
				numbers.add(108);
				names.add("gk8_spilling");
			}
			if (gk9_throughput(sentence)) {
				numbers.add(109);
				names.add("gk9_throughput");
			}

			if (sk1_negative_necessary(sentence)) {
				numbers.add(201);
				names.add("sk1_negative_necessary");
			}
			if (sk2_block_hang_crash(sentence)) {
				numbers.add(202);
				names.add("sk2_block_hang_crash");
			}
			if (sk3_byte(sentence)) {
				numbers.add(203);
				names.add("sk3_byte");
			}
			if (sk4_prefetch(sentence)) {
				numbers.add(204);
				names.add("sk4_prefetch");
			}
			if (sk5_hotspot(sentence)) {
				numbers.add(205);
				names.add("sk5_hotspot");
			}
			if (sk6_enough_space(sentence)) {
				numbers.add(206);
				names.add("sk6_enough_space");
			}
			if (sk7_buffer(sentence)) {
				numbers.add(207);
				names.add("sk7_buffer");
			}
			if (sk8_timeout_expiration(sentence)) {
				numbers.add(208);
				names.add("sk8_timeout_expiration");
			}
			if (sk9_frequency(sentence)) {
				numbers.add(209);
				names.add("sk9_frequency");
			}
			if (sk10_skip(sentence)) {
				numbers.add(210);
				names.add("sk10_skip");
			}
			if (sk11_infinity(sentence)) {
				numbers.add(211);
				names.add("sk11_infinity");
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
			if (sk15_network(sentence)) {
				numbers.add(215);
				names.add("sk15_network");
			}
			if (sk16_garbage(sentence)) {
				numbers.add(216);
				names.add("sk16_garbage");
			}
			if (sk17_workload(sentence)) {
				numbers.add(217);
				names.add("sk17_workload");
			}
			if (sk18_throttle(sentence)) {
				numbers.add(218);
				names.add("sk18_throttle");
			}
			if (sk19_processing_time(sentence)) {
				numbers.add(219);
				names.add("sk19_processing_time");
			}
			if (tk1_contended_lock(sentence)) {
				numbers.add(301);
				names.add("tk1_contended_lock");
			}
			if (tk2_bound(sentence)) {
				numbers.add(302);
				names.add("tk2_bound");
			}
			if (tk3_memory_unit(sentence)) {
				numbers.add(303);
				names.add("tk3_memory_unit");
			}
			if (tk4_cpi(sentence)) {
				numbers.add(304);
				names.add("tk4_cpi");
			}
			if (tk5_execution_skew(sentence)) {
				numbers.add(305);
				names.add("tk5_execution_skew");
			}
			if (tk6_iteration(sentence)) {
				numbers.add(306);
				names.add("tk6_iteration");
			}
			if (tk7_concurrent(sentence)) {
				numbers.add(307);
				names.add("tk7_concurrent");
			}
			if (tk8_probe_filter(sentence)) {
				numbers.add(308);
				names.add("tk8_probe_filter");
			}
			if (tk9_thread(sentence)) {
				numbers.add(309);
				names.add("tk9_thread_pause");
			}
			if (tk10_binary_search(sentence)) {
				numbers.add(310);
				names.add("tk10_binary_search");
			}
			if (tk11_power_consumption(sentence)) {
				numbers.add(311);
				names.add("tk11_power_consumption");
			}
			if (tk12_stress_testing(sentence)) {
				numbers.add(312);
				names.add("tk12_stress_testing");
			}
			if (tk13_huge_data_chunk(sentence)) {
				numbers.add(313);
				names.add("tk13_huge_data_chunk");
			}
			if (tk14_data_rate(sentence)) {
				numbers.add(314);
				names.add("tk14_data_rate");
			}
			if (tk15_GC_pressure(sentence)) {
				numbers.add(315);
				names.add("tk15_GC_pressure");
			}
			if (tk16_big_O(sentence)) {
				numbers.add(316);
				names.add("tk16_big_O");
			}
			if (tk17_disk_spills(sentence)) {
				numbers.add(317);
				names.add("tk17_disk_spills");
			}
			if (tk18_brute_force(sentence)) {
				numbers.add(318);
				names.add("tk18_brute_force");
			}
			if (pf1_percentage(sentence)) {
				numbers.add(401);
				names.add("pf1_percentage");
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
			if (ss1_one_per(sentence)) {
				numbers.add(501);
				names.add("ss1_one_per");
			}
			if (ss2_all_to_one(sentence)) {
				numbers.add(502);
				names.add("ss2_all_to_one");
			}
			if (ss3_in_one_go(sentence)) {
				numbers.add(503);
				names.add("ss3_in_one_go");
			}
			if (ss4_memory(sentence)) {
				numbers.add(504);
				names.add("ss4_memory");
			}
			if (ss5_cpu(sentence)) {
				numbers.add(505);
				names.add("ss5_cpu");
			}
			if (ss6_per_per(sentence)) {
				numbers.add(506);
				names.add("ss6_per_per");
			}
			if (ss7_nn_by_nn(sentence)) {
				numbers.add(507);
				names.add("ss7_nn_by_nn");
			}
			if (ss8_load_nn(sentence)) {
				numbers.add(508);
				names.add("ss8_load_nn");
			}
			if (ss9_respond_until(sentence)) {
				numbers.add(509);
				names.add("ss9_respond_until");
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
			if (ss15_each_one(sentence)) {
				numbers.add(515);
				names.add("ss15_each_one");
			}
			if (ss16_close_immediately(sentence)) {
				numbers.add(516);
				names.add("ss16_close_immediately");
			}
			if (ss17_cardinality_cost(sentence)) {
				numbers.add(517);
				names.add("ss17_cardinality_cost");
			}
			if (ss18_fast_to(sentence)) {
				numbers.add(518);
				names.add("ss18_fast_to");
			}
			if (ss19_lot_reading(sentence)) {
				numbers.add(519);
				names.add("ss19_lot_reading");
			}
			if (ss20_roundtrip(sentence)) {
				numbers.add(520);
				names.add("ss20_roundtrip");
			}
			if (ss21_traversal(sentence)) {
				numbers.add(521);
				names.add("ss21_traversal");
			}
			if (ss22_cd_files(sentence)) {
				numbers.add(522);
				names.add("ss22_cd_files");
			}
			if (ss23_avoid_if(sentence)) {
				numbers.add(523);
				names.add("ss23_avoid_if");
			}
			if (ss24_cost(sentence)) {
				numbers.add(524);
				names.add("ss24_cost");
			}
			if (ss25_sessions(sentence)) {
				numbers.add(525);
				names.add("ss25_sessions");
			}
			if (ss26_negative_do_everything(sentence)) {
				numbers.add(526);
				names.add("ss26_negative_do_everything");
			}
			if (ss27_cost(sentence)) {
				numbers.add(527);
				names.add("ss27_cost");
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
			if (words.get(i).equals("average")) {
				b2 = true;
			}
			if (words.get(i).equals("sped")) {
				sped = i;
			}
			if (words.get(i).contains("speedup") || words.get(i).equals("faster") || words.get(i).contains("accelerat")
					|| words.get(i).equals("quick") || words.get(i).equals("quickly")
					|| words.get(i).contains("slow")) {
				return true;
			}
		}
		if (text.contains("great speed") || text.contains("fast speed") || text.contains("low performing")
				|| text.contains("low-velocity"))
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

	public static boolean gk8_spilling(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("spilling"))
				return true;
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

	public static boolean sk1_negative_necessary(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("unnecessary") || word.equals("unneeded") || word.equals("redundant")
					|| word.equals("redundancy") || word.equals("wasteful"))
				return true;
		}

		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		if (sentence.getText().contains("no longer"))
			b1 = true;
		for (String word : words) {
			if (word.equals("only") || word.equals("not") || sentence.getText().contains("uglier than"))
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
		String text = sentence.getText().toLowerCase();
		for (String word : words) {
			if (word.contains("buffer"))
				b1 = true;
			if (word.equals("additional") || word.equals("size") || word.equals("sizes") || word.contains("optimiz")
					|| word.contains("connection") || word.equals("fit") || word.equals("filled-up"))
				b2 = true;
		}
		if (text.contains("on heap") || text.contains("on-heap") || text.contains("off heap")
				|| text.contains("off-heap"))
			b2 = true;
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

	public static boolean sk14_overhead(Sentence sentence) {
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("overhead") || word.equals("overheads")) {
				return true;
			}
		}
		return false;
	}

	public static boolean sk15_network(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("network") || word.equals("networks"))
				b1 = true;
			if (word.equals("traffic") || word.equals("traffics") || word.equals("hop") || word.equals("hops"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
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

	public static boolean sk17_workload(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("wordload") || word.equals("workloads")) {
				b1 = true;
			}
			if (word.contains("overwrite") || word.equals("smaller"))
				b2 = true;
		}
		String text = sentence.getText().toLowerCase();
		if (text.contains("corner case")) {
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

	public static boolean sk19_processing_time(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("processing time")) {
			return true;
		}
		return false;
	}

	public static boolean tk1_contended_lock(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("contended") || word.equals("contention")) {
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

	public static boolean tk9_thread(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;
		String text = sentence.getText().toLowerCase();
		if (text.contains("thread pool") || text.contains("thread-per-peer"))
			b5 = true;
		for (String word : words) {
			if (word.equals("thread") || word.equals("threads") || word.equalsIgnoreCase("gc"))
				b1 = true;
			if (word.equals("pause") || word.equals("pauses") || word.equals("paused") || word.equals("deltification"))
				b2 = true;
			if (word.equals("count"))
				b3 = true;
			if (word.equals("low") || word.equals("high"))
				b4 = true;
			if (word.equals("jump") || word.equals("jumps") || word.equals("removed") || word.equals("remove")
					|| word.equals("removes") || word.equals("outbound"))
				b6 = true;
		}
		if (b1 && b2)
			return true;
		if (b1 && b3 && b4)
			return true;
		if (b5 && b6)
			return true;
		return false;
	}

	public static boolean tk10_binary_search(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("binary search"))
			return true;
		return false;
	}

	public static boolean tk11_power_consumption(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		for (String word : words) {
			if (word.equals("power"))
				b1 = true;
			if (word.equals("consumption"))
				b2 = true;
			if (word.equalsIgnoreCase("drain"))
				b3 = true;
			if (word.equals("battery"))
				b4 = true;
		}
		if (b1 && b2)
			return true;
		if (b3 && b4)
			return true;
		return false;
	}

	public static boolean tk12_stress_testing(Sentence sentence) {
		List<String> words = sentence.getWords();
		boolean b1 = false, b2 = false;
		for (String word : words) {
			if (word.equals("stress"))
				b1 = true;
			if (word.equals("testing"))
				b2 = true;
		}
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean tk13_huge_data_chunk(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("huge page") || text.contains("huge backlog") || text.contains("huge file"))
			return true;
		return false;
	}

	public static boolean tk14_data_rate(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		String text = sentence.getText().toLowerCase();
		if (text.contains("data rate") || text.contains("hit rate") || text.contains("allocation rate"))
			b1 = true;
		for (String word : words) {
			if (word.contains("calculat") || word.equals("optimal") || word.equals("high"))
				b2 = true;
		}
		if (text.contains("perf hit"))
			return true;
		if (b1 && b2)
			return true;
		return false;
	}

	public static boolean tk15_GC_pressure(Sentence sentence) {
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("gc")) {
				b1 = true;
			}
			if (word.equals("pressure")) {
				b2 = true;
			}
			if (word.equals("count"))
				b3 = true;
			if (word.contains("increas")) {
				b4 = true;
			}
		}
		if (b1 && b2)
			return true;
		if (b1 && b3 && b4)
			return true;
		return false;
	}

	public static boolean tk16_big_O(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("o(n*log(n))") || text.contains("o(n)") || text.contains("o(n^2)") || text.contains("o(1)")) {
			return true;
		}
		return false;
	}

	public static boolean tk17_disk_spills(Sentence sentence) {
		String text = sentence.getText().toLowerCase();
		if (text.contains("disk spill")) {
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
					|| word.equals("profiling") || word.equals("ms") || word.equals("ops/sec")
					|| word.equals("megabytes/sec") || word.equals("mb/sec") || word.equals("mb/s"))
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
		String text = sentence.getText().toLowerCase();
		if (text.contains("add them all into your compaction"))
			return true;
		for (String word : words) {
			if (word.equals("all") || word.equals("overall"))
				b1 = true;
			if (word.equalsIgnoreCase("each"))
				b3 = true;
		}
		if (sentence.getText().contains("to a") || sentence.getText().contains("to one")
				|| sentence.getText().contains("one at a time")) {
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
		if (text.contains("no more than") && text.contains("at a time"))
			return true;
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
			if (word.equalsIgnoreCase("usage") || word.equals("overflow") || word.equals("hold")
					|| word.equals("remove") || word.equals("bloat") || word.equals("limit")
					|| word.equals("limitation") || word.equals("lot") || word.equals("plenty")
					|| word.equals("consume") || word.equals("consumes") || word.equals("consuming")
					|| word.contains("consumption") || word.equals("excessive") || word.equals("usage")
					|| word.equals("utilization") || word.equals("pack") || word.contains("accumulat")
					|| word.equals("high") || word.contains("increas") || word.equals("access")
					|| word.contains("allocat") || word.equals("much") || word.equals("backpressure")
					|| word.equals("management") || word.equals("lower") || word.equals("higher")
					|| word.equals("shuffle") || word.equals("leak")) {
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
		if (text.contains("lot of") || text.contains("lots of") || text.contains("low level"))
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
		String text = sentence.getText().toLowerCase();
		if (text.contains("field-by-field") || text.contains("byte-by-byte"))
			return true;
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
				|| text.contains("nearly every") || text.contains("a lot") || text.contains("on every")) {
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
					|| word.equals("waste") || word.equals("wastes") || word.equals("wasting") || word.equals("loose")
					|| word.equals("looses") || word.equals("loosed")) {
				b1 = true;
			}
			if (word.equals("most") || word.equals("most") || word.equals("long") || word.equals("part")
					|| word.equals("part") || word.contains("significant") || word.equals("longer")
					|| word.equals("majority") || word.equals("minority")) {
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
		if (text.contains("fail fast") || text.contains("fails fast") || text.contains("fast way")
				|| text.contains("fast pace") || text.contains("as fast as") || text.contains("extreme fast"))
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
			if (word.equals("lot") || word.equals("many") || word.equals("high") || word.equals("same")
					|| word.equals("every"))
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
			if (word.equals("entire") || word.equalsIgnoreCase("broad") || word.equals("lot") || word.equals("full")
					|| word.equals("recursively"))
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
					|| word.equals("again") || word.contains("duplicat") || word.contains("overrid")
					|| word.equals("double") || word.equals("lookup") || word.equals("lookups")) {
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
		String text = sentence.getText().toLowerCase();
		for (String word : words) {
			if (word.equals("cost") || word.equals("costs") || word.equals("costly")) {
				b1 = true;
			}
			if (word.equals("high") || word.equals("low") || word.equals("higher") || word.equals("lower")
					|| word.equals("minimum") || word.equals("maximum")) {
				b2 = true;
			}
		}
		if (text.contains("read lock")) {
			b2 = true;
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

	public static boolean ss26_negative_do_everything(Sentence sentence) {
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		List<String> words = sentence.getWords();
		String text = sentence.getText().toLowerCase();
		if (text.contains("shouldn't"))
			b1 = true;
		for (String word : words) {
			if (word.equals("not") || word.equals("n't")) {
				b1 = true;
			}
			if (word.equals("read") || word.equals("reads") || word.equals("do") || word.equals("create")
					|| word.equals("creates")) {
				b2 = true;
			}
			if (word.equals("everything") || word.equals("each") || word.equals("every")) {
				b3 = true;
			}
			if (word.equals("object") || word.equals("objects"))
				b4 = true;
		}
		if (b1 && b2 && b3) {
			return true;
		}
		if (b2 && b3 && b4)
			return true;
		return false;
	}

	public static boolean ss27_cost(Sentence sentence) {
		boolean b1 = false, b2 = false;
		List<String> words = sentence.getWords();
		for (String word : words) {
			if (word.equals("cost") || word.equals("costs") || word.equals("costly")) {
				b1 = true;
			}
			if (word.equals("nothing") || word.equals("higher") || word.equals("lower") || word.equals("high")
					|| word.equals("low") || word.contains("increas")) {
				b2 = true;
			}
		}
		if (b1 && b2)
			return true;
		return false;
	}
}
