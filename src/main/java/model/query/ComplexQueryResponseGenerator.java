package model.query;


import java.util.*;
import java.util.stream.Collectors;

public class ComplexQueryResponseGenerator implements QueryResponseGenerator {
    @Override
    public Set<String> generate(List<String> including, List<String> excluding, List<String> intersection, HashMap<String, Set<String>> invertedIndexMap) {
        Set<String> res;
        res = includeAllFromInvertedIndex(including, invertedIndexMap);
        if (!intersection.isEmpty()) {
            if (res.isEmpty()) res.addAll(retainAllFromInvertedIndex(intersection, invertedIndexMap));
            else res.retainAll(retainAllFromInvertedIndex(intersection, invertedIndexMap));
        }

        res.removeAll(includeAllFromInvertedIndex(excluding, invertedIndexMap));
        return res;
    }

    private Set<String> includeAllFromInvertedIndex(List<String> words, HashMap<String, Set<String>> invertedIndexMap) {

        return words.stream().map(x -> invertedIndexMap.getOrDefault(x, Set.of())).flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private Set<String> retainAllFromInvertedIndex(List<String> words, HashMap<String, Set<String>> invertedIndexMap) {
        var sets = words.stream().filter(invertedIndexMap::containsKey).map(invertedIndexMap::get).toList();
        if (sets.isEmpty())
            return new HashSet<>();
        var result = sets.get(0);
        for (Set set : sets)
            result.retainAll(set);
        return result;
    }
}
