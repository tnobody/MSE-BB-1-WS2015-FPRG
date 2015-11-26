import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * Created by tim on 26.11.2015.
 */
public class UE3 {

    public static <A,B> List<B> scan(BiFunction<B,A,B> fn, B init, List<A> in) {
        List<B> out = new ArrayList<B>() {{add(fn.apply(init,in.get(0)));}};
        if (in.size() - 1 > 0) {
             out.addAll(scan(fn, out.get(0), in.subList(1, in.size())));
        }
        return out;
    }
}
