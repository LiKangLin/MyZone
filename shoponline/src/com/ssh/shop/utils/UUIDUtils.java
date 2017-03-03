package com.ssh.shop.utils;

import java.util.UUID;

/*
 * 
 * 生成激活码
 * 
 * 
 * ***/
public class UUIDUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");  //由于生成的验证码，中间会有横杠，因此用空格代替
	}
}
