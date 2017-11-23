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
				
				break;
			case 1:
				
				break;
			
			case 2:	
				
				break;

			case 3:
				
				break;

			case 4:
				
				break;

			case 5: 
				
				break;

			case 6:
				
				break;

		}
		
		
	}
	
	public void suppress() {
		
	}
	
	public boolean takeControl() {
		return Main.isCollected;
	}
}
