package org.light32.projects.m8b.service;

import org.light32.pd.utils.StringUtils;

import java.io.Serializable;

/**
 * Created by jwhitt on 8/15/16.
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    private String question;
    private long timestamp;
    private String id;

    public Question() {

    }


    public String getQuestion() {
        return question;
    }

    // it finally happened
    // a setter with side effects
    public void setQuestion(String question) {
        this.question = question;
        this.timestamp = System.currentTimeMillis();
        this.id = StringUtils.sha256(new StringBuilder()
                .append(this.timestamp)
                .append("|")
                .append(this.question)
                .toString()
        );
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }

}
