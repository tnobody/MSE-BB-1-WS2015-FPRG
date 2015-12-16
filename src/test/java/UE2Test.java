import org.junit.Test;

import domain.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

import static org.junit.Assert.*;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE2Test {

    private BinaryOperator<Integer> sumList = (a,b) -> a+b;
    private BinaryOperator<String> concatString = (a,b) -> a + " " +b;
    private BinaryOperator<Square> sumSquares = (a,b) -> a.add(b);

    @Test
    public void testFoldInteger() throws Exception {
        Integer  sum = UE2.fold(sumList,0, Arrays.asList(1,2,3));
        assertEquals(new Integer(6), sum);
    }

    @Test
    public void testFoldString() throws Exception {
        String  sum = UE2.fold(concatString,"Hello", Arrays.asList("Functional", "Programming", "in", "Java"));
        assertEquals("Hello Functional Programming in Java", sum);
    }

    @Test
    public void testFoldProject() throws Exception {
        List<Square> projects = Arrays.asList(new Square(5), new Square(10), new Square(3));
        Square summedSquare = UE2.fold(sumSquares,new Square(7),projects);
        assertEquals(25, summedSquare.getL());
    }
}