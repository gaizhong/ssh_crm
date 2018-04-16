package cn.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	@Resource(name="customerDao")
	private CustomerDao cd;
	
	
	@Override
	public PageBean getPagebean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用dao查询中记录数
		int totalCount=cd.getTotalCount(dc);
		//创建pageBean对象
		PageBean pb=new PageBean(currentPage, totalCount, pageSize);
		//调用dao查询分页列表
		List<Customer> list=cd.getPageList(dc, pb.getStart(),pb.getPageSize());
		//列表数据放入pagebean中
		pb.setList(list);
		return pb;
	}


	public CustomerDao getCd() {
		return cd;
	}


	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

}









