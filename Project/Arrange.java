import lejos.robotics.pathfinding.Path;
import lejos.robotics.subsumption.Behavior;


public class Arrange implements Behavior {

	public void action() {
		int count=0;
		Path path = new Path();

		//counts number of bricks
		for(int i = 0;i < Main.map.length;i++)
		{
			for(int j = 0;j < Main.map[].length;j++) {
				if (Main.map[i][j] == 1)  count += 1;
			}
		}
		//hardcoded as 6 bricks
		Main.pp.getPose();
		path.add(new Waypoint(450,450));
		Main.nav.followPath(path());
		//travels to base
		count--;
		switch(count) {
			case 0: 
				Sound.beepSequence();
				break;
			case 1:
				path.add(new Waypoint(3*Main.scale,3*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				break;
			
			case 2:	
				path.add(new Waypoint(4*Main.scale,3*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(2*Main.scale,3*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				break;

			case 3:
				path.add(new Waypoint(3*Main.scale,4*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(4*Main.scale,2*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(3*Main.scale,4*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				break;

			case 4:
				path.add(new Waypoint(4*Main.scale,4*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(2*Main.scale,4*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(4*Main.scale,2*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(2*Main.scale,2*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				break;

			case 5: 
				path.add(new Waypoint(3*Main.scale,5*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(5*Main.scale,3*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(4*Main.scale,1*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(1*Main.scale,3*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(2*Main.scale,1*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				break;

			case 6:
				path.add(new Waypoint(4*Main.scale,5*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(5*Main.scale,3*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(2*Main.scale,5*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(4*Main.scale,1*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(2*Main.scale,1*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				path.add(new Waypoint(1*Main.scale,3*Main.scale));
				path.add(new Waypoint(0*Main.scale,count*Main.scale));
				count--;
				break;

		}
		
		
	}
	
	public void suppress() {
		
	}
	
	public boolean takeControl() {
		return Main.isCollected;
	}
}
