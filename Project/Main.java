import java.io.File;
import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {
	
	static DifferentialPilot pilot = new DifferentialPilot(56, 122, Motor.A, Motor.C);
	static PoseProvider pp = new OdometryPoseProvider(pilot);
	static Navigator nav = new Navigator(pilot, pp);
	static LightSensor ls = new LightSensor(SensorPort.S1);
	static UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
	static ColorSensor cs = new ColorSensor(SensorPort.S3);
	static int map[][];
	static Path searchPath = new Path();
	static boolean pickUp, atBase, isCollected, putDown;
	static int scale, size;
	static File fatality = new File("fatality.wav");
	static File fight = new File("fight.wav");
	public static void main(String args[]) {
		nav.singleStep(false);
		size = 6;
		nav.singleStep(true);
		pilot.setTravelSpeed(80);
		scale = 170;
		pickUp = false;
		putDown= false;
		atBase = false;
		isCollected = false;
		map = new int[size][size];
		
		int x = 0;
		for (int y = 0; y < size; y++) {
			if (x > 0) {
				for (x = size - 1; x >= 0; x--) {
					searchPath.add(new Waypoint(x * scale, y * scale));


				}
			} else {
				for (x = 0; x < size; x++) {
					searchPath.add(new Waypoint(x * scale, y * scale));


				}
			}
			System.out.print("\n");
		}

		for (int[] z : map) {
			for (int w : z) {
				w = 0;
			}
		}

		Behavior search = new Search();
		Behavior pickUp = new PickUp();
		Behavior returnBase = new ReturnBase();
		Behavior putDown = new PutDown();
		Behavior arrange = new Arrange();
		Behavior[] behaviors = { search,arrange,pickUp,returnBase,putDown};
		Arbitrator arb = new Arbitrator(behaviors);
		Sound.playSample(fight);
		arb.start();
	}
}
