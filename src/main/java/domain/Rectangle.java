package domain;

/**
 * Created by tim on 26.11.2015.
 */
public class Rectangle {
    private int l;

    public Rectangle(int l) {
        this.l = l;
    }

    public int getArea() {
        return (l*l);
    }
}
