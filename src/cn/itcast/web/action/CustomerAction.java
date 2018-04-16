package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.User;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService customerService;
	private Integer currentPage;
	private Integer pageSize;
	Customer customer=new Customer();
	public String love() throws Exception {
		return SUCCESS;
	}

	

	
	public String list(){
		//封装离线查询对象
		//判断并封装名字模糊查询对象
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		//调用service查询分页数据  pagebean
		//将pagebean放入request域 转发到页面
		PageBean pb=customerService.getPagebean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	@Override
	public Customer getModel() {
		return customer;
	}




	public CustomerService getCustomerService() {
		return customerService;
	}




	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}




	public Integer getCurrentPage() {
		return currentPage;
	}




	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}




	public Integer getPageSize() {
		return pageSize;
	}




	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	
	
	
	

}
