package model.query;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ComplexQueryDecoder implements QueryDecoder {
    private static final String INCLUDE_CHAR = "+";
    private static final String EXCLUDE_CHAR = "-";
    private static final String SEPARATOR = " ";
    @Override
    public HashMap<String,List<String>> decode(String queryRequest) {
        String[] args = queryRequest.split(SEPARATOR);
        return new HashMap<>() {{
            put("including", decode(args, INCLUDE_CHAR));
            put("excluding", decode(args, EXCLUDE_CHAR));
            put("intersection", decode(args, Set.of(INCLUDE_CHAR, EXCLUDE_CHAR)));
        }};
    }


    private List<String> decode(String[] args, String starter) {
        return Arrays.stream(args).filter(x -> x.startsWith(starter)).map(s -> s.substring(1).toUpperCase()).
                collect(Collectors.toList());
    }

    private List<String> decode(String[] args, Set<String> notStarter) {
        return Arrays.stream(args).filter(x -> {
            for (String s : notStarter)
                if (x.startsWith(s))
                    return false;
            return true;
        }).map(String::toUpperCase).collect(Collectors.toList());
    }

}
