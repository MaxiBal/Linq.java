package linq.tests;

import linq.Query;
import linq.criteria.ICriteria;
import linq.criteria.GreaterThan;
import linq.criteria.NotEquals;
import linq.criteria.Equals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QueryTest {

    private List<Integer> seedData()
    {
        List<Integer> dataPoints = new ArrayList<>();

        dataPoints.add(20);
        dataPoints.add(40);
        dataPoints.add(60);
        dataPoints.add(80);

        return dataPoints;
    }

    @Test
    public void testThatQueryReturnsCorrectResponse()
    {
        List<Integer> dataPoints = seedData();

        assertEquals(80, new Query(dataPoints).where(new GreaterThan(70)).first());
    }

    @Test
    public void testThatQueryCanBeCalledWithNoCriteria()
    {
        List<Integer> dataPoints = seedData();

        assertEquals(dataPoints, new Query(dataPoints).all());
    }

    @Test
    public void testThatQueryReturnsNull()
    {
        List<Integer> dataPoints = seedData();

        assertNull(new Query(dataPoints).where(new GreaterThan(90)).first());
    }

    @Test
    public void testThatQueryAcceptsLambda()
    {
        List<Integer> dataPoints = seedData();

        ICriteria<Integer> criteria = (Integer item) -> item == 80;

        assertEquals(80, new Query(dataPoints).where(criteria).first());
    }

    @Test
    public void testThatQueryCanBeChained()
    {
        List<Integer> dataPoints = seedData();

        assertEquals(80, new Query(dataPoints).where(new GreaterThan(50))
                        .where(new NotEquals(60)).first());
    }

    @Test
    public void testThatQueryReturnsNothingWithNoData()
    {
        List<Integer> dataPoints = new ArrayList<>();

        assertNull(new Query(dataPoints).all());
    }

    @Test
    public void testThatQueryAcceptsArrays()
    {
        Integer[] dataPoints = {20, 40, 60, 80};

        assertEquals(80, new Query(dataPoints).where(new Equals(80)).first());
    }
}
