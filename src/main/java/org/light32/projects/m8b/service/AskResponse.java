package org.light32.projects.m8b.service;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;

/**
 * response for a question sent to /ask
 *
 * @author jwhitt 8/17/16
 */
public class AskResponse implements Serializable {

    private final String id;
    private final Question question;
    private final Answer answer;

    AskResponse(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
        this.id = DigestUtils.shaHex(new StringBuilder()
                .append("[")
                .append(this.question.getTimestamp())
                .append(":")
                .append(this.question.getQuestion())
                .append("][")
                .append(this.answer.getTimestamp())
                .append(":")
                .append(this.answer.getAnswer())
                .append("]")
                .toString());
    }

    Question getQuestion() {
        return question;
    }

    Answer getAnswer() {
        return answer;
    }

    public String getId() {
        return id;
    }
}
