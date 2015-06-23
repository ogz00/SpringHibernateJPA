package com.crossover.trialtest.app.rest.rest.representation;

import com.crossover.trialtest.domain.question.QuestionOption;

public class OptionRep {
    public String description;
    public boolean isChecked;

    public OptionRep(QuestionOption qo) {
        this.description = qo.getDescription();
    }

    public OptionRep() {}
}
