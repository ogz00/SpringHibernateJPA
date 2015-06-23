package com.crossover.trialtest.app.rest.rest.representation;

import com.crossover.common.domain.Identifiable;
import com.crossover.trialtest.domain.examsession.ExamSession;
import com.crossover.trialtest.domain.examsession.SessionQuestion;

import java.util.ArrayList;
import java.util.List;

public class ExamSessionRep implements Identifiable {
    public int id;
    public String examName;
    public String status;
    public int finalScore;

    public List<QuestionRep> questions = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    public ExamSessionRep(ExamSession examSession) {
        id = examSession.getId();
        examName = examSession.getExam().getName();
        status = examSession.getStatus().toString();
        finalScore = examSession.getFinalScore();
        for (SessionQuestion sq : examSession.getQuestions())
            questions.add(new QuestionRep(sq));
    }

    ExamSessionRep() {}
}
