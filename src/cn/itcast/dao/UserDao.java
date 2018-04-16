package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao extends BaseDao<User>{
	//根据用户登录名称查用户对象
	User getByUserCode(String userCode);
}
