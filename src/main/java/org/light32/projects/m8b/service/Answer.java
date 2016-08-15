package org.light32.projects.m8b.service;

import org.light32.pd.utils.StringUtils;

import java.io.Serializable;

/**
 * wrapper for an /ask request response
 *
 * @author jwhitt
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String question;
    private final String answer;
    private final long timestamp;
    private final String id;

    public Answer(String answer) {
        this(null, answer);
    }

    public Answer(Question question, String answer) {
        this.question = (question == null) ? null : question.getQuestion();

        this.answer = answer;
        this.timestamp = System.currentTimeMillis();
        this.id = StringUtils.sha256(new StringBuilder()
                .append(this.timestamp)
                .append("|")
                .append(this.question)
                .append("|")
                .append(this.answer)
                .toString()
        );
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

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    public String getQuestion() {
        return question;
    }
}
