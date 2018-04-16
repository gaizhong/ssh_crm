package cn.itcast.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;//用于接收运行期的泛型
	public BaseDaoImpl() {
		//获得当前带有泛型类型的父类
		ParameterizedType ptClass= (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
		
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
		
	}

	@Override
	public void delete(Serializable id) {
		T t=this.getById(id);
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		

		//设置查询的聚合函数
		dc.setProjection(Projections.rowCount());

		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		//清空查询条件，避免查询条件混合
		dc.setProjection(null);
		
		
		if(list!=null&&list.size()>0){
			Long count=list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc, start, pageSize);

	}

	

}
