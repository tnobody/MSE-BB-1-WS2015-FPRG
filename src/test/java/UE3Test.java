import domain.Square;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.Assert.*;

/**
 * Created by tim on 26.11.2015.
 */
public class UE3Test {

    private BiFunction<Integer, Integer, Integer> add = (a,b) -> a+b;
    private BiFunction<Integer, Integer, Integer> multiply = (a,b) -> a*b;
    private BiFunction<Integer, Square, Integer> accumulateArea = (a,b) -> a+b.getArea();

    @Test
    public void testScanInt() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        assertArrayEquals(new Integer[] {1,3,6,10}, UE3.scan(add, 0, integers).toArray());
        assertArrayEquals(new Integer[] {3,6,18,72}, UE3.scan(multiply, 3, integers).toArray());
    }

    @Test
    public void testScanString() throws Exception {
        List<Square> squares = Arrays.asList(new Square(1), new Square(2), new Square(3));
        assertArrayEquals(new Integer[] {1,5,14}, UE3.scan(accumulateArea,0,squares).toArray());
    }
}