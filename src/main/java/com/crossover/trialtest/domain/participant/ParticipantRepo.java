package com.crossover.trialtest.domain.participant;

import com.crossover.common.domain.Repository;

public interface ParticipantRepo extends Repository<Participant> {
    Participant getByUserName(String username);
}

