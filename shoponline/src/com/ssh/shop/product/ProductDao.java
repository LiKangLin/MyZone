package com.ssh.shop.product;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh.shop.utils.PageHibernateCallback;




public class ProductDao extends HibernateDaoSupport {

	public List<Product> findHot() {
		//dao层查询热门商品，并且只显示10个
	    /*  方式一
	     * DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
	    criteria.add(Restrictions.eq("is_hot", 1));
	    List<Product> list = this.getHibernateTemplate().findByCriteria(criteria,0,10); //10为首页展示的数量，0为起始点
*/		
	    //方式二，自己封装分页的方法，见utils中的方法
		List<Product> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>("from Product where is_hot=?", new Object[]{1}, 0, 10));
		return list;
	}
    //dao层查询最新商品
	public List<Product> findNew() {
	
		List<Product> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>("from Product order by pdate desc", null , 0, 10));
		return list;
	}

	

}
