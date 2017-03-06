package zeny.tech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zeny.tech.model.InnerUser;
import zeny.tech.model.User;
import zeny.tech.util.SystemContext;

@Controller
public class TestController {
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "onLogin", method = RequestMethod.POST)
	public @ResponseBody InnerUser onLogin(@RequestParam String userName, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
		InnerUser innerUser = new InnerUser();
		request.getSession().setAttribute("user", innerUser);
		logger.info("==========================================================");
		logger.info(JSON.toJSONString(innerUser));
		logger.info("==========================================================");
		return innerUser;
	}
	@RequestMapping(value = "onLogin2", method = RequestMethod.POST)
	public @ResponseBody User onLogin2(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().setAttribute("user", user);
		
		logger.info("==========================================================");
		logger.info(JSON.toJSONString(user));
		logger.info("==========================================================");
		return user;
	}
	@RequestMapping(value = "testGet", method = RequestMethod.GET)
	public @ResponseBody String testGet(String userName) {
		logger.info("==========================================================");
		logger.info(userName);
		logger.info("==========================================================");
		
		User currentUser = SystemContext.getCurrentUser();
		
		logger.info("##########################################################");
		logger.info(JSON.toJSONString(currentUser));
		logger.info("##########################################################");
		
		return userName;
	}
	
	@RequestMapping(value = "loginOut", method = RequestMethod.GET)
	public @ResponseBody String loginOut(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();
		return "ok";
	}
}
