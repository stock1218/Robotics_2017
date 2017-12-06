import java.io.File;

import lejos.nxt.Motor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class Arrange implements Behavior {
	public static int count = 0;
	private int scale = testtt.scale;
	private int interval = 10;
	private static File file = new File("getover.wav");
	private Path path = new Path();

	public void action() {
		count = 6;
		System.out.println((int) testtt.pp.getPose().getX() / scale + " , " + (int) testtt.pp.getPose().getY() / scale);

		// while((int)testtt.pp.getPose().getX() < 3*scale &&
		// (int)testtt.pp.getPose().getY() < 3*scale) {
		// System.out.println("starting");
		// testtt.nav.goTo(3*scale,3*scale);
		// System.out.println((int)testtt.pp.getPose().getX()+ " ," +
		// (int)testtt.pp.getPose().getY());
		//
		//
		// }
		// path.add(new Waypoint(0,0));
		// while((int)testtt.pp.getPose().getX() > 0 && (int)testtt.pp.getPose().getY()
		// > 0) {
		// testtt.pilot.setTravelSpeed(80);
		// System.out.println("following");
		// testtt.nav.goTo(70,80);
		// System.out.println((int)testtt.pp.getPose().getX()+ " ," +
		// (int)testtt.pp.getPose().getY());
		// }
		Motor.B.setSpeed(200);
		Sound.playSample(file);
		testtt.pilot.travel(80);
		Motor.B.rotate(180);
		// travels to base
		System.out.println("here");
		Delay.msDelay(1000);
		switch (count--) {
		case 0:
			Sound.beepSequence();
			break;
		case 1:
			drop(3, 3);
			break;

		case 2:
			drop(4, 3);
			drop(2, 3);
			break;

		case 3:
			drop(3, 4);
			drop(4, 2);
			drop(2, 2);
			break;

		case 4:
			drop(4, 4);
			drop(2, 4);
			drop(4, 2);
			drop(2, 2);
			break;

		case 5:
			drop(3, 5);
			drop(5, 3);
			drop(4, 1);
			drop(1, 3);
			drop(2, 1);
			break;

		case 6:
			System.out.println("step 1");

			drop(4, 5);
			System.out.println("step 2");

			drop(5, 3);
			System.out.println("step 3");

			drop(2, 5);
			System.out.println("step 4");
			drop(4, 1);
			System.out.println("step 5");
			drop(2, 1);
			System.out.println("step 6");
			drop(1, 3);
			System.out.println("step 7");
			System.exit(0);
			break;
		}
	}

	public void drop(int x, int y) {
		path.add(new Waypoint(x, y));
		// go to location
		path = new Path();
		path.add(new Waypoint(x*scale, y*scale));
		while (Math.abs((int) testtt.pp.getPose().getX() - (x * scale)) > interval
				|| (Math.abs((int) testtt.pp.getPose().getY() - (y * scale)) > interval)) {
			System.out.println("going");
			//testtt.nav.goTo(x*scale, y*scale);
			testtt.nav.followPath(path);
		//	System.out.println((x * scale) + " ," + (y * scale));
			System.out.println(testtt.pp.getPose().getX() + "," + testtt.pp.getPose().getY());

		}
		testtt.nav.stop();
		// //put brick down 
		Motor.B.setSpeed(200);
		Motor.B.rotate(-180);
		testtt.pilot.travel(-80);

		// return to base
		Path path = new Path();
		path.add(new Waypoint(count * scale, 0));
		while ((Math.abs((int) testtt.pp.getPose().getX() - (count * scale)) > interval)
				|| (Math.abs((int) testtt.pp.getPose().getY()) > scale)) {

			System.out.println("coming");
			testtt.nav.followPath(path);
			System.out.println((Math.abs((int) testtt.pp.getPose().getX() - (count * scale))) + ", "
					+ (Math.abs((int) testtt.pp.getPose().getY())));
			System.out.println((int) testtt.pp.getPose().getX() + " ," + (int) testtt.pp.getPose().getY());
		}
		testtt.nav.stop();

		// //pick up brick
		count--;
		Motor.B.setSpeed(200);
		System.out.println("done");
		Sound.playSample(file);
		testtt.pilot.travel(80);
		Motor.B.rotate(180);
	}

	public void suppress() {

	}

	public boolean takeControl() {
		return true;
	}
}
