package com.ssh.shop.category;

import java.util.HashSet;
import java.util.Set;




/**
 * 一级分类的实体类
 * */
public class Category {
	private Integer cid;
	private String cname;
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
