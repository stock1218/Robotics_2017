import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
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

	static DifferentialPilot pilot = new DifferentialPilot(56, 95, Motor.A, Motor.C);
	static PoseProvider pp = new OdometryPoseProvider(pilot);
	static Navigator nav = new Navigator(pilot, pp);
	static LightSensor ls = new LightSensor(SensorPort.S1);
	static UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
	static ColorSensor cs = new ColorSensor(SensorPort.S3);
	static int map[][] = new int[5][5];
	static int scale;
	static Path searchPath = new Path();
	static boolean pickUp;
	public static boolean isCollected;
	
	public static void main(String args[]) {
		pickUp = false;
		isCollected = false;

		int x = 5;
		for(int y = 5; y >= 0; y--) {
			if(x > 0) {
				for(x = 5; x >= 0; x--) {
					searchPath.add(new Waypoint(x*50,y*50));
					
				}
			} else {
				for(x = 0; x < 6; x++) {
					searchPath.add(new Waypoint(x*50,y*50));
					
				}
			}

		}

		for(int[] z : map) {
			for(int w : z) {
				w = 0;
			}
		}

		Behavior putDown = new PutDown();
		Behavior search = new Search();
		Behavior pickUp = new PickUp();      
		Behavior turn = new Turn();
		Behavior returnBase = new ReturnBase();
		Behavior[] behaviors = {search, pickUp, turn, putDown, returnBase};
		Arbitrator arb = new Arbitrator(behaviors);
		arb.start();
	}
}
