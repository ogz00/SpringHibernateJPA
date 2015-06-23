package com.crossover.trialtest.app.rest.rest;

import com.crossover.common.app.rest.EntityRestControllerBase;
import com.crossover.trialtest.domain.participant.Participant;
import com.crossover.trialtest.domain.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/participant")
public class ParticipantController extends EntityRestControllerBase<Participant, ParticipantService> {

    @Autowired
    ParticipantController(ParticipantService service) {
        super(service);
    }
}

