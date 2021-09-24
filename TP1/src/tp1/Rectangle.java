package tp1;

import java.util.Collection;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        Double maxX = height/2;
        Double maxY = width/2;
        for(Double x = -maxX; x<maxX; x+=1.0){
            for(Double y = -maxY; y<maxX; y+=1.0){
                this.add(new Point2d(x,y));
            }
        }
    }

    // TODO creer un rectangle avec les dimensions contenu dans un Point.
    public Rectangle(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    // TODO initialiser le parent.
    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        super.translate(point); // juste pour changer le type de retour ?
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        return new Rectangle(getCoordsDeepCopy());
    }
}
