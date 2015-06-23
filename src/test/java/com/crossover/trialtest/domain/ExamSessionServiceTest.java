package com.crossover.trialtest.domain;

import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.examsession.*;
import com.crossover.trialtest.domain.participant.Participant;
import com.crossover.trialtest.domain.question.Question;
import com.crossover.trialtest.domain.question.QuestionRepo;
import com.google.common.collect.ImmutableSet;
import org.joda.time.Duration;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ExamSessionServiceTest {
    @Test
    public void math_session_with_75_score_should_pass() {
        ExamSessionService service = new ExamSessionService(examSessionRepo, questionRepo);
        ExamSession session = service.startSession(suyama, math);
        verify(examSessionRepo).save(any(ExamSession.class));

        session.chooseAnswer(1, 1, 4); // set question number 1 answers to: 1 and 4
        SessionQuestion sq = session.getQuestion(1); // get question number 1
        assertThat(sq.isCorrect()).isTrue();

        session.chooseAnswer(2, 1);
        assertThat(session.isAnswerCorrect(2)).isTrue();

        sq = session.getQuestion(q3); // get question by question object (q3)
        sq.chooseAnswer(3);           // directly set the answer from the SessionQuestion object
        assertThat(sq.isCorrect()).isTrue();

        session.chooseAnswer(4, 1);
        assertThat(session.isAnswerCorrect(4)).isFalse();

        assertThat(session.calculateScore()).isEqualTo(75);
        service.finish(session);
        assertThat(session.getFinalScore()).isEqualTo(75);
        assertThat(session.getStatus()).isEqualTo(ExamStatus.Passed);

        verify(examSessionRepo, times(2)).save(any(ExamSession.class));
    }

    @Test
    public void math_session_with_50_score_should_fail() {
        ExamSessionService service = new ExamSessionService(examSessionRepo, questionRepo);
        ExamSession session = service.startSession(suyama, math);
        verify(examSessionRepo).save(session);

        session.chooseAnswer(1, 1, 4);
        SessionQuestion sq = session.getQuestion(1);
        assertThat(sq.isCorrect()).isTrue();

        session.chooseAnswer(2, 2);
        assertThat(session.isAnswerCorrect(2)).isFalse();

        sq = session.getQuestion(q3);
        sq.chooseAnswer(3);
        assertThat(sq.isCorrect()).isTrue();

        sq = session.getQuestion(q4);
        assertThat(sq.isCorrect()).isFalse();

        assertThat(session.calculateScore()).isEqualTo(50);
        service.finish(session);
        assertThat(session.getFinalScore()).isEqualTo(50);
        assertThat(session.getStatus()).isEqualTo(ExamStatus.Failed);

        verify(examSessionRepo, times(2)).save(any(ExamSession.class));
    }

    @Test
    public void math_session_with_100_score_but_time_is_passed_should_fail() throws InterruptedException {
        ExamSessionService service = new ExamSessionService(examSessionRepo, questionRepo);
        ExamSession session = service.startSession(suyama, math);
        verify(examSessionRepo).save(any(ExamSession.class));

        session.chooseAnswer(1, 1, 4);
        assertThat(session.isAnswerCorrect(1)).isTrue();

        session.chooseAnswer(2, 1);
        assertThat(session.isAnswerCorrect(2)).isTrue();

        session.chooseAnswer(3, 3);
        assertThat(session.isAnswerCorrect(3)).isTrue();

        session.chooseAnswer(4, 1, 2);
        assertThat(session.isAnswerCorrect(4)).isTrue();

        assertThat(session.calculateScore()).isEqualTo(100);
        Thread.sleep(1001); // math session duration is 1 seconds, this will make the duration passed
        service.finish(session);
        assertThat(session.getFinalScore()).isEqualTo(100);
        assertThat(session.getStatus()).isEqualTo(ExamStatus.Failed);

        verify(examSessionRepo, times(2)).save(any(ExamSession.class));
    }

    @Before
    public void setup() {
        suyama = Samples.participants.suyama();
        math = Samples.exams.basicMath();
        math.setDuration(Duration.standardSeconds(1));

        q1 = Samples.questions.basicMath1(); q1.setId(1);
        q2 = Samples.questions.basicMath2(); q2.setId(2);
        q3 = Samples.questions.basicMath3(); q3.setId(3);
        q4 = Samples.questions.basicMath4(); q4.setId(4);

        examSessionRepo = mock(ExamSessionRepo.class);
        ExamSession mathSession = new ExamSession();
        mathSession.setExam(math);
        mathSession.setParticipant(suyama);
        mathSession.addQuestions(ImmutableSet.of(q1, q2, q3, q4));

        when(examSessionRepo.save(any(ExamSession.class))).thenReturn(mathSession);
        questionRepo = mock(QuestionRepo.class);
        when(questionRepo.getByExam(math)).thenReturn(ImmutableSet.of(q1, q2, q3, q4));
    }

    Exam math;
    Participant suyama;
    Question q1, q2, q3, q4;

    ExamSessionRepo examSessionRepo;
    QuestionRepo questionRepo;
}
