package com.crossover.trialtest.domain.question;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionOption {
    private final String description;
    private final boolean isCorrectAnswer;

    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public QuestionOption(String description, boolean isCorrectAnswer) {
        this.description = description;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    QuestionOption() { this(null, false); }
}
