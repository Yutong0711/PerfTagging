package com.interviewbubble.sentiment;

import java.util.List;

import com.interviewbubble.analysis.WritingHelper;
import com.interviewbubble.entity.Problem;

import analyze.Utils;
import container.BugzillaSentence;

public class SentimentAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "./input/training/non-perf-issues/sentences/training-dataset-random-issues-sentences.csv";
		String splitter = "##perffuzzyrulefengefu##";
		String output = "./input/training/non_perf_issue_sentiment_analysis.csv";
		Utils utils = new Utils();
		List<BugzillaSentence> sentences = utils.loadSentencesFromCsv(input);

		// List<Problem> problems = new ArrayList<>();
		// Set<String> keys = new HashSet<>();
		// for (Sentence sentence : sentences) {
		// keys.add(sentence.getKey());
		// }
		//
		// for (String key : keys) {
		// Problem problem = new Problem(key);
		// StringBuilder description = new StringBuilder();
		// List<Sentence> temp = new ArrayList<>();
		// for (Sentence sentence : sentences) {
		// if (sentence.getKey().equals(key)) {
		// temp.add(sentence);
		// }
		// }
		// Collections.sort(temp);
		// for (Sentence sentence : temp) {
		// description.append(sentence.getText());
		// }
		// problem.setDescription(description.toString());
		// problems.add(problem);
		// }
		// Collections.sort(problems);

		SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
		List<BugzillaSentence> sentiment_sentences = sentimentAnalysis.process_sentence(sentences);
		WritingHelper writingHelper = new WritingHelper();

	}

	public List<Problem> process_problem(List<Problem> problems) {
		SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
		sentimentAnalyzer.initialize();
		SentimentResult sentimentResult;

		for (int i = 0; i < problems.size(); i++) {
			Problem problem = problems.get(i);
			if (i % 100 == 0) {
				System.out.println(i);
			}
			sentimentResult = sentimentAnalyzer.getSentimentResult(problem.getDescription());
			problem.setSentimentScore(sentimentResult.getSentimentScore());
			problem.setSentimentType(sentimentResult.getSentimentType());
			problem.setVeryPositive(sentimentResult.getSentimentClass().getVeryPositive());
			problem.setPositive(sentimentResult.getSentimentClass().getPositive());
			problem.setNeutral(sentimentResult.getSentimentClass().getNeutral());
			problem.setNegative(sentimentResult.getSentimentClass().getNegative());
			problem.setVeryNegative(sentimentResult.getSentimentClass().getVeryNegative());
		}

		return problems;
	}

	public List<BugzillaSentence> process_sentence(List<BugzillaSentence> sentences) {
		SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
		sentimentAnalyzer.initialize();
		SentimentResult sentimentResult;

		for (int i = 0; i < sentences.size(); i++) {
			BugzillaSentence sentence = sentences.get(i);
			// if (i % 100 == 0) {
			// System.out.println(i);
			// }
			sentimentResult = sentimentAnalyzer.getSentimentResult(sentence.getText());
			sentence.setSentimentScore(sentimentResult.getSentimentScore());
			sentence.setSentimentType(sentimentResult.getSentimentType());
			sentence.setVeryPositive(sentimentResult.getSentimentClass().getVeryPositive());
			sentence.setPositive(sentimentResult.getSentimentClass().getPositive());
			sentence.setNeutral(sentimentResult.getSentimentClass().getNeutral());
			sentence.setNegative(sentimentResult.getSentimentClass().getNegative());
			sentence.setVeryNegative(sentimentResult.getSentimentClass().getVeryNegative());
		}

		return sentences;
	}

	public void process(String text) {
		SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
		sentimentAnalyzer.initialize();
		SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);

		System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
		System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
		System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive() + "%");
		System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive() + "%");
		System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral() + "%");
		System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative() + "%");
		System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative() + "%");
	}
}
