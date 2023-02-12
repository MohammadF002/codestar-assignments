package src.Queries;

import src.InvertedIndex;

import java.util.HashSet;
import java.util.Set;

public class ComplexQueryCollector {
    public Set<String> collect(Set<String> including, Set<String> excluding, Set<String> intersection,
                            InvertedIndex invertedIndex) {
        Set<String> res = new HashSet<>();
        for (String s : including)
            res.addAll(invertedIndex.getDocIdsByWord(s));

        for (String s : excluding)
            res.retainAll(invertedIndex.getDocIdsByWord(s));

        for (String s : intersection)
            res.removeAll(invertedIndex.getDocIdsByWord(s));
        return res;
    }
}
