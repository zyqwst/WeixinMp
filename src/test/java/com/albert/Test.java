/**
 * 
 */
package com.albert;

/** 
* @ClassName: Test 
* @Description: 
* @author albert
* @date 2018年2月2日 下午4:57:38 
*  
*/
public class Test {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String s = "select * from t where name= ? ";
		System.out.println("select count(1) "+s.substring(s.indexOf("from")));
	}
	    

}
