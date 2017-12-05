import lejos.robotics.mapping.LineMap;
import lejos.robotics.navigation.DestinationUnreachableException;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;
import lejos.robotics.pathfinding.ShortestPathFinder;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class ReturnBase implements Behavior {
	 
	 private int nextPlace;
	  	public void action() {
	  		Main.pilot.setTravelSpeed(500);
	  		Arrange.count++;
			System.out.println("return");
	 		findNext();			
	 		Path pathy = new Path();
	 		pathy.add(new Waypoint(nextPlace*Main.scale,0));
	 		Main.nav.stop();
			while(Math.abs((int)Main.pp.getPose().getX()-nextPlace*Main.scale) > 1 && (int)Main.pp.getPose().getY() > 0) {
				
				System.out.println((int)Main.pp.getPose().getX()+ " ," + (int)Main.pp.getPose().getY());
				Main.nav.followPath(pathy);
				System.out.println("following");
				
			}
	 		Main.pickUp = false;
	 		Main.atBase = true;
	 	}
	  	
	  	public void suppress() {
	  		
	  	}
	  	
	  	public boolean takeControl() {

	 		return (Main.pickUp&&!Main.isCollected);
	 	}
	  	
	 	public void findNext() {
	 		for (int i=0;i<Main.size;i++) {
	 			if (Main.map[0][i] == 0) {
	 				nextPlace = i;	
	 			}
	 		}
	 		
	 		Main.map[0][nextPlace] = 1;
	  	}
	  }
