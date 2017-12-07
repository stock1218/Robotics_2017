import java.io.File;
import lejos.nxt.Motor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class Arrange implements Behavior {
	public static int count = 0;
	private int scale = Main.scale;
	private static File file = new File("getover.wav");
	private Path path;

	public void action() {
		count = 6;
		System.out.println("start");
		System.out.println((int) Main.pp.getPose().getX() / scale + " , " + (int) Main.pp.getPose().getY() / scale);
		Main.nav.stop();
		Path path = new Path();
		path.add(new Waypoint(count * scale, 0));
		Main.nav.followPath(path);
		while (!Main.nav.pathCompleted()) {
			System.out.println("returning to " + count * scale + ", " + 0);
			System.out.println((int) Main.pp.getPose().getX() + " ," + (int) Main.pp.getPose().getY());
		}
		Main.nav.stop();
		
		Motor.B.setSpeed(200);
		System.out.println("start");
		Sound.playSample(file);
		Main.pilot.travel(80);
		Motor.B.rotate(180);

		while (true) {
			switch (count--) {
			case 0:
				Sound.beepSequence();
				Sound.playSample(Main.fatality);
				System.exit(0);
				break;
			case 1:
				drop(3, 3);
				Sound.playSample(Main.fatality);
				System.exit(0);
				break;

			case 2:
				drop(4, 3);
				drop(2, 3);
				Sound.playSample(Main.fatality);
				System.exit(0);
				break;

			case 3:
				drop(3, 4);
				drop(4, 2);
				drop(2, 2);
				Sound.playSample(Main.fatality);
				System.exit(0);
				break;

			case 4:
				drop(4, 4);
				drop(2, 4);
				drop(4, 2);
				drop(2, 2);
				Sound.playSample(Main.fatality);
				System.exit(0);
				break;

			case 5:
				drop(3, 5);
				drop(5, 3);
				drop(4, 1);
				drop(1, 3);
				drop(2, 1);
				Sound.playSample(Main.fatality);
				System.exit(0);
				break;

			case 6:
				drop(4, 5);
				drop(2, 5);
				drop(5, 3);
				drop(1, 3);
				drop(4, 1);
				drop(2, 1);
				Sound.playSample(Main.fatality);
				System.exit(0);
				break;
			}
		}
	}

	public void drop(int x, int y) {
		Main.nav.stop();
		// go to location
		path = new Path();
		path.add(new Waypoint(x * scale, y * scale));
		System.out.println(!Main.nav.pathCompleted());
		Main.nav.followPath(path);
		while (!Main.nav.pathCompleted()) {
			System.out.println("going to " + x + "," + y);
			System.out.println(Main.pp.getPose().getX() + "," + Main.pp.getPose().getY());

		}
		Main.nav.stop();

		// //put brick down
		Motor.B.setSpeed(200);
		Motor.B.rotate(-180);
		Main.pilot.travel(-80);

		System.out.println("Count = " + count);
		// return to next brick
		Path path = new Path();
		path.add(new Waypoint(count * scale, 0));
		Main.nav.followPath(path);
		while (!Main.nav.pathCompleted()) {
			System.out.println("returning to " + count * scale + ", " + 0);
			System.out.println((int) Main.pp.getPose().getX() + " ," + (int) Main.pp.getPose().getY());
		}
		Main.nav.stop();

		//pick up brick
		count--;
		Motor.B.setSpeed(200);
		System.out.println("done");
		Sound.playSample(file);
		Main.pilot.travel(80);
		Motor.B.rotate(180);
	}

	public void suppress() {

	}

	public boolean takeControl() {
		return (Main.isCollected);
	}
}
