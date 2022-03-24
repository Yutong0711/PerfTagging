package com.interviewbubble.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.interviewbubble.entity.Problem;
import com.interviewbubble.entity.Sentence;
import com.interviewbubble.rules.CassandraIginiteOakImpalaRules;
import com.interviewbubble.rules.HiveSparkCassandraIgniteOakImpalaRules;
import com.interviewbubble.rules.IgniteOakImpalaRules;
import com.interviewbubble.rules.ImpalaRules;
import com.interviewbubble.rules.KafkaRules;
import com.interviewbubble.rules.LuceneRules;
import com.interviewbubble.rules.MesosSvnHiveSparkCassandraIgniteOakImpalaRules;
import com.interviewbubble.rules.OakImpalaRules;
import com.interviewbubble.rules.PdfBoxRules;
import com.interviewbubble.rules.SlingRules;
import com.interviewbubble.rules.SparkCassandraIgniteOakImpalaRules;
import com.interviewbubble.rules.SvnHiveSparkCassandraIgniteOakImpalaRules;
import com.interviewbubble.rules.Tap5Rules;
import com.interviewbubble.utils.Utils;

public class Analysis1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path_1 = "./input/impala/impala-tagged-sentences-final.csv";
		String path_2 = "./input/oak/oak-perf-label-issues-sentences.csv";
		String path_3 = "./input/ignite/ignite-perf-label-issues-sentences.csv";
		String path_4 = "./input/cassandra/cassandra-perf-label-issues-sentences.csv";
		String path_5 = "./input/spark/spark-perf-label-issues-sentences.csv";
		String path_6 = "./input/hive/hive-perf-label-issues-sentences.csv";
		String path_7 = "./input/svn/svn-perf-label-issues-sentences.csv";
		String path_8 = "./input/mesos/mesos-perf-label-issues-sentences.csv";
		String path_9 = "./input/sling/sling-perf-label-issues-sentences.csv";
		String path_10 = "./input/pdfbox/pdfbox-perf-label-issues-sentences.csv";
		String path_11 = "./input/tap5/tap5-perf-label-issues-sentences.csv";
		String path_12 = "./input/lucene/lucene-perf-label-issues-sentences.csv";
		String path_13 = "./input/kafka/kafka-perf-label-issues-sentences.csv";
		List<Sentence> impala_sentences = FilesLoader.loadSentencesFromCsv(path_1);
		List<Sentence> oak_sentences = FilesLoader.loadSentencesFromCsv(path_2);
		List<Sentence> ignite_sentences = FilesLoader.loadSentencesFromCsv(path_3);
		List<Sentence> cassandra_sentences = FilesLoader.loadSentencesFromCsv(path_4);
		List<Sentence> spark_sentences = FilesLoader.loadSentencesFromCsv(path_5);
		List<Sentence> hive_sentences = FilesLoader.loadSentencesFromCsv(path_6);
		List<Sentence> svn_sentences = FilesLoader.loadSentencesFromCsv(path_7);
		List<Sentence> mesos_sentences = FilesLoader.loadSentencesFromCsv(path_8);
		List<Sentence> sling_sentences = FilesLoader.loadSentencesFromCsv(path_9);
		List<Sentence> pdfbox_sentences = FilesLoader.loadSentencesFromCsv(path_10);
		List<Sentence> tap5_sentences = FilesLoader.loadSentencesFromCsv(path_11);
		List<Sentence> lucene_sentences = FilesLoader.loadSentencesFromCsv(path_12);
		List<Sentence> original_sentences = FilesLoader.loadSentencesFromCsv(path_13);

		original_sentences.addAll(impala_sentences);
		original_sentences.addAll(oak_sentences);
		original_sentences.addAll(ignite_sentences);
		original_sentences.addAll(cassandra_sentences);
		original_sentences.addAll(spark_sentences);
		original_sentences.addAll(hive_sentences);
		original_sentences.addAll(svn_sentences);
		original_sentences.addAll(mesos_sentences);
		original_sentences.addAll(sling_sentences);
		original_sentences.addAll(pdfbox_sentences);
		original_sentences.addAll(tap5_sentences);
		original_sentences.addAll(lucene_sentences);
		int total = 0, yes = 0;
		for (Sentence sentence : original_sentences) {
			total++;
			if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
				yes++;
			}
		}
		System.out.println("Total sentences: " + total);
		System.out.println("Tagged as Yes: " + yes);
		List<Sentence> nlp_sentences = NLPAnalyzer.doNLPAnalyze(original_sentences);

		System.out.println("Impala Rules:");
		List<Sentence> checked_sentences_1 = ImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_1);
		count_rules_precision_recall(checked_sentences_1);

		System.out.println("Oak+Impala Rules:");
		List<Sentence> checked_sentences_2 = OakImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_2);
		count_rules_precision_recall(checked_sentences_2);

		System.out.println("Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_3 = IgniteOakImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_3);
		count_rules_precision_recall(checked_sentences_3);

		System.out.println("Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_4 = CassandraIginiteOakImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_4);
		count_rules_precision_recall(checked_sentences_4);

		System.out.println("Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_5 = SparkCassandraIgniteOakImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_5);
		count_rules_precision_recall(checked_sentences_5);

		System.out.println("Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_6 = HiveSparkCassandraIgniteOakImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_6);
		count_rules_precision_recall(checked_sentences_6);

		System.out.println("Svn+Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_7 = SvnHiveSparkCassandraIgniteOakImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_7);
		count_rules_precision_recall(checked_sentences_7);

		System.out.println("Mesos+Svn+Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_8 = MesosSvnHiveSparkCassandraIgniteOakImpalaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_8);
		count_rules_precision_recall(checked_sentences_8);

		System.out.println("Sling+Mesos+Svn+Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_9 = SlingRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_9);
		count_rules_precision_recall(checked_sentences_9);

		System.out.println("PdfBox+Sling+Mesos+Svn+Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_10 = PdfBoxRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_10);
		count_rules_precision_recall(checked_sentences_10);

		System.out.println("Tap5+PdfBox+Sling+Mesos+Svn+Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_11 = Tap5Rules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_11);
		count_rules_precision_recall(checked_sentences_11);

		System.out.println("Lucene+Tap5+PdfBox+Sling+Mesos+Svn+Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_12 = LuceneRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_12);
		count_rules_precision_recall(checked_sentences_12);

		System.out.println("Kafka+Lucene+Tap5+PdfBox+Sling+Mesos+Svn+Hive+Spark+Cassandra+Ignite+Oak+Impala Rules:");
		List<Sentence> checked_sentences_13 = KafkaRules.checkRules(nlp_sentences);
		count_keywords_precision_recall(checked_sentences_13);
		count_rules_precision_recall(checked_sentences_13);

		String output = "./reports/Apr23/all_checked_sentences.csv";
		try {
			WritingHelper.writeToCsv(checked_sentences_13, output);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String report = "./reports/Apr23/Kafka-Lucene-tapestry5-pdfbox-sling-mesos-svn-hive-spark-cassandra-ignite-oak-impala-fuzzy-rules-report.csv";
		try {
			WritingHelper.writeReport(checked_sentences_13, report);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		do_issue_level_analysis(checked_sentences_13);
	}

	public static void do_issue_level_analysis(List<Sentence> sentences) {
		List<Problem> problems = Utils.loadProblems(sentences);
		Map<String, List<Problem>> map = new HashMap<>();
		for (Problem problem : problems) {
			String key = problem.getKey().split("-")[0];
			if (map.containsKey(key)) {
				List<Problem> temp = map.get(key);
				temp.add(problem);
				map.put(key, temp);
			} else {
				List<Problem> list = new ArrayList<>();
				list.add(problem);
				map.put(key, list);
			}
		}

		for (Entry<String, List<Problem>> entry : map.entrySet()) {
			int total = 0, kw_yes = 0, kw_no = 0, rule_0 = 0, rule_1 = 0, rule_2 = 0, rule_3 = 0, rule_4 = 0,
					rule_5 = 0, rule_more = 0;
			for (Problem problem : entry.getValue()) {
				total++;
				if (problem.getKeywordsList().size() == 0) {
					kw_no++;
				} else {
					kw_yes++;
				}
				int number = problem.getRuleNumberList().size();
				if (number == 0) {
					rule_0++;
				} else if (number == 1) {
					rule_1++;
				} else if (number == 2) {
					rule_2++;
				} else if (number == 3) {
					rule_3++;
				} else if (number == 4) {
					rule_4++;
				} else if (number == 5) {
					rule_5++;
				} else {
					rule_more++;
				}
			}
			System.out.println(entry.getKey() + " has " + total + " issues: " + kw_yes + " can match keywords, " + kw_no
					+ " cannot match any keywords. ");
			System.out.println("Fuzzy Rules Experiment: " + rule_0 + ", " + rule_1 + ", " + rule_2 + ", " + rule_3
					+ ", " + rule_4 + ", " + rule_5 + ", " + rule_more);
		}
	}

	public static void count_rules_precision_recall(List<Sentence> sentences) {
		int correct = 0, misclassified = 0;
		for (Sentence sentence : sentences) {
			if (sentence.getFittedPerfRules().size() > 0) {
				if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
					correct++;
				} else {
					misclassified++;
				}
			}
		}
		System.out.println("Rules: " + correct + " sentences are predicted correct, " + misclassified
				+ " sentences are misclassified.");
	}

	public static void count_keywords_precision_recall(List<Sentence> sentences) {
		int correct = 0, misclassified = 0;
		for (Sentence sentence : sentences) {
			if (sentence.getMatchedKeywords().size() > 0) {
				if (sentence.getPerfTag().equalsIgnoreCase("yes")) {
					correct++;
				} else {
					misclassified++;
				}
			}
		}
		System.out.println("Keywords: " + correct + " sentences are predicted correct, " + misclassified
				+ " sentences are misclassified.");
	}
}
