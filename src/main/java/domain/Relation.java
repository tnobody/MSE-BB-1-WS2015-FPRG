package domain;

/**
 * Created by tim on 03.12.2015.
 */
public class Relation {

    private Node left;
    private Node right;
    private int weight;

    public Relation(int weight, Node left, Node right) {
        this.weight = weight;
        this.left = left;
        this.left.getRelations().add(this);
        this.right = right;
        this.right.getRelations().add(this);
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
