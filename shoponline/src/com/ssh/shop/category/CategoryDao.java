package com.ssh.shop.category;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CategoryDao extends HibernateDaoSupport {
    
	//dao层的查询一级分类的所有
	public List<Category> findAll() {
		
		return this.getHibernateTemplate().find("from Category");
	}

}
