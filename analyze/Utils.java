package analyze;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.csvreader.CsvReader;
import com.interviewbubble.sentiment.SentimentAnalysis;

import container.BugzillaComment;
import container.BugzillaSentence;
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

public class Utils {
	public List<BugzillaSentence> doNLPAnalyze(List<BugzillaSentence> sentences) {
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

		for (BugzillaSentence sentence : sentences) {
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
		SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
		List<BugzillaSentence> sentiment_sentences = sentimentAnalysis.process_sentence(sentences);

		long end = System.currentTimeMillis();
		System.out.println("NPL Analysis: analyzing " + sentences.size() + " sentences uses "
				+ (end - start) / (1000 * 60) + " minutes.");
		return sentences;
	}

	public List<BugzillaSentence> loadAnalyzedSentences(String path) {
		List<BugzillaSentence> sentences = new ArrayList<>();
		String splitter = "##perffuzzyrulefengefu##";
		try {
			List<String[]> list = readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				BugzillaSentence sentence = new BugzillaSentence();

				// set issue id
				sentence.setID(list.get(r)[0]);

				// set position

				sentence.setAuthor(list.get(r)[1]);
				sentence.setComment_number(list.get(r)[2]);
				sentence.setSentence_number(list.get(r)[3]);
				sentence.setText(list.get(r)[4]);
				String[] words = list.get(r)[6].split(splitter);
				List<String> word_list = new ArrayList<>();
				for (String word : words) {
					word_list.add(word.trim());
				}
				sentence.setWords(word_list);
				String[] posTags = list.get(r)[7].split(splitter);
				List<String> posTag_list = new ArrayList<>();
				for (String posTag : posTags) {
					posTag_list.add(posTag.trim());
				}
				sentence.setPosTag(posTag_list);
				String[] nerTags = list.get(r)[8].split(splitter);
				List<String> nerTag_list = new ArrayList<>();
				for (String nerTag : nerTags) {
					nerTag_list.add(nerTag.trim());
				}
				sentence.setNerTag(nerTag_list);
				String[] lemmas = list.get(r)[9].split(splitter);
				List<String> lemma_list = new ArrayList<>();
				for (String lemma : lemmas) {
					lemma_list.add(lemma.trim());
				}
				sentence.setLemmas(lemma_list);

				// sentence.setSentimentScore(Double.parseDouble(list.get(r)[7]));
				sentence.setSentimentType(list.get(r)[8]);

				sentences.add(sentence);
			}
			System.out.println("Loaded " + sentences.size() + " sentences.");
			return sentences;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("loadSentenceFromCsv: " + sentences.size() + " sentences are loaded.");
		return sentences;
	}

	public List<BugzillaSentence> loadSentencesFromCsv(String path) {
		List<BugzillaSentence> sentences = new ArrayList<>();
		try {
			List<String[]> list = readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				BugzillaSentence sentence = new BugzillaSentence();
				sentence.setID(list.get(r)[0]);
				sentence.setAuthor(list.get(r)[1]);
				sentence.setComment_number(list.get(r)[2]);
				sentence.setSentence_number(list.get(r)[3]);
				sentence.setText(list.get(r)[4]);
				sentences.add(sentence);
			}
			return sentences;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("loadSentenceFromCsv: " + sentences.size() + " sentences are loaded.");
		return sentences;
	}

	public List<BugzillaComment> loadBugzillaComments(String path) {
		List<BugzillaComment> comments = new ArrayList<>();
		try {
			List<String[]> list = readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				BugzillaComment comment = new BugzillaComment();
				comment.setId(list.get(r)[0]);
				comment.setAuthor(list.get(r)[1]);
				comment.setContent(list.get(r)[2]);
				comments.add(comment);
			}
			return comments;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Loading Bugzilla Comments: " + comments.size() + " comments are loaded.");
		return comments;
	}

	public List<String[]> readCsv(String path) throws Exception {
		List<String[]> csvList = new ArrayList<String[]>();
		if (isCsv(path)) {
			CsvReader reader = new CsvReader(path, ',', Charset.forName("GBK"));
			reader.readHeaders();
			while (reader.readRecord()) {
				csvList.add(reader.getValues());
			}
			// System.out.println("CSV read successfully!");
			reader.close();
		} else {
			System.out.println("Error: It is not a csv file!");
		}
		return csvList;
	}

	private boolean isCsv(String fileName) {
		return fileName.matches("^.+\\.(?i)(csv)$");
	}

}
