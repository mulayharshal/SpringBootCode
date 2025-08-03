package com.telusko.telusko2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class Telusko2Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Telusko2Application.class, args);
		Dev obj=context.getBean(Dev.class);
		obj.bulid();
	}

}
