package linq.criteria;

public class GreaterThanOrEqualTo implements ICriteria<Integer> {

    int compareNumber;

    public GreaterThanOrEqualTo(int compareNumber)
    {
        this.compareNumber = compareNumber;
    }

    public boolean validate(Integer item) {
        return item >= compareNumber;
    }
}
