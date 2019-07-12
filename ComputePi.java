import objectdraw.*;
import java.awt.*;

public class ComputePi extends WindowController {
    @Override public void begin(){
        new Text(computePi(1000),50,50,canvas);
        new Text(computePiFor(1000),50,100,canvas);
    }
    
    
    public static double computePi(int n){
        double pi = 1+piRecursion(1,n);
        pi = 4/pi;
        return pi;
    }
    
    public static double piRecursion(int i, int n){
        if(i==n)return 0;
        return Math.pow(2*i-1,2)/(2+piRecursion(i+1,n));
    }
    
    public static double computePiFor(int n){
        double temp=0;
        n--;
        for(;n>0;n--){
            temp = Math.pow(2*n-1,2)/(2+temp);
        }
        double pi = 1+temp;
        pi = 4/pi;
        return pi;
    }
}
