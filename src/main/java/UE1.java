import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE1 {

    public static <I, O> List<O> map(Function<I,O> fn, List<I> in) {
        return in.stream()
                .map(fn)
                .collect(Collectors.<O>toList());
    }
}
