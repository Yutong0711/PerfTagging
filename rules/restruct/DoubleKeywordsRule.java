package com.interviewbubble.rules.restruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interviewbubble.entity.Sentence;

public class DoubleKeywordsRule extends FuzzyRule {
	Map<String, List<String[]>> rules;

	public DoubleKeywordsRule() {
		rules = new HashMap<>();

		List<String[]> sk1_negative_necessary_double = new ArrayList<>();
		String[] sk1_negative_necessary_1 = { "only", "not", "uglier" };
		String[] sk1_negative_necessary_2 = { "necessary", "needed" };
		sk1_negative_necessary_double.add(sk1_negative_necessary_1);
		sk1_negative_necessary_double.add(sk1_negative_necessary_2);
		rules.put("sk1_negative_necessary_double", sk1_negative_necessary_double);

		List<String[]> sk2_process_crash = new ArrayList<>();
		String[] sk2_process_crash_1 = { "process" };
		String[] sk2_process_crash_2 = { "crash" };
		sk2_process_crash.add(sk2_process_crash_2);
		sk2_process_crash.add(sk2_process_crash_1);
		rules.put("sk2_process_crash", sk2_process_crash);

		List<String[]> sk6_enough_space = new ArrayList<>();
		String[] sk6_enough_space_1 = { "space" };
		String[] sk6_enough_space_2 = { "enough" };
		sk6_enough_space.add(sk6_enough_space_1);
		sk6_enough_space.add(sk6_enough_space_2);
		rules.put("sk6_enough_space", sk6_enough_space);

		List<String[]> sk7_buffer = new ArrayList<>();
		String[] sk7_buffer_1 = { "buffer" };
		String[] sk7_buffer_2 = { "additional", "optimize", "improve", "connection", "heap", "fit", "filled-up",
				"on-heap", "off-heap" };
		sk7_buffer.add(sk7_buffer_1);
		sk7_buffer.add(sk7_buffer_2);
		rules.put("sk7_buffer", sk7_buffer);

		List<String[]> sk15_network_traffic = new ArrayList<>();
		String[] sk15_network_1 = { "network" };
		String[] sk15_network_2 = { "traffic", "hop" };
		sk15_network_traffic.add(sk15_network_1);
		sk15_network_traffic.add(sk15_network_2);
		rules.put("sk15_network_traffic", sk15_network_traffic);

		List<String[]> sk16_garbage = new ArrayList<>();
		String[] sk16_garbage_1 = { "garbage" };
		String[] sk16_garbage_2 = { "produce", "generate", "generation", "production" };
		sk16_garbage.add(sk16_garbage_1);
		sk16_garbage.add(sk16_garbage_2);
		rules.put("sk16_garbage", sk16_garbage);

		List<String[]> tk1_contended_lock = new ArrayList<>();
		String[] tk1_contended_lock_1 = { "contended", "contention", "contend" };
		String[] tk1_contended_lock_2 = { "lock" };
		tk1_contended_lock.add(tk1_contended_lock_1);
		tk1_contended_lock.add(tk1_contended_lock_2);
		rules.put("tk1_contended_lock", tk1_contended_lock);

		List<String[]> tk5_execution_skew = new ArrayList<>();
		String[] tk5_execution_skew_1 = { "execution" };
		String[] tk5_execution_skew_2 = { "skew" };
		tk5_execution_skew.add(tk5_execution_skew_1);
		tk5_execution_skew.add(tk5_execution_skew_2);
		rules.put("tk5_execution_skew", tk5_execution_skew);

		List<String[]> tk6_iteration_break_infinity = new ArrayList<>();
		String[] tk6_iteration_break_infinity_1 = { "loop", "iteration", "iterate", "iterative", "recursive",
				"recursion" };
		String[] tk6_iteration_break_infinity_2 = { "infinite", "infinitely", "forever", "infinity", "break", "end",
				"jump" };
		tk6_iteration_break_infinity.add(tk6_iteration_break_infinity_1);
		tk6_iteration_break_infinity.add(tk6_iteration_break_infinity_2);
		rules.put("tk6_iteration_break_infinity", tk6_iteration_break_infinity);

		List<String[]> tk9_thread_pause = new ArrayList<>();
		String[] tk9_thread_pause_1 = { "thread", "session" };
		String[] tk9_thread_pause_2 = { "pause" };
		tk9_thread_pause.add(tk9_thread_pause_1);
		tk9_thread_pause.add(tk9_thread_pause_2);
		rules.put("tk9_thread_pause", tk9_thread_pause);

		List<String[]> tk11_power_consumption = new ArrayList<>();
		String[] tk11_power_consumption_1 = { "power" };
		String[] tk11_power_consumption_2 = { "consumption", "consume" };
		tk11_power_consumption.add(tk11_power_consumption_1);
		tk11_power_consumption.add(tk11_power_consumption_2);
		rules.put("tk11_power_consumption", tk11_power_consumption);

		List<String[]> tk11_battery_drainage = new ArrayList<>();
		String[] tk11_battery_drainage_1 = { "battery" };
		String[] tk11_battery_drainage_2 = { "drain", "drainage" };
		tk11_battery_drainage.add(tk11_battery_drainage_1);
		tk11_battery_drainage.add(tk11_battery_drainage_2);
		rules.put("tk11_battery_drainage", tk11_battery_drainage);

		List<String[]> tk12_stress_testing = new ArrayList<>();
		String[] tk12_stress_testing_1 = { "stress" };
		String[] tk12_stress_testing_2 = { "testing" };
		tk12_stress_testing.add(tk12_stress_testing_1);
		tk12_stress_testing.add(tk12_stress_testing_2);
		rules.put("tk12_stress_testing", tk12_stress_testing);

		List<String[]> tk15_GC_pressure = new ArrayList<>();
		String[] tk15_GC_pressure_1 = { "gc" };
		String[] tk15_GC_pressure_2 = { "pressure", "thrash", "thrashing" };
		tk15_GC_pressure.add(tk15_GC_pressure_1);
		tk15_GC_pressure.add(tk15_GC_pressure_2);
		rules.put("tk15_GC_pressure", tk15_GC_pressure);

		List<String[]> ss4_memory = new ArrayList<>();
		String[] ss4_memory_1 = { "memory", "in-memory" };
		String[] ss4_memory_2 = { "usage", "overflow", "bloat", "consume", "consumption", "excessive", "high", "low",
				"backpressure", "leak", "leaking", "leakage", "shuffle", "limitation", "fit" };
		ss4_memory.add(ss4_memory_1);
		ss4_memory.add(ss4_memory_2);
		rules.put("ss4_memory", ss4_memory);

		List<String[]> ss5_cpu = new ArrayList<>();
		String[] ss5_cpu_1 = { "cpu" };
		String[] ss5_cpu_2 = { "usage", "limit", "limited", "limitation", "utilization", "utilisation", "higher",
				"lower", "lot" };
		ss5_cpu.add(ss4_memory_1);
		ss5_cpu.add(ss4_memory_2);
		rules.put("ss5_cpu", ss5_cpu);

		// List<String[]> ss10_called_frequently = new ArrayList<>();
		// String[] ss10_called_frequently_1 = { "call", "invoke", "request" };
		// String[] ss10_called_frequently_2 = { "frequent", "frequently", "repeatedly",
		// "extra", "often", "lot",
		// "multiple" };
		// ss10_called_frequently.add(ss10_called_frequently_1);
		// ss10_called_frequently.add(ss10_called_frequently_2);
		// rules.put("ss10_called_frequently", ss10_called_frequently);

		List<String[]> ss13_cache = new ArrayList<>();
		String[] ss13_cache_1 = { "cache" };
		String[] ss13_cache_2 = { "cold", "warm", "buffer", "duplicate", "improve", "optimize", "benefit",
				"configurable", "drop", "maximize", "minimize", "preload", "mess", "in-memory", "heap", "on-heap",
				"off-heap" };
		ss13_cache.add(ss13_cache_1);
		ss13_cache.add(ss13_cache_2);
		rules.put("ss13_cache", ss13_cache);

		List<String[]> ss13_disk_save = new ArrayList<>();
		String[] ss13_disk_save_1 = { "disk" };
		String[] ss13_disk_save_2 = { "save", "saving" };
		ss13_disk_save.add(ss13_disk_save_1);
		ss13_disk_save.add(ss13_disk_save_2);
		rules.put("ss13_disk_save", ss13_disk_save);

		List<String[]> ss14_poor_perform = new ArrayList<>();
		String[] ss14_poor_perform_1 = { "perform" };
		String[] ss14_poor_perform_2 = { "poor", "poorly" };
		ss14_poor_perform.add(ss14_poor_perform_1);
		ss14_poor_perform.add(ss14_poor_perform_2);
		rules.put("ss14_poor_perform", ss14_poor_perform);

		List<String[]> ss24_cost = new ArrayList<>();
		String[] ss24_cost_1 = { "cost", "costly" };
		String[] ss24_cost_2 = { "high", "low", "higher", "lower", "maximum", "minimum", "significant", "nothing" };
		ss24_cost.add(ss24_cost_1);
		ss24_cost.add(ss24_cost_2);
		rules.put("ss24_cost", ss24_cost);

		List<String[]> ss28_wasted_work = new ArrayList<>();
		String[] ss28_waste_1 = { "waste", "wasted", "wasteful" };
		String[] ss28_waste_2 = { "time", "work" };
		ss28_wasted_work.add(ss28_waste_1);
		ss28_wasted_work.add(ss28_waste_2);
		rules.put("ss28_wasted_work", ss28_wasted_work);

		List<String[]> ss29_save_time_space = new ArrayList<>();
		String[] ss29_save_time_space_1 = { "save" };
		String[] ss29_save_time_space_2 = { "time", "space" };
		ss29_save_time_space.add(ss29_save_time_space_1);
		ss29_save_time_space.add(ss29_save_time_space_2);
		rules.put("ss29_save_time_space", ss29_save_time_space);

		List<String[]> ss30_decrease_operations = new ArrayList<>();
		String[] ss30_decrease_operations_1 = { "operation", "call", "callstack" };
		String[] ss30_decrease_operations_2 = { "decrease" };
		ss30_decrease_operations.add(ss30_decrease_operations_1);
		ss30_decrease_operations.add(ss30_decrease_operations_2);
		rules.put("ss30_decrease_operations", ss30_decrease_operations);
	}

	public Set<String> check_rules(Sentence sentence) {
		Set<String> matched_rules = new HashSet<>();
		int length = Math.min(sentence.getWords().size(), sentence.getLemmas().size());
		for (Map.Entry<String, List<String[]>> entry : rules.entrySet()) {
			boolean b1 = false, b2 = false;
			for (String keyword : entry.getValue().get(0)) {
				for (int i = 0; i < length; i++) {
					if (sentence.getWords().get(i).equals(keyword) || sentence.getLemmas().get(i).equals(keyword)) {
						b1 = true;
					}
				}
			}
			for (String keyword : entry.getValue().get(1)) {
				for (int i = 0; i < length; i++) {
					if (sentence.getWords().get(i).equals(keyword) || sentence.getLemmas().get(i).equals(keyword)) {
						b2 = true;
					}
				}
			}

			if (b1 && b2) {
				matched_rules.add(entry.getKey());
			}
		}
		return matched_rules;
	}
}
