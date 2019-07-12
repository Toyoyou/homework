import objectdraw.*;
import java.awt.*;

public class TenCircles extends WindowController {
    private final int numMaxCircle = 10;
    private FramedOval[] circles;
    private int count;
    
    @Override public void begin(){
        circles = new FramedOval[10];
        count = 0;
    }
    
    @Override public void onMouseClick(Location point){
        for(int i = 0; i < count; i++){
            if(circles[i].contains(point)){
                setColor();
                return;
            }
        }
        
        if(count>10)count = 0;
        circles[count] = new FramedOval(point.getX()-25,point.getY()-25,50,50,canvas);
        count++;
    }
    
    private void setColor(){
        
        Color c = getRandomColor();
        
        for(int i = 0; i < count; i++){
            circles[i].setColor(c);
        }
    }
    
    private Color getRandomColor(){
        RandomIntGenerator rnd = new RandomIntGenerator(0,4);
        int i = rnd.nextValue();
        switch(i){
            case 0:
                return Color.red;
            case 1:
                return Color.blue;
            case 2:
                return Color.green;
            case 3:
                return Color.yellow;
            default:
                return Color.black;
        }
    }
}
