package com.luxton.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserCheckInterceptor implements HandlerInterceptor {

	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse res, Object arg2) throws Exception {
		
		String userId = (String)request.getSession().getAttribute("userId");
		
		System.out.println("-----------"+userId);
		
		if(StringUtils.isBlank(userId)){
			res.sendRedirect("http://luxma.helpyoulove.com/user/relogin/432");
		}
		
		return true;
	}

}
