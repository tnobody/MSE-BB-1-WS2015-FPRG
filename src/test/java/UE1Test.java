import domain.Rectangle;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE1Test {

    private Function<Integer, Integer> powerInt = (i -> i*i);
    private Function<Integer, String> int2String = (i -> "#" + i.toString());

    private Function<Rectangle, Integer> rect2Area = (r -> r.getArea());

    @Test
    public void testMap() throws Exception {
        List<Integer> integerList = Arrays.asList(1,2,3);
        List<Integer> mappedList = UE1.map(powerInt, integerList);
        List<String> stringList = UE1.map(int2String, integerList);
        assertArrayEquals("old list should be untouched", Arrays.asList(1,2,3).toArray(), integerList.toArray());
        assertArrayEquals("mapped list should have powered values", Arrays.asList(1,4,9).toArray(), mappedList.toArray());
        assertArrayEquals("mapped list should be string values", Arrays.asList("#1","#2","#3").toArray(), stringList.toArray());
    }

    @Test
    public void testMapRectangle() throws Exception {
        List<Rectangle> rectangles = Arrays.asList(new Rectangle(5), new Rectangle(3), new Rectangle(10));
        assertArrayEquals("", Arrays.asList(25,9,100).toArray(), UE1.map(rect2Area, rectangles).toArray());
    }
}