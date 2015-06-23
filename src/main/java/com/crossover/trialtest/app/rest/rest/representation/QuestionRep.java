package com.crossover.trialtest.app.rest.rest.representation;

import com.crossover.trialtest.domain.examsession.SessionQuestion;
import com.crossover.trialtest.domain.question.QuestionOption;

import java.util.ArrayList;
import java.util.List;

public class QuestionRep {
    public String title;
    public String description;
    public List<OptionRep> options = new ArrayList<>();

    public QuestionRep(SessionQuestion sq) {
        title = sq.getQuestion().getTitle();
        description = sq.getQuestion().getDescription();
        for (QuestionOption qo : sq.getQuestion().getOptions())
            options.add(new OptionRep(qo));
    }

    public QuestionRep() {}
}
