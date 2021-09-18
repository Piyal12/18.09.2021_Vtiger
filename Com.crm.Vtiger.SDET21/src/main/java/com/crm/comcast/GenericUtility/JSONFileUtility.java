package com.crm.comcast.GenericUtility;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/*
 * this class contains methods tpo read data from json file 
 * @autor PIYAL
 */

public class JSONFileUtility {
	/*
	 * this method reads the data from json file
	 * 
	 * @throws throwable
	 */

	public String readDataFromJSON(String key) throws Throwable {
		// read data from json file
		FileReader file = new FileReader(IPathConstants.JsonFIlePath);
		// convert the json file into java object
		JSONParser jsonobj = new JSONParser();
		Object jobj = jsonobj.parse(file);

		// type cast java obj to hashmap
		HashMap map = (HashMap) jobj;
		String value = map.get(key).toString();

		// return the value
		return value;
	}

}
