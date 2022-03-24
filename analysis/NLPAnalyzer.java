package com.interviewbubble.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.interviewbubble.entity.Sentence;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class NLPAnalyzer {
	public static List<Sentence> doNLPAnalyze(List<Sentence> sentences) {
		long start = System.currentTimeMillis();
		String log4jConfPath = "./log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		// creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER,
		// parsing, and coreference resolution
		Properties properties = new Properties();
		properties.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");

		StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);

		if (sentences == null || sentences.size() == 0)
			return sentences;

		for (Sentence sentence : sentences) {
			// read some text in the text variable
			String text = sentence.getText();
			// create an empty Annotation just with the given text
			Annotation document = new Annotation(text);
			// run all Annotators on this text
			pipeline.annotate(document);

			List<CoreMap> coreMaps = document.get(SentencesAnnotation.class);
			List<String> words = new ArrayList<>();
			List<String> posTags = new ArrayList<>();
			List<String> nerTags = new ArrayList<>();
			List<String> lemmas = new ArrayList<>();
			Tree tree = null;
			SemanticGraph dependencies = null;

			for (CoreMap coreMap : coreMaps) {
				// traversing the words in the current sentences
				for (CoreLabel token : coreMap.get(TokensAnnotation.class)) {
					// this is the text of the token
					String word = token.get(TextAnnotation.class);
					words.add(word.toLowerCase());
					// this is the POS tag of the token
					String posTag = token.get(PartOfSpeechAnnotation.class);
					posTags.add(posTag);
					// this is the NER label of the token
					String nerTag = token.get(NamedEntityTagAnnotation.class);
					nerTags.add(nerTag);
					// this is the lemma of the token
					String lemma = token.get(LemmaAnnotation.class);
					lemmas.add(lemma);
				}
				tree = coreMap.get(TreeAnnotation.class);
				dependencies = coreMap.get(CollapsedDependenciesAnnotation.class);
			}
			sentence.setWords(words);
			sentence.setPosTag(posTags);
			sentence.setNerTag(nerTags);
			sentence.setLemmas(lemmas);
			sentence.setSyntacticParseTree(tree);
			sentence.setDependencies(dependencies);
		}
		long end = System.currentTimeMillis();
		System.out.println("NPL Analysis: analyzing " + sentences.size() + " sentences uses "
				+ (end - start) / (1000 * 60) + " minutes.");
		return sentences;
	}
}
