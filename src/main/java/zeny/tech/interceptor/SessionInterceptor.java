package zeny.tech.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import zeny.tech.model.User;
import zeny.tech.util.FilterUrlsUtil;
import zeny.tech.util.SystemContext;

public class SessionInterceptor implements HandlerInterceptor{

	private Logger logger = Logger.getLogger(SessionInterceptor.class);  
	
	@Autowired
	private FilterUrlsUtil filterUrlsUtil;
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		SystemContext.removeUser();
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if(user != null){
			logger.info("----------------------------------------------------------");
			logger.info(JSON.toJSONString(user));
			logger.info("----------------------------------------------------------");
			SystemContext.setUser(user);
			return true;
		}else{
			String requestURI = request.getRequestURI();
			String[] urls = filterUrlsUtil.getUrls();
			for (String url : urls) {
				if(requestURI.equals(url)){
					return true;
				}
			}
			response.setStatus(HttpStatus.FORBIDDEN.value());
			return false;
		}
	}

}
