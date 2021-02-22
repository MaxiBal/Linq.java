package linq.criteria;

public class LessThan implements ICriteria<Integer> {

    private int compareNumber;

    /**
     * Creates a criteria for items that are less than <param ref="greaterThanCompareNumber" />
     * @param lessThanCompareNumber the number which all items in list will be compared to
     */
    public LessThan(int lessThanCompareNumber)
    {
        compareNumber = lessThanCompareNumber;
    }

    public boolean validate(Integer item) {
        return item < compareNumber;
    }
}
