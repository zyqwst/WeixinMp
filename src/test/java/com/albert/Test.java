/**
 * 
 */
package com.albert;

import me.chanjar.weixin.common.util.crypto.SHA1;

/** 
* @ClassName: Test 
* @Description: 
* @author albert
* @date 2018年2月2日 下午4:57:38 
*  
*/
public class Test {
	public static void main(String[] args) {
		//f3df4e03f814dda5412eadaf046860ec02393a39
		//6318c986887d13fe91546ba1c162ab36d811e10e
		
		String s = SHA1.gen("adminC4CA4238A0B923820DCC509A6F75849B1517561824745");
		System.out.println(s);
	}
}
