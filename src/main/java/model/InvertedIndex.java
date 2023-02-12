package model;

import java.io.IOException;
import java.util.*;

public class InvertedIndex {
    private HashMap<String, Set<String>> invertedIndexMap;


    public void createInvertedIndexFromFiles(String targetLocation) throws IOException {
        HashMap<String, Set<String>> map = new HashMap<>();
        FileHandler fileHandler = new FileHandler();
        List<String> fileNames = fileHandler.gatherAllFileNames(targetLocation);
        for (String fileName : fileNames) {
            List<String> words = fileHandler.getWordsInFile("EnglishData\\" + fileName);
            mapFiller(map, fileName, words);
        }
        this.invertedIndexMap = map;
    }

    private void mapFiller(HashMap<String, Set<String>> map, String fileName, List<String> words) {
        for (String word : words) {
            if (map.containsKey(word.toUpperCase()))
                map.get(word.toUpperCase()).add(fileName);
            else {
                map.put(word.toUpperCase(), new HashSet<>(Collections.singleton(fileName)));
            }
        }
    }

    public HashMap<String, Set<String>> getMap() {
        return invertedIndexMap;
    }
}
