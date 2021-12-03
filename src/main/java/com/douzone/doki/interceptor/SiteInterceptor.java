package com.douzone.doki.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

//import com.douzone.doki.service.AdminService;
//import com.douzone.doki.vo.SiteVo;

public class SiteInterceptor implements HandlerInterceptor {
//	@Autowired
//	AdminService adminService;
//	
//	@Autowired
//	ServletContext servletContext;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//			SiteVo siteVo = (SiteVo) request.getServletContext().getAttribute("siteVo");
//			
//			if(siteVo == null) {
//				siteVo = adminService.getSite();
//				servletContext.setAttribute("siteVo", siteVo);
//			} 
//			
//		return true;
//	}
//	
	
}
