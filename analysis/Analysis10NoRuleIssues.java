package com.interviewbubble.analysis;

import java.util.ArrayList;
import java.util.List;

import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.DecisionRules;
import com.interviewbubble.utils.Utils;

public class Analysis10NoRuleIssues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String splitter = "##perffuzzyrulefengefu##";
		String sentences_path = "./input/training/training_dataset_sentences.csv";

	}

	public List<Problem> getNoRulesIssues(String input, String splitter) {
		List<Problem> res = new ArrayList<>();
		List<Sentence> sentences = FilesLoader.loadSentencesFromCsv(input, splitter);
		List<Sentence> checked_sentences = DecisionRules.checkRules(sentences);
		List<Problem> all_problems = Utils.loadProblems(checked_sentences);
		for (Problem problem : all_problems) {

		}

		return res;
	}
}
