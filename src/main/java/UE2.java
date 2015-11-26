
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE2 {

    public static <T> T fold(BinaryOperator<T> fn, T init, List<T> in) {
        if (in.size() - 1 > 0) {
            return fold(fn, fn.apply(init, in.get(0)), in.subList(1, in.size()));
        }
        return fn.apply(init, in.get(0));
    }

}
