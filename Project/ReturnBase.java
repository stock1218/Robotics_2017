import lejos.robotics.mapping.LineMap;
import lejos.robotics.navigation.DestinationUnreachableException;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;
import lejos.robotics.pathfinding.ShortestPathFinder;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class ReturnBase implements Behavior {
	 
	public void action() {
	  		Main.pilot.setTravelSpeed(500);
	  		Arrange.count++;
	  		Delay.msDelay(500);	
	 		System.out.println("Next Place"+Arrange.count);
	 		Path pathy = new Path();
	 		pathy.add(new Waypoint(((Arrange.count-1)*Main.scale),0));
	 		Main.nav.stop();
			while(!Main.nav.pathCompleted())	{
				Main.nav.followPath(pathy);
			}
	 		Main.pickUp = false;
	 		Main.atBase = true;
	 }
	  	
	  public void suppress() {
	  		
	  }
	  	
	  public boolean takeControl() {

	 		return (Main.pickUp&&!Main.isCollected);
	 }
}	  	
