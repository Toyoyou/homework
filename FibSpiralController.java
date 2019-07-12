import objectdraw.*;
import java.awt.*;

public class FibSpiralController extends WindowController {
    private FibSpiral fs;
    @Override public void begin(){
        fs = new FibSpiral(new Location(0,0),6,0,canvas);
    }
    
    @Override public void onMouseClick(Location point){
        new Text(fs.getLength(),10,300,canvas);
    }
}
