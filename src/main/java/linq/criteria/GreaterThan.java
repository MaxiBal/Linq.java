package linq.criteria;

public class GreaterThan implements ICriteria<Integer> {

    private final int compareNumber;

    /**
     * Creates a criteria for items that are greater than <param ref="greaterThanCompareNumber" />
     * @param greaterThanCompareNumber the number which all items in list will be compared to
     */
    public GreaterThan(int greaterThanCompareNumber)
    {
        compareNumber = greaterThanCompareNumber;
    }

    public boolean validate(Integer item) {
        return item > compareNumber;
    }
}
