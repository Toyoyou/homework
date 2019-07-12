import objectdraw.*;
import java.awt.*;

// Recursive structure for collection of nested rectangles
public class NestedRects implements NestedRectsInterface {
    private FramedRect outerRect; // Outermost rectangle in picture
    private NestedRectsInterface rest; // Remaining nested rectangles

    public NestedRects( double x, double y, double width, double height,
                        Color color, DrawingCanvas canvas ) {
        outerRect = new FramedRect( x, y, width, height, canvas );
        outerRect.setColor(color);
        if ( width >= 8 && height >= 8 ) {
            if(color==Color.red){
                color = Color.blue;
            }else if(color == Color.blue){
                color = Color.green;
            }else if(color == Color.green){
                color = Color.yellow;
            }else{
                color = Color.red;
            }
            
            rest = new NestedRects( x + 4, y + 4, width - 8,
                                    height - 8,color, canvas );
        } else { // Construct a base object
            rest = new BaseRects();
        }
    }
}
