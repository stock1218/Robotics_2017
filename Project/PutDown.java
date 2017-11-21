public class PutDown implements Behaviour{
	public void action() {
		main.pilot.backward();
		Motor.B.setSpeed(360);
		Motor.B.rotate(-140,true);
		Delay.msDelay(400);
		main.pilot.stop();
		main.map[(int)main.nav.getPoseProvider().getPose().getX()][(int)main.nav.getPoseProvider().getPose().getY()]=1;
	}
	public void suppress() {
		
	}
	public boolean takeControl() {
		return us.getDistance()>20;
	}
}
