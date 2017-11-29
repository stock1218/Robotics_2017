import lejos.robotics.pathfinding.Path;

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
		int scale=Main.scale;
		switch(count) {
			case 0: 
				Sound.beepSequence();
				break;
			case 1:
				path.add(new Waypoint(3*scale,3*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				break;
			
			case 2:	
				path.add(new Waypoint(4*scale,3*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(2*scale,3*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				break;

			case 3:
				path.add(new Waypoint(3*scale,4*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(4*scale,2*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(3*scale,4*scale));
				path.add(new Waypoint(0,count));
				count--;
				break;

			case 4:
				path.add(new Waypoint(4*scale,4*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(2*scale,4*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(4*scale,2*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(2*scale,2*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				break;

			case 5: 
				path.add(new Waypoint(3*scale,5*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(5*scale,3*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(4*scale,1*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(1*scale,3*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(2*scale,1*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				break;

			case 6:
				path.add(new Waypoint(4*scale,5*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(5*scale,3*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(2*scale,5*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(4*scale,1*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(2*scale,1*scale));
				path.add(new Waypoint(0,count*scale));
				count--;
				path.add(new Waypoint(1*scale,3*scale));
				path.add(new Waypoint(0,count*scale));
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
