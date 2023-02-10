package src;


import java.util.*;


public class SetOperations {
    public HashSet<String> extractSetsFromMap(Map<String, List<String>> args, Iterable<String> components) {
        HashSet<String> result = new HashSet<>();
        for (String component : components)
            result.addAll(args.get(component));
        return result;
    }

    public HashSet<String> union (Iterable<Set<String>> setsToGetUnionWith) {
        HashSet<String> result = new HashSet<>();
        for (Set<String> set : setsToGetUnionWith)
            result.addAll(set);
        return result;
    }

    public HashSet<String> intersection (List<Set<String>> setsToGetIntersectionFrom) {
        HashSet<String> result = new HashSet<>();
        if (!setsToGetIntersectionFrom.isEmpty())
            result.addAll(setsToGetIntersectionFrom.get(0));
        for (Set<String> set : setsToGetIntersectionFrom)
            result.retainAll(set);
        return result;
    }
}
