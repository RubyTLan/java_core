package com.tian.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		super();
		this.setEnergyLevel(300);
	}
	
	public Bat fly(){
		System.out.println("SOUND");
		this.setEnergyLevel(this.getEnergyLevel()-50);
		return this;
		
	}
	public Bat eatHumans(){
		System.out.println("NVM!");
		this.setEnergyLevel(this.getEnergyLevel()+25);
		return this;
		
	}
	public Bat attackTown(){
		System.out.println("SOUND");
		this.setEnergyLevel(this.getEnergyLevel()-100);
		return this;
		
	}

}
