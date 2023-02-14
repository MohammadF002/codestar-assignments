package model;

import lombok.Getter;
import model.crawler.Crawler;
import model.dataSource.SourceWordExtractor;

import java.util.*;

public class InvertedIndex {
    @Getter
    private HashMap<String, Set<String>> invertedIndexMap;


    public void createInvertedIndexFromSource(Crawler crawler, SourceWordExtractor extractor, String sourceLocation) {
        this.invertedIndexMap = new HashMap<>();
        for (String sourceLocations:crawler.fetchDataLocations(sourceLocation)) {
            List<String> words = extractor.fetchWordsFromSource(sourceLocations);
            mapFiller(sourceLocations, words);
        }
    }

    private void mapFiller(String fileName, List<String> words) {
        for (String word : words) {
            word = word.toUpperCase();
            if (invertedIndexMap.containsKey(word))
                invertedIndexMap.get(word).add(fileName);
            else {
                invertedIndexMap.put(word, new HashSet<>(Collections.singleton(fileName)));
            }
        }
    }

}
