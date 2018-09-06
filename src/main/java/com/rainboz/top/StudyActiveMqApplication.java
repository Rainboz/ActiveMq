package com.rainboz.top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.rainboz.top.rainboz_top.dao")
public class StudyActiveMqApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StudyActiveMqApplication.class, args);
	}
}
