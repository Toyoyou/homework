import objectdraw.*;
import java.awt.*;

public class FibSpiral {
    public static int scale = 10;
    
    private int nn;
    private FibSpiral child;
    
    public FibSpiral(Location point, int n, int direction, DrawingCanvas canvas){
        nn = n;
        
        double angle = 90;
        angle -= direction * 90;
        
        int f = fib(n);
        
        Location origin = new Location(point);
        switch(direction%4){
            case 0:
                break;
            case 1:
                origin.translate(-f*scale,0);
                break;
            case 2:
                origin.translate(-f*scale,-f*scale);
                break;
            case 3:
                origin.translate(0,-f*scale);
        }
        
        new FramedArc(origin,f*2*scale,f*2*scale,angle,90,canvas);
        
        if(n>1){
            switch(direction%4){
                case 0:
                    point.translate(f*scale,0);
                    break;
                case 1:
                    point.translate(fib(n-2)*scale,f*scale);
                    break;
                case 2:
                    point.translate(-fib(n-1)*scale,fib(n-2)*scale);
                    break;
                case 3:
                    point.translate(0,-fib(n-1)*scale);
                    break;
            }
            child = new FibSpiral(point,n-1,direction+1,canvas);
        }
    }
    
    public static int fib(int n){
        if(n<=1)return 1;
        return fib(n-1)+fib(n-2);
    }
    
    public double getLength(){
        double l = Math.PI*fib(nn)/2;
        if(nn>1){
            l+=child.getLength();
        }
        return l;
    }
}
