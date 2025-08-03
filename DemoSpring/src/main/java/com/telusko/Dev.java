package com.telusko;


public class Dev {

	private Computer comp;

	private int age;

	public Dev(){
		System.out.println("dev constructor");
	}

	public void build() {
		System.out.println("working on project");
		comp.compile();
	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Computer getComp() {
		return comp;
	}

	public void setComp(Computer comp) {
		this.comp = comp;
	}
}
