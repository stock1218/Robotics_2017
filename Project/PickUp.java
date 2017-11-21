public class PickUp implements Behavior {
	public void action() {
		pilot.setTravelSpeed(200);
		pilot.forward();
		Motor.B.setSpeed(360);
		Motor.B.rotate(140,true);
		Delay.msDelay(200);
		pilot.stop();
		main.map[(int)nav.getPoseProvider().getPose().getX()][(int)nav.getPoseProvider().getPose().getY()]=0;
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return Main.us.getDistance()<20;
	}
}
