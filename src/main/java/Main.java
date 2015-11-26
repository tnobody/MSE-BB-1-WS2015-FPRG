import java.util.Arrays;
import java.util.List;

/**
 * Created by tim on 26.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> l =  Arrays.asList(1,2,3,4);
        List<Integer> s = l.subList(1,l.size());
        System.out.println(l.size() + " - " + s.size());

    }
}
