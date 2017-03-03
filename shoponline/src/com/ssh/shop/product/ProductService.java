package com.ssh.shop.product;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ProductService {
//注入Dao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
    //业务层查询热门商品的代码
	public List<Product> findHot() {
		return productDao.findHot();
		
	}
	//业务层查询最新商品
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	
	
}
