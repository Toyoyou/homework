import objectdraw.*;
import java.awt.*;

public class FunnyFace implements ReMovable {
    private static final int FACE_HEIGHT = 60, // Dimensions of
                             FACE_WIDTH = 60,  // the face

                             EYE_OFFSET =20,   // Eye location and size
                             EYE_RADIUS = 8,

                             MOUTH_HEIGHT =10, // Dimensions of
                             MOUTH_WIDTH = FACE_WIDTH/2; // the mouth

    private FramedOval head,               // Parts of the face
                       leftEye,
                       rightEye,
                       mouth;

    // Create pieces of funny face
    public FunnyFace( double left, double top, DrawingCanvas canvas ) {
        head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
        mouth = new FramedOval( left+(FACE_WIDTH-MOUTH_WIDTH)/2,
                                top+2*FACE_HEIGHT/3, MOUTH_WIDTH,
                                MOUTH_HEIGHT, canvas );
        leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2,
                                  top+EYE_OFFSET, EYE_RADIUS,
                                  EYE_RADIUS, canvas );
        rightEye = new FramedOval( left+FACE_WIDTH-EYE_OFFSET-
                                   EYE_RADIUS/2, top+EYE_OFFSET,
                                   EYE_RADIUS, EYE_RADIUS, canvas );
    }

    public FunnyFace( Location upperLeft, DrawingCanvas canvas ) {
        this( upperLeft.getX(), upperLeft.getY(), canvas );
    }

    // Move funny face by (dx, dy)
    @Override public void move( double dx, double dy ) {
        head.move( dx, dy );
        leftEye.move( dx, dy );
        rightEye.move( dx, dy );
        mouth.move( dx, dy );
    }

    // Move funny face to (x, y)
    public void moveTo( double x, double y ) {
        this.move( x - head.getX(), y - head.getY() );
    }

    // Determine whether pt is inside funny face
    @Override public boolean contains( Location pt ) {
        return head.contains( pt );
    }
    
    @Override public double getY(){return head.getY();}
    
    @Override public void removeFromCanvas(){
        head.removeFromCanvas();
        leftEye.removeFromCanvas();
        rightEye.removeFromCanvas();
        mouth.removeFromCanvas();
    }
}
