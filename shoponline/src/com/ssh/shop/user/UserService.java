package com.ssh.shop.user;

import org.springframework.transaction.annotation.Transactional;



import com.ssh.shop.utils.MailUtils;
import com.ssh.shop.utils.UUIDUtils;

/**
 * 用户模块中的业务层代码：
 * 注入userDao
 *
 * 
 * 
 * */
/*业务层开启事物*/
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
     /**
      * 
      * 业务层注册用户
     * @throws Exception 
      * 
      * **/
	public void regist(User user) throws Exception {
		//保存用户
		user.setState(0);  //0表示未激活，1表示激活
		String code= UUIDUtils.getUUID();
		user.setCode(code);   //传入验证码
		userDao.save(user);
		//发送邮件
		MailUtils.sendMail(user.getEmail(), code);  //发送邮件，即用户的注册邮箱
		
	}
	
	/*
	 * 
	 * 业务层根据激活码来查找用户
	 * 
	 * */
	public User findByCode(String code) {
		return userDao.findByCode(code);

	}
	public void update(User existUser) {
		
		userDao.update(existUser);
	}
	
	public User login(User user) {
		return userDao.login(user);
	}
	public User findByUserName(String username) {
		
		return userDao.findByUserName(username);
	}
	
}
