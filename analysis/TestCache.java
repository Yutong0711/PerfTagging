package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.interviewbubble.entity.Sentence;

public class TestCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "./input/training/non-perf-issues/sentences/training-dataset-random-issues-sentences.csv";
		String splitter = "##perffuzzyrulefengefu##";
		String path = "C:/Users/Yutong/eclipse-workspace/dl4j-examples/dl4j-examples/src/main/resources/";
		String output = path + "non_perf_sentences.txt";

		List<Sentence> sentences = FilesLoader.loadSentencesFromCsv(input);

		try {
			PrintWriter printWriter = new PrintWriter(new File(output));
			int count = 0;
			for (Sentence sentence : sentences) {

				printWriter.write(sentence.getText());
				count++;
				printWriter.write("\n");

			}
			printWriter.flush();
			printWriter.close();
			System.out.println("Write " + count + " sentences to " + output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
