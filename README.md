# remove-duplicates-task

Target: Java 8+.

This is a simple Maven project. To run the tests simply run `mvn test`

### Implementation details
- It uses `HashSet` as a cache to keep track of characters already present. That class uses a `HashMap` to store the data.
- It uses `StringBuilder` to build the return value.
- Tests require JUnit 5. The dependency is present in `pom.xml`.
- Single utility method: `com.example.StringUtils.removeDuplicates(String)`.