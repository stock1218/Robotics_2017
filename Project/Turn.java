import lejos.robotics.subsumption.Behavior;

public class Turn implements Behavior {
	//light sensor - black = 30, white = 50
	//colour sensor colour id - white = 6, black = 7
	//left hand side is colour sensor, right is light sensor
	//implement method to ensure it knows which way to rotate
	public void action() {
		System.out.println("turn");
		//functionality to straighten robot up
		if ((Main.ls.readValue()<40)&&(Main.cs.getColorID()!=7)) {
			do {
				Main.pilot.rotate(10);
			} while (Main.cs.getColorID()!=7);
		}
		else if ((Main.ls.readValue()>40)&&(Main.cs.getColorID()==7))
			do {
				Main.pilot.rotate(-10);
			} while (Main.ls.readValue()>40);
		
		//make the robot turn round 
		Main.pilot.travel(120);
		Main.pilot.arc(50, 250);
		//check to ensure robot is straight before it proceeds
		if ((Main.ls.readValue()>40)&&(Main.cs.getColorID() ==7)) { //right side behind
			do {
				Main.pilot.rotate(-10);
			} while (Main.ls.readValue()>40);
		}
		else if ((Main.ls.readValue()<40)&&(Main.cs.getColorID()!=7)) { //left side behind
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
