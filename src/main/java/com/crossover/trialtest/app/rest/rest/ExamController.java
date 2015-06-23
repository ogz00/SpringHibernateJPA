package com.crossover.trialtest.app.rest.rest;

import com.crossover.common.app.rest.EntityRestControllerBase;
import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/exam")
public class ExamController extends EntityRestControllerBase<Exam, ExamService> {

    @Autowired
    ExamController(ExamService service) {
        super(service);
    }
}
