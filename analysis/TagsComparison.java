package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Sentence;

public class TagsComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentences_csv_path = "./input/impala-sentences-yutong-leisun.csv";
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(sentences_csv_path);
		int yutong_peter = 0;
		List<Sentence> same = new ArrayList<>();
		List<Sentence> difference = new ArrayList<>();
		for (Sentence sentence : original_sentences) {
			if (sentence.getPerfTag().equals(sentence.getLei_perf_tag())) {
				same.add(sentence);
			} else {
				difference.add(sentence);
			}
		}
		String same_path = "./reports/Apr12/impala-S1-yutong-lei-same.csv";
		String differ_path = "./reports/Apr12/impala-S1-yutong-lei-differ.csv";

		try {
			writeToCsv(difference, differ_path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// SSystem.out.println("Aparajita: " + yutong_rana);
	}

	public static void writeToCsv(List<Sentence> sentences, String output) throws IOException {

		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');

		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.write("No");
			writer.write("Text");
			writer.write("Yutong Tag");
			writer.write("Lei Tag");
			writer.write("Lei's Reason");
			writer.endRecord();
			for (Sentence sentence : sentences) {
				writer.write(sentence.getKey());
				writer.write(sentence.getNumber() + "");
				writer.write(sentence.getText());
				writer.write(sentence.getPerfTag());
				writer.write(sentence.getLei_perf_tag());
				writer.write(sentence.getLei_reason());
				writer.endRecord();

			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
}
