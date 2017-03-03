package com.ssh.shop.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	//struts中模型驱动使用的类
	private User user = new User();
	//注入service方法
	private UserService userService;
	//存储验证码
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	/**
	 * 
	 * 由首页转到注册 的页面
	 * 
	 * */
	public String registPage(){
		
		return "registPageSuccess";
	}
	
   /**
    * 注册成功后的跳转
 * @throws Exception 
    * 
    * 
    * */
	/*此时moder中已存有user的数据，数据库中开始添加数据*/
	//采用注解，由于通过后台校验，若返回错误信息，都会直接用input，导致登陆与注册重复，使用注解区分开
	@InputConfig(resultName="registInput")
	public String regist() throws Exception{
		
		//从session中获得存储的验证码，由于之前的生成验证码的程序，已经存在session中,equalsIgnoreCase该方法的比对，是忽略大小写的
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(checkcode == null || !checkcode1.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码错误");
			return "registInput";
		}
		userService.regist(user);
		
		this.addActionMessage("注册成功,请去邮箱进行激活");   //在页面上显示信息
		return "registSuccess";
	}
	
	/*
	 * 进行激活页面代码
	 * 
	 * **/
	public String active(){
		// 根据激活码查询用户
				User existUser = userService.findByCode(user.getCode());
				if(existUser != null){
					// 根据激活码查询到这个用户.
					existUser.setState(1);
					// 修改用户的状态
					userService.update(existUser);
					// 添加信息:
					this.addActionMessage("激活成功!请去登录!");
					return "activeSuccess";
				}else{
					this.addActionMessage("激活失败!激活码有误!");
					return "activeSuccess";
				}
		
	}
	
	//跳转到登陆页面
	public String loginPage(){
		return "loginPageSuccess";
	}
	//登陆功能
	@InputConfig(resultName="loginInput")
	public String login(){
		//从session中获得存储的验证码，由于之前的生成验证码的程序，已经存在session中,equalsIgnoreCase该方法的比对，是忽略大小写的
				String checkcode2 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
				if(checkcode == null || !checkcode.equalsIgnoreCase(checkcode2)){
					this.addActionError("验证码错误");
					return "loginInput";
				}
		User existUser = userService.login(user);
		if(existUser == null){
			// 登录失败
			this.addActionError("用户名或密码错误或用户未激活!");
			return "loginInput";
		}else{
			//存到session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}
		
	}
	/**前台检验用户名**/
	public String checkUserName() throws IOException{
		User existUser = userService.findByUserName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(existUser == null){
			// 用户名可以使用的
			response.getWriter().print("<font color='green'>用户名可以使用</font>");
		}else{
			// 用户名已经存在
			response.getWriter().print("<font color='red'>用户名已经存在</font>");
		}
		return NONE;
	}
	
	/**
	 * 用户退出的方法
	 * 
	 * */
	 public String logOut(){
		 //获得用户的session
		 //销毁用户的session
		 ServletActionContext.getRequest().getSession().invalidate();
		 return "logOutSuccess";
	 }
}

