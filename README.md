# Linq in Java

A light-weight java implementation of LINQ (Language Integrated Query)

## Usage

Linq's constructor takes in a dataset which can be a List<> or an Array.

Linq creates a query and needs its criteria specified using its where() method.

```java

Integer[] data = {20, 40, 60, 80};

int eighty = new Query(data).where(new Equals(80)).first();

```

To fetch the data, one can use either the first() or all() methods.  first() returns the first element that matches the criteria given. 
all() returns every element that matches the criteria in a List<>.

## Built in Criteria

Linq comes with 6 built-in criterias: Equals, GreaterThan, GreaterThanOrEqualTo, LessThan, LessThanOrEqualTo, and NotEquals.  
However, a criteria can be created with a lambda:

```java
ICriteria<Integer> criteria = (Integer item) -> item > 20 && item < 80;
```

## Tests

Run tests with: 

```sh
$ gradle test
```
