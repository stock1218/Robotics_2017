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
		switch(count) {
			case 0: 
				Sound.beepSequence();
				break;
			case 1:
				path.add(new Waypoint(3,3));
				path.add(new Waypoint(0,count));
				count--;
				break;
			
			case 2:	
				path.add(new Waypoint(4,3));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(2,3));
				path.add(new Waypoint(0,count));
				count--;
				break;

			case 3:
				path.add(new Waypoint(3,4));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(4,2));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(3,4));
				path.add(new Waypoint(0,count));
				count--;
				break;

			case 4:
				path.add(new Waypoint(4,4));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(2,4));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(4,2));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(2,2));
				path.add(new Waypoint(0,count));
				count--;
				break;

			case 5: 
				path.add(new Waypoint(3,5));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(5,3));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(4,1));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(1,3));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(2,1));
				path.add(new Waypoint(0,count));
				count--;
				break;

			case 6:
				path.add(new Waypoint(4,5));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(5,3));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(2,5));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(4,1));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(2,1));
				path.add(new Waypoint(0,count));
				count--;
				path.add(new Waypoint(1,3));
				path.add(new Waypoint(0,count));
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
