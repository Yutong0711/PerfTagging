package com.interviewbubble.analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.csvreader.CsvWriter;
import com.interviewbubble.entity.Issue;
import com.interviewbubble.utils.Utils;

public class IssueDescriptionWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml_path = "C:/Users/Yutong/eclipse-workspace/athena/jira-issues/serf-jira-issues";
		String output = "./input/testing/dlab/serf-all-issues-description.csv";
		try {
			writeToCsv(xml_path, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void print_description(List<Issue> issues, String output) {

	}

	public static void writeToCsv(String xml_path, String output) throws IOException {
		Map<String, Issue> issues = Utils.generate_all_issues(xml_path);
		System.out.println("Total Number of Issues: " + issues.size());
		boolean alreadyExists = new File(output).exists();
		CsvWriter writer = new CsvWriter(new FileWriter(output, true), ',');

		if (!alreadyExists) {
			writer.write("Issue-Key");
			writer.write("Description");
			writer.endRecord();
			for (Issue issue : issues.values()) {
				writer.write(issue.getKey());
				Document doc = Jsoup.parse(issue.getDescription());
				doc = Utils.pre_process(doc);
				String description = Utils.post_process(doc.toString());
				writer.write(description);
				writer.endRecord();
			}
			writer.close();
		} else {
			System.out.println("ERROR: the output file already exists!!!");
		}
	}
}
