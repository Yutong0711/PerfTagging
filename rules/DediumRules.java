package com.interviewbubble.rules;

import java.util.List;

import com.interviewbubble.entity.Sentence;

public class DediumRules {
	String name;

	public DediumRules(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean contains_paper(Sentence sentence) {
		List<String> lemmaList = sentence.getLemmas();
		for (String lemma : lemmaList) {
			if (lemma.equalsIgnoreCase("papar") || lemma.equalsIgnoreCase("study") || lemma.equalsIgnoreCase("research")
					|| lemma.equalsIgnoreCase("article")) {
				return true;
			}
		}
		return false;
	}

	public String do_check(Sentence sentence) {

		if (name.equals("method_1_explore")) {
			String text = sentence.getText();
			if (text.contains("paper explore") || text.contains("study explore"))
				return name;
		}

		if (name.equals("method_2_review_theory")) {
			String text = sentence.getText();
			if (text.contains("review") && (text.contains("theory") || text.contains("evidence")))
				return name;
		}

		if (name.equals("method_3_provide_evidence")) {
			String text = sentence.getText();
			if (text.contains("paper provides evidence"))
				return name;
		}

		if (name.equals("method_4_explain")) {
			String text = sentence.getText();
			if (text.contains("paper explain") || text.contains("study explain"))
				return name;
		}

		if (name.equals("method_5_reexamine")) {
			String text = sentence.getText();
			if (text.contains("reexamin") || text.contains("re-examin"))
				return name;
		}

		if (name.equals("method_6_paper_compare")) {
			String text = sentence.getText();
			if (text.contains("paper compare") || text.contains("study compare"))
				return name;
		}

		if (name.equals("method_7_paper_point_out")) {
			String text = sentence.getText();
			if (text.contains("paper points out") || text.contains("paper pointed out")
					|| text.contains("study points out") || text.contains("study pointed out"))
				return name;
		}

		if (name.equals("method_8_model_assume")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("assume"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_9_augment_model")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("augment"))
					b1 = true;
				if (lemma.equals("model"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_10_paper_describe")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("describe") || lemma.equals("description"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_11_design_or_build")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("design") || lemma.equals("build") || lemma.equals("construct"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_12_aimto")) {
			String textString = sentence.getText();
			if (textString.contains("aims to") || textString.contains("aim to") || textString.contains("aiming to")
					|| textString.contains("aimed to"))
				return name;
		}

		if (name.equals("method_13_paper_present")) {
			String textString = sentence.getText();
			if (textString.contains("paper present") || textString.contains("study present"))
				return name;
		}

		if (name.equals("method_14_paper_address")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("address"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_15_examine_relationship")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("examine"))
					b1 = true;
				if (lemma.equals("relation") || lemma.equals("relationship"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_16_use_approach")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("use"))
					b1 = true;
				if (lemma.equals("approach"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_17_conduct_analysis")) {
			boolean b1 = false, b2 = false, b3 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("conduct"))
					b2 = true;
				if (lemma.equals("analysis") || lemma.equals("analyze"))
					b3 = true;
			}

			if (b1 && b2 && b3)
				return name;
		}

		if (name.equals("method_18_paper_introduce")) {
			String textString = sentence.getText();
			if (textString.contains("paper introduce") || textString.contains("study introduce"))
				return name;
		}

		if (name.equals("method_19_paper_investigate")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("investigate"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_20_paper_review")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("review"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_21_model_derive")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("derive"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_22_model_develop")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("develop"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_23_paper_purpose")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("purpose"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_24_model_establish")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("establish") || lemma.equals("construct") || lemma.equals("build"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_25_theory_develop")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("develop"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_26_author_propose")) {
			String textString = sentence.getText();
			if (textString.contains("author propose"))
				return name;
		}

		if (name.equalsIgnoreCase("method_27_study_contribute")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("contribute") || lemma.equals("contribution"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_28_paper_attemps_to")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			String textString = sentence.getText();
			if (textString.contains("attemp to") || textString.contains("attempts to"))
				b2 = true;
			if (b1 && b2)
				return name;
		}
		if (name.equals("method_29_paper_provide")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("provide"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_30_paper_examine")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("examine"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_31_article_move_forward")) {
			boolean b1 = false, b2 = false, b3 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("move"))
					b2 = true;
				if (lemma.equals("forward"))
					b3 = true;
			}
			if (b1 && b2 && b3)
				return name;
		}

		if (name.equals("method_32_posit_that")) {
			String textString = sentence.getText();
			if (textString.contains("posit that"))
				return name;
		}

		if (name.equals("method_33_explore_how")) {
			String textString = sentence.getText();
			if (textString.contains("exlpore how"))
				return name;
		}

		if (name.equals("method_34_in_comparing")) {
			String textString = sentence.getText();
			if (textString.contains("in comparing"))
				return name;
		}

		if (name.equals("method_35_in_this_article")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			if (textString.contains("in this article"))
				b1 = true;
			if (textString.contains("authors"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_36_author_look_at")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("author"))
					b1 = true;
			}
			if (textString.contains("look at"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_37_article_begin_with")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			if (contains_paper(sentence))
				b1 = true;
			if (textString.contains("begins with"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_38_theory_develop")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("theory"))
					b1 = true;
				if (lemma.equals("develop"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_39_paper_offer")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("offer"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_40_author_study")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("author"))
					b1 = true;
				if (lemma.equals("study"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_41_result_provide")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("result"))
					b1 = true;
				if (lemma.equals("provide"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_42_examine_question")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("examine"))
					b1 = true;
				if (lemma.equals("question"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_43_through_model")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("through"))
					b1 = true;
				if (lemma.equals("model"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_44_paper_case_study")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			if (contains_paper(sentence))
				b1 = true;
			if (textString.contains("case study of"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_45_address_simulation")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("address"))
					b1 = true;
				if (lemma.equals("simulation"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_46_derive_test")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("derive"))
					b1 = true;
				if (lemma.equals("test"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_47_derive_concern")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("derive"))
					b1 = true;
				if (lemma.equals("concern"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_48_author_examine")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("author"))
					b1 = true;
				if (lemma.equals("examine"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_49_study_consider")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("consider"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_50_study_question")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("question"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_51_methodology")) {
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("methodology"))
					return name;
			}
		}

		if (name.equals("method_52_paper_study")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("study"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_53_paper_develop")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("develop"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_54_paper_present")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("present"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_55_study_how")) {
			String textString = sentence.getText();
			if (textString.contains("study how"))
				return name;
		}

		if (name.equals("method_56_begin_with_then")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("present"))
					b1 = true;
			}
			if (textString.contains("begin with"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_57_investigate_test")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("investigate"))
					b1 = true;
				if (lemma.equals("test"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_58_explore_by")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("explore"))
					b1 = true;
				if (lemma.equals("by"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_59_begin_by")) {
			String textString = sentence.getText();
			if (textString.contains("begin by"))
				return name;
		}

		if (name.equals("method_60_context_model")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("context"))
					b1 = true;
				if (lemma.equals("model"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_61_provide_examine")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("provide"))
					b1 = true;
				if (lemma.equals("examine"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_62_approach_method")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("approach"))
					b1 = true;
				if (lemma.equals("method"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_63_investigate_apply")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("investigate"))
					b1 = true;
				if (lemma.equals("apply"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_64_look_into")) {
			String textString = sentence.getText();
			if (textString.contains("look into"))
				return name;
		}

		if (name.equals("method_65_come_up_with")) {
			String textString = sentence.getText();
			if (textString.contains("come up with"))
				return name;
		}

		if (name.equals("method_66_by_able_to")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			if (textString.contains("able to"))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("by"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("method_67_be_studied")) {
			String textString = sentence.getText();
			if (textString.contains("were studied"))
				return name;
		}

		// patterns_sent_sample

		if (name.equals("sample_1_context")) {
			String textString = sentence.getText();
			if (textString.contains("context"))
				return name;
		}

		if (name.equals("sample_2_use_article")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("use"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("sample_3_participate_article")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("participate"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("sample_4_use")) {
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("use"))
					return name;
			}
		}

		if (name.equals("sample_5_model_use")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("use"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("sample_6_use_date")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("use"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("date on"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("sample_7_sample")) {
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("sample"))
					return name;
			}
		}

		if (name.equals("sample_8_dataset")) {
			String textString = sentence.getText();
			if (textString.contains("dataset on"))
				return name;
		}

		if (name.equals("sample_9_analyse_sample")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("analyse"))
					b1 = true;
				if (lemma.equals("sample"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		// patterns_sent_region
		if (name.equals("region_1_worldwide")) {
			String textString = sentence.getText();
			if (textString.contains("worldwide"))
				return name;
		}

		if (name.equals("region_2_sample")) {
			String textString = sentence.getText();
			if (textString.contains("sample"))
				return name;
		}

		if (name.equals("region_3_develop_country")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("develop"))
					b1 = true;
				if (lemma.equals("country"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		// patterns_sent_variable
		if (name.equals("variable_1_variable_predict")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("variable"))
					b1 = true;
				if (lemma.equals("predict"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_2_paper_reexamine")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("reexamine"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_3_study_reexamine")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("examine"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_4_investigate_context")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("investigate"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("context of"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_5_reveal_what")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("reveal"))
					b1 = true;
				if (lemma.equals("what"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_6_explore_influence")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("explore"))
					b1 = true;
				if (lemma.equals("influence"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_7_paper_examine_relationship")) {
			boolean b1 = false, b2 = false, b3 = false;
			if (contains_paper(sentence))
				b1 = true;
			String textString = sentence.getText();
			if (textString.contains("relationship between") || textString.contains("link between"))
				b2 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("examine") || lemma.equals("re-examine"))
					b3 = true;
			}
			if (b1 && b2 && b3)
				return name;
		}

		if (name.equals("variable_8_paper_investigate_affect")) {
			boolean b1 = false, b2 = false, b3 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("investigate"))
					b2 = true;
				if (lemma.equals("affect"))
					b3 = true;
			}
			if (b1 && b2 && b3)
				return name;
		}

		if (name.equals("variable_9_show_icrease/decrease")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("show"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("increase with") || textString.contains("decrease with")) {
				b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_10_how_affect")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("how"))
					b1 = true;
				if (lemma.equals("affect"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_11_article_investigate_effect")) {
			boolean b1 = false, b2 = false, b3 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("investigate"))
					b2 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("effect on"))
				b3 = true;
			if (b1 && b2 && b3)
				return name;
		}

		if (name.equals("variable_12_aim_effect_to")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("aim"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("effects to"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_13_study_classify")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("classify"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_14_finding_depend_on")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("fingding"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("depend on")) {
				b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_15_article_explain")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("explain"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_16_paper_relationship_between")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			String textString = sentence.getText();
			if (textString.contains("relationship between"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_17_decompose_across")) {
			String textString = sentence.getText();
			if (textString.contains("decompose across"))
				return name;
		}

		if (name.equals("variable_18_setting_cause")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("setting"))
					b1 = true;
				if (lemma.equals("cause"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_19_author_influence")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("author"))
					b1 = true;
				if (lemma.equals("influence"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_20_article_examine_influence")) {
			boolean b1 = false, b2 = false, b3 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("examine"))
					b2 = true;
				String textString = sentence.getText();
				if (textString.contains("influence of") || textString.contains("related to"))
					b3 = true;
			}
			if (b1 && b2 && b3 || b1 && b2)
				return name;
		}

		if (name.equals("variable_21_investigate_predict")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("investigate"))
					b1 = true;
				if (lemma.equals("predict"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_22_how_predict")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			if (textString.contains("how do"))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("predict"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_23_implication_under")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("implicate"))
					b1 = true;
				if (lemma.equals("under"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_24_account_for")) {
			String textString = sentence.getText();
			if (textString.contains("account for"))
				return name;
		}

		if (name.equals("variable_25_estimate_impact_on")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("estimate"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("impact on"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_26_determine")) {
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("determine"))
					return name;
			}
		}

		if (name.equals("variable_27_linked_via")) {
			String textString = sentence.getText();
			if (textString.contains("linked via"))
				return name;
		}

		if (name.equals("variable_28_derive_affect")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("derive"))
					b1 = true;
				if (lemma.equals("affect"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_29_find_associate")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("analysis") || lemma.equals("find") || lemma.equals("examine")
						|| lemma.equals("explore"))
					b1 = true;
				if (lemma.equals("associate") || lemma.equals("relation") || lemma.equals("impact"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_30_find_earn")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("find"))
					b1 = true;
				if (lemma.equals("earn") || lemma.equals("improve"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_31_control_for")) {
			String textString = sentence.getText();
			if (textString.contains("control for"))
				return name;
		}

		if (name.equals("variable_32_examine_effect")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("effect") || lemma.equals("affect") || lemma.equals("influence"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_33_model_distinguish")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("distinguish"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_34_explore_condition")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("explore") || lemma.equals("find"))
					b1 = true;
				if (lemma.equals("condition") || lemma.equals("depend"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_35_reduce_amplify")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("reduce"))
					b1 = true;
				if (lemma.equals("amplify"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("variable_36_conclude_represent_performance")) {
			boolean b1 = false, b2 = false, b3 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("conclude"))
					b1 = true;
				if (lemma.equals("represent"))
					b2 = true;
				if (lemma.equals("performance"))
					b3 = true;
			}
			if (b1 && b2 && b3)
				return name;
		}

		if (name.equals("variable_37_relation")) {
			String textString = sentence.getText();
			if (textString.contains("variations in") || textString.contains("relation between")
					|| textString.contains("relation to") || textString.contains("relationship along")
					|| textString.contains("concentration on") || textString.contains("impact of")
					|| textString.contains("especially for"))
				return name;
		}

		// patterns_sent_result
		if (name.equals("result_1_find")) {
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("find"))
					return name;
			}
		}

		if (name.equals("result_2_theory_consist")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("theory"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("consistent with"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_3_paper_show")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("show") || lemma.equals("explain")) {
					b2 = true;
				}
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_4_in_sum")) {
			String textString = sentence.getText();
			if (textString.contains("in sum") || textString.contains("empirically"))
				return name;
		}

		if (name.equals("result_5_demonstrate")) {
			String textString = sentence.getText();
			if (textString.contains("demonstrate that"))
				return name;
		}

		if (name.equals("result_6_cause_by")) {
			String textString = sentence.getText();
			if (textString.contains("caused by"))
				return name;
		}

		if (name.equals("result_7_result_show")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("result") || lemma.equals("research") || lemma.equals("analysis")
						|| lemma.equals("lesson"))
					b1 = true;
				if (lemma.equals("show") || lemma.equals("indicate") || lemma.equals("suggest")
						|| lemma.equals("reveal") || lemma.equals("reflect"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_8_model_predict")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
				if (lemma.equals("predict"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_9_present_result")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("present"))
					b1 = true;
				if (lemma.equals("result"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_10_paper_suggest")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("find") || lemma.equals("reveal") || lemma.equals("suggest"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_11_result")) {
			String textString = sentence.getText();
			if (textString.contains("result:") || textString.contains("result from"))
				return name;
		}

		if (name.equals("result_12_conclude")) {
			String textString = sentence.getText();
			if (textString.contains("result in") || textString.contains("consequently")
					|| textString.contains("statictically") || textString.contains("conclude that")
					|| textString.contains("summarize"))
				return name;
		}

		if (name.equals("result_13_overview")) {
			String textString = sentence.getText();
			if (textString.contains("overview of"))
				return name;
		}

		if (name.equals("result_14_experience_influence")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("experience"))
					b1 = true;
				if (lemma.equals("influence"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_15_contrast_study")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("contrast"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_16_consist_predict")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("predict"))
					b1 = true;
				if (lemma.equals("consist"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_17_setting_cause")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("set"))
					b1 = true;
				if (lemma.equals("cause"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_18_article_define")) {
			boolean b1 = false, b2 = false;
			if (contains_paper(sentence))
				b1 = true;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("define"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_19_positively_predicted")) {
			String textString = sentence.getText();
			if (textString.contains("positively predicted"))
				return name;
		}

		if (name.equals("result_20_consist_theory")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("consist"))
					b1 = true;
				if (lemma.equals("theory"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_21_far_from_show_to")) {
			boolean b1 = false, b2 = false;
			String textString = sentence.getText();
			if (textString.contains("far from"))
				b1 = true;
			if (textString.contains("shown to"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_22_literature_by")) {
			String textString = sentence.getText();
			if (textString.contains("literature by"))
				return name;
		}

		if (name.equals("result_23_model_insight_into")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("model"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("insight into"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_24_evidence_provide")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("evidence"))
					b1 = true;
				if (lemma.equals("provide"))
					b2 = true;
			}
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_25_find_suggest_that")) {
			boolean b1 = false, b2 = false;
			for (String lemma : sentence.getLemmas()) {
				if (lemma.equals("find"))
					b1 = true;
			}
			String textString = sentence.getText();
			if (textString.contains("suggest that"))
				b2 = true;
			if (b1 && b2)
				return name;
		}

		if (name.equals("result_26_turn_out_that")) {
			String textString = sentence.getText();
			if (textString.contains("turns out that"))
				return name;
		}
		return null;
	}
}
