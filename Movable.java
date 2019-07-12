import objectdraw.*;
import java.awt.*;

public interface Movable{
    // Move receiver by dx in x direction and dy in y direction
    public void move( double dx, double dy );

    // Determine whether point is contained in receiver
    public boolean contains( Location point );
}
