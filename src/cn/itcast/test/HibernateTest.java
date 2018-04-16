package cn.itcast.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Test
	public void fun1(){
		Configuration cgf=new Configuration().configure();
		SessionFactory sessionFactory = cgf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="from User  ";
		User user=new User();
		user.setUser_code("Linda");
		user.setUser_password("233");
		user.setUser_name("怜星");
//		Query query = session.createQuery(hql);
//		List list = query.list();
//		System.out.println(list);
		session.save(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	
	@Test
	public  void fun2(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="from User  ";
		User user=new User();
		user.setUser_code("Linda");
		user.setUser_password("233");
		user.setUser_name("love");
//		Query query = session.createQuery(hql);
//		List list = query.list();
//		System.out.println(list);
		session.save(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	@Resource(name="userDao")
	UserDao userDao;
	@Test
	public  void fun3(){
		User user = userDao.getByUserCode("rose");
		System.out.println(user);
	}
	
	
	@Resource(name="userService")
	UserService userService;
	@Test
	public  void fun4(){
		User user=new User();
		user.setUser_code("雪茹");
		user.setUser_password("233");
		user.setUser_name("love");
		userService.save(user);
		
	}
}





