package com.ssh.shop.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * 
 * userDao层的代码
 * 
 * */
public class UserDao extends HibernateDaoSupport {

	/*
	 * 
	 * dao层用来保存用户的代码
	 * 
	 * **/
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	
	}
	/*
	 * 
	 * dao层根据激活码查询用户
	 * 
	 * **/
	public User findByCode(String code) {
		List<User> list =this.getHibernateTemplate().find("from User where code = ?",code);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}
	/*
	 * userDao层修改
	 * 
	 * 
	 * ***/
	public void update(User existUser) {
		
		this.getHibernateTemplate().update(existUser);
	}
	
	public User login(User user) {
		//查询用户,sql语句出现了
		List<User> list = this.getHibernateTemplate().find("from User where username = ? and password= ? and state = ?",user.getUsername(),user.getPassword(),1);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}
	public User findByUserName(String username) {
		List<User> list = this.getHibernateTemplate().find("from User where username = ?",username);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}
}
