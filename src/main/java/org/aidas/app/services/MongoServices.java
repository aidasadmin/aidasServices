package org.aidas.app.services;

import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;

/**
 * The Interface MongoServices.
 */
public interface MongoServices {

	/**
	 * Gets the all collections.
	 *
	 * @param tenantId the tenant id
	 * @return the all collections
	 */
	List<String> getAllCollections(String tenantId);

	/**
	 * Does collection exists.
	 *
	 * @param tenantId the tenant id
	 * @param collectionName the collection name
	 * @return true, if successful
	 */
	boolean doesCollectionExists(String tenantId, String collectionName);

	/**
	 * Gets the all document by criteria.
	 *
	 * @param tenantId the tenant id
	 * @param collectionName the collection name
	 * @param criteria the criteria
	 * @return the all document by criteria
	 */
	FindIterable<Document> getAllDocumentByCriteria(String tenantId, String collectionName, Document criteria);

	/**
	 * Update document.
	 *
	 * @param tenantId the tenant id
	 * @param collectionName the collection name
	 * @param criteria the criteria
	 * @param updatedDocument the updated document
	 */
	void updateDocument(String tenantId, String collectionName, BasicDBObject criteria, Document updatedDocument);

	Set<String> getAllKeyInCollectionByCriteria(String tenantId, String collectionName, Document criteria);

	Document getSingelDocument(String collectionName, BasicDBObject criteria);

	FindIterable<Document> getAllDocument(String collectionName, BasicDBObject criteria);

	Long getCount(String collectionName, BasicDBObject criteria);
	
	FindIterable<Document> getAllDocumentWithLimit(String collectionName, BasicDBObject criteria, Integer limit);
}
