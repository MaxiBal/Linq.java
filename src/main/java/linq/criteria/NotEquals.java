package linq.criteria;

public class NotEquals<T> implements ICriteria<T> {

    private final T compareValue;

    public NotEquals(T compareValue)
    {
        this.compareValue = compareValue;
    }

    public boolean validate(T item)
    {
        return item != compareValue;
    }
}
