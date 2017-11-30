import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class PickUp implements Behavior {
	

	
	public void action() {
		System.out.println("up");
		Main.pilot.forward();
		Motor.B.setSpeed(360);
		Motor.B.rotate(140,true);
		Main.pilot.stop();
		System.out.println((int)Main.pp.getPose().getX()/50);
		System.out.println((int)Main.pp.getPose().getY()/50);
		Delay.msDelay(2000);
		Main.map[(int)Main.pp.getPose().getX()/Main.scale][(int)Main.pp.getPose().getY()/Main.scale]=0;
		Main.pickUp=true;	
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return Main.us.getDistance()<20;
	}
}
