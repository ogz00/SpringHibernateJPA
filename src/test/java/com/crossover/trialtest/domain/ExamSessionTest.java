package com.crossover.trialtest.domain;

import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.examsession.ExamSession;
import com.crossover.trialtest.domain.examsession.ExamStatus;
import com.crossover.trialtest.domain.participant.Participant;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.jodatime.api.Assertions.assertThat;

public class ExamSessionTest {
    @Test public void set_exam_should_automatically_set_passing_score() {
        ExamSession sut = new ExamSession();
        sut.setExam(calcExam);
        assertThat(sut.getPassingScore()).isEqualTo(calcExam.getPassingScore());
    }

    @Test public void set_exam_should_automatically_set_duration() {
        ExamSession sut = new ExamSession();
        sut.setExam(calcExam);
        assertThat(sut.getDuration()).isEqualTo(calcExam.getDuration());
    }

    @Test public void starting_the_exam_should_set_the_end_time() {
        ExamSession sut = new ExamSession();
        sut.setExam(calcExam);
        sut.start();
        assertThat(sut.getStatus()).isEqualTo(ExamStatus.Started);
        assertThat(sut.getStartTime()).isEqualToIgnoringMillis(DateTime.now());
        assertThat(sut.getEndDuration()).isEqualToIgnoringMillis(DateTime.now().plus(sut.getDuration()));
    }

    @Test public void finishing_exam_after_duration_passed() throws InterruptedException {
        ExamSession sut = new ExamSession();
        sut.setDuration(Duration.standardSeconds(1));
        sut.start();
        Thread.sleep(1001);
        sut.finish();
        assertThat(sut.isDurationPassed()).isTrue();
    }

    @Before public void init() {
        suyama = new Participant();
        suyama.setFullName("Michael Suyama");
        suyama.setUserName("getSuyama");

        calcExam = new Exam();
        calcExam.setName("Vector Calculus");
        calcExam.setDescription("An examination that requires you to use curl and div");
        calcExam.setPassScore(75);
        calcExam.setDuration(new Duration(Duration.standardHours(2)));
    }

    private Participant suyama;
    private Exam calcExam;
}
