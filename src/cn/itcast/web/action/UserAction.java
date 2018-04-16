package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	User user=new User();
	public String love() throws Exception {
		System.out.println("love");
		userService.getUserBypassword(null);
		return SUCCESS;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public String login(){
		User u = userService.getUserBypassword(user);
		//放入struts框架中的session作用域
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}
	@Override
	public User getModel() {
		return user;
	}

	
	
	

}
