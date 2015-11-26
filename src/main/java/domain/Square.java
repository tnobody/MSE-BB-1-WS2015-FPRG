package domain;

/**
 * Created by tim on 26.11.2015.
 */
public class Square {
    private int l;

    public Square(int l) {
        this.l = l;
    }

    public int getL() {
        return l;
    }

    public int getArea() {
        return (l*l);
    }

    public Square add(Square r) {
        return new Square(l + r.getL());
    }
}
