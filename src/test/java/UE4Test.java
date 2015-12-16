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

    private static Function<Integer, Boolean> isEven = i -> i % 2 == 0;
    private Function<List<Integer>, Boolean> qsTrivial;
    private Function<List<Integer>, List<Integer>> qsSolve;
    private Function<List<Integer>, UE4.Tupel<List<Integer>>> qsDivide;
    private BinaryOperator<List<Integer>> qsCombine;
    private Function<List<Integer>, Boolean> msTrivial;
    private Function<List<Integer>, List<Integer>> msSolve;
    private Function<List<Integer>, UE4.Tupel<List<Integer>>> msDivide;
    private BinaryOperator<List<Integer>> msCombine;


    @Test
    public void testFilter() throws Exception {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        UE4.Tupel<List<Integer>> filtered = UE4.filter(ints, isEven);
        assertArrayEquals(new Integer[]{2, 4, 6, 8}, filtered.getX().toArray());
        assertArrayEquals(new Integer[]{1, 3, 5, 7, 9}, filtered.getY().toArray());
    }


    @Test
    public void testDivideAndConquerQuickSort() throws Exception {
        List<Integer> integers = Arrays.asList(5, 3, 9, 7, 5, 53, 2);
        // TODO: How to Handle duplicated Values?
        qsTrivial = (l) -> l.size() <= 1;
        qsSolve = (l) -> l;
        qsDivide = (l) -> {
            UE4.Tupel<List<Integer>> duplicationFilter = UE4.filter(l,i -> i == l.get(0));
            UE4.Tupel<List<Integer>> divides = UE4.filter(duplicationFilter.getY(), i -> i < l.get(0));
            divides.getX().addAll(duplicationFilter.getX());
            return divides;
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
        System.out.println(qsDivide.apply(integers));
        assertArrayEquals("", new Integer[]{2, 3, 5, 7, 9, 53}, sortedIntegers.toArray());
    }

    @Test
    public void testDivideAndConquerMergeSort() throws Exception {
        List<Integer> integers = Arrays.asList(5, 3, 9, 7, 53, 2);
        msTrivial = (l) -> l.size() <= 1;
        msSolve = (l) -> l;
        msDivide = (l) -> new UE4.Tupel<>(
                l.subList(0, (int) Math.floor(l.size() / 2)),
                l.subList((int) (Math.floor(l.size() / 2)), l.size()));
        msCombine = (left, right) -> {
            // TODO: Recursion
            List<Integer> combined = new ArrayList<>();
            while (left.size() > 0 && right.size() > 0) {
                if (left.get(0) <= right.get(0)) {
                    combined.add(left.get(0));
                    left = left.subList(1, left.size());
                } else {
                    combined.add(right.get(0));
                    right = right.subList(1, right.size());
                }
            }
            while (left.size() > 0) {
                combined.add(left.get(0));
                left = left.subList(1, left.size());
            }
            while (right.size() > 0) {
                combined.add(right.get(0));
                right = right.subList(1, right.size());
            }
            return combined;
        };
        List<Integer> sortedIntegers = UE4.divideAndConquer(
                msTrivial,
                msSolve,
                msDivide,
                msCombine,
                integers
        );
        assertArrayEquals("", new Integer[]{2, 3, 5, 7, 9, 53}, sortedIntegers.toArray());
    }
}