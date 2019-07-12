import objectdraw.*;
import java.awt.*;

public class StraightFace implements ReMovable {
    private static final int FACE_HEIGHT = 60, // Dimensions of
                             FACE_WIDTH = 60,  // the face

                             EYE_OFFSET =20,   // Eye location and size
                             EYE_RADIUS = 8,

                             MOUTH_HEIGHT =10, // Dimensions of
                             MOUTH_WIDTH = FACE_WIDTH/2; // the mouth


    private FramedOval head; // oval for head

    private Line leftEye, // Parts of the face
                 rightEye,
                 nose,
                 mouth;

    // Create pieces of straight face
    public StraightFace( double left, double top, DrawingCanvas canvas ) {
        head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
        mouth = new Line( left+(FACE_WIDTH-MOUTH_WIDTH)/2, top + 2*FACE_HEIGHT/3,
                          left+(FACE_WIDTH+MOUTH_WIDTH)/2,
                          top + 2*FACE_HEIGHT/3, canvas );
        nose = new Line( left+FACE_WIDTH/2, top+EYE_OFFSET,
                         left+FACE_WIDTH/2, top + FACE_HEIGHT/2, canvas );
        leftEye = new Line( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET,
                            left+EYE_OFFSET+EYE_RADIUS/2, top+EYE_OFFSET,
                            canvas );
        rightEye = new Line( left+FACE_WIDTH-EYE_OFFSET-EYE_RADIUS/2,
                             top+EYE_OFFSET,
                             left + FACE_WIDTH - EYE_OFFSET + EYE_RADIUS/2,
                             top+EYE_OFFSET, canvas );
    }
    
    public StraightFace(Location leftTop, DrawingCanvas canvas){
        this(leftTop.getX(),leftTop.getY(),canvas);
    }

    // Move straight face by (dx.dy)
    @Override public void move( double dx, double dy ) {
        head.move( dx, dy );
        leftEye.move( dx, dy );
        rightEye.move( dx, dy );
        mouth.move( dx, dy );
        nose.move( dx, dy );
    }

    // Move straight face to pt
    public void moveTo( Location pt ) {
        this.move( pt.getX() - head.getX(), pt.getY() - head.getY() );
    }

    // Determine whether pt is inside straight face
    @Override public boolean contains( Location pt ) {
        return head.contains( pt );
    }
    
    @Override public void removeFromCanvas(){
        head.removeFromCanvas();
        leftEye.removeFromCanvas();
        rightEye.removeFromCanvas();
        mouth.removeFromCanvas();
        nose.removeFromCanvas();
    }
    
    @Override public double getY(){return head.getY();}
}
