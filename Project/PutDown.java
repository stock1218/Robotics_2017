import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class PutDown implements Behavior{
	public void action() {
		System.out.println("down");
		Motor.B.setSpeed(200);
		Motor.B.rotate(-180);
		Main.pilot.travel(-200);
		Main.pickUp = false;
		//Main.map[(int)Main.pp.getPose().getY()/Main.scale][(int)Main.pp.getPose().getX()/Main.scale]=1;
		Main.atBase = false;
		Main.putDown = false;
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return ((Main.atBase)||(Main.putDown));
	}
}
