package model.query;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class ComplexQueryDecoder implements QueryDecoder {
    private final String INCLUDE_CHAR = "+";
    private final String EXCLUDE_CHAR = "-";
    private final String SEPARATOR = " ";
    @Override
    public HashMap<String,Set<String>> decode(String queryRequest) {
        String[] args = queryRequest.split(SEPARATOR);
        return new HashMap<>() {{
            put("including", decode(args, INCLUDE_CHAR));
            put("excluding", decode(args, EXCLUDE_CHAR));
            put("intersection", decode(args, Set.of(INCLUDE_CHAR, EXCLUDE_CHAR)));
        }};
    }


    private Set<String> decode(String[] args, String starter) {
        return Arrays.stream(args).filter(x -> x.startsWith(starter)).collect(Collectors.toSet());
    }

    private Set<String> decode(String[] args, Set<String> notStarter) {
        return Arrays.stream(args).filter(x -> !x.startsWith(notStarter.toString())).collect(Collectors.toSet());

    }

}
