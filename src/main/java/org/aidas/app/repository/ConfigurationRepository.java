package org.aidas.app.repository;

import org.aidas.app.model.ConfigurationModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends MongoRepository<ConfigurationModel, String> {
	

}
