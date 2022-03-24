package analyze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.interviewbubble.rules.DediumRules;
import com.interviewbubble.rules.Rule;

import container.BugzillaSentence;

public class HLPChecker {
	public List<BugzillaSentence> check_literature_keywords(List<BugzillaSentence> sentences) {
		String[] keywords = { "fast", "slow", "perform", "latency", "throughput", "optimiz", "optimis", "speed",
				"waste", "efficien", "necessary", "redundan", "too many times", "lot of time", "too much time" };
		for (BugzillaSentence sentence : sentences) {
			Set<String> matched_keywords = new HashSet<>();
			for (String keyword : keywords) {
				if (sentence.getText().toLowerCase().contains(keyword)) {
					matched_keywords.add(keyword);
				}
			}
			sentence.setMatchedKeywords(matched_keywords);
		}
		return sentences;
	}

	public List<BugzillaSentence> check_keywords_rules(List<BugzillaSentence> sentences) {
		String[] rules = { "gk1_efficiency", "gk2_complexity", "gk3_reduce", "gk4_performance", "gk5_latency",
				"gk6_expensive", "gk7_speed", "gk8_spilling", "gk9_throughput", "pf2_duration", "pf4_benchmark",
				"sk10_skip", "sk11_infinity", "sk12_over_again", "sk13_regression", "sk14_overhead", "sk15_network",
				"sk16_garbage", "sk17_workload", "sk18_throttle", "sk19_processing_time", "sk2_block_hang_crash",
				"sk3_byte", "sk4_prefetch", "sk5_hotspot", "sk6_enough_space", "sk7_buffer", "sk8_timeout_expiration",
				"sk9_frequency", "ss10_called_frequently", "ss11_rework", "ss12_spend_time", "ss14_perform",
				"ss7_nn_by_nn", "ss8_load_nn", "ss9_respond_until", "tk10_binary_search", "tk11_power_consumption",
				"tk12_stress_testing", "tk13_huge_data_chunk", "tk14_data_rate", "tk15_GC_pressure", "tk16_big_O",
				"tk17_disk_spills", "tk18_brute_force", "tk1_contended_lock", "tk2_bound", "tk3_memory_unit", "tk4_cpi",
				"tk5_execution_skew", "tk6_iteration", "tk7_concurrent", "tk8_probe_filter", "tk9_thread_pause" };
		List<String> rulenames = new ArrayList<>();
		for (String r : rules) {
			rulenames.add(r);
		}
		System.out.println("Check all fuzzy rules: " + rulenames.size());
		Set<Rule> ruleset = create_rule_set(rulenames);
		return add_fitted_rules_to_sentences(sentences, ruleset);
	}

	public List<BugzillaSentence> check_all_rules(List<BugzillaSentence> sentences) {
		String[] rules = { "gk1_efficiency", "gk2_complexity", "gk3_reduce", "gk4_performance", "gk5_latency",
				"gk6_expensive", "gk7_speed", "gk8_spilling", "gk9_throughput", "pf1_percentage", "pf2_duration",
				"pf3_profiling", "pf4_benchmark", "sk10_skip", "sk11_infinity", "sk12_over_again", "sk13_regression",
				"sk14_overhead", "sk15_network", "sk16_garbage", "sk17_workload", "sk18_throttle",
				"sk19_processing_time", "sk1_negative_necessary", "sk2_block_hang_crash", "sk3_byte", "sk4_prefetch",
				"sk5_hotspot", "sk6_enough_space", "sk7_buffer", "sk8_timeout_expiration", "sk9_frequency",
				"ss10_called_frequently", "ss11_rework", "ss12_spend_time", "ss13_cache", "ss14_perform",
				"ss15_each_one", "ss16_close_immediately", "ss17_cardinality_cost", "ss18_fast_to", "ss19_lot_reading",
				"ss1_one_per", "ss20_roundtrip", "ss21_traversal", "ss22_cd_files", "ss23_avoid_if", "ss24_cost",
				"ss25_sessions", "ss26_negative_do_everything", "ss27_algorithm", "ss28_waste", "ss29_save_time_space",
				"ss2_all_to_one", "ss30_decrease_operations", "ss3_in_one_go", "ss4_memory", "ss5_cpu", "ss6_per_per",
				"ss7_nn_by_nn", "ss8_load_nn", "ss9_respond_until", "tk10_binary_search", "tk11_power_consumption",
				"tk12_stress_testing", "tk13_huge_data_chunk", "tk14_data_rate", "tk15_GC_pressure", "tk16_big_O",
				"tk17_disk_spills", "tk18_brute_force", "tk1_contended_lock", "tk2_bound", "tk3_memory_unit", "tk4_cpi",
				"tk5_execution_skew", "tk6_iteration", "tk7_concurrent", "tk8_probe_filter", "tk9_thread_pause" };
		List<String> rulenames = new ArrayList<>();
		for (String r : rules) {
			rulenames.add(r);
		}
		System.out.println("Check all fuzzy rules: " + rulenames.size());
		Set<Rule> ruleset = create_rule_set(rulenames);
		return add_fitted_rules_to_sentences(sentences, ruleset);
	}

	public Set<Rule> create_rule_set(String[] rule_names) {
		List<String> rule_name_list = new ArrayList<String>();
		for (String name : rule_names) {
			rule_name_list.add(name);
		}
		return create_rule_set(rule_name_list);
	}

	public Set<Rule> create_rule_set(List<String> rule_names) {
		Set<Rule> ruleSet = new HashSet<>();
		for (String rule_name : rule_names) {
			Rule rule = new Rule(rule_name);
			ruleSet.add(rule);
		}
		return ruleSet;
	}

	public Set<DediumRules> create_dedium_rule_set(List<String> rule_names) {
		Set<DediumRules> ruleSet = new HashSet<>();
		for (String rule_name : rule_names) {
			DediumRules rule = new DediumRules(rule_name);
			ruleSet.add(rule);
		}
		return ruleSet;
	}

	public List<BugzillaSentence> add_fitted_rules_to_sentences(List<BugzillaSentence> sentences, Set<Rule> ruleSet) {
		for (BugzillaSentence sentence : sentences) {
			Set<String> fitted_rules = new HashSet<>();
			for (Rule rule : ruleSet) {
				if (rule.do_check(sentence) != null) {
					fitted_rules.add(rule.do_check(sentence));
				}
			}
			sentence.setFittedPerfRules(fitted_rules);
		}
		return sentences;
	}

}
