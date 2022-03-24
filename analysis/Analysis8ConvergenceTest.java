package com.interviewbubble.analysis;

import java.util.List;

import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.KafkaRules;
import com.interviewbubble.rules.LuceneRules;

public class Analysis8ConvergenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "./input/kafka/kafka-perf-label-issues-sentences.csv";
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(path);
		int total = 0, yes = 0;
		for (Sentence sentence : original_sentences) {
			total++;
			if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
				yes++;
			}
		}
		System.out.println("Total sentences: " + total);
		System.out.println("Tagged as Yes: " + yes);
		List<Sentence> nlp_sentences = NLPAnalyzer.doNLPAnalyze(original_sentences);

		// Check Before Rule Set
		System.out.println("---------------Checking Before Rule Set------------------");
		List<Sentence> before_rule_set = LuceneRules.checkRules(nlp_sentences);
		Analysis1.count_keywords_precision_recall(before_rule_set);
		Analysis1.count_rules_precision_recall(before_rule_set);

		// Check Accumulated Rule Set
		System.out.println("---------------Checking Accumalted Rule Set------------------");
		List<Sentence> accumulated_rule_set = KafkaRules.checkRules(nlp_sentences);
		Analysis1.count_keywords_precision_recall(accumulated_rule_set);
		Analysis1.count_rules_precision_recall(accumulated_rule_set);

	}

}
