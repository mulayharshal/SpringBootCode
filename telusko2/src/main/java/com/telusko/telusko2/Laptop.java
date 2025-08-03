package com.telusko.telusko2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Laptop implements Computer{
	public void compile() {
		System.out.println("comipling with 404 Buges laptop ");;
	}

}
