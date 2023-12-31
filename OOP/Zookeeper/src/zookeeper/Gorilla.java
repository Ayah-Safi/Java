package zookeeper;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		energyLevel -= 5;
		System.out.println("The gorilla thrown something, the remaining energy level is: "+ energyLevel);
	}
	
	public void eatBananas() {
		energyLevel += 10;
		System.out.println("The gorilla ate an banana, the energy level is: "+ energyLevel);
	}
	
	public void climb() {
		energyLevel -= 10;
		System.out.println("The gorilla climbed a tree, the remaining energy level is: "+ energyLevel);
	}
}
