package com.ssh.shop.category;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

//开启事务
@Transactional
public class CategoryService {
	//注入dao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}
	
}
