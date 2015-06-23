package com.crossover.trialtest.domain.question;

import com.crossover.common.domain.DomainServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends DomainServiceBase<Question> {

    @Autowired
    public QuestionService(QuestionRepo questionRepo) {
        super(Question.class, questionRepo);
    }
}
