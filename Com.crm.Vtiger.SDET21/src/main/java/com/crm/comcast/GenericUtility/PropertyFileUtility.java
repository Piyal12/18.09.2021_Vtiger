package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this class contains generic methods
 * 
 * @author PIYAL
 *
 */

public class PropertyFileUtility {
	public void getPropertyFileData() throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);

	}
}
