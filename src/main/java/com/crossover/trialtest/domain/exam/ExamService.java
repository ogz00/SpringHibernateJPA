package com.crossover.trialtest.domain.exam;

import com.crossover.common.domain.DomainServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends DomainServiceBase<Exam> {
    @Autowired
    public ExamService(ExamRepo repository) {
        super(Exam.class, repository);
    }
}
