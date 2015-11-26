import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tmkein on 25.11.2015.
 */
public class UE2Test {

    public class Project {
        private int workedHours;

        public Project(int workedHours) {
            this.workedHours = workedHours;
        }

        public int getWorkedHours() {
            return workedHours;
        }
    }

    @Test
    public void testFoldInteger() throws Exception {
        Integer  sum = UE2.fold((a,b) -> a+b,0, Arrays.asList(1,2,3));
        // This will lead to a compiler error
        //int  sum = UE2.fold((a,b) -> a+b,0, Arrays.asList(1,2,3));
        assertEquals(new Integer(6), sum);
    }

    @Test
    public void testFoldString() throws Exception {
        String  sum = UE2.fold((a,b) -> a + "" +b,"Hello", Arrays.asList("Functional", "Programming", "in", "Java"));
        assertEquals("Hello Functional Programming in Java", sum);
    }

    @Test
    public void testFoldProject() throws Exception {
        List<Project> projects = Arrays.asList(new Project(5), new Project(10), new Project(2));
        //String  sum = UE2.fold((a,b) -> new Project(a.getWorkedHours()+b.getWorkedHours) ,new Project(0), projects);
        //assertEquals("Hello Functional Programming in Java", sum);
    }
}