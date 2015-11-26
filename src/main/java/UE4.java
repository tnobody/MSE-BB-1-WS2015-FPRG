import java.util.List;
import java.util.Map;
import java.util.Vector;
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

    public static <A,B> B divideAndConquer(
            Function<List<A>,Boolean> trivial,
            Function<List<A>,B> solve,
            Function<List<A>,Tupel<List<A>>> divide,
            BinaryOperator<B> combine,
            List<A> in) {

        if(trivial.apply(in)) {
            return solve.apply(in);
        } else {
            Tupel<List<A>> tupel = divide.apply(in);
            return combine.apply(
                    divideAndConquer(trivial,solve,divide,combine,tupel.getX()),
                    divideAndConquer(trivial,solve,divide,combine,tupel.getY())
            );
        }
    }

}
