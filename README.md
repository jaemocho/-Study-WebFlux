# Study-WebFlux_1
(Study)WebFlux 

메타코딩 Springboot-WebFlux

	webflux 를 유사하게 구현해본 (springboot web)
	사용자가 들어올 때마다 thread 생성 -> webflux 는 단일 thread가 여러 event를 동시에 response 가능  
	 http://localhost:8080/sse
	 http://localhost:8080/add
   
   servletResponse.setContentType("text/event-stream; charset=utf-8"); // event-stream event를 계속 주어 발생시 마다 display  
