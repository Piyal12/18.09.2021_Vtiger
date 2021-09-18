package com.crm.comcast.GenericUtility;

/**
 * this class contains java specific utility
 * @author PIYAL
 */

import java.util.Random;

public class JavaUtility {
	/**
	 * this method generates random number
	 * 
	 * @return INT
	 */
	public static int getRandomNum() {
		Random ran = new Random();
		int randomNum = ran.nextInt(1000);
		return randomNum;
	}

}