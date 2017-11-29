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
			putDown();

	 	}
	  	
	  	public void suppress() {
	  		Main.pickUp=false;
	  	}
	  	
	  	public boolean takeControl() {

	 		return (Main.pickUp&&!Main.isCollected);
	 	}
	 	
	 	public void findNext() {
	 		for (int i=5;i>=0;i--) {
	 			if (Main.map[5][i] == 0) {
	 				nextPlace = i;	
	 			}
	 		}	
	  	}
	
		 public void putDown( ) {
	  		System.out.println("down");
			Main.pilot.backward();
			Motor.B.setSpeed(360);
			Motor.B.rotate(-140,true);
			Delay.msDelay(400);
			Main.pilot.stop();
			Main.map[(int)Main.nav.getPoseProvider().getPose().getX()][(int)Main.nav.getPoseProvider().getPose().getY()]=1;
	  		
	  	}
	  }
