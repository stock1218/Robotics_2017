import java.io.File;

import lejos.nxt.Motor;
import lejos.nxt.Sound;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class PickUp implements Behavior {
	private static File file  = new File("getover.wav");
	public void action() {
		System.out.println("up"); 
		Motor.B.setSpeed(200);
		Sound.playSample(file);
		Main.pilot.travel(80);
		Motor.B.rotate(180);
		//Main.map[(int)Main.pp.getPose().getY()/Main.scale][(int)Main.pp.getPose().getX()/Main.scale]=0;
		Main.pickUp=true;
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return ((Main.us.getDistance()<10)&&(!Main.pickUp)||(Main.atBase && Main.isCollected));
	}
}

