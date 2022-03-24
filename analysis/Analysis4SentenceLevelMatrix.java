package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Sentence;

public class Analysis4SentenceLevelMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentences_csv_path = "./input/perf-tagged-sentences/impala-non-perf-issues-sentences.csv";
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(sentences_csv_path);
		List<Sentence> nlp_sentences = NLPAnalyzer.doNLPAnalyze(original_sentences);
		List<Sentence> checked_sentences = RuleChecker.doCheck(nlp_sentences);

		String output = "./reports/Apr13/Rules-combination.csv";
		// process(checked_sentences, output);
	}

	public static void process(List<Sentence> sentences, int num_of_rules, String output) {
		int zero = 0, one = 0, two = 0, three = 0, more = 0, total = 0;
		for (Sentence sentence : sentences) {
			total++;
			int size = sentence.getFittedPerfRules().size();
			if (size == 0)
				zero++;
			if (size == 1)
				one++;
			if (size == 2)
				two++;
			if (size == 3)
				three++;
			if (size > 3)
				more++;
		}
		System.out.println("Total: " + total);
		System.out.println("Zero: " + zero);
		System.out.println("One: " + one);
		System.out.println("Two: " + two);
		System.out.println("Three: " + three);
		System.out.println("More: " + more);

		try {
			writeReport(sentences, num_of_rules, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeReport(List<Sentence> sentences, int num_of_rules, String output) throws IOException {
		int[][] matrix = new int[num_of_rules][num_of_rules];
		for (Sentence sentence : sentences) {
			for (int i = 0; i < num_of_rules; i++) {
				for (int j = 0; j < num_of_rules; j++) {
					if (sentence.getFittedRules().contains(i + 1) && sentence.getFittedRules().contains(j + 1)) {
						matrix[i][j]++;
					}
				}
			}
		}
		for (int i = 0; i < num_of_rules; i++) {
			matrix[i][i] = 0;
		}
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			for (int i = 1; i <= num_of_rules; i++) {
				writer.write("Rule " + i);
			}
			writer.endRecord();
			for (int i = 0; i < num_of_rules; i++) {
				for (int j = 0; j < num_of_rules; j++) {
					writer.write(matrix[i][j] + "");
				}
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
}
