package org.aidas.app.test;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

public class UnitTest {
	
	private static final String[] formats = { 
            "yyyy-MM-dd'T'HH:mm:ss'Z'",   "yyyy-MM-dd'T'HH:mm:ssZ",
            "yyyy-MM-dd'T'HH:mm:ss",      "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss", 
            "MM/dd/yyyy HH:mm:ss",        "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", 
            "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS", 
            "MM/dd/yyyy'T'HH:mm:ssZ",     "MM/dd/yyyy'T'HH:mm:ss", 
            "yyyy:MM:dd HH:mm:ss",        "yyyyMMdd", "MMddyyyy", 
            "ddMMyyyy", "yyyyMMddHHmmss", "yyyy/MM/dd", "dd/MM/yyyy", "MM/dd/yyyy" };

	public static void main(String[] args) throws Exception{
		
		
		//System.out.println(System.getenv(AppConstants.AIDAS_HOME));
		/*System.out.println(DateUtils.parseDateStrictly("13/03/2018", formats));
		System.out.println(DateFormatUtils.format(DateUtils.parseDateStrictly("13/03/2018", formats), "ddMMyyyy"));*/
		
		/*JSONObject json = new JSONObject();
		json.put("sessionKey", "244");
		
		System.out.println(CommonUtil.convertJsonStringToJavaObject(json.toString(), SessionKeyDTO.class));*/
		/*long start = System.currentTimeMillis();
		//System.out.println("Start: " + );
		//JsonNode node = new ObjectMapper().readTree(IOUtils.toString(new FileInputStream("E:/Test/nested.txt"), "UTF-8"));
		//System.out.println(node.toString());
		
		
		//JSONArray jsonArray = new JSONArray(IOUtils.toString(new FileInputStream("E:/Test/nested.txt"), "UTF-8"));
		//System.out.println(jsonArray.toString());
		//JSONObject json = new JSONObject(IOUtils.toString(new FileInputStream("E:/Test/nested.txt"), "UTF-8"));
		//System.out.println(json.toString());
		
		String response = IOUtils.toString(new FileInputStream("E:/Test/nested.txt"), "UTF-8");
		String searchKey = "PageList";
		
		if (StringUtils.startsWith(response, "[")) {
			JSONArray jsonArray = new JSONArray(response);
			System.out.println("ARRAY: " + getDataFromJson(jsonArray, searchKey));
		}else if (StringUtils.startsWith(response, "{")){
			JSONObject json = new JSONObject(response);
			System.out.println("JSON: " + getDataFromJson(json, searchKey));
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);*/
		Object output = getNumber("3432244");
		System.out.println(output instanceof Integer ? "Integer: " +output.toString() : "Double: " +output.toString());
	}
	
	
	public static Object getNumber(String inputString){
		try{
			if(StringUtils.isBlank(inputString))
				return 0;
			if(inputString.contains("."))
				return Double.parseDouble(inputString);
			else
				return Integer.parseInt(inputString);
		}catch(Exception e){}
		return 0;
	}
	
	public static Object getDataFromJson(Object object, String searchedKey) throws Exception {
		if(object instanceof org.json.JSONObject){
			org.json.JSONObject jsonObject = (org.json.JSONObject) object;
			if(jsonObject.has(searchedKey)){
				return jsonObject.get(searchedKey);
			}else{
				Iterator<?> keys = jsonObject.keys();
		        while( keys.hasNext() ) {
		        	 String key = (String)keys.next();
					if(searchedKey.equals(key))
						return jsonObject.get(key);
					
					Object subElementJson = jsonObject.get(key);
					if (subElementJson instanceof org.json.JSONArray) {
						org.json.JSONArray jsonArray = (org.json.JSONArray) subElementJson;
						for (int i = 0; i < jsonArray.length(); i++) {
							Object dataObject = jsonArray.get(i);
							if (dataObject instanceof org.json.JSONObject) {
								Object obj = getDataFromJson((org.json.JSONObject)dataObject, searchedKey);
								if(obj != null)
									return obj;
							}
						}
					} else if (subElementJson instanceof org.json.JSONObject) {
						Object obj = getDataFromJson((org.json.JSONObject)subElementJson, searchedKey);
						if(obj != null)
							return obj;
					}
		        }
			}
		}else if(object instanceof org.json.JSONArray){
			org.json.JSONArray jsonArray = (org.json.JSONArray) object;
			for (int i = 0; i < jsonArray.length(); i++) {
				Object dataObject = jsonArray.get(i);
				if (dataObject instanceof org.json.JSONObject) {
					Object obj = getDataFromJson((org.json.JSONObject)dataObject, searchedKey);
					if(obj != null)
						return obj;
				}
			}
		}
	    return null;
	}
	
}
