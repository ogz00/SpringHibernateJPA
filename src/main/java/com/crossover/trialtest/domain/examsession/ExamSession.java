package com.crossover.trialtest.domain.examsession;

import com.crossover.common.domain.EntityBase;
import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.question.Question;
import com.crossover.trialtest.domain.participant.Participant;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExamSession extends EntityBase {
    private int passingScore;
    private int finalScore;

    private ExamStatus status;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDurationAsSecondsInteger")
    private Duration duration;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startTime;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime finishTime;

    @ManyToOne private Exam exam;
    @ManyToOne private Participant user;

    @OneToMany(cascade = CascadeType.ALL)
    private final List<SessionQuestion> questions;

    public int getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(int passingScore) {
        this.passingScore = passingScore;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public DateTime getEndDuration() {
        return startTime.plus(duration);
    }

    public int getFinalScore() {
        return finalScore;
    }

    public ExamStatus getStatus() {
        return status;
    }

    public Participant getUser() {
        return user;
    }

    public void setParticipant(Participant user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
        setPassingScore(this.exam.getPassingScore());
        setDuration(exam.getDuration());
    }

    public Iterable<SessionQuestion> getQuestions() {
        return questions;
    }

    public ExamSession() {
        status = ExamStatus.NotStarted;
        startTime = finishTime = DateTime.now();
        duration = Duration.standardHours(1);
        questions = new ArrayList<>();
    }

    public void start() {
        status = ExamStatus.Started;
        startTime = DateTime.now();
    }

    public void finish() {
        finishTime = DateTime.now();
        finalScore = calculateScore();
        status = isDurationPassed() || finalScore < passingScore? ExamStatus.Failed : ExamStatus.Passed;
    }

    public int calculateScore() {
        return questions.size() == 0? 0 : (getCorrectCount() * 100) / questions.size();
    }

    public int getCorrectCount() {
        return FluentIterable.from(questions).filter(new Predicate<SessionQuestion>() {
            public boolean apply(SessionQuestion sq) { return sq.isCorrect(); }
        }).size();
    }

    public boolean isDurationPassed() {
        return finishTime.isAfter(getEndDuration());
    }

    public void addQuestion(Question question) {
        questions.add(new SessionQuestion(question));
    }

    public void addQuestions(Iterable<Question> questions) {
        for (Question q : questions) addQuestion(q);
    }

    public SessionQuestion getQuestion(final Question question) {
        return getQuestion(question.getId());
    }

    public SessionQuestion getQuestionById(final int id) {
        return FluentIterable.from(questions).firstMatch(new Predicate<SessionQuestion>() {
            public boolean apply(SessionQuestion sq) { return sq.getQuestion().getId() == id; }
        }).orNull();
    }

    public SessionQuestion getQuestion(int number) {
        return questions.get(number - 1);
    }

    public void chooseAnswer(int number, Iterable<Integer> answers) {
        SessionQuestion sq = getQuestion(number);
        for (int a : answers)
            sq.chooseAnswer(a);
    }

    public void chooseAnswer(int number, int... answers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int s : answers) list.add(s);
        chooseAnswer(number, list);
    }

    public void chooseAnswerById(int id, Iterable<Integer> answers) {
        SessionQuestion sq = getQuestion(id);
        for (int s : answers)
            sq.chooseAnswer(s);
    }

    public void chooseAnswerById(int id, int... sequences) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int s : sequences) list.add(s);
        chooseAnswerById(id, list);
    }

    public boolean isAnswerCorrect(int number) {
        return getQuestion(number).isCorrect();
    }
}
