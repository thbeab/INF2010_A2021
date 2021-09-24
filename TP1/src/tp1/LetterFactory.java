package tp1;

import java.awt.*;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    // TODO
    public static BaseShape create_e() {
        BaseShape e = new BaseShape();
        e.add(new Ellipse(halfMaxWidth, halfMaxHeight));
        e.remove(new Ellipse(halfMaxWidth-halfStripeThickness,
                halfMaxHeight-halfStripeThickness));
        e.remove(new Rectangle(halfStripeThickness, halfMaxWidth).translate(
                new Point2d(halfMaxWidth,-halfStripeThickness)));
        e.add(new Rectangle(stripeThickness, maxWidth));

        return e;
    }

    // TODO
    public static BaseShape create_a() {
        BaseShape a = new BaseShape();
        a.add(new Ellipse(halfMaxWidth, halfMaxHeight));
        a.remove(new Ellipse(halfMaxWidth-halfStripeThickness,
                halfMaxHeight-halfStripeThickness));
        a.add(new Rectangle(halfStripeThickness,maxHeight).translate(
                new Point2d(halfMaxWidth,0.0)));

        return a;
    }

    // TODO
    public static BaseShape create_C() {
        BaseShape C = new BaseShape();

        return C;
    }

    // TODO
    public static BaseShape create_l() {
        BaseShape l = new BaseShape();
        l.add(new Rectangle(halfStripeThickness, maxHeight));

        return l;
    }

    // TODO
    public static BaseShape create_i() {
        BaseShape i = new BaseShape();
        i.add(new Rectangle(halfStripeThickness, maxHeight));

        return i;
    }

    // TODO
    public static BaseShape create_A() {
        BaseShape A = new BaseShape();
        A.add(new Rectangle(halfStripeThickness, maxHeight));

        return A;
    }

    // TODO
    public static BaseShape create_V() {
        BaseShape V = new BaseShape();
        V.add(new Rectangle(halfStripeThickness, maxHeight));

        return V;
    }

    // TODO
    public static BaseShape create_n() {
        BaseShape n = new BaseShape();
        n.add(new Rectangle(halfStripeThickness, maxHeight));

        return n;
    }

    // TODO
    public static BaseShape create_r() {
        BaseShape r = new BaseShape();
        r.add(new Rectangle(halfStripeThickness, maxHeight));

        return r;
    }

    // TODO
    public static BaseShape create_B() {
        BaseShape B = new BaseShape();
        B.add(new Rectangle(halfStripeThickness, maxHeight));

        return B;
    }
}
