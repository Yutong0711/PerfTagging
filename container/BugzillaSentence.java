package container;

import java.util.List;
import java.util.Set;

import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.Tree;

public class BugzillaSentence {
	String ID;
	String author;
	String comment_number;
	String sentence_number;
	String text;
	List<String> words;
	List<String> posTag;
	List<String> nerTag;
	List<String> lemmas;
	String perfTag;

	public String getPerfTag() {
		return perfTag;
	}

	public void setPerfTag(String perfTag) {
		this.perfTag = perfTag;
	}

	Tree syntacticParseTree;
	SemanticGraph dependencies;
	Set<Integer> fittedRules;
	Set<String> fittedPerfRules;
	Set<String> matchedKeywords;

	public double getSentimentScore() {
		return sentimentScore;
	}

	public void setSentimentScore(double sentimentScore) {
		this.sentimentScore = sentimentScore;
	}

	public String getSentimentType() {
		return sentimentType;
	}

	public void setSentimentType(String sentimentType) {
		this.sentimentType = sentimentType;
	}

	public double getVeryPositive() {
		return veryPositive;
	}

	public void setVeryPositive(double veryPositive) {
		this.veryPositive = veryPositive;
	}

	public double getPositive() {
		return positive;
	}

	public void setPositive(double positive) {
		this.positive = positive;
	}

	public double getNeutral() {
		return neutral;
	}

	public void setNeutral(double neutral) {
		this.neutral = neutral;
	}

	public double getNegative() {
		return negative;
	}

	public void setNegative(double negative) {
		this.negative = negative;
	}

	public double getVeryNegative() {
		return veryNegative;
	}

	public void setVeryNegative(double veryNegative) {
		this.veryNegative = veryNegative;
	}

	double sentimentScore;
	String sentimentType;
	double veryPositive;
	double positive;
	double neutral;
	double negative;
	double veryNegative;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment_number() {
		return comment_number;
	}

	public void setComment_number(String comment_number) {
		this.comment_number = comment_number;
	}

	public String getSentence_number() {
		return sentence_number;
	}

	public void setSentence_number(String sentence_number) {
		this.sentence_number = sentence_number;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public List<String> getPosTag() {
		return posTag;
	}

	public void setPosTag(List<String> posTag) {
		this.posTag = posTag;
	}

	public List<String> getNerTag() {
		return nerTag;
	}

	public void setNerTag(List<String> nerTag) {
		this.nerTag = nerTag;
	}

	public List<String> getLemmas() {
		return lemmas;
	}

	public void setLemmas(List<String> lemmas) {
		this.lemmas = lemmas;
	}

	public Tree getSyntacticParseTree() {
		return syntacticParseTree;
	}

	public void setSyntacticParseTree(Tree syntacticParseTree) {
		this.syntacticParseTree = syntacticParseTree;
	}

	public SemanticGraph getDependencies() {
		return dependencies;
	}

	public void setDependencies(SemanticGraph dependencies) {
		this.dependencies = dependencies;
	}

	public Set<Integer> getFittedRules() {
		return fittedRules;
	}

	public void setFittedRules(Set<Integer> fittedRules) {
		if (this.fittedRules == null || this.fittedRules.size() == 0) {
			this.fittedRules = fittedRules;
		} else {
			Set<Integer> temp = this.fittedRules;
			temp.addAll(fittedRules);
			this.fittedRules = temp;
		}
	}

	public Set<String> getFittedPerfRules() {
		return fittedPerfRules;
	}

	public void setFittedPerfRules(Set<String> fittedPerfRules) {
		if (this.fittedPerfRules == null || this.fittedPerfRules.size() == 0) {
			this.fittedPerfRules = fittedPerfRules;
		} else {
			Set<String> temp = this.fittedPerfRules;
			temp.addAll(fittedPerfRules);
			this.fittedPerfRules = temp;
		}
	}

	public Set<String> getMatchedKeywords() {
		return matchedKeywords;
	}

	public void setMatchedKeywords(Set<String> matchedKeywords) {
		if (this.matchedKeywords == null || this.matchedKeywords.size() == 0) {
			this.matchedKeywords = matchedKeywords;
		} else {
			Set<String> temp = this.matchedKeywords;
			temp.addAll(matchedKeywords);
			this.matchedKeywords = temp;
		}
	}

}
