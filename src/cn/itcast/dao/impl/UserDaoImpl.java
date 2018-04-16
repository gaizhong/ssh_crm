package cn.itcast.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

//HibernateDaoSupport  为Dao注入sessionFactory
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	// private HibernateTemplate ht;
	
	@Override
	public User getByUserCode(final String userCode) {
		HibernateTemplate template = this.getHibernateTemplate();
		//hql
		return template.execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql = "from User where user_code = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, userCode);
				Object result = query.uniqueResult();
				return (User) result;
			}

		});
		//Criteria
		/*DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		  dc.add(Restrictions.eq("user_code", userCode));
		List<?> userlist = template.findByCriteria(dc);
		if(userlist!=null&userlist.size()>0){
			
			return (User) userlist.get(0);
		}else{
			return null;
		}*/
	}

}
