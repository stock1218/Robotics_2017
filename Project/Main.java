import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {

	static DifferentialPilot pilot = new DifferentialPilot(56, 95, Motor.A, Motor.C);
	static LightSensor ls = new LightSensor(SensorPort.S1);
	static UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
	static ColorSensor cs = new ColorSensor(SensorPort.S3);
	public static void main(String args[]) {
	Behavior move = new Move();
	Behavior pickUp = new PickUp();
	Behavior[] behaviors = {move,pickUp};
	Arbitrator arb = new Arbitrator(behaviors);
	arb.start();
	}
}
