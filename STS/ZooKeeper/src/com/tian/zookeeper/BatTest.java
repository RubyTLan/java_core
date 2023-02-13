package com.tian.zookeeper;

public class BatTest {
	public static void main(String[] args) {
		Bat bat1=new Bat();
		bat1.attackTown().attackTown().attackTown().eatHumans().eatHumans().fly().fly();
		System.out.println(bat1.getEnergyLevel());
		
	}

}
