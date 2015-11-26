
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE2 {

    public static <T> T fold(BinaryOperator<T> fn, T init, List<T> in) {
        return in.stream().reduce(init,fn);
    }

}
