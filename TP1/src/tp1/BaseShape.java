package tp1;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class BaseShape implements Cloneable {
    private Collection<Point2d> coords;

    // TODO Initialiser la liste de points.
    public BaseShape() {
        coords = new ArrayList<>();
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<>(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public BaseShape add(Point2d coord) {
        this.coords.add(coord);
        return this;
    }
    public BaseShape add(BaseShape shape) {
        Collection<Point2d> coordsToAdd = shape.getCoords();
        for(Point2d coord : coordsToAdd){
            this.add(coord);
        }
        return this;
    }
    public BaseShape addAll(Collection<Point2d> coords) {
        for(Point2d coord : coords){
            this.coords.add(coord);
        }
        return this;
    }
    public BaseShape remove(Point2d coord) {
        this.coords.remove(coord);
        return this;
    }
    public BaseShape remove(BaseShape shape) {
        Collection<Point2d> coordsToRemove = shape.getCoords();
        for(Point2d coord : coordsToRemove){
            this.remove(coord);
        }
        return this;
    }
    public BaseShape removeAll(Collection<Point2d> coords) {
        for(Point2d coord : coords){
            this.remove(coord);
        }
        return this;
    }

    // TODO retourner les coordonnees de la liste.
    public Collection<Point2d> getCoords() {
        return new ArrayList<>(this.coords); // new ArrayList ?
    }

    // TODO retourner une nouvelle liste ou tous les points sont des copy
    public Collection<Point2d> getCoordsDeepCopy() {
        Collection<Point2d> coordsDeepCopy = new ArrayList<Point2d>();
        for(Point2d coord : coords){
            coordsDeepCopy.add(new Point2d(coord.X(), coord.Y())); // copy X and Y ?
        }

        return coordsDeepCopy;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        for(Point2d coord : coords){
            coord.translate(point);
        }
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        for(Point2d coord : coords){
            coord.rotate(angle);
        }
        return this;
    }

    // TODO donner la plus grande valeur en X
    public Double getMaxX() {
        Iterator<Point2d> it = coords.iterator();
        if(!it.hasNext())
            return null;

        Double maxX = it.next().X();
        while(it.hasNext()){
                maxX = Math.max(maxX, it.next().X());
        }

        return maxX;
    }

    // TODO donner la plus grande valeur en Y
    public Double getMaxY() {
        Iterator<Point2d> it = coords.iterator();
        if(!it.hasNext())
            return null;

        Double maxY = it.next().Y();
        while(it.hasNext()){
            maxY = Math.max(maxY, it.next().Y());
        }

        return maxY;
    }

    // TODO donner les plus grandes valeurs en X et Y
    public Point2d getMaxCoord() {
        return new Point2d(new Double[]{getMaxX(), getMaxY()});
    }

    // TODO donner la plus petite valeur en X
    public Double getMinX() {
        Iterator<Point2d> it = coords.iterator();
        if(!it.hasNext())
            return null;

        Double minX = it.next().X();
        while(it.hasNext()){
            minX = Math.min(minX, it.next().X());
        }

        return minX;
    }
    // TODO donner la plus petite valeur en Y
    public Double getMinY() {
        Iterator<Point2d> it = coords.iterator();
        if(!it.hasNext())
            return null;

        Double minY = it.next().Y();
        while(it.hasNext()){
            minY = Math.min(minY, it.next().Y());
        }

        return minY;
    }

    // TODO donner les plus petites valeurs en X et Y
    public Point2d getMinCoord() {
        return new Point2d(new Double[]{this.getMinX(), getMinY()});
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        return new BaseShape(getCoordsDeepCopy());
    }
}
