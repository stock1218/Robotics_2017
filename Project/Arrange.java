import lejos.nxt.Sound;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;

public class Arrange implements Behavior {
		private int count=0;
	public void action() {
		Path path = new Path();

		//counts number of bricks
		for(int i = 0;i < Main.map.length;i++)
		{
			for(int j = 0;j < Main.map.length;j++) {
				if (Main.map[i][j] == 1)  count += 1;
			}
		}
		//hardcoded as 6 bricks
		Main.pp.getPose();
		Main.nav.goTo(0,0);
		//travels to base
		count--;
		switch(count) {
			case 0: 
				Sound.beepSequence();
				break;
			case 1:
				drop(3,3);
				break;
			
			case 2:	
				drop(4,3);
				drop(2,3);
				break;

			case 3:
				drop(3,4);
				drop(4,2);
				drop(2,2);
				break;

			case 4:
				drop(4,4);
				drop(2,4);
				drop(4,2);
				drop(2,2);
				break;

			case 5: 
				drop(3,5);
				drop(5,3);
				drop(4,1);
				drop(1,3);
				drop(2,1);
				break;

			case 6:
				drop(4,5);
				drop(5,3);
				drop(2,5);
				drop(4,1);
				drop(2,1);
				drop(1,3);
				break;

	}
	public void drop(int x, int y) {
		Main.nav.goTo(x,y);
		ReturnBase.putDown();
		Main.nav.goTo(0,count);
		count--;
	}
	public void suppress() {
		
	}
	
	public boolean takeControl() {
		return Main.isCollected;
	}
}
