package org.aidas.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.aidas.app.services.MongoServices;
import org.aidas.app.util.ConfigurationUtil;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

/**
 * The Class MongoServicesImpl.
 */
@Service
public class MongoServicesImpl implements MongoServices {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoServicesImpl.class);
	
	/* (non-Javadoc)
	 * @see org.ramyam.pm.services.MongoServices#getAllCollections(java.lang.String)
	 */
	@Override
	public List<String> getAllCollections(final String tenantId) {
		final List<String> collectionsList = new ArrayList<String>();
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(tenantId);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		final MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();
		for (String collection : collectionNames) {
			collectionsList.add(collection);
		}
		return collectionsList;
	}

	/* (non-Javadoc)
	 * @see org.ramyam.pm.services.MongoServices#doesCollectionExists(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean doesCollectionExists(final String tenantId, final String collectionName) {
		boolean collectionExists = false;

		final List<String> collectionList = getAllCollections(tenantId);
		if (collectionList != null && !collectionList.isEmpty() && collectionList.contains(collectionName)) {
			collectionExists = true;
		}
		return collectionExists;
	}

	/* (non-Javadoc)
	 * @see org.ramyam.pm.services.MongoServices#getAllDocumentByCriteria(java.lang.String, java.lang.String, org.bson.Document)
	 */
	@Override
	public FindIterable<Document> getAllDocumentByCriteria(final String tenantId, final String collectionName,
			final Document criteria) {
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(tenantId);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		return mongoDatabase.getCollection(collectionName).find(criteria).noCursorTimeout(true);
	}

	/* (non-Javadoc)
	 * @see org.ramyam.pm.services.MongoServices#updateDocument(java.lang.String, java.lang.String, org.bson.Document, org.bson.Document)
	 */
	@Override
	public void updateDocument(final String tenantId, final String collectionName, final BasicDBObject criteria,
			final Document updatedDocument) {
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(tenantId);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		mongoDatabase.getCollection(collectionName).replaceOne(criteria, updatedDocument);
		//mongoDatabase.getCollection(collectionName).findOneAndUpdate(criteria, updatedDocument);
	}
	
	@Override
	public Set<String> getAllKeyInCollectionByCriteria(final String tenantId, final String collectionName,
			final Document criteria) {
		FindIterable<Document> documents = null;
		Set<String> keyList = null;
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(tenantId);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		
		if(criteria!=null){
			documents = mongoDatabase.getCollection(collectionName).find(criteria).noCursorTimeout(true).limit(1);
		}else {
			documents = mongoDatabase.getCollection(collectionName).find().noCursorTimeout(true).limit(1);
		}
		
		MongoCursor<Document> cursor = documents.iterator();
		while (cursor.hasNext()) {
		      Document doc = cursor.next();
		      keyList = doc.keySet();
		      break;
		}
		return keyList;
	}
	
	@Override
	public Document getSingelDocument(final String collectionName,final BasicDBObject criteria) {
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(tenantId);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		return mongoDatabase.getCollection(collectionName).find(criteria).noCursorTimeout(true).first();
	}
	
	@Override
	public FindIterable<Document> getAllDocument(final String collectionName,final BasicDBObject criteria) {
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(null);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		return mongoDatabase.getCollection(collectionName).find(criteria).noCursorTimeout(true);
	}
	
	@Override
	public Long getCount(final String collectionName,final BasicDBObject criteria) {
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(null);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		return mongoDatabase.getCollection(collectionName).count(criteria);
	}
	
	@Override
	public FindIterable<Document> getAllDocumentWithLimit(final String collectionName,final BasicDBObject criteria, Integer limit) {
		//final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByTenant(null);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabase();
		return mongoDatabase.getCollection(collectionName).find(criteria).noCursorTimeout(true).limit(limit);
	}
}
