package com.tian.zookeeper;

public class Gorilla extends Mammal {

	public Gorilla throwSomething(){
		System.out.println("gorilla thows something!");
		this.setEnergyLevel(this.getEnergyLevel()-5);
		return this;
		
	}
	public Gorilla eatBananas(){
		System.out.println("gorilla is eating banana!");
		this.setEnergyLevel(this.getEnergyLevel()+10);
		return this;
		
	}
	public Gorilla climb(){
		System.out.println("gorilla is climbing!");
		this.setEnergyLevel(this.getEnergyLevel()-10);
		return this;
		
	}

}
