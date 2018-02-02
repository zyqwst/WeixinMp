package com.albert.wechat.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.albert.wechat.domain.EntityBase;
import com.albert.wechat.exceptions.DaoException;
import com.albert.wechat.exceptions.ServiceException;

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
	public <T extends EntityBase> List<T> findAllBySql(Class<T> clazz,String sql,List<Object> params) throws ServiceException;
	
	public <T extends EntityBase> T findEntityBySql(Class<T> clazz,String sql,List<Object> params) throws ServiceException;
	
	public <T extends EntityBase> Page<T> findPageBySql(Class<T> clazz,String sql,List<Object> params,Pageable pageable) throws ServiceException;
	public <T extends EntityBase> void detach(T t) throws DaoException;
}
