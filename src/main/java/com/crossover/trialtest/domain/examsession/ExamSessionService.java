package com.crossover.trialtest.domain.examsession;

import com.crossover.common.domain.DomainServiceBase;
import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.exam.ExamRepo;
import com.crossover.trialtest.domain.participant.Participant;
import com.crossover.trialtest.domain.participant.ParticipantRepo;
import com.crossover.trialtest.domain.question.Question;
import com.crossover.trialtest.domain.question.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamSessionService extends DomainServiceBase<ExamSession> {
    private final ExamSessionRepo examSessionRepo;
    private final QuestionRepo questionRepo;
    private final ParticipantRepo participantRepo;
    private final ExamRepo examRepo;

    @Autowired
    public ExamSessionService(ExamSessionRepo examSessionRepo, QuestionRepo questionRepo,
                              ParticipantRepo participantRepo, ExamRepo examRepo) {
        super(ExamSession.class, examSessionRepo);
        this.examSessionRepo = examSessionRepo;
        this.questionRepo = questionRepo;
        this.participantRepo = participantRepo;
        this.examRepo = examRepo;
    }

    public ExamSessionService(ExamSessionRepo examSessionRepo, QuestionRepo questionRepo) {
        this(examSessionRepo, questionRepo, null, null);
    }

    public ExamSession startSession(Participant participant, Exam exam) {
        ExamSession newSession = new ExamSession();
        newSession.setParticipant(participant);
        newSession.setExam(exam);
        newSession.start();
        Iterable<Question> questions = questionRepo.getByExam(exam);
        newSession.addQuestions(questions);
        return examSessionRepo.save(newSession);
    }

    public ExamSession startSession(String username, int examId) {
        return startSession(participantRepo.getByUserName(username), examRepo.findOne(examId));
    }

    public void finish(ExamSession examSession) {
        examSession.finish();
        examSessionRepo.save(examSession);
    }
}
