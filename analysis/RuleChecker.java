package com.interviewbubble.analysis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.GeneralKeywordRules;
import com.interviewbubble.rules.ProfilingRules;
import com.interviewbubble.rules.SentenceStructureRules;
import com.interviewbubble.rules.SpecificKeywordRules;
import com.interviewbubble.rules.TerminologyKeywordRules;

public class RuleChecker {
	public static List<Sentence> checkSentenceStructuralRules(List<Sentence> sentences) {
		for (Sentence sentence : sentences) {
			Set<Integer> numbers = new HashSet<>();
			Set<String> names = new HashSet<>();

			if (SentenceStructureRules.ss1_one_per(sentence)) {
				numbers.add(501);
				names.add("ss1_one_per");
			}
			if (SentenceStructureRules.ss2_all_to_one(sentence)) {
				numbers.add(502);
				names.add("ss2_all_to_one");
			}
			if (SentenceStructureRules.ss3_in_one_go(sentence)) {
				numbers.add(503);
				names.add("ss3_in_one_go");
			}
			if (SentenceStructureRules.ss4_memory(sentence)) {
				numbers.add(504);
				names.add("ss4_memory");
			}
			if (SentenceStructureRules.ss5_cpu(sentence)) {
				numbers.add(505);
				names.add("ss5_cpu");
			}
			if (SentenceStructureRules.ss6_per_per(sentence)) {
				numbers.add(506);
				names.add("ss6_per_per");
			}
			if (SentenceStructureRules.ss7_nn_by_nn(sentence)) {
				numbers.add(507);
				names.add("ss7_nn_by_nn");
			}
			if (SentenceStructureRules.ss8_load_nn(sentence)) {
				numbers.add(508);
				names.add("ss8_load_nn");
			}
			if (SentenceStructureRules.ss9_respond_until(sentence)) {
				numbers.add(509);
				names.add("ss9_respond_until");
			}
			if (SentenceStructureRules.ss10_called_frequently(sentence)) {
				numbers.add(510);
				names.add("ss10_called_frequently");
			}
			if (SentenceStructureRules.ss11_rework(sentence)) {
				numbers.add(511);
				names.add("ss11_rework");
			}
			if (SentenceStructureRules.ss12_spend_time(sentence)) {
				numbers.add(512);
				names.add("ss12_spend_time");
			}
			if (SentenceStructureRules.ss13_cache(sentence)) {
				numbers.add(513);
				names.add("ss13_cache");
			}
			if (SentenceStructureRules.ss14_perform(sentence)) {
				numbers.add(514);
				names.add("ss14_perform");
			}
			if (SentenceStructureRules.ss15_each_one(sentence)) {
				numbers.add(515);
				names.add("ss15_each_one");
			}
			if (SentenceStructureRules.ss16_close_immediately(sentence)) {
				numbers.add(516);
				names.add("ss16_close_immediately");
			}
			if (SentenceStructureRules.ss17_cardinality_cost(sentence)) {
				numbers.add(517);
				names.add("ss17_cardinality_cost");
			}
			if (SentenceStructureRules.ss18_fast_to(sentence)) {
				numbers.add(518);
				names.add("ss18_fast_to");
			}
			if (SentenceStructureRules.ss19_lot_reading(sentence)) {
				numbers.add(519);
				names.add("ss19_lot_reading");
			}
			if (SentenceStructureRules.ss20_roundtrip(sentence)) {
				numbers.add(520);
				names.add("ss20_roundtrip");
			}
			if (SentenceStructureRules.ss21_traversal(sentence)) {
				numbers.add(521);
				names.add("ss21_traversal");
			}
			if (SentenceStructureRules.ss22_cd_files(sentence)) {
				numbers.add(522);
				names.add("ss22_cd_files");
			}
			if (SentenceStructureRules.ss23_avoid_if(sentence)) {
				numbers.add(523);
				names.add("ss23_avoid_if");
			}
			if (SentenceStructureRules.ss24_cost(sentence)) {
				numbers.add(524);
				names.add("ss24_cost");
			}
			if (SentenceStructureRules.ss25_sessions(sentence)) {
				numbers.add(525);
				names.add("ss25_sessions");
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
		}
		return sentences;
	}

	public static List<Sentence> checkProfilingRules(List<Sentence> sentences) {
		for (Sentence sentence : sentences) {
			Set<Integer> numbers = new HashSet<>();
			Set<String> names = new HashSet<>();

			if (ProfilingRules.pf1_percentage(sentence)) {
				numbers.add(401);
				names.add("pf1_percentage");
			}
			if (ProfilingRules.pf2_duration(sentence)) {
				numbers.add(402);
				names.add("pf2_duration");
			}
			if (ProfilingRules.pf3_profiling(sentence)) {
				numbers.add(403);
				names.add("pf3_profiling");
			}
			if (ProfilingRules.pf4_benchmark(sentence)) {
				numbers.add(404);
				names.add("pf4_benchmark");
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
		}

		return sentences;
	}

	public static List<Sentence> checkTerminologyKeywordRules(List<Sentence> sentences) {
		for (Sentence sentence : sentences) {
			Set<Integer> numbers = new HashSet<>();
			Set<String> names = new HashSet<>();
			if (TerminologyKeywordRules.tk1_contended_lock(sentence)) {
				numbers.add(301);
				names.add("tk1_contended_lock");
			}
			if (TerminologyKeywordRules.tk2_bound(sentence)) {
				numbers.add(302);
				names.add("tk2_bound");
			}
			if (TerminologyKeywordRules.tk3_memory_unit(sentence)) {
				numbers.add(303);
				names.add("tk3_memory_unit");
			}
			if (TerminologyKeywordRules.tk4_cpi(sentence)) {
				numbers.add(304);
				names.add("tk4_cpi");
			}
			if (TerminologyKeywordRules.tk5_execution_skew(sentence)) {
				numbers.add(305);
				names.add("tk5_execution_skew");
			}
			if (TerminologyKeywordRules.tk6_iteration(sentence)) {
				numbers.add(306);
				names.add("tk6_iteration");
			}
			if (TerminologyKeywordRules.tk7_concurrent(sentence)) {
				numbers.add(307);
				names.add("tk7_concurrent");
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
		}
		return sentences;
	}

	public static List<Sentence> checkSpecificKeywordRules(List<Sentence> sentences) {
		for (Sentence sentence : sentences) {
			Set<Integer> numbers = new HashSet<>();
			Set<String> names = new HashSet<>();
			if (SpecificKeywordRules.sk1_negative_necessary(sentence)) {
				numbers.add(201);
				names.add("sk1_negative_necessary");
			}
			if (SpecificKeywordRules.sk2_block_hang_crash(sentence)) {
				numbers.add(202);
				names.add("sk2_block_hang_crash");
			}
			if (SpecificKeywordRules.sk3_byte(sentence)) {
				numbers.add(203);
				names.add("sk3_byte");
			}
			if (SpecificKeywordRules.sk4_prefetch(sentence)) {
				numbers.add(204);
				names.add("sk4_prefetch");
			}
			if (SpecificKeywordRules.sk5_hotspot(sentence)) {
				numbers.add(205);
				names.add("sk5_hotspot");
			}
			if (SpecificKeywordRules.sk6_enough_space(sentence)) {
				numbers.add(206);
				names.add("sk6_enough_space");
			}
			if (SpecificKeywordRules.sk7_buffer(sentence)) {
				numbers.add(207);
				names.add("sk7_buffer");
			}
			if (SpecificKeywordRules.sk8_timeout_expiration(sentence)) {
				numbers.add(208);
				names.add("sk8_timeout_expiration");
			}
			if (SpecificKeywordRules.sk9_frequency(sentence)) {
				numbers.add(209);
				names.add("sk9_frequency");
			}
			if (SpecificKeywordRules.sk10_overhead(sentence)) {
				numbers.add(210);
				names.add("sk10_overhead");
			}
			if (SpecificKeywordRules.sk11_skip(sentence)) {
				numbers.add(211);
				names.add("sk11_skip");
			}
			if (SpecificKeywordRules.sk12_infinity(sentence)) {
				numbers.add(212);
				names.add("sk12_infinity");
			}
			if (SpecificKeywordRules.sk13_over_again(sentence)) {
				numbers.add(213);
				names.add("sk13_over_again");
			}
			if (SpecificKeywordRules.sk14_regression(sentence)) {
				numbers.add(214);
				names.add("sk14_regression");
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
		}

		return sentences;
	}

	public static List<Sentence> checkGeneralKeywordRules(List<Sentence> sentences) {
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

			if (GeneralKeywordRules.gk1_efficiency(sentence)) {
				numbers.add(101);
				names.add("gk1_efficiency");
			}
			if (GeneralKeywordRules.gk2_complexity(sentence)) {
				numbers.add(102);
				names.add("gk2_complexity");
			}
			if (GeneralKeywordRules.gk3_reduce(sentence)) {
				numbers.add(103);
				names.add("gk3_reduce");
			}
			if (GeneralKeywordRules.gk4_performance(sentence)) {
				numbers.add(104);
				names.add("gk4_performance");
			}
			if (GeneralKeywordRules.gk5_latency(sentence)) {
				numbers.add(105);
				names.add("gk5_latency");
			}
			if (GeneralKeywordRules.gk6_expensive(sentence)) {
				numbers.add(106);
				names.add("gk6_expensive");
			}
			if (GeneralKeywordRules.gk7_speed(sentence)) {
				numbers.add(107);
				names.add("gk7_speed");
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

	public static List<Sentence> doCheck(List<Sentence> sentences) {
		sentences = checkGeneralKeywordRules(sentences);
		sentences = checkSpecificKeywordRules(sentences);
		sentences = checkTerminologyKeywordRules(sentences);
		sentences = checkProfilingRules(sentences);
		sentences = checkSentenceStructuralRules(sentences);

		return sentences;
	}
}
