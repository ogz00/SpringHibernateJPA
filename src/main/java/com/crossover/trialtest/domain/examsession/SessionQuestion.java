package com.crossover.trialtest.domain.examsession;

import com.crossover.common.domain.EntityBase;
import com.crossover.trialtest.domain.question.Question;
import com.crossover.trialtest.domain.question.QuestionOption;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SessionQuestion extends EntityBase {
    @ManyToOne private final Question question;

    @ElementCollection
    private final List<QuestionOption> answers;

    public Question getQuestion() {
        return question;
    }

    public Iterable<QuestionOption> getAnswers() {
        return answers;
    }

    public SessionQuestion(Question question) {
        this.question = question;
        answers = new ArrayList<>();
    }

    SessionQuestion() { this(null); }

    public boolean isCorrect() {
        Iterable<QuestionOption> corrects = question.getCorrectAnswers();
        return answers.size() == Iterables.size(corrects) &&  answers.containsAll(Lists.newArrayList(corrects));
    }

    public void chooseAnswer(int sequence) {
        answers.add(question.getOption(sequence - 1));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        SessionQuestion that = (SessionQuestion) other;
        return Objects.equal(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(question);
    }
}
