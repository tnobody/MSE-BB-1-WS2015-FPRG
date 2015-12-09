import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * Created by tim on 26.11.2015.
 */
public class UE4Test {

    private static Function<Integer,Boolean> isEven = i -> i % 2 == 0;
    private Function<List<Integer>, Boolean> qsTrivial;
    private Function<List<Integer>, List<Integer>> qsSolve;
    private Function<List<Integer>, UE4.Tupel<List<Integer>>> qsDivide;
    private BinaryOperator<List<Integer>> qsCombine;


    @Test
    public void testFilter() throws Exception {
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> odd = UE4.filter(ints,isEven);
        assertArrayEquals(new Integer[] {2,4,6,8}, odd.toArray());
    }



    @Test
    public void testDivideAndConquerQuickSort() throws Exception {
        List<Integer> integers = Arrays.asList(5,3,9,7,53,2);
        qsTrivial = (l) -> l.size() <= 1;
        qsSolve = (l) -> l;
        qsDivide = (l) -> {
            List<Integer> x = UE4.filter(l, i -> i < l.get(0));
            x.add(l.get(0));
            return new UE4.Tupel<>(
                    x,
                    UE4.filter(l, i -> i > l.get(0))
            );
        };
        qsCombine = (a, b) -> new ArrayList<Integer>() {{
            addAll(a);
            addAll(b);
        }};
        List<Integer> sortedIntegers = UE4.divideAndConquer(
                qsTrivial,
                qsSolve,
                qsDivide,
                qsCombine,
                integers
        );
        assertArrayEquals("", new Integer[] {2,3,5,7,9,53}, sortedIntegers.toArray());
    }
}