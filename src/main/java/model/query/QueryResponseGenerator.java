package model.query;

import java.util.HashMap;
import java.util.Set;

public interface QueryResponseGenerator {
    Set<String> generate(Set<String> including, Set<String> excluding, Set<String> intersection,
                         HashMap<String, Set<String>> invertedIndexMap);
}
