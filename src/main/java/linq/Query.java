package linq;

import linq.criteria.ICriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Query<T> {

    private final List<T> data;
    private List<ICriteria<T>> criteriaList = new ArrayList<>();

    /**
     * Generates a new LINQ query
     *
     * @param data the data to read from
     */
    public Query(List<T> data)
    {
        this.data = data;
    }

    public Query(T[] data) {
        this.data = Arrays.asList(data);
    }

    public Query<T> where(ICriteria<T> criteria)
    {
        this.criteriaList.add(criteria);
        return this;
    }

    /**
     * Gets the first item that matches the given criteria
     * @return the first item found, or null if the item is not in the dataset
     */
    public T first()
    {
        if (data.isEmpty())
        {
            return null;
        }

        if (criteriaList.isEmpty())
        {
            return data.get(0);
        }

        for(T dataValue : this.data)
        {
            boolean verified = true;

            for (ICriteria<T> criteria : this.criteriaList)
            {
                if (!criteria.validate(dataValue))
                {
                    verified = false;
                    break;
                }

            }

            if (verified)
            {
                return dataValue;
            }
        }

        return null;
    }

    /**
     * Gets every item that matches the given criteria
     * @return ArrayList of all items that match the criteria
     */
    public List<T> all()
    {
        List<T> gatheredSelections = new ArrayList<>();

        if (data.isEmpty())
        {
            return null;
        }

        if (criteriaList.isEmpty())
        {
            return data;
        }

        for(T dataValue : this.data)
        {
            boolean verified = true;

            for (ICriteria<T> criteria : this.criteriaList)
            {
                if (!criteria.validate(dataValue))
                {
                    verified = false;
                    break;
                }
            }

            if (verified)
            {
                gatheredSelections.add(dataValue);
            }
        }

        return gatheredSelections;
    }
}
