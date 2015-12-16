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

        @Override
        public String toString() {
            return "Tupel{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    /**
     * Returns a tupel where X contains al list of all elements applied with true and Y a List where all Elemetns appllied with false
     * @param in
     * @param filterFn
     * @param <T>
     * @return
     */
    public static <T> Tupel<List<T>> filter(List<T> in, Function<T, Boolean> filterFn) {
        Tupel<List<T>> out = new Tupel<>(new ArrayList<>(), new ArrayList<>());
        _filter(in, filterFn, out);
        return out;
    }

    private static <T> void _filter(List<T> in, Function<T, Boolean> filterFn, Tupel<List<T>> out) {
        if (filterFn.apply(in.get(0))) {
            out.getX().add(in.get(0));
        } else {
            out.getY().add(in.get(0));
        }
        if (in.size() -1 > 0) {
            _filter(in.subList(1,in.size()), filterFn, out);
        }
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
