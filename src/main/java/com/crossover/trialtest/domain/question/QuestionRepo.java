package com.crossover.trialtest.domain.question;

import com.crossover.common.domain.Repository;
import com.crossover.trialtest.domain.exam.Exam;

public interface QuestionRepo extends Repository<Question> {
    Iterable<Question> getByExam(Exam exam);
}
