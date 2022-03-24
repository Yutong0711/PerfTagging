package com.interviewbubble.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class FuzzyRuleChecker {

	public List<Sentence> check_literature_keywords(List<Sentence> sentences) {
		String[] keywords = { "fast", "slow", "perform", "latency", "throughput", "optimiz", "optimis", "speed",
				"waste", "efficien", "necessary", "redundan", "too many times", "lot of time", "too much time" };
		for (Sentence sentence : sentences) {
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

	public List<Sentence> check_keywords_rules(List<Sentence> sentences) {
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

	public List<Sentence> check_dedium_rules(List<Sentence> sentences) {
		String[] rules = { "method_1_explore", "method_2_review_theory", "method_3_provide_evidence",
				"method_4_explain", "method_5_reexamine", "method_6_paper_compare", "method_7_paper_point_out",
				"method_8_model_assume", "method_9_augment_model", "method_10_paper_describe",
				"method_11_design_or_build", "method_12_aimto", "method_13_paper_present", "method_14_paper_address",
				"method_15_examine_relationship", "method_16_use_approach", "method_17_conduct_analysis",
				"method_18_paper_introduce", "method_19_paper_investigate", "method_20_paper_review",
				"method_21_model_derive", "method_22_model_develop", "method_23_paper_purpose",
				"method_24_model_establish", "method_25_theory_develop", "method_26_author_propose",
				"method_27_study_contribute", "method_28_paper_attemps_to", "method_29_paper_provide",
				"method_30_paper_examine", "method_31_article_move_forward", "method_32_posit_that",
				"method_33_explore_how", "method_34_in_comparing", "method_35_in_this_article",
				"method_36_author_look_at", "method_37_article_begin_with", "method_38_theory_develop",
				"method_39_paper_offer", "method_40_author_study", "method_41_result_provide",
				"method_42_examine_question", "method_43_through_model", "method_44_paper_case_study",
				"method_45_address_simulation", "method_46_derive_test", "method_47_derive_concern",
				"method_48_author_examine", "method_49_study_consider", "method_50_study_question",
				"method_51_methodology", "method_52_paper_study", "method_53_paper_develop", "method_54_paper_present",
				"method_55_study_how", "method_56_begin_with_then", "method_57_investigate_test",
				"method_58_explore_by", "method_59_begin_by", "method_60_context_model", "method_61_provide_examine",
				"method_62_approach_method", "method_63_investigate_apply", "method_64_look_into",
				"method_65_come_up_with", "method_66_by_able_to", "method_67_be_studied", "sample_1_context",
				"sample_2_use_article", "sample_3_participate_article", "sample_4_use", "sample_5_model_use",
				"sample_6_use_date", "sample_7_sample", "sample_8_dataset", "sample_9_analyse_sample",
				"region_1_worldwide", "region_2_sample", "region_3_develop_country", "variable_1_variable_predict",
				"variable_2_paper_reexamine", "variable_3_study_reexamine", "variable_4_investigate_context",
				"variable_5_reveal_what", "variable_6_explore_influence", "variable_7_paper_examine_relationship",
				"variable_8_paper_investigate_affect", "variable_9_show_icrease/decrease", "variable_10_how_affect",
				"variable_11_article_investigate_effect", "variable_12_aim_effect_to", "variable_13_study_classify",
				"variable_14_finding_depend_on", "variable_15_article_explain",
				"variable_16_paper_relationship_between", "variable_17_decompose_across", "variable_18_setting_cause",
				"variable_19_author_influence", "variable_20_article_examine_influence",
				"variable_21_investigate_predict", "variable_22_how_predict", "variable_23_implication_under",
				"variable_24_account_for", "variable_25_estimate_impact_on", "variable_26_determine",
				"variable_27_linked_via", "variable_28_derive_affect", "variable_29_find_associate",
				"variable_30_find_earn", "variable_31_control_for", "variable_32_examine_effect",
				"variable_33_model_distinguish", "variable_34_explore_condition", "variable_35_reduce_amplify",
				"variable_36_conclude_represent_performance", "variable_37_relation", "result_1_find",
				"result_2_theory_consist", "result_3_paper_show", "result_4_in_sum", "result_5_demonstrate",
				"result_6_cause_by", "result_7_result_show", "result_8_model_predict", "result_9_present_result",
				"result_10_paper_suggest", "result_11_result", "result_12_conclude", "result_13_overview",
				"result_14_experience_influence", "result_15_contrast_study", "result_16_consist_predict",
				"result_17_setting_cause", "result_18_article_define", "result_19_positively_predicted",
				"result_20_consist_theory", "result_21_far_from_show_to", "result_22_literature_by",
				"result_23_model_insight_into", "result_24_evidence_provide", "result_25_find_suggest_that",
				"result_26_turn_out_that" };
		List<String> rulenames = new ArrayList<>();
		for (String r : rules) {
			rulenames.add(r);
		}
		System.out.println("Check all Dedium rules: " + rulenames.size());
		Set<DediumRules> ruleset = create_dedium_rule_set(rulenames);
		return add_fitted_dedium_rules_to_sentences(sentences, ruleset);
	}

	public List<Sentence> check_all_rules(List<Sentence> sentences) {
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

	public List<Sentence> check_sentences(List<Sentence> sentences, List<String> rulenames) {
		FuzzyRuleChecker fuzzyRuleChecker = new FuzzyRuleChecker();
		Set<Rule> rule_set = fuzzyRuleChecker.create_rule_set(rulenames);
		List<Sentence> res = fuzzyRuleChecker.add_fitted_rules_to_sentences(sentences, rule_set);
		Set<String> fitted_rules = new HashSet<>();
		int tp = 0, fp = 0, tn = 0, fn = 0;

		for (Sentence sentence : res) {
			if (sentence.getFittedPerfRules().size() > 0) {
				fitted_rules.addAll(sentence.getFittedPerfRules());
				if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
					tp++;
				} else {
					fp++;
				}
			} else {
				if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
					fn++;
				} else {
					tn++;
				}
			}
		}
		System.out.println("Checking " + rulenames.size() + " fuzzy rules for " + sentences.size() + " sentences: ");
		System.out.println("Fitted Rules: " + fitted_rules.size());
		System.out.println("True Positive: " + tp);
		System.out.println("False Positive: " + fp);
		System.out.println("True Negative: " + tn);
		System.out.println("False Negative: " + fn);
		return res;
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

	public List<Sentence> add_fitted_rules_to_sentences(List<Sentence> sentences, Set<Rule> ruleSet) {
		for (Sentence sentence : sentences) {
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

	public List<Sentence> add_fitted_dedium_rules_to_sentences(List<Sentence> sentences, Set<DediumRules> ruleSet) {
		for (Sentence sentence : sentences) {
			Set<String> fitted_rules = new HashSet<>();
			Set<String> categories = new HashSet<String>();
			for (DediumRules rule : ruleSet) {
				if (rule.do_check(sentence) != null) {
					fitted_rules.add(rule.do_check(sentence));
				}
			}
			sentence.setFittedPerfRules(fitted_rules);
			for (String fittedPerfRule : sentence.getFittedPerfRules()) {
				if (fittedPerfRule.startsWith("method")) {
					categories.add("Method");
				}
				if (fittedPerfRule.startsWith("sample")) {
					categories.add("Sample");
				}
				if (fittedPerfRule.startsWith("region")) {
					categories.add("Region");
				}
				if (fittedPerfRule.startsWith("variable")) {
					categories.add("Variable");
				}
				if (fittedPerfRule.startsWith("result")) {
					categories.add("Result");
				}
			}
			sentence.setCategory(categories);
		}
		return sentences;
	}
}
