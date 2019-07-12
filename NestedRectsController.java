import objectdraw.*;
import java.awt.*;

public class NestedRectsController extends WindowController {
    private NestedRectsInterface nr;
    private Location topLeft;
    
    @Override public void begin() {
    }    
    
    @Override public void onMousePress(Location point){
        topLeft = point;
    }
    
    @Override public void onMouseRelease(Location point){
        double width = point.getX()-topLeft.getX();
        double height = point.getY()-topLeft.getY();
        if(width<0||height<0)return;
        new NestedRects(topLeft.getX(),topLeft.getY(),
                    width,height,Color.red,canvas);
    }
}
