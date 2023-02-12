package src.Queries;

import java.util.HashSet;
import java.util.Set;

public class ComplexQueryDecoder{
    public void decode(ComplexQuery queryToBeDecoded) {
        String[] args = queryToBeDecoded.getQueryRequest().split(" ");
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
        queryToBeDecoded.setSets(including,excluding,intersection);
    }
}
