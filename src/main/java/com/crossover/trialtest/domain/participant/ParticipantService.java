package com.crossover.trialtest.domain.participant;

import com.crossover.common.domain.DomainServiceBase;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService extends DomainServiceBase<Participant> {

    private ParticipantRepo participantRepo;

    @Autowired public ParticipantService(ParticipantRepo repository) {
        super(Participant.class, repository);
        participantRepo = repository;
    }

    public Optional<Participant> getByUsername(String username) {
        return Optional.fromNullable(participantRepo.getByUserName(username));
    }
}