package model.Queries;

import java.util.HashMap;
import java.util.Set;

public interface QueryCollector {
    Set<String> collect(Set<String> including, Set<String> excluding, Set<String> intersection,
                        HashMap<String, Set<String>> invertedIndexMap);
}
