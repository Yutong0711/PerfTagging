package analyze;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.csvreader.CsvWriter;

import container.BugzillaSentence;

public class HLPMatcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "./jon/analyzed-sentences.csv";
		String splitter = "##perffuzzyrulefengefu##";
		String output_1 = "./jon/sentences-HLP-set.csv";
		String output_2 = "./jon/sentences-HLP-vector.csv";

		HLPMatcher matcher = new HLPMatcher();
		matcher.check(input, output_1, output_2);
	}

	public void check(String input, String output1, String output2) {
		Utils utils = new Utils();
		List<BugzillaSentence> sentences = utils.loadAnalyzedSentences(input);
		HLPChecker checker = new HLPChecker();
		List<BugzillaSentence> checked_sentences = checker.check_all_rules(sentences);

		try {
			print_sentences_with_rules(checked_sentences, output1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			print_vectorized_sentences(checked_sentences, output2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print_sentences_with_rules(List<BugzillaSentence> sentences, String output) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("ID");
			writer.write("Author");
			writer.write("Comment Number");
			writer.write("Sentence Number");
			writer.write("Text");
			writer.write("Tag");
			writer.write("Matched HLPs");
			// writer.write("Auto-Category");
			writer.endRecord();
			for (BugzillaSentence sentence : sentences) {
				writer.write(sentence.getID());
				writer.write(sentence.getAuthor());
				writer.write(sentence.getComment_number());
				writer.write(sentence.getSentence_number());
				writer.write(sentence.getText());
				if (sentence.getPerfTag() == null || sentence.getPerfTag().equals("")) {
					writer.write("TBA");
				} else {
					writer.write(sentence.getPerfTag());
				}
				writer.write(sentence.getFittedPerfRules().toString());
				// writer.write(sentence.getCategory().toString());
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}

	}

	public void print_vectorized_sentences(List<BugzillaSentence> sentences, String output) throws IOException {
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
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("ID");
			writer.write("Author");
			writer.write("Comment Number");
			writer.write("Sentence Number");
			writer.write("Text");
			for (String rule : rules) {
				writer.write(rule);
			}
			writer.endRecord();
			for (BugzillaSentence sentence : sentences) {
				writer.write(sentence.getID());
				writer.write(sentence.getAuthor());
				writer.write(sentence.getComment_number());
				writer.write(sentence.getSentence_number());
				writer.write(sentence.getText());
				for (String rule : rules) {
					if (sentence.getFittedPerfRules().contains(rule)) {
						writer.write("1");
					} else {
						writer.write("0");
					}
				}
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
}
