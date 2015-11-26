import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by tim on 26.11.2015.
 */
public class UE4Test {

    @Test
    public void testDivideAndConquerQuickSort() throws Exception {
        List<Integer> integers = Arrays.asList(5,3,9,7,53,2);
        List<Integer> sortedIntegers = UE4.divideAndConquer(
                (l) -> l.size() <= 1,
                (l) -> l,
                (l) -> {
                    List<Integer> x = l.stream().filter(i -> i < l.get(0)).collect(Collectors.toList());
                    x.add(l.get(0));
                    return new UE4.Tupel<>(
                            x,
                            l.stream().filter(i -> i > l.get(0)).collect(Collectors.toList())
                    );
                },
                (a,b) -> new ArrayList<Integer>() {{
                    addAll(a);
                    addAll(b);
                }},
                integers
        );
        assertArrayEquals("", new Integer[] {2,3,5,7,9,53}, sortedIntegers.toArray());
    }
}