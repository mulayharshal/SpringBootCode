package com.telusko.telusko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {
	
	@Autowired
	private Computer comp;
	
	public void bulid() {
		comp.compile();
		System.out.println("working on project");
	}

}
