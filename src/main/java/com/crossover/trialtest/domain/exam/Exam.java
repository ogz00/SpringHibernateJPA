package com.crossover.trialtest.domain.exam;

import com.crossover.common.domain.EntityBase;
import com.crossover.trialtest.domain.question.Question;
import org.hibernate.annotations.Type;
import org.joda.time.Duration;

import javax.persistence.Entity;

@Entity
public class Exam extends EntityBase {
    private String code;
    private String name;
    private String description;
    private int passScore;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDurationAsSecondsInteger")
    private Duration duration;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPassingScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Exam() {
        duration = Duration.standardMinutes(30);
    }

    public Question createQuestion() {
        Question result = new Question();
        result.setExam(this);
        return result;
    }
}
