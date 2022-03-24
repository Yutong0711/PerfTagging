package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.KafkaRules;
import com.interviewbubble.rules.restruct.CheckingHelper;
import com.interviewbubble.utils.Utils;

public class WritingHelper {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "./input/testing/serf/serf-sentences.csv";
		String output = "./input/testing/serf/serf-issues.csv";
		String splitter = "##perffuzzyrulefengefu##";
		WritingHelper writingHelper = new WritingHelper();

		try {
			writingHelper.print_issue(input, splitter, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print_issue(String sentences_path, String splitter, String output) throws IOException {
		CheckingHelper checkingHelper = new CheckingHelper();
		List<Sentence> nlp_sentences = FilesLoader.loadSentencesFromCsv(sentences_path, splitter);
		List<Sentence> checked_sentences = checkingHelper.check_all_rules(nlp_sentences);
		List<Problem> problems = Utils.loadProblems(checked_sentences);
		System.out.println("Loaded " + problems.size() + " problems.");

		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("Issue Key");
			writer.write("Description");
			writer.write("Num of Sentences");
			writer.write("Keywords");
			writer.write("Fuzzy Rules");
			writer.endRecord();
			for (Problem problem : problems) {
				writer.write(problem.getKey());
				writer.write(problem.getDescription());
				writer.write("" + problem.getNum_of_sentences());
				StringBuilder keywords = new StringBuilder();
				StringBuilder rules = new StringBuilder();
				for (Sentence sentence : problem.getSentences()) {
					if (sentence.getMatchedKeywords().size() > 0) {
						keywords.append(sentence.getNumber() + ": ");
						keywords.append(sentence.getMatchedKeywords().toString());
						keywords.append("  ");
					}
					if (sentence.getFittedPerfRules().size() > 0) {
						rules.append(sentence.getNumber());
						rules.append(sentence.getFittedPerfRules().toString());
						keywords.append("  ");
					}
				}
				writer.write(keywords.toString());
				writer.write(rules.toString());
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	public void print_problem_sentiment(List<Problem> problems, String output) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');

		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.write("Text");
			writer.write("Sentiment Score");
			writer.write("Sentiment Type");
			writer.write("Very Positive");
			writer.write("Positive");
			writer.write("Neutral");
			writer.write("Negative");
			writer.write("Very Negative");
			writer.endRecord();
			for (Problem problem : problems) {
				writer.write(problem.getKey());
				writer.write(problem.getDescription());
				writer.write(problem.getSentimentScore() + "");
				writer.write(problem.getSentimentType());
				writer.write(problem.getVeryPositive() + "%");
				writer.write(problem.getPositive() + "%");
				writer.write(problem.getNeutral() + "%");
				writer.write(problem.getNegative() + "%");
				writer.write(problem.getVeryNegative() + "%");
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	public void print_sentence_sentiment(List<Sentence> sentences, String output) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');

		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.write("No");
			writer.write("Text");
			writer.write("Perf Tag");
			writer.write("Sentiment Score");
			writer.write("Sentiment Type");
			writer.write("Very Positive");
			writer.write("Positive");
			writer.write("Neutral");
			writer.write("Negative");
			writer.write("Very Negative");
			writer.endRecord();
			for (Sentence sentence : sentences) {
				writer.write(sentence.getKey());
				writer.write(sentence.getNumber() + "");
				writer.write(sentence.getText());
				writer.write(sentence.getPerfTag());
				writer.write(sentence.getSentimentScore() + "");
				writer.write(sentence.getSentimentType());
				writer.write(sentence.getVeryPositive() + "%");
				writer.write(sentence.getPositive() + "%");
				writer.write(sentence.getNeutral() + "%");
				writer.write(sentence.getNegative() + "%");
				writer.write(sentence.getVeryNegative() + "%");
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	public static void writeReport(List<Sentence> sentences, String output) throws IOException {
		Map<Integer, Integer> correctness = new HashMap<>();
		Map<Integer, Integer> misclassfication = new HashMap<>();

		for (Sentence sentence : sentences) {
			for (Integer rule_number : sentence.getFittedRules()) {
				correctness.put(rule_number, 0);
				misclassfication.put(rule_number, 0);
			}
		}

		for (Sentence sentence : sentences) {
			for (Integer rule_number : sentence.getFittedRules()) {
				if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
					int temp = correctness.get(rule_number);
					temp = temp + 1;
					correctness.put(rule_number, temp);
				} else {
					int temp = misclassfication.get(rule_number);
					temp = temp + 1;
					misclassfication.put(rule_number, temp);
				}
			}
		}

		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("Rule");
			writer.write("Correctness");
			writer.write("Misclassification");
			writer.endRecord();
			for (Integer rule_number : correctness.keySet()) {
				writer.write(rule_number + "");
				writer.write(correctness.get(rule_number) + "");
				writer.write(misclassfication.get(rule_number) + "");
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	public void writeAnalyzedSentences(String input, String splitter, String output) throws IOException {
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(input);
		List<Sentence> nlp_sentences = NLPAnalyzer.doNLPAnalyze(original_sentences);
		List<Sentence> checked_sentences = KafkaRules.checkRules(nlp_sentences);
		List<Problem> problems = Utils.loadProblems(checked_sentences);
		System.out.println("Loaded " + problems.size() + " problems.");
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.write("No");
			writer.write("Text");
			writer.write("Perf Tag");
			writer.write("Words");
			writer.write("POSTag");
			writer.write("NERTag");
			writer.write("Lemmas");
			writer.endRecord();
			for (Problem problem : problems) {
				for (Sentence sentence : problem.getSentences()) {
					writer.write(sentence.getKey());
					writer.write(sentence.getNumber() + "");
					writer.write(sentence.getText());
					writer.write(sentence.getPerfTag());
					StringBuilder words = new StringBuilder();
					for (String word : sentence.getWords()) {
						words.append(word);
						words.append(splitter);
					}
					writer.write(words.toString());
					StringBuilder posTags = new StringBuilder();
					for (String posTag : sentence.getPosTag()) {
						posTags.append(posTag);
						posTags.append(splitter);
					}
					writer.write(posTags.toString());
					StringBuilder nerTags = new StringBuilder();
					for (String nerTag : sentence.getNerTag()) {
						nerTags.append(nerTag);
						nerTags.append(splitter);
					}
					writer.write(nerTags.toString());
					StringBuilder lemmas = new StringBuilder();
					for (String lemma : sentence.getLemmas()) {
						lemmas.append(lemma);
						lemmas.append(splitter);
					}
					writer.write(lemmas.toString());
					writer.endRecord();
				}
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	public static void writeToCsv(List<Sentence> sentences, String output) throws IOException {
		List<Problem> problems = Utils.loadProblems(sentences);
		System.out.println("Loaded " + problems.size() + " problems.");
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');

		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.write("No");
			writer.write("Text");
			writer.write("Perf Tag");
			writer.write("Fitted Perf Rules");
			writer.write("Matched Keywords");
			writer.write("Words");
			writer.write("POSTag");
			writer.write("NERTag");
			writer.endRecord();
			for (Problem problem : problems) {
				for (Sentence sentence : problem.getSentences()) {
					writer.write(sentence.getKey());
					writer.write(sentence.getNumber() + "");
					writer.write(sentence.getText());
					writer.write(sentence.getPerfTag());
					writer.write(sentence.getFittedPerfRules().toString());
					writer.write(sentence.getMatchedKeywords().toString());
					writer.write(sentence.getWords().toString());
					writer.write(sentence.getPosTag().toString());
					writer.write(sentence.getNerTag().toString());
					writer.endRecord();
				}
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	public static void writeToCsv(List<Sentence> sentences, Map<String, String> tags, String output)
			throws IOException {
		List<Problem> problems = Utils.loadProblems(sentences);
		System.out.println("Loaded " + problems.size() + " problems.");
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');

		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.write("No");
			writer.write("Text");
			writer.write("Issue Tag");
			writer.write("Fitted Perf Rules");
			writer.write("Matched Keywords");
			writer.write("Words");
			writer.write("POSTag");
			writer.write("NERTag");
			writer.endRecord();
			for (Problem problem : problems) {
				for (Sentence sentence : problem.getSentences()) {
					writer.write(sentence.getKey());
					writer.write(sentence.getNumber() + "");
					writer.write(sentence.getText());
					if (tags.containsKey(sentence.getKey())) {
						writer.write(tags.get(sentence.getKey()));
					} else {
						writer.write("Unknown");
					}
					writer.write(sentence.getFittedPerfRules().toString());
					writer.write(sentence.getMatchedKeywords().toString());
					writer.write(sentence.getWords().toString());
					writer.write(sentence.getPosTag().toString());
					writer.write(sentence.getNerTag().toString());
					writer.endRecord();
				}
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
	// public static int[] calculateCorrectness(List<Sentence> sentences, int
	// total_num_of_rules) {
	// int[] res = new int[total_num_of_rules];
	// for (Sentence sentence : sentences) {
	// for (int i = 0; i < res.length; i++) {
	// if (sentence.getFittedRules().contains(i + 1)) {
	// if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
	// int temp = res[i];
	// res[i] = temp + 1;
	// }
	// }
	// }
	// }
	// return res;
	// }
	//
	// public static int[] calculateMisclassification(List<Sentence> sentences, int
	// total_num_of_rules) {
	// int[] res = new int[total_num_of_rules];
	// for (Sentence sentence : sentences) {
	// for (int i = 0; i < res.length; i++) {
	// if (sentence.getFittedRules().contains(i + 1)) {
	// if (!sentence.getPerfTag().equalsIgnoreCase("yes")) {
	// int temp = res[i];
	// res[i] = temp + 1;
	// }
	// }
	// }
	// }
	// return res;
	// }
}
