package tp1;

import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        for(Double x = -widthRadius; x <= widthRadius; x++){
            for(Double y = -widthRadius; y <= widthRadius; y++){
                if(x*x*heightRadius*heightRadius+y*y*widthRadius*widthRadius<=
                widthRadius*widthRadius*heightRadius*heightRadius){
                    add(new Point2d(x, y));
                }
            }
        }
    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    // TODO initialiser le parent.
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        super.translate(point);
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() {
        return new Ellipse(getCoordsDeepCopy());
    }
}
