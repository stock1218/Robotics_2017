public class Arrange implements Behavior {
    
    public void action() {
    //understand where the robot is, where the bricks are in relation to the robot
    //work out where the bricks have to go using grid
    //use PickUp, PutDown classes to help deliver bricks
    }
    
    public void suppress() {
    
    }
    
    public boolean takeControl() {
        return Main.isCollected();
    }
}
