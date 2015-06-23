package com.crossover.trialtest.domain.question;

import com.crossover.common.domain.EntityBase;
import com.crossover.trialtest.domain.exam.Exam;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question extends EntityBase {
    private String code;
    private String title;
    private String description;

    @ManyToOne private Exam exam;
    @ElementCollection private List<QuestionOption> questionOptions;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionOption getOption(int sequence) {
        return questionOptions.get(sequence);
    }

    public Iterable<QuestionOption> getOptions() {
        return questionOptions;
    }

    public boolean isMultipleAnswers() {
        return Iterables.size(getCorrectAnswers()) > 1;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question() {
        questionOptions = new ArrayList<>();
    }

    public void addOption(String answer, boolean correct) {
        questionOptions.add(new QuestionOption(answer, correct));
    }

    public void addOption(String answer) {
        addOption(answer, false);
    }

    public Iterable<QuestionOption> getCorrectAnswers() {
        return FluentIterable.from(questionOptions).filter(new Predicate<QuestionOption>() {
            public boolean apply(QuestionOption questionOption)
                { return questionOption.isCorrectAnswer(); } });
    }
}
