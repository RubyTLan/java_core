package com.tian.zookeeper;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		this.energyLevel=100;
	}
	
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
	

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	

}
