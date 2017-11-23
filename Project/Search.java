public class Search implements Behavior {

	private Path search;

	public void action() {

		Main.nav.followPath(search);

	}

	public void suppress() {

	}

	public void takeControl() {


	}

}