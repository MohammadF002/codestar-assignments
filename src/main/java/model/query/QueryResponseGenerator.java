package model.query;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface QueryResponseGenerator {
    Set<String> generate(List<String> including, List<String> excluding, List<String> intersection,
                         HashMap<String, Set<String>> invertedIndexMap);
}
