package com.cos.myflux;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter{
	
	private EventNotify eventNotify;
	
	public MyFilter(EventNotify eventNotify) {
		this.eventNotify = eventNotify;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("excute filter");
		
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		//servletResponse.setContentType("text/plain; charset=utf-8");  // 5초가 지난뒤에 한번에 display
		servletResponse.setContentType("text/event-stream; charset=utf-8"); // event-stream event를 계속 주어 발생시 마다 display  
		

 		
		PrintWriter out = servletResponse.getWriter();
		
		//1. Reactive Streams 라이브러리를 쓰면 표준을 지켜서 응답을 할 수 있다.
		for (int i = 0; i < 5; i++) {
			out.print("응답 " + i +"\n");
			out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//2. SSE Emitter 라이브러리를 사용하면 편하게 쓸 수 있다. 
		while(true) {
			try {
				if(eventNotify.getChange()) {
					int lastIndex = eventNotify.getEvents().size()-1;
					out.print("응답 " +eventNotify.getEvents().get(lastIndex) +"\n");
					out.flush();
					eventNotify.setChange(false);
				}
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//3.WebFlux -> Reactive Streams 이 것이 적용된 stream을 배우고(비동기 단일스레드 동작)
		//4.servlet MVC -> Reactive Streams 이 것이 적용된 stream을 배우고(멀티쓰레드 방식)
	}

}
