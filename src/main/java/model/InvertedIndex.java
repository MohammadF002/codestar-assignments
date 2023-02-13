package model;

import model.dataSource.DataSource;

import java.util.*;

public class InvertedIndex {
    private HashMap<String, Set<String>> invertedIndexMap;


    public void createInvertedIndexFromSource(DataSource source) {
        this.invertedIndexMap = new HashMap<>();
        List<DataSource> sources = source.fetchSource();
        for (DataSource src:sources) {
            List<String> words = src.fetchWordsFromSource();
            mapFiller(src.getSourceName(), words);
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

    public HashMap<String, Set<String>> getMap() {
        return invertedIndexMap;
    }
}
