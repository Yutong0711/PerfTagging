package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Issue;
import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.KafkaRules;
import com.interviewbubble.rules.restruct.CheckingHelper;
import com.interviewbubble.utils.Utils;

public class Analysis3IssueLevelChecking {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String description_path = "./input/testing/serf/serf-all-issues-description.csv";
		String splitter = "##perffuzzyrulefengefu##";
		String sentences_path = "./input/training/training_dataset_sentences_2.csv";
		String output = "./input/training/perf_sentences.txt";
		process(sentences_path, splitter);
		// process(description_path, sentences_path, output);
	}

	public static void process(String input, String splitter) {
		CheckingHelper checkingHelper = new CheckingHelper();
		List<Sentence> nlp_sentences = FilesLoader.loadSentencesFromCsv(input, splitter);
		List<Sentence> checked_sentences = KafkaRules.checkRules(nlp_sentences);
		List<Problem> problems = Utils.loadProblems(checked_sentences);
		int kw = 0, fr = 0;
		for (Problem problem : problems) {
			if (problem.getKeywordsList().size() > 0) {
				kw++;
			}
			if (problem.getRulesList().size() > 0) {
				fr++;
			}
		}
		System.out.println("Total Number of Issues: " + problems.size());
		System.out.println("Keyword Matched Issues: " + kw);
		System.out.println("Fuzzy Rule Matched Issues: " + fr);
	}

	public static void process(String description_path, String input, String output) {
		CheckingHelper checkingHelper = new CheckingHelper();
		Map<String, Issue> map = Utils.load_descriptions(description_path);
		String splitter = "##perffuzzyrulefengefu##";
		List<Sentence> nlp_sentences = FilesLoader.loadSentencesFromCsv(input, splitter);
		List<Sentence> checked_sentences = checkingHelper.check_all_rules(nlp_sentences);
		List<Problem> problems = Utils.loadProblems(checked_sentences);
		int kw = 0, fr = 0;
		for (Problem problem : problems) {
			if (problem.getKeywordsList().size() > 0) {
				kw++;
			}
			if (problem.getRulesList().size() > 0) {
				fr++;
			}
		}
		System.out.println("Total Number of Issues: " + problems.size());
		System.out.println("Keyword Matched Issues: " + kw);
		System.out.println("Fuzzy Rule Matched Issues: " + fr);
		try {
			writeToCsv(map, problems, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeToCsv(Map<String, Issue> map, List<Problem> problems, String output) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("Issue Key");
			writer.write("Description");
			writer.write("Num of Sentences");
			writer.write("Num of KW Sentences");
			writer.write("Num of FR Sentences");
			writer.write("Keywords");
			writer.write("Fuzzyrules");
			writer.write("Number of Keywords");
			writer.write("Numbers of Fuzzyrules");
			writer.endRecord();
			for (Problem problem : problems) {
				int total = 0, mk = 0, mr = 0;
				for (Sentence sentence : problem.getSentences()) {
					total++;
					if (sentence.getMatchedKeywords().size() > 0)
						mk++;
					if (sentence.getFittedPerfRules().size() > 0)
						mr++;
				}
				writer.write(problem.getKey());
				writer.write(problem.getDescription());
				writer.write(total + "");
				writer.write("" + mk);
				writer.write("" + mr);
				writer.write(problem.getKeywordsList().toString());
				writer.write(problem.getRulesList().toString());
				writer.write(problem.getKeywordsList().size() + "");
				writer.write(problem.getRulesList().size() + "");

				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
}
