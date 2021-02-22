package linq.criteria;

public class Equals<T> implements ICriteria<T> {

    private final T compareValue;

    public Equals(T compareValue)
    {
        this.compareValue = compareValue;
    }

    public boolean validate(T item)
    {
        return item == compareValue;
    }
}
