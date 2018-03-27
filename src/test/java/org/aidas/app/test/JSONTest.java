package org.aidas.app.test;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTest {

	public static void main(String[] args) throws Exception {

		JSONObject json = new JSONObject(IOUtils.toString(new FileInputStream("E:/Test/nested.txt"), "UTF-8"));
		/*Object obj=JSONValue.parse(IOUtils.toString(new FileInputStream("E:/Test/nested.txt"), "UTF-8"));
		JSONObject json = (JSONObject) obj;*/
		System.out.println(getDataFromJson(json, "GetCustExpResponse").toString());
		
	}
	
	public static Object getDataFromJson(JSONObject inputJsonObject, String searchedKey) throws Exception {
		if(inputJsonObject.has(searchedKey)){
			return inputJsonObject.get(searchedKey);
		}else{
			Iterator<?> keys = inputJsonObject.keys();
	        while( keys.hasNext() ) {
	        	 String key = (String)keys.next();
				Object subElementJson = inputJsonObject.get(key);
				if(searchedKey.equals(key))
					return subElementJson;
				
				if (subElementJson instanceof JSONArray) {
					JSONArray jsonArray = (JSONArray) subElementJson;
					for (int i = 0; i < jsonArray.length(); i++) {
						Object dataObject = jsonArray.get(i);
						if (dataObject instanceof JSONObject) {
							Object obj = getDataFromJson((JSONObject)dataObject, searchedKey);
							if(obj != null)
								return obj;
						}
					}
				} else if (subElementJson instanceof JSONObject) {
					Object obj = getDataFromJson((JSONObject)subElementJson, searchedKey);
					if(obj != null)
						return obj;
				}
	        }
		}
	    return null;
	}
	
	/*public static boolean checkExists(JSONObject  inputJsonObject, String searchedKey){
		Iterator<?> keys = inputJsonObject.keys();
		while (keys.hasNext()) {
			String nodeType = (String) keys.next();
			
			Object subElementJson = inputJsonObject.get(nodeType);
			if(subElementJson instanceof JSONArray){
				JSONArray jsonArray = (JSONArray)subElementJson;
				for (int i = 0; i < jsonArray.length(); i++) {
					Object dataObject = jsonArray.get(i);
					if(dataObject instanceof JSONObject)
						processNode(dataObject, workFlowModel, nodeType, sequenceFlowObject, boundaryEventAttachedRefMap, user);
				}
			}else if(subElementJson instanceof JSONObject){
				processNode(subElementJson, workFlowModel, nodeType, sequenceFlowObject, boundaryEventAttachedRefMap, user);
			}
		}
	}
	
	public static boolean keyExists(JSONObject  object, String searchedKey) {
	    boolean exists = object.has(searchedKey);
	    if(!exists) {      
	        Iterator<?> keys = object.keys();
	        while( keys.hasNext() ) {
	            String key = (String)keys.next();
	            if(subElementJson instanceof JSONArray){
					JSONArray jsonArray = (JSONArray)subElementJson;
					for (int i = 0; i < jsonArray.length(); i++) {
						Object dataObject = jsonArray.get(i);
						if(dataObject instanceof JSONObject)
							processNode(dataObject, workFlowModel, nodeType, sequenceFlowObject, boundaryEventAttachedRefMap, user);
					}
				}else if ( object.get(key) instanceof JSONObject ) {
	                    exists = keyExists(object.get(key), searchedKey);
	            }
	        }
	    }
	    return exists;
	}*/


}
