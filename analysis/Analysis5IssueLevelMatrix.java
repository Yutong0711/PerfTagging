package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.KafkaRules;
import com.interviewbubble.utils.Utils;

public class Analysis5IssueLevelMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentences_csv_path = "./input/training/training_dataset_sentences.csv";
		String splitter = "##perffuzzyrulefengefu##";
		String output = "./input/training/Matrix/Training-DataSet-Issue-Level-matrix-2.csv";

		Analysis5IssueLevelMatrix analysis5IssueLevelMatrix = new Analysis5IssueLevelMatrix();
		analysis5IssueLevelMatrix.process(sentences_csv_path, splitter, output);
	}

	public void process(String input, String splitter, String output) {
		List<Sentence> nlp_sentences = FilesLoader.loadSentencesFromCsv(input, splitter);
		List<Sentence> checked_sentences = KafkaRules.checkRules(nlp_sentences);
		List<Problem> problems = Utils.loadProblems(checked_sentences);

		try {
			generate_matrix(problems, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int[][] generate_matrix(List<Problem> problems, String output) throws IOException {
		Set<String> rule_set = new HashSet<>();
		for (Problem problem : problems) {
			rule_set.addAll(problem.getRulesSet());
		}
		List<String> rules = new ArrayList<>();
		for (String rule : rule_set) {
			rules.add(rule);
		}

		int[][] matrix = new int[rules.size()][rules.size()];
		for (int i = 0; i < rules.size(); i++) {
			for (int j = 0; j < rules.size(); j++) {
				for (Problem problem : problems) {
					if (problem.getRulesSet().contains(rules.get(i)) && problem.getRulesSet().contains(rules.get(j))) {
						matrix[i][j]++;
					}
				}
			}
		}
		for (int i = 0; i < rules.size(); i++) {
			int sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
			System.out.println(rules.get(i) + "," + matrix[i][i] + "," + (sum - matrix[i][i]));

		}
		return matrix;
	}

	public void print_matrix(List<String> rules, int[][] matrix, String output) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("Rule");
			for (int j = 0; j < rules.size(); j++) {
				writer.write(rules.get(j));
			}
			writer.endRecord();
			for (int i = 0; i < rules.size(); i++) {
				writer.write(rules.get(i));
				for (int j = 0; j < rules.size(); j++) {
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
