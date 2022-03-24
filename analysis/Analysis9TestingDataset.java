package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.KafkaRules;
import com.interviewbubble.rules.restruct.CheckingHelper;
import com.interviewbubble.utils.Utils;

public class Analysis9TestingDataset {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String issue_path = "./input/testing/serf/serf-issues-tag.csv";
		String sentence_path = "./input/testing/serf/serf-sentences.csv";
		String splitter = "##perffuzzyrulefengefu##";
		String report = "./input/testing/serf/serf-report-3.csv";
		// String output = "./input/testing/serf/serf-sentence-report.csv";

		Analysis9TestingDataset analysis9TestingDataset = new Analysis9TestingDataset();
		try {
			analysis9TestingDataset.generateReport(issue_path, sentence_path, splitter, report);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printSentences(String issue_path, String sentence_path, String output) {
		Analysis9TestingDataset analysis9TestingDataset = new Analysis9TestingDataset();
		Map<String, String> tags = analysis9TestingDataset.loadTags(issue_path);
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(sentence_path);
		List<Sentence> nlp_sentences = NLPAnalyzer.doNLPAnalyze(original_sentences);
		List<Sentence> checked_sentences = KafkaRules.checkRules(nlp_sentences);

		try {
			WritingHelper.writeToCsv(checked_sentences, tags, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map<String, String> loadTags(String issue_path) {
		Map<String, String> res = new HashMap<>();
		try {
			List<String[]> list = Utils.readCsv(issue_path);
			for (int r = 0; r < list.size(); r++) {
				res.put(list.get(r)[0], list.get(r)[2]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	public void generateReport(String issue_path, String sentence_path, String splitter, String report)
			throws IOException {
		CheckingHelper checkingHelper = new CheckingHelper();
		Analysis9TestingDataset analysis9TestingDataset = new Analysis9TestingDataset();
		Map<String, String> tags = analysis9TestingDataset.loadTags(issue_path);
		List<Sentence> nlp_sentences = FilesLoader.loadSentencesFromCsv(sentence_path, splitter);
		List<Sentence> checked_sentences = checkingHelper.check_all_rules(nlp_sentences);
		List<Problem> problems = Utils.loadProblems(checked_sentences);
		Set<String> matched_rules = new HashSet<>();
		for (Problem problem : problems) {
			if (tags.containsKey(problem.getKey())) {
				problem.setTag(tags.get(problem.getKey()));
			}
			// matched_rules.addAll(problem.getRulesSet());
		}
		List<Problem> problems_without_unsure = new ArrayList<>();
		for (Problem problem : problems) {
			if (problem.getTag().equals("yes")) {
				problems_without_unsure.add(problem);
				matched_rules.addAll(problem.getRulesSet());
			} else if (problem.getTag().equals("no")) {
				problems_without_unsure.add(problem);
				matched_rules.addAll(problem.getRulesSet());
			} else if (problem.getTag().equals("unsure")) {
				continue;
			} else {
				problem.setTag("no");
				problems_without_unsure.add(problem);
				matched_rules.addAll(problem.getRulesSet());
			}
		}

		boolean alreadyExists = new File(report).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(report, true), ',');
		if (!alreadyExists) {
			writer.write("Rule");
			writer.write("Correctness");
			writer.write("Misclassification");
			writer.endRecord();
			for (String rule : matched_rules) {
				int right = 0, wrong = 0;
				for (Problem problem : problems_without_unsure) {
					if (problem.getRulesSet().contains(rule)) {
						if (problem.getTag().equalsIgnoreCase("yes")) {
							right++;
						} else if (problem.getTag().equals("no") || problem.getTag().equals("??")) {
							wrong++;
						}
					}
				}
				writer.write(rule);
				writer.write("" + right);
				writer.write("" + wrong);
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
		int kw_right = 0, kw_wrong = 0, fr_right = 0, fr_wrong = 0;
		for (Problem problem : problems) {
			if (problem.getKeywordsList().size() > 0) {
				if (problem.getTag().equals("yes")) {
					kw_right++;
				} else {
					kw_wrong++;
				}
			}
			if (problem.getRulesList().size() > 0) {
				if (problem.getTag().equals("yes")) {
					fr_right++;
				} else {
					fr_wrong++;
				}
			}
		}
		System.out.println("Keywords: " + kw_right + " correctness, " + kw_wrong + " misclassification.");
		System.out.println("Fuzzy Rules: " + fr_right + " correctness, " + fr_wrong + " misclassification.");
	}

	public Map<String, Problem> load(String path) {
		Map<String, Problem> res = new HashMap<>();
		try {
			List<String[]> list = Utils.readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				Problem problem = new Problem();
				problem.setKey(list.get(r)[0]);
				problem.setTag(list.get(r)[2]);

				List<String> keywords = new ArrayList<>();
				if (list.get(r)[6].length() > 2) {
					String[] kwStrings = list.get(r)[6].substring(1, list.get(r)[6].length() - 1).split(",");
					for (String kw : kwStrings) {
						keywords.add(kw.trim());
					}
					problem.setKeywordsList(keywords);
					;
				} else {
					problem.setKeywordsList(keywords);
				}

				List<String> fuzzyrules = new ArrayList<>();
				if (list.get(r)[7].length() > 2) {
					String[] ruleStrings = list.get(r)[7].substring(1, list.get(r)[7].length() - 1).split(",");
					for (String fz : ruleStrings) {
						fuzzyrules.add(fz.trim());
					}
					problem.setRulesList(fuzzyrules);
				} else {
					problem.setRulesList(fuzzyrules);
				}
				res.put(list.get(r)[0], problem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
