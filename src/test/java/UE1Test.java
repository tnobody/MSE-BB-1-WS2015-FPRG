import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE1Test {

    @Test
    public void testMap() throws Exception {
        List<Integer> integerList = Arrays.asList(1,2,3);
        List<Integer> mappedList = UE1.map((i -> i*i), integerList);
        assertArrayEquals("old list should be untouched", Arrays.asList(1,2,3).toArray(), integerList.toArray());
        assertArrayEquals("mapped list should have powered values", Arrays.asList(1,4,9).toArray(), mappedList.toArray());
    }
}