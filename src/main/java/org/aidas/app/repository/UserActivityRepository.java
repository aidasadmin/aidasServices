package org.aidas.app.repository;

import org.aidas.app.model.UserActivityModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository extends MongoRepository<UserActivityModel, String> {
	
	UserActivityModel findById(String id);

}
