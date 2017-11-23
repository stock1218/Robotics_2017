public class Search implements Behavior {

	public void action() {

		Main.nav.followPath(Main.search);

	}

	public void suppress() {

	}

	public void takeControl() {
		return true;
	}

}