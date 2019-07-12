import objectdraw.*;
import java.awt.*;

public class StoppableController extends WindowController {

    private static final Location INSTR_LOCATION = new Location (10, 5);
    private int width;
    private int height;
    private Stoppable face;
    
    public void begin() {
        width = canvas.getWidth();
        height = canvas.getHeight();
        
        // Display instructions
        new Text( "Click to make a falling ball...",
                  INSTR_LOCATION, canvas );
    }

    public void onMouseClick( Location point ) {
        // Make a new ball when the player clicks
        if(point.getY()<height/2){
            if(point.getX()<width/2){
                face = new FallingFace(new FunnyFace(point,canvas),canvas);
            }else{
                face = new FallingFace(new StraightFace(point,canvas),canvas);
            }
        }else{
            if(point.getX()<width/2){
                face = new RisingFace(new FunnyFace(point,canvas),canvas);
            }else{
                face = new RisingFace(new StraightFace(point,canvas),canvas);
            }
        }
    }
        // Falling ball stops when mouse exits canvas
    public void onMouseExit( Location point ) {
        face.stopFalling();
    }
}