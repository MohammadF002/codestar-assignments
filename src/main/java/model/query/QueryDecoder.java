package model.query;

import java.util.HashMap;
import java.util.Set;

public interface QueryDecoder {
    HashMap<String, Set<String>> decode(String queryRequest);
}
