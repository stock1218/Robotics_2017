import lejos.robotics.subsumption.Behavior;

public class Search implements Behavior {

	public void action() {

		System.out.println("search");
		Main.nav.followPath(Main.searchPath);

	}

	public void suppress() {

	}

	public boolean takeControl() {
		return true;
	}

}
