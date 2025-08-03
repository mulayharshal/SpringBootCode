package com.telusko.Telusko1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@RequestMapping("/")
	public String greet() {
		return "Hello, this is first site build with help of telusko";
				
	}

}
