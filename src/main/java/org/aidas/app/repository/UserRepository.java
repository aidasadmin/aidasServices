package org.aidas.app.repository;

import org.aidas.app.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
	
	UserModel findByEmailIdAndPassword(String emailId, String password);

}
