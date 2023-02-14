package model.query;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface QueryDecoder {
    HashMap<String, List<String>> decode(String queryRequest);
}
