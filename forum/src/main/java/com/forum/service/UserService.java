package com.forum.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.LoginTicketDao;
import com.forum.dao.UserDao;
import com.forum.entity.LoginTicket;
import com.forum.entity.User;
import com.forum.untils.ForumUntils;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	LoginTicketDao loginTicketDao;

	public Map<String, Object> register(String tel, String password) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(tel == null || "".equals(tel)) {
			map.put("tel", "手机号不能为空！");
			return map;
		}
		if(tel.length() != 11) {
			map.put("tel", "手机号不对！");
			return map;
		}
		if(password == null || "".equals(password)) {
			map.put("password", "手机号不能为空！");
			return map;
		}
		if(password.length() < 6) {
			map.put("password", "密码不能小于6位！");
			return map;
		}
		User user = userDao.getUserByTel(tel);
		if(user != null) {
			map.put("tel", "手机号已注册！");
			return map;
		}
		user = new User();
		String salt = ForumUntils.getRandomUUID().substring(0, 6);
		user.setSalt(salt);
		//对原密码进行加密  很难被破解了
		user.setPassword(ForumUntils.MD5(password) + salt);
		user.setTel(tel);
		//map.put("添加成功！", user);
		userDao.addUser(user);
		// 调用下面的封装令牌方法
		String addTicket = addTicket(tel);
		map.put("ticket", addTicket);
		map.put("message", "注册成功！");
		return map;
	}
	
	public Map<String, Object> login(String tel, String password) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(tel == null || "".equals(tel)) {
			map.put("tel", "手机号不能为空！");
			return map;
		}
		if(tel.length() != 11) {
			map.put("tel", "手机号不对！");
			return map;
		}
		if(password == null || "".equals(password)) {
			map.put("password", "手机号不能为空！");
			return map;
		}
		if(password.length() < 6) {
			map.put("password", "密码不能小于6位！");
			return map;
		}
		User user = userDao.getUserByTel(tel);
		if(user == null) {
			map.put("tel", "手机号未注册！");
			return map;
		}
		// 判断页面输入的password加salt 与数据库的加salt的密码做比较
		if(!user.getPassword().equals(ForumUntils.MD5(password + user.getSalt()))) {
			map.put("password", "密码输入错误！");
			return map;
		}
		LoginTicket loginTicket = loginTicketDao.getLoginTicketByTel(tel);
		updateLoginTicketStatus(tel,0);
		updateLoginTicketExpired(tel);
		map.put("ticket", loginTicket);
		
		return map;
	}
	
	// 更新状态
	private void updateLoginTicketStatus(String tel,Integer status) {
		loginTicketDao.updateLoginTicket(tel,status);
	}
	// 更新有效时间
	private void updateLoginTicketExpired(String tel) {
		long expired = new Date().getTime() + 1000*3600*24*10;
		Date date = new Date(expired);
		loginTicketDao.updateLoginTicketExpired(tel,date);
	}
	
	
	
	// 定义封装一个方法，对tel的加令牌
	private String addTicket(String tel) {
		// 令牌值
		String ticket = ForumUntils.getRandomUUID();
		//设置登陆有效期  10天
		long expired = new Date().getTime() + 1000*3600*24*10;
		LoginTicket loginTicket = new LoginTicket();
		loginTicket.setTel(tel);
		loginTicket.setTicket(ticket);
		loginTicket.setExpired(new Date(expired));
		loginTicketDao.addLoginTicketr(loginTicket);
		return ticket;
	}
	

}
