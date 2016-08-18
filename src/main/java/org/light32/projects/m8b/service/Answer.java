package org.light32.projects.m8b.service;

import java.io.Serializable;

/**
 * wrapper for an /ask request response
 *
 * @author jwhitt
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    private final long timestamp;
    private final String answer;

    public Answer(String answer) {
        this.timestamp = System.currentTimeMillis();
        this.answer = answer;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return this.timestamp;
    }

}
