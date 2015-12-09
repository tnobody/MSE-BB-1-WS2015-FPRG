package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tim on 03.12.2015.
 */
public class Node {
    private List<Relation> relations = new ArrayList<>();

    public List<Relation> getRelations() {
        return relations;
    }

    public List<Node> getRelatedNodes() {
        return relations.stream()
                .map((r) -> ((r.getLeft() == this) ? r.getRight() : r.getLeft()))
                .collect(Collectors.toList());
    }
}
