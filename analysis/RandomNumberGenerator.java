package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Issue;
import com.interviewbubble.utils.Utils;

public class RandomNumberGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String output = "./input/oak-non-perf-issues-description-text.csv";
		// try {
		// writeKeys(output, "OAK", 50, 1, 7381);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		String project = "log4j2";
		int rand = 17;
		List<Issue> randomly_selected_non_perf_issues = randomly_generate_non_perf_issues(project, rand);
		String output = "./metadata/issues/" + project + "-random-issues-description.csv";

	}

	public void writeDescription(List<Issue> issues, String output) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		if (!alreadyExists) {
			writer.write("Issue Key");
			writer.write("Description");
			writer.write("Label");
			writer.write("Length");
			writer.endRecord();
			for (Issue issue : issues) {
				writer.write(issue.getKey());
				Document document = Jsoup.parse(issue.getDescription());
				document = Utils.pre_process(document);
				String description = Utils.post_process(document.toString());
				writer.write(issue.getSummary() + ". " + description);
				writer.write(issue.getType());
				char[] chs = description.toCharArray();
				writer.write(chs.length + "");
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	private static List<Issue> randomly_generate_non_perf_issues(String project, int num) {
		List<Issue> selection = new ArrayList<>();
		Set<String> res = new HashSet<>();
		String xml_dir = "C:/Users/Yutong/eclipse-workspace/athena/jira-issues/" + project + "-jira-issues";
		String perf_issues_list = "./perf-issues-list.csv";
		Map<String, Issue> all_issues = Utils.generate_all_issues(xml_dir);
		System.out.println("All issues size: " + all_issues.size());
		List<String> all_keys = new ArrayList<>();
		for (String key : all_issues.keySet()) {
			all_keys.add(key);
		}

		Set<String> perf_list = Utils.getPerfIssueKeyList(project, perf_issues_list);
		while (res.size() < num) {
			Random r = new Random();
			int random_number = r.nextInt(all_keys.size() - 1) + 1;
			String selected_key = all_keys.get(random_number);
			if (!perf_list.contains(selected_key)) {
				System.out.println(selected_key);
				res.add(selected_key);
			}
		}
		for (String k : res) {
			selection.add(all_issues.get(k));
		}
		System.out.println("Randomly selected " + selection.size() + " issues.");
		return selection;
	}

	private static void writeKeys(String output, String project, int num, int low, int high) throws IOException {
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');
		Set<Integer> numbers = generateRandomNumbers(num, low, high);
		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.endRecord();
			for (Integer number : numbers) {
				writer.write(project + "-" + number);
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}

	private static Set<Integer> generateRandomNumbers(int num, int low, int high) {
		Set<Integer> res = new HashSet<>();
		while (res.size() <= num) {
			Random r = new Random();
			int result = r.nextInt(high - low) + low;
			res.add(result);
		}
		return res;
	}
}
