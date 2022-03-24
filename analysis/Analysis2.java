package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.utils.Utils;

public class Analysis2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentences_csv_path = "./input/oak/oak-non-perf-issues-sentences.csv";
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(sentences_csv_path);
		List<Sentence> nlp_sentences = NLPAnalyzer.doNLPAnalyze(original_sentences);
		List<Sentence> checked_sentences = RuleChecker.doCheck(nlp_sentences);

		List<Problem> problems = Utils.loadProblems(checked_sentences);

		int keyword_matched = 0, rule_matched = 0;
		for (Problem problem : problems) {
			if (problem.getKeywordsList().size() > 0) {
				keyword_matched++;
			}
			if (problem.getRulesList().size() > 0) {
				rule_matched++;
			}
		}
		// String output =
		// "./reports/Apr13/impala-non-perf-labelled-issues-checked.csv";
		// try {
		// writeToCsv(problems, output);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("This selection totally has " + problems.size() + " problems without performance label: "
				+ keyword_matched + " can match keywords, " + rule_matched + " can match rules.");

		// String output4 =
		// "./reports/Apr13/impala-non-perf-issues-sentences-level-rules-combination.csv";
		// Analysis4SentenceLevelMatrix.process(checked_sentences, 61, output4);
		//
		// String output5 = "./reports/Apr13/impala-issues-level-rules-combination.csv";
		// Analysis5IssueLevelMatrix.process(checked_sentences, 61, output5);

	}

	public static void writeToCsv(List<Problem> problems, String output) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("Issue Key");
			writer.write("Matched Rules");
			writer.write("Matched Keyword");
			writer.endRecord();
			for (Problem problem : problems) {
				writer.write(problem.getKey());
				writer.write(problem.getKeywordsList().toString());
				writer.write(problem.getRulesList().toString());
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

}
