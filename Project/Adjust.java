import lejos.robotics.subsumption.Behavior;

public class Adjust implements Behavior {
	// light sensor - black = 30, white = 50
	// colour sensor colour id - white = 6, black = 7
	// left hand side is colour sensor, right is light sensor
	public void action() {
		Main.turning = true;
		System.out.println("turn");
		float h = Main.nav.getPoseProvider().getPose().getHeading();
		if ((Main.ls.readValue() < 40) && (Main.cs.getColorID() != 7)) {
//			while ((Main.cs.getColorID() != 7) && (Main.ls.readValue() < 40)) {
				Main.pilot.rotate(1);

	//		}
		} else if ((Main.ls.readValue() > 40) && (Main.cs.getColorID() == 7)) {
		//	while (Main.ls.readValue() > 40 && (Main.cs.getColorID() == 7)) {
				Main.pilot.rotate(1);
			//}
		}

		if ((Main.ls.readValue() < 40) && (Main.cs.getColorID() == 7)) {
			Main.adjusted = true;
			Main.pilot.stop();
		}
		Main.nav.getPoseProvider().getPose().setHeading(h);
	}

	public void suppress() {

	}

	public boolean takeControl() {
		return (((Main.ls.readValue() < 40) && (Main.cs.getColorID() != 7)
					|| 
				(Main.ls.readValue() > 40) && (Main.cs.getColorID() == 7))
				&&
				(!Main.adjusted));
	}

}
