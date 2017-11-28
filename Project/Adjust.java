import lejos.robotics.subsumption.Behavior;


public class Adjust implements Behavior {
	//light sensor - black = 30, white = 50
	//colour sensor colour id - white = 6, black = 7
	//left hand side is colour sensor, right is light sensor
	public void action() {
		System.out.println("turn");
		if ((testtt.ls.readValue()<40)&&(testtt.cs.getColorID()!=7)) {
				testtt.pilot.travel(-15);
				testtt.pilot.rotate(5);
				testtt.pilot.travel(15);
		}
		else if ((testtt.ls.readValue()>40)&&(testtt.cs.getColorID()==7))
				testtt.pilot.travel(-15);
				testtt.pilot.rotate(-5);
				testtt.pilot.travel(15);
	}
	public void suppress() {
		
	}	
	public boolean takeControl() {
		return (
				(testtt.ls.readValue()<40) && (testtt.cs.getColorID() != 7)
					||
				(testtt.ls.readValue()>40) && (testtt.cs.getColorID() == 7)
				);
//		return true;
	}

}
