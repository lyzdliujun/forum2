package com.forum.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.service.UserService;
import com.forum.untils.ForumUntils;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/register/",method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam("tel") String tel,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			Map<String,Object> resultMap = userService.register(tel,password);
			if(resultMap.containsKey("ticket")) {
				// 页面端返回ticket
				Cookie cookie = new Cookie("ticket", resultMap.get("ticket").toString());
				// 设置有效时间
				cookie.setMaxAge(60*24*12);
				cookie.setPath("/");
				response.addCookie(cookie);
				return ForumUntils.toJsonString(200, resultMap);
			}else {
				return ForumUntils.toJsonString(500, resultMap);
			}
		} catch (Exception e) {
			return ForumUntils.toJsonString(500, "注册失败!");
		}
	}
	
	@RequestMapping(path="/login/",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("tel") String tel,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			Map<String,Object> resultMap = userService.register(tel,password);
			if(resultMap.containsKey("ticket")) {
				// 页面端返回ticket
				Cookie cookie = new Cookie("ticket", resultMap.get("ticket").toString());
				// 设置有效时间
				cookie.setMaxAge(60*24*12);
				cookie.setPath("/");
				response.addCookie(cookie);
				return ForumUntils.toJsonString(200, resultMap);
			}else {
				return ForumUntils.toJsonString(500, resultMap);
			}
		} catch (Exception e) {
			return ForumUntils.toJsonString(500, "注册失败!");
		}
	}
	
	
}
