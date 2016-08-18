package org.light32.projects.m8b.service;

import java.io.Serializable;

/**
 * Created by jwhitt on 8/15/16.
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    private final long timestamp;
    private String question;

    public Question() {
        this.timestamp = System.currentTimeMillis();
    }

    public Question(String question) {
        this();
        this.question = question;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
