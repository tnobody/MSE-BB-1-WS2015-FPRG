import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Created by tim on 26.11.2015.
 */
public class UE4 {

    public static class Tupel<T> {
        private final T x;
        private final T y;

        public Tupel(T x, T y) {
            this.x = x;
            this.y = y;
        }

        public T getX() {
            return x;
        }

        public T getY() {
            return y;
        }
    }

    public static <T> List<T> filter(List<T> in, Function<T, Boolean> filterFn) {
        List<T> out = new ArrayList<>();
        if (in.size() == 0) {
            return out;
        }
        if(filterFn.apply(in.get(0))) {
            out.add(in.get(0));
        }
        out.addAll(filter(in.subList(1, in.size()), filterFn));
        return out;
    }

    public static <I, O> O divideAndConquer(
            Function<List<I>, Boolean> trivial,
            Function<List<I>, O> solve,
            Function<List<I>, Tupel<List<I>>> divide,
            BinaryOperator<O> combine,
            List<I> in) {

        if (trivial.apply(in)) {
            return solve.apply(in);
        } else {
            Tupel<List<I>> tupel = divide.apply(in);
            return combine.apply(
                    divideAndConquer(trivial, solve, divide, combine, tupel.getX()),
                    divideAndConquer(trivial, solve, divide, combine, tupel.getY())
            );
        }
    }

}
