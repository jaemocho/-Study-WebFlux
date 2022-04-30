package com.cos.myflux;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {
	
	@Autowired
	private EventNotify eventNotify;
	
	@Bean
	public FilterRegistrationBean<Filter> addFilter(){
		
		System.out.println("Regist Filter Config");
		
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter(eventNotify));
		//bean.addUrlPatterns("/*");
		bean.addUrlPatterns("/sse");
		
		return bean;
	}
	
	
	@Bean
	public FilterRegistrationBean<Filter> addFilterSSE(){
		
		System.out.println("Regist Filter Config");
		
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilterSSE(eventNotify));
		//bean.addUrlPatterns("/*");
		bean.addUrlPatterns("/add");
		
		return bean;
	}
	
}
