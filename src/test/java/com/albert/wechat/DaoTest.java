/**
 * 
 */
package com.albert.wechat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;

/** 
* @ClassName: DaoTest 
* @Description: 
* @author albert
* @date 2018年2月4日 下午7:54:00 
*  
*/
public class DaoTest extends WxMpDemoApplicationTest {
	@PersistenceContext
	EntityManager em;
	@Test
	 public void test() {
		Query query = em.createNativeQuery("select name from t_member");
		List list = query.getResultList();
	     System.out.println(list);
	 }
	
	
	
}
