import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class PutDown implements Behavior{
	public void action() {
		System.out.println("down");
		Main.pilot.backward();
		Motor.B.setSpeed(360);
		Motor.B.rotate(-140,true);
		Delay.msDelay(400);
		Main.pilot.stop();
		Main.map[(int)Main.nav.getPoseProvider().getPose().getX()][(int)Main.nav.getPoseProvider().getPose().getY()]=1;
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return Main.us.getDistance()<20;
	}
}
