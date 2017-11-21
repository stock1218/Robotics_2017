public class ReturnBase implements Behavior{

	public static void action() {
		Pose currentpos=Main.pp.getPose(); // current position of the robot
		
		Path path = findRoute(Pose currentpos, Waypoint (10,10)); //10,10 is base
		
		Main.nav.followPath(path);
}
	
	public static void supress() {
		Pickup.pickedUp=false;
	}
	
	public static boolean takeControl() {
		return (PickUp.pickedUp);
	}
}
