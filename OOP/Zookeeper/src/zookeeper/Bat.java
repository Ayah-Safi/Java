package zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		energyLevel = 300;
	}
	
	public void fly(){
		energyLevel -= 50;
		System.out.println("The bat is airborn, the remaining energy level is: "+ energyLevel);
	}
	
	public void eatHumans() {
		energyLevel += 25;
		System.out.println("The bat ate a human, the energy level is: "+ energyLevel);
	}
	
	public void attackTown() {
		energyLevel -= 100;
		System.out.println("The bat attacke a town, the remaining energy level is: "+ energyLevel);
	}

	

}
