package cn.itcast.utils;

import java.util.List;

public class PageBean {
	Integer currentPage;
	Integer totalCount;
	Integer pageSize;
	Integer totalPage;
	//存储列表数据
	private List list;
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		if(this.currentPage==null){
			this.currentPage=1;
		}
		//首次进入页面为空
		if(this.pageSize==null){
			this.pageSize=3;
		}
		
		//计算总页数
		this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;
		//判断当前页数是否超出范围
		//不能小于1，不能大于中页数
		if(this.currentPage<1){
			this.currentPage=1;
			
		}
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
	}
	//计算起始索引
	public int getStart(){
		return (this.currentPage-1)*this.pageSize;
	}
	
	
	
	
	
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

}









