import lejos.robotics.subsumption.Behavior;

public class Turn implements Behavior {
	//light sensor - black = 30, white = 50
	//colour sensor colour id - white = 6, black = 7
	//left hand side is colour sensor, right is light sensor
	public void action() {
		System.out.println("turn");
		if ((Main.ls.readValue()<40)&&(Main.cs.getColorID()!=7)) {
			do {
				Main.pilot.rotate(10);
			} while (Main.cs.getColorID()!=7);
		}
		else if ((Main.ls.readValue()>40)&&(Main.cs.getColorID()==7))
			do {
				Main.pilot.rotate(-10);
			} while (Main.ls.readValue()>40);
		int temp = Main.pp.getPose().getHeading();
		if (temp = 90) {
			Main.pilot.travel(120);
			Main.pilot.arc(50, 250);
		}
		else {
			Main.pilot.travel(120);
			Main.pilot.arc(-50,250);
		}
		if ((Main.ls.readValue()>40)&&(Main.cs.getColorID() ==7)) { 
			do {
				Main.pilot.rotate(-10);
			} while (Main.ls.readValue()>40);
		}
		else if ((Main.ls.readValue()<40)&&(Main.cs.getColorID()!=7)) { 
			do {
				Main.pilot.rotate(10);
			} while (Main.cs.getColorID()!=7);
		}
	}
	public void suppress() {
		
	}	
	public boolean takeControl() {
		return (Main.ls.readValue()<40|Main.cs.getColorID()==7);
	}

}

