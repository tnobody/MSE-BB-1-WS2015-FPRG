import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE1 {

    public static <I, O> List<O> map(Function<I, O> fn, List<I> in) {
        List<O> out = new ArrayList<O>() {{ add(fn.apply(in.get(0))); }};
        if (in.size() - 1 > 0) {
            out.addAll(map(fn, in.subList(1, in.size())));
        }
        return out;
    }
}
