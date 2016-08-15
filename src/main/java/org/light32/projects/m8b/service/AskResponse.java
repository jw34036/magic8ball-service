package org.light32.projects.m8b.service;

import org.light32.pd.utils.StringUtils;

import java.io.Serializable;
import java.util.UUID;

/**
 * wrapper for an /ask request response
 *
 * @author jwhitt
 */
public class AskResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String text;
	private final long timestamp;
	private final String id;
	
	public AskResponse(String text) { 
		this.text = text;
		this.timestamp = System.currentTimeMillis();
		this.id = StringUtils.sha256(UUID.randomUUID().toString());
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return this.text;
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
}
