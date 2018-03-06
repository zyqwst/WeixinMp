package com.sy.wechat.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sy.wechat.domain.EntityBase;
import com.sy.wechat.exceptions.DaoException;
import com.sy.wechat.exceptions.ServiceException;

public interface CommonService {
	public <T extends EntityBase> void save(T t) throws ServiceException;
	
	public <T extends EntityBase>  void update(T t) throws ServiceException;
	
	public <T extends EntityBase>  void delete(Class<T> clazz,Long id) throws ServiceException;
	
	public <T extends EntityBase> T findEntityById(Class<T> clazz,Long id) throws ServiceException;
	
	public <T extends EntityBase> T findEntity(Class<T> clazz ,String hql,List<Object> params) throws ServiceException;
	
	public<T extends EntityBase> List<T> findAll(Class<T> clazz ,String hql,List<Object> params) throws ServiceException;
	
	public <T extends EntityBase> void updateByHql(Class<T> clazz, String hql, List<Object> params) throws ServiceException;
	public <T extends EntityBase> Page<T> findPage(Class<T> clazz, String hql, List<Object> params, Pageable pageable)
			throws ServiceException;
	
	public <T extends EntityBase> Double getSum(Class<T> clazz,String field,String hql,List<Object> params) throws ServiceException;
	public <T extends EntityBase> long count(Class<T> clazz,String hql,  List<Object> params) throws ServiceException;
	public <T extends EntityBase> long countBySql(String sql,  List<Object> params) throws ServiceException;
	public <T extends Object> List<T> findAllBySql(Class<T> clazz,String sql,List<Object> params) throws ServiceException;
	
	public <T extends Object> T findEntityBySql(Class<T> clazz,String sql,List<Object> params) throws ServiceException;
	
	public <T extends Object> Page<T> findPageBySql(Class<T> clazz,String sql,List<Object> params,Pageable pageable) throws ServiceException;
	public <T extends EntityBase> void detach(T t) throws DaoException;
}
