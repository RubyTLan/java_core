package com.tian.zookeeper;

public class GorillaTest {
	public static void main(String[] args) {
		Gorilla gorilla1=new Gorilla();
		gorilla1.throwSomething().throwSomething().throwSomething().eatBananas().eatBananas().climb();
		System.out.println(gorilla1.getEnergyLevel());
		
	}

}
