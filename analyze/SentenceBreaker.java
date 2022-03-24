package analyze;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.csvreader.CsvWriter;

import container.BugzillaComment;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class SentenceBreaker {

	public static void main(String[] args) {
		// The input is the downloaded comments from Bugzilla from your scrawler
		String input = "./jon/issue_comments_testing.csv";

		// The outpur here is the breaked sentences for each comment
		String output = "./jon/comments_in_sentences.csv";
		SentenceBreaker breaker = new SentenceBreaker();
		try {
			breaker.break_to_sentences(input, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void break_to_sentences(String input, String output) throws IOException {
		Utils utils = new Utils();
		List<BugzillaComment> comments = utils.loadBugzillaComments(input);
		System.out.println("Loading Bugzilla Comments: " + comments.size() + " comments are loaded.");
		String log4jConfPath = "./log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		Properties properties = new Properties();
		properties.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);

		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');

		if (!alreadyExists) {
			writer.write("ID");
			writer.write("Author");
			writer.write("Comment No.");
			writer.write("Sentence No.");
			writer.write("Sentence Text");
			writer.endRecord();
			int comment_num = 0;

			for (BugzillaComment comment : comments) {
				comment_num++;
				int sentence_num = 0;
				Annotation document = new Annotation(comment.getContent());
				pipeline.annotate(document);
				List<CoreMap> sentences = document.get(SentencesAnnotation.class);
				for (CoreMap sentence : sentences) {
					sentence_num++;
					writer.write(comment.getId());
					writer.write(comment.getAuthor());
					writer.write(comment_num / 2 + "");
					writer.write(sentence_num + "");
					writer.write(sentence + "");
					writer.endRecord();
				}
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
}
