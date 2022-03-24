package analyze;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.csvreader.CsvWriter;

import container.BugzillaSentence;

public class NLPAnalyzer {

	public static void main(String[] args) {
		// It is the broken sentences, i.e., the output of SentenceBreaker.java
		String input = "./jon/comments_in_sentences.csv";

		String output = "./jon/analyzed-sentences.csv";
		NLPAnalyzer analyzer = new NLPAnalyzer();
		analyzer.execute_nlp_analyzing(input, output);
	}

	public void execute_nlp_analyzing(String input, String output) {
		String splitter = "##perffuzzyrulefengefu##";

		Utils utils = new Utils();
		List<BugzillaSentence> original_sentences = utils.loadSentencesFromCsv(input);
		List<BugzillaSentence> analyzed_sentences = utils.doNLPAnalyze(original_sentences);

		try {
			print_nlp_analyzed_sentences(analyzed_sentences, splitter, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print_nlp_analyzed_sentences(List<BugzillaSentence> sentences, String splitter, String output)
			throws IOException {
		// List<Problem> problems = Utils.loadProblems(sentences);
		// System.out.println("Loaded " + problems.size() + " problems.");
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("ID");
			writer.write("Author");
			writer.write("Comment Number");
			writer.write("Sentence Number");
			writer.write("Text");
			writer.write("Perf Tag");
			writer.write("Words");
			writer.write("POSTag");
			writer.write("NERTag");
			writer.write("Lemmas");
			writer.write("Sentiment Score");
			writer.write("Sentiment Type");
			writer.write("Very Positive");
			writer.write("Positive");
			writer.write("Neutral");
			writer.write("Negative");
			writer.write("Very Negative");
			writer.endRecord();
			for (BugzillaSentence sentence : sentences) {
				writer.write(sentence.getID());
				writer.write(sentence.getAuthor());
				writer.write(sentence.getComment_number());
				writer.write(sentence.getSentence_number());
				writer.write(sentence.getText());
				writer.write("??");
				StringBuilder words = new StringBuilder();
				for (String word : sentence.getWords()) {
					words.append(word);
					words.append(splitter);
				}
				writer.write(words.toString());
				StringBuilder posTags = new StringBuilder();
				for (String posTag : sentence.getPosTag()) {
					posTags.append(posTag);
					posTags.append(splitter);
				}
				writer.write(posTags.toString());
				StringBuilder nerTags = new StringBuilder();
				for (String nerTag : sentence.getNerTag()) {
					nerTags.append(nerTag);
					nerTags.append(splitter);
				}
				writer.write(nerTags.toString());
				// System.out.println(nerTags.toString());
				StringBuilder lemmas = new StringBuilder();
				for (String lemma : sentence.getLemmas()) {
					lemmas.append(lemma);
					lemmas.append(splitter);
				}
				writer.write(lemmas.toString());

				writer.write(sentence.getSentimentScore() + "");
				writer.write(sentence.getSentimentType());
				writer.write(sentence.getVeryPositive() + "%");
				writer.write(sentence.getPositive() + "%");
				writer.write(sentence.getNeutral() + "%");
				writer.write(sentence.getNegative() + "%");
				writer.write(sentence.getVeryNegative() + "%");
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
}
