package linq.criteria;

public class LessThanOrEqualTo implements ICriteria<Integer> {

    private final int compareNumber;

    public LessThanOrEqualTo(int compareNumber)
    {
        this.compareNumber = compareNumber;
    }

    public boolean validate(Integer item) {
        return item <= compareNumber;
    }
}
