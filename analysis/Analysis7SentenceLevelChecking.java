package com.interviewbubble.analysis;

import java.io.IOException;
import java.util.List;

import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.KafkaRules;
import com.interviewbubble.utils.Utils;

public class Analysis7SentenceLevelChecking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "./input/training/non-perf-issues/sentences/training-dataset-random-issues-sentences.csv";
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(path);
		List<Sentence> nlp_sentences = NLPAnalyzer.doNLPAnalyze(original_sentences);
		List<Sentence> checked_sentences = KafkaRules.checkRules(nlp_sentences);
		String output = "./input/training/non-perf-issues/sentences/training-dataset-random-issues-sentences_checked.csv";

		int keyword_sentences = 0, fuzzy_rule_sentences = 0;
		for (Sentence sentence : checked_sentences) {
			if (sentence.getMatchedKeywords().size() > 0) {
				keyword_sentences++;
			}
			if (sentence.getFittedPerfRules().size() > 0) {
				fuzzy_rule_sentences++;
			}
		}
		System.out.println("In " + checked_sentences.size() + "sentences: " + keyword_sentences
				+ " sentences can match keywords, " + fuzzy_rule_sentences + " can match fuzzy rules");

		List<Problem> problems = Utils.loadProblems(checked_sentences);
		int keyword_issues = 0, fuzzy_rule_issues = 0;
		for (Problem problem : problems) {
			if (problem.getKeywordsList().size() > 0) {
				keyword_issues++;
			}
			if (problem.getRulesList().size() > 0) {
				fuzzy_rule_issues++;
			}
		}
		System.out.println("In " + problems.size() + "problems: " + keyword_issues + " issues can match keyword, "
				+ fuzzy_rule_issues + " can match fuzzy rules.");
		try {
			WritingHelper.writeToCsv(checked_sentences, output);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
