package model.query;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ComplexQueryCollector implements QueryCollector {
    @Override
    public Set<String> collect(Set<String> including, Set<String> excluding, Set<String> intersection,
                               HashMap<String, Set<String>> invertedIndexMap) {
        Set<String> res;
        res = includeAllFromInvertedIndex(including, invertedIndexMap);
        if (res.isEmpty())
            res.addAll(retainAllFromInvertedIndex(intersection, invertedIndexMap));
        else
            res.retainAll(retainAllFromInvertedIndex(intersection, invertedIndexMap));
        res.removeAll(includeAllFromInvertedIndex(excluding, invertedIndexMap));
        return res;
    }

    private Set<String> includeAllFromInvertedIndex(Set<String> words, HashMap<String, Set<String>> invertedIndexMap) {
        Set<String> result = new HashSet<>();
        for (String word : words)
            if (invertedIndexMap.containsKey(word))
                result.addAll(invertedIndexMap.get(word));
        return result;
    }

    private Set<String> retainAllFromInvertedIndex(Set<String> words, HashMap<String, Set<String>> invertedIndexMap) {
        Set<String> result = new HashSet<>();
        String first = words.iterator().next();
        if (!words.isEmpty())
            if (invertedIndexMap.containsKey(first))
                result.addAll(invertedIndexMap.get(first));
        for (String word : words)
            if (invertedIndexMap.containsKey(word))
                result.addAll(invertedIndexMap.get(word));
        return result;
    }
}
