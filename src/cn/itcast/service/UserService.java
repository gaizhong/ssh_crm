package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	
	User getUserBypassword(User user);
	void save(User user);

}
