package com.interviewbubble.rules.restruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class TextContainsRule {
	Map<String, String[]> rules;

	public TextContainsRule() {
		rules = new HashMap<>();

		String[] sk5_hotspot = { "hot spot" };
		rules.put("sk5_hotspot", sk5_hotspot);

		String[] sk12_over_again = { "over again", "again and again" };
		rules.put("sk12_over_again", sk12_over_again);

		String[] sk17_dynamic_allocation = { "dynamic allocation", "dynamic allocated", "allocated dynamically" };
		rules.put("sk17_dynamic_allocation", sk17_dynamic_allocation);

		String[] sk19_processing_time = { "processing time" };
		rules.put("sk19_processing_time", sk19_processing_time);

		String[] tk8_probe_filter = { "probe filter" };
		rules.put("tk8_probe_filter", tk8_probe_filter);

		String[] tk10_binary_search = { "binary search" };
		rules.put("tk10_binary_search", tk10_binary_search);

		String[] tk13_huge_data_chunk = { "huge page", "huge backlog", "huge file" };
		rules.put("tk13_huge_data_chunk", tk13_huge_data_chunk);

		String[] tk17_disk_spills = { "disk spill" };
		rules.put("tk17_disk_spills", tk17_disk_spills);

		String[] tk18_brute_force = { "brute force" };
		rules.put("tk18_brute_force", tk18_brute_force);

		String[] ss4_outofmemory = { "out of memory" };
		rules.put("ss4_outofmemory", ss4_outofmemory);
	}

	public Set<String> check_rules(Sentence sentence) {
		Set<String> matched_rules = new HashSet<>();
		for (Map.Entry<String, String[]> entry : rules.entrySet()) {
			for (String phrase : entry.getValue()) {
				if (sentence.getText().toLowerCase().contains(phrase)) {
					matched_rules.add(entry.getKey());
				}
			}
		}
		return matched_rules;

	}
}
