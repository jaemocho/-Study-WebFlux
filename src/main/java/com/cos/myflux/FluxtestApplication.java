package com.cos.myflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluxtestApplication {

	//webflux 를 유사하게 구현해본 
	//사용자가 들어올 때마다 thread 생성 -> webflux 는 단일 thread가 여러 event를 동시에 response 가능  
	// http://localhost:8080/sse
	// http://localhost:8080/add
	public static void main(String[] args) {
		SpringApplication.run(FluxtestApplication.class, args);
	}

}
