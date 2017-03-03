package com.ssh.shop.product;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.shop.category.Category;
import com.ssh.shop.category.CategoryService;

public class ProductAction extends ActionSupport  {
	//接收cid
	private Integer cid;
	//注入一级分类的service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	  
	//查询商品的方法
	public String findByCid(){
		//查询所有一级分类
		List<Category> categoryList = categoryService.findAll();
		//获得值栈,存储该集合
		ActionContext.getContext().getValueStack().set("categoryList", categoryList);;
		return "findByCidSuccess";
	}
}
