public class PickUp implements Behavior {
	public void action() {
		main.pilot.forward();
		Motor.B.setSpeed(360);
		Motor.B.rotate(140,true);
		Delay.msDelay(200);
		main.pilot.stop();
		main.map[(int)main.nav.getPoseProvider().getPose().getX()][(int)main.nav.getPoseProvider().getPose().getY()]=0;
		boolean pickUp=true;
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return Main.us.getDistance()<20;
	}
}
