package com.crossover.trialtest.domain.participant;

import com.crossover.common.domain.EntityBase;

import javax.persistence.Entity;

@Entity
public class Participant extends EntityBase {
    private String userName;
    private String password;
    private String fullName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

