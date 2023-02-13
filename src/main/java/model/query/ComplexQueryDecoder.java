package model.query;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ComplexQueryDecoder implements QueryDecoder {
    @Override
    public HashMap<String,Set<String>> decode(String queryRequest) {
        String[] args = queryRequest.split(" ");
        Set<String> including = new HashSet<>();
        Set<String> excluding = new HashSet<>();
        Set<String> intersection = new HashSet<>();
        for (String token:args) {
            if (token.startsWith("+"))
                including.add(token.substring(1).toUpperCase());
            else if (token.startsWith("-"))
                excluding.add(token.substring(1).toUpperCase());
            else intersection.add(token.toUpperCase());
        }
        return new HashMap<>() {{
            put("including", including);
            put("excluding", excluding);
            put("intersection", intersection);
        }};
    }
}
