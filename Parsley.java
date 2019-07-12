import objectdraw.*;
import java.awt.*;
import java.util.ArrayList;


public class Parsley extends WindowController {
    
    
    ArrayList<Line> lines;
    
    @Override public void begin(){
        lines = new ArrayList<Line>();
        
        Location start = new Location(canvas.getWidth()/2,canvas.getHeight()-20);
        Location end = new Location(canvas.getWidth()/2,canvas.getHeight()/2);
        drawParsley(start,end);
    }
    
    @Override public void onMousePress(Location point){
        for(Line l:lines){
            l.setColor(Color.green);
        }
    }
    
    @Override public void onMouseRelease(Location point){
        for(Line l:lines){
            l.setColor(Color.black);
        }
    }
    
    
    private void drawParsley(Location start, Location end){
        Location branch = subtract(end, start);
        if(sqabs(branch)<25) return;
        
        lines.add(new Line(start, end, canvas));
        //draw sub branch 1
        Location subS = apply(start,multiply(branch,1/3.0));
        Location subE = multiply(branch,3/4.0);
        subE = rotate(subE,-Math.PI/6.0);
        subE = apply(subS,subE);
        drawParsley(subS,subE);
        //draw sub branch 2
        subS = apply(start, multiply(branch,2/3.0));
        subE = multiply(branch,2/3.0);
        subE = rotate(subE,Math.PI/5.0);
        subE = apply(subS,subE);
        drawParsley(subS,subE);
        //draw sub branch 3
        subS = end;
        subE = multiply(branch,1/2.0);
        subE = rotate(subE,-Math.PI/4.0);
        subE = apply(subS,subE);
        drawParsley(subS,subE);
    }
    
    private Location multiply(Location loc, double d){
        return new Location(loc.getX()*d, loc.getY()*d);
    }
    
    private Location apply(Location loc1, Location loc2){
        return new Location(loc1.getX()+loc2.getX(),loc1.getY()+loc2.getY());
    }
    
    private Location subtract(Location loc1, Location loc2){
        return new Location(loc1.getX()-loc2.getX(),loc1.getY()-loc2.getY());
    }
    
    private Location rotate(Location loc, double rot){
        double x = loc.getX()*Math.cos(rot) - loc.getY()*Math.sin(rot);
        double y = loc.getX()*Math.sin(rot) + loc.getY()*Math.cos(rot);
        return new Location(x,y);
    }
    
    private double sqabs(Location loc){
        return loc.getX()*loc.getX() + loc.getY()*loc.getY();
    }
}
