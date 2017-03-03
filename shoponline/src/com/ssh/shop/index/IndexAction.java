package com.ssh.shop.index;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.shop.category.Category;
import com.ssh.shop.category.CategoryService;
import com.ssh.shop.product.Product;
import com.ssh.shop.product.ProductService;

public class IndexAction extends ActionSupport {
	//注入一级分类
	private CategoryService categoryService;
	//注入商品的service方法
	private ProductService productService;
	//获得热门商品
	private List<Product> hotList;
	//最新商品
	private List<Product> newList;
	
	
     public List<Product> getNewList() {
		return newList;
	}

	public List<Product> getHotList() {
		return hotList;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
     public String execute() throws Exception {
		//查询所有的一级分类	
		List<Category> categoryList = categoryService.findAll();
		ActionContext.getContext().getSession().put("categoryList", categoryList); //存到session中
		//查询热门商品
		hotList = productService.findHot();
		
		//查询最新商品
		newList = productService.findNew();
		
		
 		return "indexSuccess";
 	}
}
