package devices;

public class Device {
	private int battery = 100;

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	public void displayBattery(String device){
		System.out.println("The Battery of this device is" + getBattery());
		
	}

}
