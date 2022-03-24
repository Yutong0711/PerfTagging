package com.interviewbubble.analysis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.interviewbubble.entity.Sentence;
import com.interviewbubble.utils.Utils;

public class FilesLoader {

	public static List<Sentence> loadSentencesFromFolder(String path, String splitter) {
		List<Sentence> sentences = new ArrayList<>();
		File file = new File(path);
		File[] files = file.listFiles();
		for (File f : files) {
			List<Sentence> partition = loadSentencesFromCsv(f.getAbsolutePath(), splitter);
			sentences.addAll(partition);
		}
		System.out.println(sentences.size() + " sentences are loaded from " + path);
		return sentences;
	}

	public static List<Sentence> loadSentencesFromCsv_simple(String path) {
		List<Sentence> sentences = new ArrayList<>();
		try {
			List<String[]> list = Utils.readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				Sentence sentence = new Sentence();
				sentence.setKey(list.get(r)[0]);
				sentence.setNumber(Integer.parseInt(list.get(r)[1]));
				sentence.setText(list.get(r)[2]);
				sentence.setPerfTag(list.get(r)[3]);

				sentences.add(sentence);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("loadSentenceFromCsv: " + sentences.size() + " sentences are loaded.");
		return sentences;
	}

	public static List<Sentence> loadSentencesFromCsv(String path, String splitter) {
		List<Sentence> sentences = new ArrayList<>();
		try {
			List<String[]> list = Utils.readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				Sentence sentence = new Sentence();
				sentence.setKey(list.get(r)[0]);
				sentence.setPosition("Description");
				sentence.setNumber(Integer.parseInt(list.get(r)[1]));
				sentence.setText(list.get(r)[2]);
				sentence.setPerfTag(list.get(r)[3]);
				String[] words = list.get(r)[4].split(splitter);
				List<String> word_list = new ArrayList<>();
				for (String word : words) {
					word_list.add(word.trim());
				}
				sentence.setWords(word_list);
				String[] posTags = list.get(r)[5].split(splitter);
				List<String> posTag_list = new ArrayList<>();
				for (String posTag : posTags) {
					posTag_list.add(posTag.trim());
				}
				sentence.setPosTag(posTag_list);
				String[] nerTags = list.get(r)[6].split(splitter);
				List<String> nerTag_list = new ArrayList<>();
				for (String nerTag : nerTags) {
					nerTag_list.add(nerTag.trim());
				}
				sentence.setNerTag(nerTag_list);
				String[] lemmas = list.get(r)[7].split(splitter);
				List<String> lemma_list = new ArrayList<>();
				for (String lemma : lemmas) {
					lemma_list.add(lemma.trim());
				}
				sentence.setLemmas(lemma_list);

				sentence.setSentimentType(list.get(r)[9]);

				sentences.add(sentence);
			}
			// System.out.println("Loaded " + sentences.size() + " sentences.");
			// return sentences;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("loadSentenceFromCsv: " + sentences.size() + " sentences are loaded.");
		return sentences;
	}

	public static List<Sentence> loadSentencesFromCsv2(String path, String splitter) {
		List<Sentence> sentences = new ArrayList<>();
		try {
			List<String[]> list = Utils.readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				Sentence sentence = new Sentence();

				// set issue id
				StringBuilder id = new StringBuilder();
				String[] temp = list.get(r)[0].split("-");
				id.append(temp[0]);
				id.append("-");
				id.append(temp[1]);
				sentence.setKey(id.toString());

				// set position
				if (temp[2].equalsIgnoreCase("Description")) {
					sentence.setPosition("Description");
				} else if (temp[2].equalsIgnoreCase("Title")) {
					sentence.setPosition("Title");
				} else {
					StringBuilder comment_id = new StringBuilder();
					comment_id.append(temp[2]);
					comment_id.append("-");
					comment_id.append(temp[3]);
					sentence.setPosition(comment_id.toString());
				}
				sentence.setNumber(Integer.parseInt(list.get(r)[1]));
				sentence.setText(list.get(r)[2]);
				String[] words = list.get(r)[3].split(splitter);
				List<String> word_list = new ArrayList<>();
				for (String word : words) {
					word_list.add(word.trim());
				}
				sentence.setWords(word_list);
				String[] posTags = list.get(r)[4].split(splitter);
				List<String> posTag_list = new ArrayList<>();
				for (String posTag : posTags) {
					posTag_list.add(posTag.trim());
				}
				sentence.setPosTag(posTag_list);
				String[] nerTags = list.get(r)[5].split(splitter);
				List<String> nerTag_list = new ArrayList<>();
				for (String nerTag : nerTags) {
					nerTag_list.add(nerTag.trim());
				}
				sentence.setNerTag(nerTag_list);
				String[] lemmas = list.get(r)[6].split(splitter);
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

	public static List<Sentence> loadSentencesFromCsv(String path) {
		List<Sentence> sentences = new ArrayList<>();
		try {
			List<String[]> list = Utils.readCsv(path);
			for (int r = 0; r < list.size(); r++) {
				Sentence sentence = new Sentence();
				sentence.setKey(list.get(r)[0]);
				sentence.setPosition("Description");
				sentence.setNumber(Integer.parseInt(list.get(r)[1]));
				sentence.setText(list.get(r)[2]);
				sentence.setPerfTag(list.get(r)[3]);
				// sentence.setLei_perf_tag(list.get(r)[4]);
				// sentence.setLei_reason(list.get(r)[5]);
				// sentence.setAparajita_perf_tag(list.get(r)[5]);
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
}
