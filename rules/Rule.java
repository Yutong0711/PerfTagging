package com.interviewbubble.rules;

import java.util.ArrayList;
import java.util.List;

import container.BugzillaSentence;

public class Rule {
	String name;

	public Rule(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String do_check(BugzillaSentence sentence) {
		if (name.equals("gk1_efficiency")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.contains("efficien")) {
					return name;
				}
			}
		}

		if (name.equals("gk2_complexity")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("complex") || word.equals("complexity") || word.equals("complicated")
						|| word.equals("uncomplex")) {
					return name;
				}
			}
		}

		if (name.equals("gk3_reduce")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("reduce") || word.equals("reducing") || word.equals("reduces")
						|| word.equals("reduction") || word.equalsIgnoreCase("reduced"))
					return name;
			}
		}

		if (name.equals("gk4_performance")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("performance"))
					return name;
			}
		}

		if (name.equals("gk5_latency")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("latency") || word.equals("latencies"))
					return name;
			}
		}

		if (name.equals("gk6_expensive")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("expensive") || word.equals("expensively"))
					return name;
			}
		}

		if (name.equals("gk7_speed")) {
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
				if (words.get(i).contains("speedup") || words.get(i).equals("faster")
						|| words.get(i).contains("accelerat") || words.get(i).equals("quick")
						|| words.get(i).equals("quickly") || words.get(i).contains("slow")) {
					return name;
				}
			}
			if (text.contains("great speed") || text.contains("fast speed") || text.contains("low performing")
					|| text.contains("low-velocity") || text.contains("paused is longer than usual")
					|| text.contains("for a long moment"))
				return name;
			if (b1 && b2) {
				return name;
			}

			if (speed > -1 && speed < words.size() - 1) {
				if (words.get(speed + 1).equals("up")) {
					return name;
				}
			}

			if (sped > -1 && sped < words.size() - 1) {
				if (words.get(sped + 1).equals("by")) {
					return name;
				}
			}
		}

		if (name.equals("gk8_spilling")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("spilling"))
					return name;
			}
		}

		if (name.equals("gk9_throughput")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("throughput"))
					return name;
			}
		}

		if (name.equals("sk1_negative_necessary")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("unnecessary") || word.equals("unneeded") || word.equals("redundant")
						|| word.equals("redundancy") || word.equals("wasteful"))
					return name;
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
				return name;
			if (b3 && b4)
				return name;
		}

		if (name.equals("sk2_block_hang_crash")) {
			boolean b1 = false, b2 = false;
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("block") || word.equals("blocks") || word.equals("blocked") || word.equals("blocking")
						|| word.contains("bottleneck")) {
					return name;
				}
				if (word.equals("hang") || word.equals("hangs") || word.equals("hanging")) {
					return name;
				}
				if (word.equals("process") || word.equals("processes"))
					b1 = true;
				if (word.contains("crash"))
					b2 = true;
			}
			if (sentence.getText().toLowerCase().contains("long running"))
				return name;
			if (b1 && b2)
				return name;
		}

		if (name.equals("sk3_byte")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("byte") || word.equals("bytes") || word.contains("-byte"))
					return name;
			}
		}

		if (name.equals("sk4_prefetch")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.contains("prefetch") || word.contains("pre-fetch")) {
					return name;
				}
			}
		}

		if (name.equals("sk5_hotspot")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("hot spot") || text.contains("hotspot"))
				return name;
		}

		if (name.equals("sk6_enough_space")) {
			boolean b1 = false, b2 = false;
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("space") || word.equals("spaces"))
					b1 = true;
				if (word.equals("enough"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("sk7_buffer")) {
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
				return name;
		}

		if (name.equals("sk8_timeout_expiration")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.contains("timeout"))
					return name;
				if (word.equals("expire") || word.equalsIgnoreCase("expires") || word.equals("expiration"))
					return name;
			}
		}

		if (name.equals("sk9_frequency")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.contains("frequen"))
					return name;
			}
		}

		if (name.equals("sk10_skip")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("skip") || word.equals("skips") || word.equals("skipped") || word.equals("skipping")
						|| word.equals("skiped"))
					return name;
			}
		}

		if (name.equals("sk11_infinity")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("infinite") || word.equals("infinity") || word.equals("forever"))
					return name;
			}
		}

		if (name.equals("sk12_over_again")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("over again") || text.contains("again and again"))
				return name;
		}

		if (name.equals("sk13_regression")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.contains("regress"))
					return name;
			}
		}

		if (name.equals("sk14_overhead")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("overhead") || word.equals("overheads")) {
					return name;
				}
			}
		}

		if (name.equals("sk15_network")) {
			List<String> words = sentence.getWords();
			boolean b1 = false, b2 = false;
			for (String word : words) {
				if (word.equals("network") || word.equals("networks"))
					b1 = true;
				if (word.equals("traffic") || word.equals("traffics") || word.equals("hop") || word.equals("hops"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("sk16_garbage")) {
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
				return name;
		}

		if (name.equals("sk17_dynamic_allocation")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("dynamic allocation") || text.contains("dynamic allocated")
					|| text.contains("allocated dynamically")) {
				return name;
			}
		}

		if (name.equals("sk18_throttle")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("throttling") || word.equals("throttle") || word.equals("throttles"))
					return name;
			}
		}

		if (name.equals("sk19_processing_time")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("processing time")) {
				return name;
			}
		}

		if (name.equals("tk1_contended_lock")) {
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
				return name;
		}

		if (name.equals("tk2_bound")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("bound") || word.equals("inbound"))
					return name;
			}
		}

		if (name.equals("tk3_memory_unit")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("kb") || word.equals("mb") || word.equals("gb") || word.equals("tb"))
					return name;
			}
		}

		if (name.equals("tk4_cpi")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("cpi"))
					return name;
			}
		}

		if (name.equals("tk5_execution_skew")) {
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
				return name;
		}

		if (name.equals("tk6_iteration")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("loop") || word.equals("loops") || word.contains("iterat") || word.equals("recursion")
						|| word.equals("recursive") || word.equals("recursions"))
					return name;
			}
		}

		if (name.equals("tk7_concurrent")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.contains("concurren"))
					return name;
			}
		}

		if (name.equals("tk9_thread")) {
			List<String> words = sentence.getWords();
			boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;
			String text = sentence.getText().toLowerCase();
			if (text.contains("thread pool") || text.contains("thread-per-peer"))
				b5 = true;
			for (String word : words) {
				if (word.equals("thread") || word.equals("threads") || word.equalsIgnoreCase("gc"))
					b1 = true;
				if (word.equals("pause") || word.equals("pauses") || word.equals("paused")
						|| word.equals("deltification"))
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
				return name;
			if (b1 && b3 && b4)
				return name;
			if (b5 && b6)
				return name;
		}

		if (name.equals("tk10_binary_search")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("binary search"))
				return name;
		}

		if (name.equals("tk11_power_consumption")) {
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
				return name;
			if (b3 && b4)
				return name;
		}

		if (name.equals("tk12_stress_testing")) {
			List<String> words = sentence.getWords();
			boolean b1 = false, b2 = false;
			for (String word : words) {
				if (word.equals("stress"))
					b1 = true;
				if (word.equals("testing"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("tk13_huge_data_chunk")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("huge page") || text.contains("huge backlog") || text.contains("huge file"))
				return name;
		}

		if (name.equals("tk14_data_rate")) {
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
				return name;
			if (b1 && b2)
				return name;
		}

		if (name.equals("tk15_GC_pressure")) {
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
				return name;
			if (b1 && b3 && b4)
				return name;
		}

		if (name.equals("tk16_big_O")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("o(n*log(n))") || text.contains("o(n)") || text.contains("o(n^2)")
					|| text.contains("o(1)")) {
				return name;
			}
		}

		if (name.equals("tk17_disk_spills")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("disk spill")) {
				return name;
			}
		}

		if (name.equals("tk18_brute_force")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("brute force") || text.contains("brute-force")) {
				return name;
			}
		}

		if (name.equals("pf1_percentage")) {
			List<String> nerTags = sentence.getNerTag();
			for (String nerTag : nerTags) {
				if (nerTag.equals("PERCENT"))
					return name;
			}
		}

		if (name.equals("pf2_duration")) {
			List<String> nerTags = sentence.getNerTag();
			for (String nerTag : nerTags) {
				if (nerTag.equals("DURATION"))
					return name;
			}
		}

		if (name.equals("pf3_profiling")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("<profiling>") || word.equals("profile") || word.equals("profiles")
						|| word.equals("profiling") || word.equals("ms") || word.equals("ops/sec")
						|| word.equals("megabytes/sec") || word.equals("mb/sec") || word.equals("mb/s"))
					return name;
			}
		}

		if (name.equals("pf4_benchmark")) {
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.contains("benchmark"))
					return name;
			}
		}

		if (name.equals("ss1_one_per")) {
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
					return name;
				}
			}
		}

		if (name.equals("ss2_all_to_one")) {
			boolean b1 = false, b2 = false, b3 = false, b4 = false;
			List<String> words = sentence.getWords();
			String text = sentence.getText().toLowerCase();
			if (text.contains("add them all into your compaction"))
				return name;
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
				return name;
			}
			if (b3 && b4)
				return name;
		}

		if (name.equals("ss3_in_one_go")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("in one time") || text.contains("in one go") || text.contains("at the same time")
					|| text.contains("only once") || text.contains("just one time") || text.contains("in a single")
					|| text.contains("in one operation") || text.contains("at once"))
				return name;
			if (text.contains("no more than") && text.contains("at a time"))
				return name;
		}

		if (name.equals("ss4_memory")) {
			List<String> words = sentence.getWords();
			String text = sentence.getText().toLowerCase();
			if (text.contains("out of memory") || text.contains("out-of-memory"))
				return name;
			boolean b1 = false, b2 = false;
			for (String word : words) {
				if (word.equals("oom") || word.equals("outofmemory") || word.equals("oome"))
					return name;
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
						|| word.equals("shuffle") || word.equals("leak") || word.equals("leaks")
						|| word.equals("leakage")) {
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
				return name;
			if (b3 && b4)
				return name;
		}

		if (name.equals("ss5_cpu")) {
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
				return name;
			}
			if (text.contains("lot of") || text.contains("lots of") || text.contains("low level"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("ss6_per_per")) {
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
						return name;
					}
				}
			}
		}

		if (name.equals("ss7_nn_by_nn")) {
			int by = -1;
			List<String> words = sentence.getWords();
			for (int i = 0; i < words.size(); i++) {
				if (words.get(i).equals("by"))
					by = i;
			}
			if (by > 0 && by < words.size() - 1) {
				if (words.get(by - 1).equals(words.get(by + 1)))
					return name;
			}
			String text = sentence.getText().toLowerCase();
			if (text.contains("field-by-field") || text.contains("byte-by-byte"))
				return name;
		}

		if (name.equals("ss8_load_nn")) {
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
					return name;
				}
			}
		}

		if (name.equals("ss9_respond_until")) {
			int index = -1;
			boolean b1 = false, b2 = false;
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
					return name;
			}
			if (b1 && b2) {
				return name;
			}
		}

		if (name.equals("ss10_called_frequently")) {
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
				return name;

			if (text.contains("at least")) {
				b3 = true;
			}
			if (text.contains("too many")) {
				b6 = true;
			}
			if (b1 && b3 && b4)
				return name;
			if (b5 && b6) {
				return name;
			}
		}

		if (name.equals("ss11_rework")) {
			String text = sentence.getText().toLowerCase();
			if (text.contains("calculated again"))
				return name;
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("redo") || word.contains("recalculat") || word.contains("rework")
						|| word.startsWith("re-") || word.contains("resurrect") || word.contains("reindex")
						|| word.contains("rewrit") || word.contains("reload") || word.equals("resize")
						|| word.equals("resizing"))
					return name;
			}
		}

		if (name.equals("ss12_spend_time")) {
			boolean b1 = false, b2 = false, b3 = false;
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("take") || word.equals("took") || word.equals("takes") || word.equals("taken")
						|| word.equals("spend") || word.equals("spends") || word.equals("spent")
						|| word.equals("wasted") || word.equals("waste") || word.equals("wastes")
						|| word.equals("wasting") || word.equals("loose") || word.equals("looses")
						|| word.equals("loosed") || word.equals("go") || word.equals("goes")) {
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
				return name;
		}

		if (name.equals("ss13_cache")) {
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
						|| word.equals("adds") || word.equals("added") || word.equals("tracker")
						|| word.contains("discard") || word.equals("additional") || word.equals("heavy")
						|| word.contains("optimiz") || word.contains("benefit") || word.equals("extra")
						|| word.equals("speed") || word.contains("parallel") || word.equals("configurable")
						|| word.equals("drop") || word.equals("dropping") || word.equals("drops")
						|| word.equals("maximize") || word.contains("maximise") || word.equals("maximizes")
						|| word.equals("maximises") || word.equals("minimise") || word.equals("minimize")
						|| word.equals("minimises") || word.equals("minimizes") || word.equals("capacity")
						|| word.equals("mess") || word.equals("preload") || word.equals("in-memory")) {
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
				return name;
			}
			if (b1 && b3 && b4) {
				return name;
			}
		}

		if (name.equals("ss14_perform")) {
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
				return name;
		}

		if (name.equals("ss15_each_one")) {
			boolean b1 = false, b2 = false;
			List<String> words = sentence.getWords();
			for (String word : words) {
				if (word.equals("each"))
					b1 = true;
				if (word.equals("one") || word.equals("own") || word.equals("individual"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("ss16_close_immediately")) {
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
				return name;
		}

		if (name.equals("ss17_cardinality_cost")) {
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
				return name;
		}

		if (name.equals("ss18_fast_to")) {
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
					return name;
				}
				if (words.get(index - 1).equals("ignorably")) {
					return name;
				}
			}

			String text = sentence.getText().toLowerCase();
			if (text.contains("fail fast") || text.contains("fails fast") || text.contains("fast way")
					|| text.contains("fast pace") || text.contains("as fast as") || text.contains("extreme fast"))
				return name;
		}

		if (name.equals("ss19_lot_reading")) {
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
				return name;
		}

		if (name.equals("ss20_roundtrip")) {
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
				return name;
		}

		if (name.equals("ss21_traversal")) {
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
				return name;
		}

		if (name.equals("ss22_cd_files")) {
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
				return name;
		}

		if (name.equals("ss23_avoid_if")) {
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
				return name;
		}

		if (name.equals("ss24_cost")) {
			boolean b1 = false, b2 = false;
			List<String> words = sentence.getWords();
			String text = sentence.getText().toLowerCase();
			for (String word : words) {
				if (word.equals("cost") || word.equals("costs") || word.equals("costly")) {
					b1 = true;
				}
				if (word.equals("high") || word.equals("low") || word.equals("higher") || word.equals("lower")
						|| word.equals("minimum") || word.equals("maximum") || word.equals("nothing")
						|| word.equals("higher") || word.equals("lower") || word.equals("high") || word.equals("low")
						|| word.contains("increas") || word.equals("significant")) {
					b2 = true;
				}
			}
			if (text.contains("read lock")) {
				b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("ss25_sessions")) {
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
				return name;
		}

		if (name.equals("ss26_negative_do_everything")) {
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
				return name;
			}
			if (b2 && b3 && b4)
				return name;
		}

		if (name.equals("ss27_algorithm")) {
			List<String> words = sentence.getWords();
			boolean b1 = false, b2 = false;
			for (String word : words) {
				if (word.equals("one-pass")) {
					b1 = true;
				}
				if (word.equals("algorithm") || word.equals("algorithms")) {
					b2 = true;
				}
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("ss28_waste")) {
			List<String> words = sentence.getWords();
			boolean b1 = false, b2 = false;
			for (String word : words) {
				if (word.equals("waste") || word.equals("wasted") || word.equals("wastes")) {
					b1 = true;
				}
				if (word.equals("time") || word.equals("work")) {
					b2 = true;
				}
			}
			if (b1 && b2)
				return name;
			String text = sentence.getText().toLowerCase();
			if (text.contains("extra work") && text.contains("lot of")) {
				return name;
			}
		}

		if (name.equals("ss29_save_time_space")) {
			List<String> words = sentence.getWords();
			boolean b1 = false, b2 = false;
			for (String word : words) {
				if (word.equals("save") || word.equals("saves") || word.equals("saved") || word.equals("saving")) {
					b1 = true;
				}
				if (word.equals("time") || word.equals("space")) {
					b2 = true;
				}
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("ss30_decrease_operations")) {
			List<String> words = sentence.getWords();
			boolean b1 = false, b2 = false;
			for (String word : words) {
				if (word.equals("calls") || word.equals("operations")) {
					b1 = true;
				}
				if (word.equals("decrease") || word.equals("descreases") || word.equals("decreased")
						|| word.equals("decreasing")) {
					b2 = true;
				}
			}
			if (b1 && b2)
				return name;
		}
		return null;
	}
}
