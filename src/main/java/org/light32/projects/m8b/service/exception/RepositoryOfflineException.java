package org.light32.projects.m8b.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * exception thrown when mongo is down or unavailable
 *
 * @author jwhitt 8/18/16
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RepositoryOfflineException extends Exception {

    public RepositoryOfflineException(String s) {
        super(s);
    }
}
