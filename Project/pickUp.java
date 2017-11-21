public class pickUp implements Behavior {
	public void action() {
		pilot.setTravelSpeed(200);
		pilot.forward();
		Motor.B.setSpeed(360);
		Motor.B.rotate(140,true);
		Delay.msDelay(200);
		pilot.stop();
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return Main.us.getDistance()<20;
	}
}
