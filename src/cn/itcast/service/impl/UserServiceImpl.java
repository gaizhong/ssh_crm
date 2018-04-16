package cn.itcast.service.impl;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	UserDao userDao;
	@Override
	public User getUserBypassword(User user) {
		System.out.println("自动组装到struts中");
		User existU = userDao.getByUserCode(user.getUser_code());
		if(existU==null){
			throw new RuntimeException("用户名不存在");
		}
		if(!existU.getUser_password().equals(user.getUser_password())){
			throw new RuntimeException("密码错误");
		}
		return existU;
	}
	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

}
