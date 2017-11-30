import lejos.robotics.subsumption.Behavior;

public class Search implements Behavior {

	public void action() {

		System.out.println(Main.pp.getPose().getX()/Main.scale);
		Main.nav.followPath(Main.searchPath);
		if ((((int)(Main.pp.getPose().getX()/Main.scale) <= 1)||
			((int)(Main.pp.getPose().getX()/Main.scale) >= Main.size*Main.scale))) {
				Main.adjusted = false;
			
		}
		

	}

	public void suppress() {

		Main.nav.stop();
	}

	public boolean takeControl() {
		return true;
	}

}
