package linq.criteria;

public interface ICriteria<T> {
    boolean validate(T item);
}
