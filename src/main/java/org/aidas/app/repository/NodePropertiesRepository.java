package org.aidas.app.repository;

import org.aidas.app.model.NodePropertiesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodePropertiesRepository extends MongoRepository<NodePropertiesModel, String> {
	

}
