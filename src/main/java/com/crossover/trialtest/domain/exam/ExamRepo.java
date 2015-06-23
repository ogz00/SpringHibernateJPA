package com.crossover.trialtest.domain.exam;

import com.crossover.common.domain.Repository;

public interface ExamRepo extends Repository<Exam> {
    Exam getByCode(String code);
}

