package com.interviewbubble.rules.restruct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.interviewbubble.analysis.FilesLoader;
import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.utils.Utils;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence_path = "./input/training/training_dataset_sentences_2.csv";
		String splitter = "##perffuzzyrulefengefu##";

		CheckingHelper checkingHelper = new CheckingHelper();

		List<Sentence> nlp_sentences = FilesLoader.loadSentencesFromCsv(sentence_path, splitter);
		List<Sentence> checked_sentences = checkingHelper.check_all_rules(nlp_sentences);

		Set<String> rules = new HashSet<>();
		for (Sentence sentence : checked_sentences) {
			rules.addAll(sentence.getFittedPerfRules());
		}
		for (String rule : rules) {
			int correctness = 0, misclassification = 0;
			for (Sentence sentence : checked_sentences) {
				if (sentence.getFittedPerfRules().contains(rule)) {
					if (sentence.getPerfTag().equals("yes")) {
						correctness++;
					} else {
						misclassification++;
					}
				}
			}
			System.out.println(rule + ": " + correctness + " correct, " + misclassification + " misclassified.");
		}

		List<Problem> problems = Utils.loadProblems(nlp_sentences);
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

}
