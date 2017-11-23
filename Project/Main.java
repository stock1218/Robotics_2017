import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {

	static DifferentialPilot pilot = new DifferentialPilot(56, 95, Motor.A, Motor.C);
	static PoseProvider pp = new OdometryPoseProvider(pilot);
	static Navigator nav = new Navigator(pilot);
	static LightSensor ls = new LightSensor(SensorPort.S1);
	static UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
	static ColorSensor cs = new ColorSensor(SensorPort.S3);
	static int map[][];
	static boolean pickUp;
	public boolean isCollected;
	public static void main(String args[]) {
		pickUp = false;
		isCollected = false;

		for(int[] x : map) {
			for(int y : x) {
			y = 0;
			}
		}

		Behavior putDown = new PutDown();
		Behavior search = new Search();
		Behavior pickUp = new PickUp();
		Behavior turn = new Turn();
		Behavior returnBase = new ReturnBase();
		Behavior[] behaviors = {search, pickUp, turn, returnBase, PutDown};
		Arbitrator arb = new Arbitrator(behaviors);
		arb.start();
	}
}
