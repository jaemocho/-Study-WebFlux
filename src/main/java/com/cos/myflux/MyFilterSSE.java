package com.cos.myflux;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class MyFilterSSE implements Filter{
	
	@Autowired
	private EventNotify eventNotify;
	
	public MyFilterSSE(EventNotify eventNotify) {
		this.eventNotify = eventNotify;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("excute SSE filter");
	
		eventNotify.add("new Data");
		
	}

}
