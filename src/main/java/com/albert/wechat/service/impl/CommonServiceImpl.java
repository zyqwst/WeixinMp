package com.albert.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.albert.wechat.domain.EntityBase;
import com.albert.wechat.exceptions.DaoException;
import com.albert.wechat.exceptions.ServiceException;
import com.albert.wechat.reponsitory.CommonDao;
import com.albert.wechat.service.CommonService;

@Service
@Transactional
public class CommonServiceImpl implements CommonService{
	@Resource
	private  CommonDao  commonDao;

	@Override
	public <T extends EntityBase> void save(T t) throws ServiceException {
		commonDao.save(t);
	}

	@Override
	public <T extends EntityBase> void update(T t) throws ServiceException {
		commonDao.update(t);
	}

	@Override
	public <T extends EntityBase>  void delete(Class<T> clazz,Long id) throws ServiceException {
		commonDao.deleteById(clazz, id);
	}

	@Override
	public <T extends EntityBase> T findEntityById(Class<T> clazz, Long id) throws ServiceException {
		return commonDao.findEntityById(clazz, id);
	}

	@Override
	public <T extends EntityBase> T findEntity(Class<T> clazz ,String hql, List<Object> params) throws ServiceException {
		return commonDao.findEntity(clazz, hql, params);
	}

	@Override
	public <T extends EntityBase> List<T> findAll(Class<T> clazz, String hql, List<Object> params)
			throws ServiceException {
		return commonDao.findAll(clazz, hql, params);
	}

	@Override
	public <T extends EntityBase>void updateByHql(Class<T> clazz, String hql, List<Object> params)
			throws ServiceException {
		commonDao.update(clazz, hql, params);
	}

	@Override
	public <T extends EntityBase> Page<T> findPage(Class<T> clazz, String hql, List<Object> params, Pageable pageable)
			throws ServiceException {
		return commonDao.findPage(clazz, hql, params, pageable);
	}

	@Override
	public <T extends EntityBase> Double getSum(Class<T> clazz,  String field,String hql,List<Object> params) throws ServiceException {
		return commonDao.getSum(clazz, field, hql, params);
	}

	@Override
	public <T extends EntityBase> List<T> findAllBySql(Class<T> clazz, String sql,List<Object> params) throws ServiceException {
		return commonDao.findAllBySql(clazz, sql,params);
	}

	@Override
	public <T extends EntityBase> T findEntityBySql(Class<T> clazz, String sql, List<Object> params)
			throws ServiceException {
		return commonDao.findEntityBySql(clazz, sql, params);
	}

	@Override
	public <T extends EntityBase> Page<T> findPageBySql(Class<T> clazz, String sql, List<Object> params,
			Pageable pageable) throws ServiceException {
		return commonDao.findPageBySql(clazz, sql, params, pageable);
	}

	@Override
	public <T extends EntityBase> long count(Class<T> clazz, String hql, List<Object> params) throws ServiceException {
		return commonDao.count(clazz, hql, params);
	}

	@Override
	public <T extends EntityBase> long countBySql(String sql, List<Object> params) throws ServiceException {
		return commonDao.countBySql(sql, params);
	}
	public <T extends EntityBase> void detach(T t) throws DaoException{
		commonDao.detach(t);
	}
}
