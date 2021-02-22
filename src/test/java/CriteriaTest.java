package linq.tests;

import linq.Query;
import linq.criteria.Equals;
import linq.criteria.ICriteria;
import linq.criteria.GreaterThan;
import linq.criteria.NotEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CriteriaTest {

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
    public void testEqualsCriteria()
    {
        List<Integer> dataPoints = seedData();

        assertEquals(20, new Query(dataPoints).where(new Equals(20)).first());
    }

}
