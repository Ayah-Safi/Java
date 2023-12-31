package devices;

public class Phone extends Device{
	private String criticalMessage = "Remaining Battery is less than 10%";
	
	public String getCriticalMessage() {
		return criticalMessage;
	}

	public void setCriticalMessage(String criticalMessage) {
		this.criticalMessage = criticalMessage;
	}

	public void makeCall() {
		int newBattery = this.getBattery()  - 5;
		this.setBattery(newBattery);
		if (newBattery < 10) {
			System.out.println(criticalMessage);
		}
		System.out.println("Make a Call, the remaining battery life is: " + getBattery());
		
	}
	
	public void playGame() {
		int battery = this.getBattery();
		if (battery < 25) {
			System.out.println("remaining phone battery is less than 25, please charge first");
		}
		else {
			int newBattery = this.getBattery()  - 20;
			this.setBattery(newBattery);
			if (newBattery < 10) {
				System.out.println(criticalMessage);
			}
		}
		
		
		System.out.println("Play a Game, the remaining battery life is: " + getBattery());
		
	}
	
	public void chargePhone() {
		int newBattery = this.getBattery()  + 50;
		this.setBattery(newBattery);
		System.out.println("Charge the Phone, the remaining battery life is: " + getBattery());
		
	}

}
