package org.light32.projects.m8b.service.mongo;

import org.light32.projects.m8b.service.AskResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB repository to log AskResponses and query them
 *
 * @author jwhitt 8/17/16
 */
public interface Magic8BallRepository extends MongoRepository<AskResponse, String> {

    AskResponse findById(String id);

}
