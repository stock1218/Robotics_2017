public class ReturnBase implements Behavior{
private int nextPlace;
	public static void action() {
		
		Pose currentpos=Main.pp.getPose(); // current position of the robot
		findNext();
		Path path = findRoute(Pose currentpos, Waypoint (9,nextPlace)); //9,9 is base
		Main.nav.followPath(path);
	}
	
	public static void supress() {
		Pickup.pickedUp=false;
	}
	
	public static boolean takeControl() {
		return (PickUp.pickedUp&&!Main.isCollected);
	}
	
	public void findNext() {
		for (int i=9;i>=0;i--) {
			if (Main.map[9][i] == 0) {
				nextPlace = i;	
			}
		}	
	}
}
