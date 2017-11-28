import lejos.robotics.mapping.LineMap;
import lejos.robotics.navigation.DestinationUnreachableException;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;
import lejos.robotics.pathfinding.ShortestPathFinder;
import lejos.robotics.subsumption.Behavior;

public class ReturnBase implements Behavior {
	 
	 private int nextPlace;
	  	public void action() {

			System.out.println("return");
	 		findNext();
//	 		LineMap linemap = new LineMap();
//	 		ShortestPathFinder finder = new ShortestPathFinder(linemap);
//	 		Path path;
//			try {
//				path = finder.findRoute(Main.pp.getPose(), (new Waypoint(9,nextPlace)));
//		  		Main.nav.followPath(path);
//			} catch (DestinationUnreachableException e) {
//				e.printStackTrace();
//			}
			
			Main.nav.goTo(5, nextPlace);

	 	}
	  	
	  	public void suppress() {
	  		Main.pickUp=false;
	  	}
	  	
	  	public boolean takeControl() {

	 		return (Main.pickUp&&!Main.isCollected);
	 	}
	 	
	 	public void findNext() {
	 		for (int i=9;i>=0;i--) {
	 			if (Main.map[9][i] == 0) {
	 				nextPlace = i;	
	 			}
	 		}	
	  	}
	  }
