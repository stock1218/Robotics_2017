public class ReturnBase implements Behavior{
private int nextPlace;
	public static void action() {
		findNext();
		Main.nav.goTo(5, nextPlace);// base starts at (5,5) up to(5,0) 
		// goTo takes the robot from wherever it is to the waypoint mentioned
		
		//Pose currentpos=Main.pp.getPose();  current position of the robot
		//Path path = findRoute(Pose currentpos, Waypoint (9,nextPlace)); //9,9 is base
		//Main.nav.followPath(path);
	}
	
	public static void supress() {
		Pickup.pickedUp=false;
	}
	
	public static boolean takeControl() {
		return (PickUp.pickedUp&&!Main.isCollected);
	}
	
	public void findNext() {
		for (int i=5;i>=0;i--) {
			if (Main.map[5][i] == 0) {
				nextPlace = i;	
			}
		}	
	}
}
