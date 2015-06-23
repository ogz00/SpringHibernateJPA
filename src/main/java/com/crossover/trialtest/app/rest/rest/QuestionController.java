package com.crossover.trialtest.app.rest.rest;

import com.crossover.common.app.rest.EntityRestControllerBase;
import com.crossover.trialtest.domain.question.Question;
import com.crossover.trialtest.domain.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/question")
public class QuestionController extends EntityRestControllerBase<Question, QuestionService> {

    @Autowired
    QuestionController(QuestionService service) {
        super(service);
    }
}
